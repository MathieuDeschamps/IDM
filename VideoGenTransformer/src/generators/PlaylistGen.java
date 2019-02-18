package generators;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.FfmpegException;
import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.ImageDescription;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;
import model.Possibility;
import tools.Ffmpeg;

public class PlaylistGen implements VisitorVideoGen{

	private Possibility playlist;
	private VideoGeneratorModel videoGeneratorModel;
	
	public PlaylistGen(VideoGeneratorModel videoGeneratorModel) {
		playlist = new Possibility();
		this.videoGeneratorModel = videoGeneratorModel;
	}
	
	public void process() {
		playlist = new Possibility();
		visitVideoGeneratorModel(videoGeneratorModel);		
	}
	
	@Override
	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) {
		for(Media media : videoGeneratorModel.getMedias()) {
			if(media instanceof MandatoryMedia) {
				visitMandatoryMedia((MandatoryMedia) media);
			}else if(media instanceof OptionalMedia) {
				visitOptionalMedia((OptionalMedia) media);
			}else if(media instanceof AlternativesMedia) {
				visitAlternativeMedia((AlternativesMedia) media);
			}else {
			
			}
		}
	}

	@Override
	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia){
		playlist.add((mandatoryMedia).getDescription());
	}

	@Override
	public void visitOptionalMedia(OptionalMedia optionalMedia) {
		if(optionalMedia.getDescription() instanceof VideoDescription) {
			VideoDescription videoDescription = (VideoDescription) optionalMedia.getDescription();
			if(videoDescription.getProbability() == 0) {
				(videoDescription).setProbability(50);
			}
			double random = Math.random() * 100;
			if(random < videoDescription.getProbability()) {
				playlist.add(optionalMedia.getDescription());
			}
		}else if(optionalMedia instanceof ImageDescription){
			double random = Math.random() * 100;
			// 50 because optional image description does not have probability field
			if(random < 50) {
				playlist.add(optionalMedia.getDescription());
			}
		}
	}

	@Override
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) {
		List<MediaDescription> mediaDescriptions = new ArrayList<>();
		
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
				mediaDescriptions.add(mediaDescription);
		}
		// TODO improve random with the probability field for the videoDescription
		// and default case  
		int randomIndex = (int) (Math.random() * mediaDescriptions.size());
		playlist.add(mediaDescriptions.get(randomIndex));
	}
	
	
	public Possibility getPlaylist() {
		return playlist;
	}
	/**
	 * 
	 * @path
	 * @param playlistName
	 * @return the path of the playlist
	 * @throws FfmpegException
	 */
	public Optional<String> genPlaylist(String path, String playlistName) throws FfmpegException{
		Possibility parsePossibility = playlist.toPlaylist();
		Optional<MediaDescription> optional = parsePossibility.get(0);
		
		// check if there's a file to concat
		if(optional.isPresent()) {
			String inputPath = path;
			String outputPath = path;
			String content = parsePossibility.toFfmpeg("");
			BufferedWriter writer;
			inputPath += playlistName + ".txt";
			outputPath += playlistName + ".mp4";
			try {
				writer = new BufferedWriter(new FileWriter(inputPath));
				writer.write(content);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Ffmpeg.concatVideos(inputPath, outputPath);
			return Optional.of(outputPath);
		}
		return Optional.empty();
	}
}

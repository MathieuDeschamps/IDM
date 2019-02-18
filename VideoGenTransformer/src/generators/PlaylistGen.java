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

/**
 * Class which are able to generate playlist form a video gen model
 */
public class PlaylistGen{

	private Possibility playlist;
	private VideoGeneratorModel videoGeneratorModel;
	
	public PlaylistGen(VideoGeneratorModel videoGeneratorModel) {
		playlist = new Possibility();
		this.videoGeneratorModel = videoGeneratorModel;
	}
	
	/**
	 * Run the generation of the playlist
	 */
	public void process() {
		playlist = new Possibility();
		visitVideoGeneratorModel(videoGeneratorModel);		
	}
	
	private void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) {
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

	private void visitMandatoryMedia(MandatoryMedia mandatoryMedia){
		playlist.add((mandatoryMedia).getDescription());
	}

	private void visitOptionalMedia(OptionalMedia optionalMedia) {
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

	private void visitAlternativeMedia(AlternativesMedia alternativesMedia) {
		List<MediaDescription> mediaDescriptions = new ArrayList<>();
		
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
				mediaDescriptions.add(mediaDescription);
		}
		// TODO improve random with the probability field for the videoDescription
		// and default case  
		int randomIndex = (int) (Math.random() * mediaDescriptions.size());
		playlist.add(mediaDescriptions.get(randomIndex));
	}
	
	/**
	 * @return the last playlist generated
	 */
	public Possibility getPlaylist() {
		return playlist;
	}
	/**
	 * Generate the last playlist
	 * @param parentPath where is generated the playlist
	 * @param playlistName name of the playlist file
	 * @return the path where the playlist has been generated
	 * @throws FfmpegException if the generation encountered a problem
	 */
	public Optional<String> genPlaylist(String parentPath, String playlistName) throws FfmpegException{
		Possibility parsePossibility = playlist.toPlaylist();
		Optional<MediaDescription> optional = parsePossibility.get(0);
		
		// check if there's a file to concat
		if(optional.isPresent()) {
			String inputPath = parentPath;
			String outputPath = parentPath;
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

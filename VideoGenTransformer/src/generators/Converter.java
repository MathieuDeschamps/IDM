package generators;

import exceptions.FfmpegException;
import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;
import tools.Ffmpeg;

public class Converter{
	
	private VideoGeneratorModel videoGeneratorModel;
	
	public Converter(VideoGeneratorModel videoGeneratorModel) {
		this.videoGeneratorModel = videoGeneratorModel;
	}
	
	public void process() throws FfmpegException {
		visitVideoGeneratorModel(videoGeneratorModel);
	}
	
	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) throws FfmpegException {
		for(Media media: videoGeneratorModel.getMedias()) {
			if(media instanceof MandatoryMedia){
				visitMandatoryMedia((MandatoryMedia) media);
			}else if(media instanceof OptionalMedia) {
				visitOptionalMedia((OptionalMedia) media);
			}else if(media instanceof AlternativesMedia) {
				visitAlternativeMedia((AlternativesMedia) media);
			}
		}
	}

	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia) throws FfmpegException {
		MediaDescription mediaDescription = mandatoryMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}
	}

	public void visitOptionalMedia(OptionalMedia optionalMedia) throws FfmpegException {
		MediaDescription mediaDescription = optionalMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}
	}

	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) throws FfmpegException {
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
			if(mediaDescription instanceof VideoDescription) {
				visitVideoDescription((VideoDescription) mediaDescription);
			}	
		}
	}
	
	private void visitVideoDescription(VideoDescription mediaDescription) throws FfmpegException {
		String inputPath = mediaDescription.getLocation();
		int beginExtension = inputPath.lastIndexOf('.');
		int beginFile = inputPath.lastIndexOf('/') + 1;
		String extension = inputPath.substring(beginExtension);
		String name = inputPath.substring(beginFile, beginExtension);
		String outputPath = "res/videos/" + name + "_gen" + extension;
		Ffmpeg.formatVideo(inputPath, outputPath);
		mediaDescription.setLocation(outputPath);
	}
}

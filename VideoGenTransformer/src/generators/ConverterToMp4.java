package generators;

import java.io.File;

import exceptions.FfmpegException;
import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;
import tools.Ffmpeg;

/**
 * Class which convert every videoseq into a mp4 video.
 *
 */
public class ConverterToMp4{
	
	private VideoGeneratorModel videoGeneratorModel;
	
	public ConverterToMp4(VideoGeneratorModel videoGeneratorModel) {
		this.videoGeneratorModel = videoGeneratorModel;
	}
	
	/**
	 * Run the conversion
	 * @throws FfmpegException if the conversion failed
	 */
	public void process() throws FfmpegException {
		visitVideoGeneratorModel(videoGeneratorModel);
	}
	
	private void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) throws FfmpegException {
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

	private void visitMandatoryMedia(MandatoryMedia mandatoryMedia) throws FfmpegException {
		MediaDescription mediaDescription = mandatoryMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}
	}

	private void visitOptionalMedia(OptionalMedia optionalMedia) throws FfmpegException {
		MediaDescription mediaDescription = optionalMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}
	}

	private void visitAlternativeMedia(AlternativesMedia alternativesMedia) throws FfmpegException {
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
			if(mediaDescription instanceof VideoDescription) {
				visitVideoDescription((VideoDescription) mediaDescription);
			}	
		}
	}
	
	private void visitVideoDescription(VideoDescription mediaDescription) throws FfmpegException {
		String inputPath = mediaDescription.getLocation();
		int beginExtension = inputPath.lastIndexOf('.');
		String inputPathWitoutExtension = inputPath.substring(0, beginExtension);
		String outputPath = inputPathWitoutExtension + "_conv.mp4";
		File file = new File(outputPath);
		System.out.println("-" + file.getName());
		
		// if the file had not been already converted
		if(!file.exists()) {
			Ffmpeg.formatVideo(inputPath, outputPath);
		}		
		mediaDescription.setLocation(outputPath);
	}
}

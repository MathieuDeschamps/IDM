package generators;


import java.io.IOException;
import java.text.SimpleDateFormat;

import exceptions.FfmpegException;
import exceptions.ImageNotGenerated;
import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;
import tools.Ffmpeg;
import tools.Utils;

public class ThumbnailGen{
	
	VideoGeneratorModel videoGeneratorModel;
	
	public ThumbnailGen(VideoGeneratorModel videoGeneratorModel) {
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
	
	public void visitVideoDescription(VideoDescription videoDescription) throws FfmpegException {
		String locationVideo = videoDescription.getLocation();
		Integer seconds = videoDescription.getDuration();
		if(seconds == 0) {
			seconds = Ffmpeg.getDuration(locationVideo);
			if(seconds > 2){
				seconds --;
			}
		}
		String duration = Utils.formatHHmmss(seconds);
		String outputPath = "res/thumbnails/"+ videoDescription.getVideoid() + ".png";
		Ffmpeg.makeThumbnails(locationVideo, duration, outputPath);
		
	}

}

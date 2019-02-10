package generators;


import java.io.IOException;
import java.text.SimpleDateFormat;

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

public class ThumbnailGen implements VisitorVideoGen{
	
	public ThumbnailGen(VideoGeneratorModel videoGeneratorModel) {
		visitVideoGeneratorModel(videoGeneratorModel);
	}
	
	@Override
	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) {
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

	@Override
	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia) {
		MediaDescription mediaDescription = mandatoryMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}
	}

	@Override
	public void visitOptionalMedia(OptionalMedia optionalMedia) {
		MediaDescription mediaDescription = optionalMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}
	}

	@Override
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) {
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
			if(mediaDescription instanceof VideoDescription) {
				visitVideoDescription((VideoDescription) mediaDescription);
			}	
		}	
	}
	
	public void visitVideoDescription(VideoDescription videoDescription) {
		String locationVideo = videoDescription.getLocation();
		Integer seconds = videoDescription.getDuration();
		if(seconds == 0) {
			seconds = Ffmpeg.getDuration(locationVideo);			
		}
		String duration = Utils.formatHHmmss(seconds);
		String outputPath = "res/thumbnails/"+ videoDescription.getVideoid() + ".png";
		try {
			Ffmpeg.makeThumbnails(locationVideo, duration, outputPath);
		} catch (ImageNotGenerated e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

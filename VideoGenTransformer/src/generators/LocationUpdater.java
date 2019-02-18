package generators;

import java.io.File;
import java.util.ArrayList;

import exceptions.FileNotFoundException;
import exceptions.IdAlreadyExists;
import exceptions.InvalidProbability;
import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.ImageDescription;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;

public class LocationUpdater{

	private VideoGeneratorModel videoGeneratorModel;
	private String parentPath;

	public LocationUpdater(VideoGeneratorModel videoGeneratorModel){
		this.parentPath = "";
		this.videoGeneratorModel = videoGeneratorModel;
	}

	public void process(String parentPath) throws FileNotFoundException {
		this.parentPath = parentPath;
		visitVideoGeneratorModel(videoGeneratorModel);
	}

	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) throws FileNotFoundException {
		for (Media media : videoGeneratorModel.getMedias()) {
			if (media instanceof MandatoryMedia) {
				visitMandatoryMedia((MandatoryMedia) media);
			} else if (media instanceof OptionalMedia) {
				visitOptionalMedia((OptionalMedia) media);
			} else if (media instanceof AlternativesMedia) {
				visitAlternativeMedia((AlternativesMedia) media);
			}
		}

	}

	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia) throws FileNotFoundException {
		MediaDescription mediaDescription = mandatoryMedia.getDescription();
		if (mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		} else if (mediaDescription instanceof ImageDescription) {
			visitImageDescription((ImageDescription) mediaDescription);
		}
	}

	public void visitOptionalMedia(OptionalMedia optionalMedia) throws FileNotFoundException {
		MediaDescription mediaDescription = optionalMedia.getDescription();
		visitMediaDescription(mediaDescription);
	}

	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) throws FileNotFoundException {
		for (MediaDescription mediaDescription : alternativesMedia.getMedias()) {
			visitMediaDescription(mediaDescription);
		}
	}

	private void visitMediaDescription(MediaDescription mediaDescription) throws FileNotFoundException {
		if (mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		} else if (mediaDescription instanceof ImageDescription) {
			visitImageDescription((ImageDescription) mediaDescription);
		}
	}

	private void visitVideoDescription(VideoDescription videoDescription) throws FileNotFoundException {
		String id = videoDescription.getVideoid();
		String location = videoDescription.getLocation();
		File video = new File(parentPath + location);
		if(video.exists()) {
			videoDescription.setLocation(parentPath + location); 
		}else {
			throw new FileNotFoundException("Location Converter: "+ this.parentPath + location +" not found.");
		}
	}

	private void visitImageDescription(ImageDescription imageDescription) throws FileNotFoundException {
		String id = imageDescription.getImageid();
		String location = imageDescription.getLocation();
		File image = new File(parentPath + location);
		if(image.exists()) {
			imageDescription.setLocation(parentPath + location); 
		}else {
			throw new FileNotFoundException("Location Converter: "+ this.parentPath + location +" not found.");
		}
	}

}

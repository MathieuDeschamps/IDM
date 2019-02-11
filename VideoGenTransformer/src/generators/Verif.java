package generators;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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

public class Verif{
	
	List<String> idTable;
	VideoGeneratorModel videoGeneratorModel;
	
	public Verif(VideoGeneratorModel videoGeneratorModel) {
		idTable = new ArrayList<>();
		this.videoGeneratorModel = videoGeneratorModel;
	}
	
	public void process() throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
		visitVideoGeneratorModel(videoGeneratorModel);
		
	}
	
	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
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

	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia) throws IdAlreadyExists, FileNotFoundException {
		MediaDescription mediaDescription = mandatoryMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}else if(mediaDescription instanceof ImageDescription) {
			visitImageDescription((ImageDescription) mediaDescription);
		}
	}

	public void visitOptionalMedia(OptionalMedia optionalMedia) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
		MediaDescription mediaDescription = optionalMedia.getDescription();
		visitMediaDescription(mediaDescription);
	}

	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
		verifProbability(alternativesMedia.getMedias().listIterator());
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
			visitMediaDescription(mediaDescription);
		}
	}
	

	private void visitMediaDescription(MediaDescription mediaDescription) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
		if(mediaDescription instanceof VideoDescription) {
			verifProbability(mediaDescription);
			visitVideoDescription((VideoDescription) mediaDescription);			
		}else if(mediaDescription instanceof ImageDescription) {
			verifProbability(mediaDescription);
			visitImageDescription((ImageDescription) mediaDescription);
		}
	}

	private void visitVideoDescription(VideoDescription videoDescription) throws IdAlreadyExists, FileNotFoundException {
		String id = videoDescription.getVideoid();
		verifId(id);
		String location = videoDescription.getLocation();
		verifLocation(location);
	}
	private void visitImageDescription(ImageDescription imageDescription) throws IdAlreadyExists {
		String id = imageDescription.getImageid();
		verifId(id);
	}
	

	
	private void verifId(String newId) throws IdAlreadyExists {
		if(idTable.contains(newId)){
			throw new IdAlreadyExists("Verif: " + newId);
		}else {
			idTable.add(newId);
		}
	}
	
	private void verifLocation(String location) throws FileNotFoundException {
		File mediaFile = new File(location);
		if(!mediaFile.exists()) {
			throw new FileNotFoundException("Verif: " + location);
		}
	}
	
	private void verifProbability(Iterator<MediaDescription> iteratorMediaDescriptions) throws InvalidProbability {
		int sumProbability = 0;
		MediaDescription mediaDescription;
		while(iteratorMediaDescriptions.hasNext()) {
			mediaDescription = iteratorMediaDescriptions.next();
			if(mediaDescription instanceof VideoDescription) {
				VideoDescription videoDescription = (VideoDescription) mediaDescription;
				sumProbability += videoDescription.getProbability();
				if(sumProbability > 100) {
					throw new InvalidProbability("Verif:" + videoDescription.getLocation()); 
				}
			}
		}
	}
	
	private void verifProbability(MediaDescription mediaDescription) throws InvalidProbability {
		if(mediaDescription instanceof VideoDescription){
			VideoDescription videoDescription = (VideoDescription) mediaDescription;
			if(videoDescription.getProbability() > 100) {
				throw new InvalidProbability("Verif:" + videoDescription.getLocation()); 
			}
		}
	}
}

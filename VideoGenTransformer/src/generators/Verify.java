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

/**
 * Class which check if the video gen model match the requirement
 *
 */
public class Verify{
	
	List<String> idTable;
	VideoGeneratorModel videoGeneratorModel;
	
	public Verify(VideoGeneratorModel videoGeneratorModel) {
		idTable = new ArrayList<>();
		this.videoGeneratorModel = videoGeneratorModel;
	}
	
	/**
	 * Run the verifications
	 * @throws IdAlreadyExists
	 * @throws InvalidProbability
	 * @throws FileNotFoundException
	 */
	public void process() throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
		visitVideoGeneratorModel(videoGeneratorModel);
		
	}
	
	private void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
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

	private void visitMandatoryMedia(MandatoryMedia mandatoryMedia) throws IdAlreadyExists, FileNotFoundException {
		MediaDescription mediaDescription = mandatoryMedia.getDescription();
		if(mediaDescription instanceof VideoDescription) {
			visitVideoDescription((VideoDescription) mediaDescription);
		}else if(mediaDescription instanceof ImageDescription) {
			visitImageDescription((ImageDescription) mediaDescription);
		}
	}

	private void visitOptionalMedia(OptionalMedia optionalMedia) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
		MediaDescription mediaDescription = optionalMedia.getDescription();
		visitMediaDescription(mediaDescription);
	}

	private void visitAlternativeMedia(AlternativesMedia alternativesMedia) throws IdAlreadyExists, InvalidProbability, FileNotFoundException {
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
	

	/**
	 * run the verification on the id
	 * @param newId
	 * @throws IdAlreadyExists if the new id is already in idTable
	 */
	private void verifId(String newId) throws IdAlreadyExists {
		if(newId != null) {
			if(idTable.contains(newId)){
				throw new IdAlreadyExists("Verif: id " + newId + "already declared.");
			}else {
				idTable.add(newId);
			}
		}
	}
	
	/**
	 * run the verification on the location
	 * @param location
	 * @throws FileNotFoundException if none file are at the location
	 */
	private void verifLocation(String location) throws FileNotFoundException {
		File mediaFile = new File(location);
		if(!mediaFile.exists()) {
			throw new FileNotFoundException("Verif: file not found " + location + ".");
		}
	}
	/**
	 * run the verification about probability for several mediaDescription
	 * @param iteratorMediaDescriptions
	 * @throws InvalidProbability if the sum of probability goes over 100 
	 */
	private void verifProbability(Iterator<MediaDescription> iteratorMediaDescriptions) throws InvalidProbability {
		int sumProbability = 0;
		MediaDescription mediaDescription;
		while(iteratorMediaDescriptions.hasNext()) {
			mediaDescription = iteratorMediaDescriptions.next();
			if(mediaDescription instanceof VideoDescription) {
				VideoDescription videoDescription = (VideoDescription) mediaDescription;
				sumProbability += videoDescription.getProbability();
				if(sumProbability > 100) {
					throw new InvalidProbability("Verif: bad probability " + sumProbability + " over 100 for media " + videoDescription.getLocation() + "." ); 
				}
			}
		}
	}
	
	/**
	 * run the verification about probability for one media
	 * @param mediaDescription
	 * @throws InvalidProbability if the probability goes over 100
	 */
	private void verifProbability(MediaDescription mediaDescription) throws InvalidProbability {
		if(mediaDescription instanceof VideoDescription){
			VideoDescription videoDescription = (VideoDescription) mediaDescription;
			int probability = videoDescription.getProbability();
			if(probability > 100) {
				throw new InvalidProbability("Verif: bad probability "+ probability +"over 100 for media " + mediaDescription.getLocation() + "."); 
			}
		}
	}
}

package generators;

import java.util.ArrayList;
import java.util.List;

import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.ImageDescription;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;
import model.Possibility;

public class CalculateSizes implements VisitorVideoGen{

	private List<String> mediaIds;
	private List<Possibility> possibilites;

	
	public CalculateSizes(VideoGeneratorModel videoGen) {
		mediaIds = new ArrayList<>();
		possibilites = new ArrayList<>();
		// init with a empty possibility
		possibilites.add(new Possibility());
		
		visitVideoGeneratorModel(videoGen);
	}
	
	public List<Possibility> getPossibilities() {
		return this.possibilites;
	}
	
	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel) {
		for(Media media : videoGeneratorModel.getMedias()) {
			if(media instanceof MandatoryMedia) {
				visitMandatoryMedia((MandatoryMedia) media);
			}else if(media instanceof OptionalMedia) {
				visitOptionalMedia((OptionalMedia) media);
			}else if(media instanceof AlternativesMedia) {
				visitAlternativeMedia((AlternativesMedia) media);
			}
		}
	}

	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia) {
		MediaDescription mediaDescription = mandatoryMedia.getDescription() ;
		if(mediaDescription instanceof VideoDescription) {
			mediaIds.add(((VideoDescription) mediaDescription).getVideoid());
			for(Possibility possibility: possibilites) {
				possibility.add((VideoDescription) mediaDescription);
			}
		}		
	}
	
	public void visitOptionalMedia(OptionalMedia optionalMedia) {
		MediaDescription mediaDescription = optionalMedia.getDescription() ;
		if(mediaDescription instanceof VideoDescription) {
			mediaIds.add(((VideoDescription) mediaDescription).getVideoid());
		}else if(mediaDescription instanceof ImageDescription) {
			mediaIds.add(((ImageDescription) mediaDescription).getImageid());
		}
		List<Possibility>newPossilibities = clonedPossibilities(possibilites);
		for(Possibility newPossibility : newPossilibities) {
			newPossibility.add(mediaDescription);
			possibilites.add(newPossibility);
		}	
	}
	
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) {
		// the list which will contains the possibilities
		List<Possibility> newPossibilities = new ArrayList<>();
		
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {			
			if(mediaDescription instanceof VideoDescription) {
				mediaIds.add(((VideoDescription) mediaDescription).getVideoid());
			}else if(mediaDescription instanceof ImageDescription) {
				mediaIds.add(((ImageDescription) mediaDescription).getImageid());
			}
			List<Possibility>clonedPossibilities = clonedPossibilities(possibilites);
			
			// Add the current alternative to the clonned possibility
			// then add to the new possibilities
			for(Possibility clonedPossibility : clonedPossibilities) {
				clonedPossibility.add(mediaDescription);
				newPossibilities.add(clonedPossibility);
			}		
			
		}
		// change the possibilities with the new possibilities
		possibilites = newPossibilities;
	}
		
	private List<Possibility> clonedPossibilities(List<Possibility> possibilites2) {
		List<Possibility> result = new ArrayList<>();
		for(Possibility possibility : possibilites2) {
			result.add(possibility.clone());
		}
		return result;
	}
	
	public String toCSV() {
		String result = "";
		int count = 1;
		boolean isSelected = false;
		for(String id : mediaIds) {
			result += id + "; ";
		}
		result += "size\n";
		
		for(Possibility possibility : possibilites) {
			result += count + "; ";
			for(String id : mediaIds){
				if(possibility.getById(id).isPresent()) {
					isSelected = true;
				}
				result += isSelected + "; ";
				isSelected = false;
			}
			result += possibility.size() + "\n";
			count++;
		}
		return result;
	}
}

import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoGeneratorModel;

public class TestFunctions implements VisitorVideoGen{
	int nbPossibilities;
	
	public TestFunctions(VideoGeneratorModel videoGeneratorModel) {
		if(videoGeneratorModel.getMedias().size() > 0) {
			nbPossibilities = 1;
			visitVideoGeneratorModel(videoGeneratorModel);
		}else {
			nbPossibilities = 0;
		}
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
			}
		}		
	}

	@Override
	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia) {
			
	}

	@Override
	public void visitOptionalMedia(OptionalMedia optionalMedia) {
		nbPossibilities *= 2;		
	}

	@Override
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) {
		int nbAlternatives = alternativesMedia.getMedias().size();
		nbPossibilities *= nbAlternatives;
	}
	
	public int getNbPossibilities() {
		return nbPossibilities;
	}
	
	public static int nbLignes(String string) {
		return string.split("\n").length;
		
	}
}

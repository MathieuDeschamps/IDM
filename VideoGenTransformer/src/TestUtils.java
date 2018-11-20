import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoGeneratorModel;

public class TestUtils{
	
	public static int nbPossibilities(VideoGeneratorModel videoGeneratorModel) {
		int nbPossibilities = 0;
		if(videoGeneratorModel.getMedias().size() > 0) {
			nbPossibilities++;
			for(Media media : videoGeneratorModel.getMedias()) {
				if(media instanceof MandatoryMedia) {
					// nothing
				}else if(media instanceof OptionalMedia) {
					nbPossibilities *= 2;
				}
				else if(media instanceof AlternativesMedia) {
					nbPossibilities *= ((AlternativesMedia) media).getMedias().size();
				}
			}
		}
		return nbPossibilities;
	}
	
	public static int nbLignes(String string) {
		return string.split("\n").length;		
	}
}

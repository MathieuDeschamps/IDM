package tools;

import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoGeneratorModel;

public class UtilsTest {
	/**
	 * Give the number of possibilities of playlist in a generatorModel
	 * @param videoGeneratorModel
	 * @return
	 */
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
	/**
	 * Give the maximum of media in a playlist
	 * @param videoGeneratorModel
	 * @return the number of media
	 */
	public static int maxMedia(VideoGeneratorModel videoGeneratorModel) {
		return videoGeneratorModel.getMedias().size();
	}
	
	/**
	 * Give the minimum of media in a playlist
	 * @param videoGeneratorModel
	 * @return the number of media
	 */
	public static int minMedia(VideoGeneratorModel videoGeneratorModel) {
		int minMedia = 0;
		for(Media media: videoGeneratorModel.getMedias()) {
			//TODO look alternativeMedia
			if(media instanceof MandatoryMedia || media instanceof AlternativesMedia) {
				minMedia++;
			}
		}
		return minMedia;
		
	}
}

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.Media;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;

public class PlaylistGen implements VisitorVideoGen{

	Possibility playlist;
	
	public PlaylistGen(VideoGeneratorModel videoGeneratorModel) {
		playlist = new Possibility();
		visitVideoGeneratorModel(videoGeneratorModel);
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
			}else {
			
			}
		}
	}

	@Override
	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia){
		if(mandatoryMedia.getDescription() instanceof VideoDescription){
			playlist.add((VideoDescription) (mandatoryMedia).getDescription());
		}
	}

	@Override
	public void visitOptionalMedia(OptionalMedia optionalMedia) {
		
		if(optionalMedia.getDescription() instanceof VideoDescription) {
			VideoDescription videoDescription = (VideoDescription) optionalMedia.getDescription();
			if(videoDescription.getProbability() == 0) {
				(videoDescription).setProbability(50);
			}
			double random = Math.random() * 100;
			if(random < videoDescription.getProbability()) {
				playlist.add((VideoDescription)(optionalMedia.getDescription()));
			}
		}else {
			
		}
	}

	@Override
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia) {
		List<VideoDescription> videoDescriptions = new ArrayList<>();
		
		for(MediaDescription mediaDescription : alternativesMedia.getMedias()) {
			if(mediaDescription instanceof VideoDescription) {
				videoDescriptions.add((VideoDescription) mediaDescription);
			}
		}
		int randomIndex = (int) (Math.random() * videoDescriptions.size());
		playlist.add(videoDescriptions.get(randomIndex));
	}
	
	
	public Possibility getPlaylist() {
		return playlist;
	}
}

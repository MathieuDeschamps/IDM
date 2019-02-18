package generators;


import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.ImageDescription;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import fr.istic.videoGen.VideoGeneratorModel;

/**
 * Interface use to quickly build the functions to browse video gen model.
 */
public interface VisitorVideoGen {

	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel);

	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia);
	
	public void visitOptionalMedia(OptionalMedia optionalMedia);
	
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia);
	
	public void visitMediaDescription(MediaDescription MediaDescription);

	public void visitVideoDescription(VideoDescription videoDescription);

	public void visitImageDescription(ImageDescription imageDescription);
}
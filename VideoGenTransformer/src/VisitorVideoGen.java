import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoGeneratorModel;

public interface VisitorVideoGen {

	public void visitVideoGeneratorModel(VideoGeneratorModel videoGeneratorModel);

	public void visitMandatoryMedia(MandatoryMedia mandatoryMedia);
	
	public void visitOptionalMedia(OptionalMedia optionalMedia);
	
	public void visitAlternativeMedia(AlternativesMedia alternativesMedia);
}

package generators;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import fr.istic.videoGen.VideoGeneratorModel;
import model.Possibility;

public class TestConverter {

	@Test
	public void example1Converter() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		assertNotNull(videoGen);	
		Converter converter = new Converter(videoGen);
		converter.process();

	}

}

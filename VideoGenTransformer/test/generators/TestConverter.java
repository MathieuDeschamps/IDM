package generators;

import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import fr.istic.videoGen.VideoGeneratorModel;

public class TestConverter {

	@Test
	public void example1Converter() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		assertNotNull(videoGen);	
		ConverterToMp4 converter = new ConverterToMp4(videoGen);
		converter.process();

	}

}

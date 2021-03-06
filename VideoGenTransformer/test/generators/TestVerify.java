package generators;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import exceptions.FileNotFoundException;
import exceptions.IdAlreadyExists;
import exceptions.InvalidProbability;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.Verify;
import generators.VideoGenHelper;

public class TestVerify {

	@Test(expected = IdAlreadyExists.class)
	public void shouldRunIdAlreadyExistsBad1() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad1.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}

	@Test(expected = IdAlreadyExists.class)
	public void shouldRunIdAlreadyExistsBad2() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad2.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}
	
	@Test(expected = IdAlreadyExists.class)
	public void shouldRunIdAlreadyExistsBad3() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad3.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}
	
	@Test(expected = InvalidProbability.class)
	public void shouldRunIdAlreadyExistsBad4() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad4.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}

	@Test(expected = InvalidProbability.class)
	public void shouldRunIdAlreadyExistsBad5() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad5.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}
	
	@Test(expected = InvalidProbability.class)
	public void shouldRunIdAlreadyExistsBad6() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad6.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}
	
	@Test(expected = FileNotFoundException.class)
	public void shouldRunFileNotFoundBad7() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/bad7.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		fail("The exception was not thrown");
	}
	
	@Test
	public void shouldRunExample1() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample2() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	@Test
	public void shouldRunExample3() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	@Test
	public void shouldRunExample4() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	@Test
	public void shouldRunExample5() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	
	@Test
	public void shouldRunExample6() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample7() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample8() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample9() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	@Test
	public void shouldRunExample10() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample11() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample12() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
	@Test
	public void shouldRunExample13() throws Exception {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example13.videogen"));
		Verify verif = new Verify(videoGen);
		verif.process();
		assertNotNull(verif);
	}
	
}

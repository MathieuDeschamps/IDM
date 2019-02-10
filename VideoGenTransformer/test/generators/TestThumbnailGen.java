package generators;



import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import generators.VideoGenHelper;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.ThumbnailGen;

public class TestThumbnailGen {

	@Test
	public void testInJavaTp2Example1() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example2() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example3() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example4() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example5() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example6() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example7() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example8() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example9() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example10() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example11() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example12() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
	
	@Test
	public void testInJavaTp2Example13() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		assertNotNull(videoGen);	
		ThumbnailGen thumbnailGen = new ThumbnailGen(videoGen);
	}
}
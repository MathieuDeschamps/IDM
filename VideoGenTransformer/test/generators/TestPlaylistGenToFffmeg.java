package generators;


import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import fr.istic.videoGen.VideoGeneratorModel;
import model.Possibility;
import tools.Utils;

public class TestPlaylistGenToFffmeg {
	
	@Test
	public void example1toFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example1");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example2ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example2");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example3ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example3");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example4ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example4");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example5ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example5");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void exampleTo6Ffmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example6");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example7ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example7");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}

	
	@Test
	public void example8ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example8");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example9ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example9");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example10ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		playlistGen.genPlaylist("Example10");
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example11ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")),playlist.length());
	}
	
	@Test
	public void example12ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")), playlist.length());
	}
	
	@Test
	public void example13ToFfmpeg(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example13.videogen"));
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
		assertEquals(Utils.nbLignes(playlist.toFfmpeg("")), playlist.length());
	}
	
	
}




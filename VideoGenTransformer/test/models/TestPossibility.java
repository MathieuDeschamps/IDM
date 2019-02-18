package models;
import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import generators.VideoGenHelper;
import model.Possibility;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.PlaylistGen;

public class TestPossibility {
	
	@Test
	public void containsFalseExample1() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample2() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample3() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample4() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample5() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample6() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample7() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample8() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsFalseExample9() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void containsTrueExample10() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertTrue(playlist.containsImageDescription());
	}
	
	@Test
	public void containsTrueExample11() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertTrue(playlist.containsImageDescription());
	}
	
	@Test
	public void containsTrueExample12() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertTrue(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample1() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();	
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample2() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample3() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample4() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample5() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample6() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample7() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample8() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample9() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertFalse(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample10() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertTrue(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample11() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertTrue(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}
	
	@Test
	public void toPlaylistExample12() {
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		playlistGen.process();
		Possibility playlist = playlistGen.getPlaylist();
		assertTrue(playlist.containsImageDescription());
		playlist = playlist.toPlaylist();
		assertFalse(playlist.containsImageDescription());
	}

}

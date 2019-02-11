package generators;

import static org.junit.Assert.*;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import exceptions.FfmpegException;
import generators.VideoGenHelper;
import model.Possibility;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.PlaylistGen;
import tools.Ffmpeg;
import tools.Utils;
import tools.UtilsTest;

public class TestPlaylistGenBis {


		
		@Test
		public void example1PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example1";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example2PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example2";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example3PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example3";;
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);		}
		
		@Test
		public void example4PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example4";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example5PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example5";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example6PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example6";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example7PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example7";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
			
		}

		
		@Test
		public void example8PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example8";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example9PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example9";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
			
		}
		
		@Test
		public void example10PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example10";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
			
		}
		
		@Test
		public void example11PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example11";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example12PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example12";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void example13PlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example13.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "Example12";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
		
		@Test
		public void gotPlaylistGen() throws Exception{
			VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/iGOTa.videogen"));
			PlaylistGen playlistGen = new PlaylistGen(videoGen);
			Possibility playlist = playlistGen.getPlaylist();
			String outputName = "iGOTa";
			playlistGen.genPlaylist(outputName);
			int duration = Ffmpeg.getDuration("res/playlists/"+outputName+".mp4");
			assertEquals(playlist.duration(), duration);
		}
				
	}


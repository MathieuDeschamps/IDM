package services;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import services.PlaylistService;

public class TestPlaylistService {
	
	private static final int NB_PLAYLIST_GEN = 10;
	
	@Test
	public void shouldProcessWithRequiredFile() {
		PlaylistService service = new PlaylistService("test-files/iGOTa.videogen");
		List<String> fileRequired = new ArrayList<>();
		fileRequired.add("Dragonstone.mp4");
		fileRequired.add("Braavos.mp4");
		String outputPath = service.process(fileRequired);
		File video = new File(outputPath);
		assertTrue(video.exists());
	}
	
	@Test
	public void shouldProcessNbTimes() {
		String path = "";
		String outputName = "";
		String specsName = "";
		PlaylistService service = new PlaylistService(path + outputName + specsName);
		List<String> outputPaths = service.process(outputName, NB_PLAYLIST_GEN);
		File video;
		for(String outputPath : outputPaths) {
			video = new File(outputPath);
			assertTrue(video.exists());
		}
	}
	
	

}

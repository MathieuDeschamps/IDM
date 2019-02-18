package services;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import model.ProjectVideoGen;
import services.PlaylistService;

public class TestPlaylistService {
	
	private static final int NB_PLAYLIST_GEN = 10;
	
	//@Test
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
		String path ="/home/jeremy/Téléchargements/high_scale_tests/IDM_unzip_folder/LEBLANC_VANSTEEN/spec.videogen";
		String outputFolderPath = "/home/jeremy/Téléchargements/high_scale_tests/IDM_unzip_folder/LEBLANC_VANSTEEN/";
		String outputName = "LEBLANC_VANSTEEN";
		String[] outputPaths = new String[0];
		PlaylistService service = new PlaylistService(outputFolderPath);
		ProjectVideoGen project = new ProjectVideoGen(outputName, outputFolderPath, path, NB_PLAYLIST_GEN);
		service.process(project, outputName);
			outputPaths = project.getPlaylistPaths();
		File video;
		for(String outputPath : outputPaths) {
			video = new File(outputPath);
			assertTrue(video.exists());
		}
	}
	
	

}

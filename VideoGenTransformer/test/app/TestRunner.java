package app;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class TestRunner {

	@Test
	public void shoudlRunProcessRequiredFile() {
		Runner runner = new Runner("test-files/iGOTa.videogen");
		List<String> fileRequired = new ArrayList<>();
		fileRequired.add("Dragonstone.mp4");
		fileRequired.add("Braavos.mp4");
		Optional<String> optional = runner.processPlaylist(fileRequired);
		if(optional.isPresent()) {
			String outputPath = optional.get();
			File playlist = new File(outputPath);
			assertTrue(playlist.exists());
		}else {
			fail("The playlist was not be generated");
		}
	}

}

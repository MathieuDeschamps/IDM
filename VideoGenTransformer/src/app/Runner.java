package app;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;

import exceptions.FfmpegException;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.ConverterToMp4;
import generators.PlaylistGen;
import generators.Verify;
import generators.VideoGenHelper;
import model.Possibility;

public class Runner {
	
	private static final int NB_MAX_ITERATION_GEN_PLAYLIST = 100; 
	
	private VideoGeneratorModel videoGeneratorModel;
	
	/**
	 * @param pathSpecsFile the path to the file (.videogen)
	 */
	public Runner(String pathSpecsFile) {
		this.videoGeneratorModel = new VideoGenHelper().loadVideoGenerator(URI.createURI(pathSpecsFile));
	}
	
	/**
	 * Methods called by the JHipster application
	 * @param fileNeeded the names of the file required in the playlist
	 * @return optional which contains the output path of the playlist
	 */
	public Optional<String> processPlaylist(List<String> fileRequired) {
		String outputPath = "res/playlists/playlist_gen.mp4";
		PlaylistGen playlist = new PlaylistGen(videoGeneratorModel);
		Possibility possibility;
		int nbIteration = 0;
		boolean matchRequirement;
		int i;
		do {			
			playlist.process();
			possibility = playlist.getPlaylist();
			nbIteration++;
			matchRequirement = true;
			i = 0;
			// check if the possibility contains the required file 
			while(matchRequirement && i < fileRequired.size()){
			if(!possibility.containsFile(fileRequired.get(i))) {
					matchRequirement = false;
				}
			i++;
			}		
		}while((!matchRequirement) &&
				nbIteration < NB_MAX_ITERATION_GEN_PLAYLIST);
		// Generate the playlist with the possibilty
		try {
			return playlist.genPlaylist("playlist_gen");
		} catch (FfmpegException e) {
			System.err.println(e.getMessage());
			return Optional.empty();
		}
	}
	
	/**
	 * Method call high scale tests
	 * @param fileName the name of the output file
	 * @param nbPlaylist the number of playlist to generate
	 */
	public void processPlaylist(String fileName, int nbPlaylist) {
		String outputPath;
		PlaylistGen playlist = new PlaylistGen(videoGeneratorModel);
		for(int i = 0; i < nbPlaylist; i++) {
			outputPath = "res/playlists/" + fileName + i + ".mp4";
			try {
				playlist.genPlaylist(outputPath);
			} catch (FfmpegException e) {
				System.err.println(e.getMessage());
				Optional.empty();
			}
		}
	}
	
	/**
	 * Convert the path of videoseq media into mp4
	 */
	public void processConverterToMp4(){
		ConverterToMp4 converter = new ConverterToMp4(videoGeneratorModel);
		try {
			converter.process();
		} catch (FfmpegException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Verify if the file (.videogen) match the requirement
	 * @return true if the file macth the requirement
	 * 			otherwise false and print the exception
	 */
	public boolean processVerify() {
		Verify verify = new Verify(videoGeneratorModel);
		try {
			verify.process();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}
}

package services;

import java.util.ArrayList;
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

public class PlaylistService {
	
	private static final int NB_MAX_ITERATION_GEN_PLAYLIST = 100; 
	
	private VideoGeneratorModel videoGeneratorModel;
	
	/**
	 * @param pathSpecsFile the path to the file (.videogen)
	 */
	public PlaylistService(String pathSpecsFile) {
		this.videoGeneratorModel = new VideoGenHelper().loadVideoGenerator(URI.createURI(pathSpecsFile));
	}
	
	/**
	 * Methods called by the JHipster application
	 * @param fileNeeded the names of the file required in the playlist
	 * @return the output path of the video
	 */
	public String process(List<String> fileRequired) {
		if(fileRequired == null) { fileRequired = new ArrayList<>();}
		String outputPath = "";
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
			Optional<String> optional = playlist.genPlaylist("playlist_gen");
			if(optional.isPresent()) {
				outputPath = optional.get();
			}
		} catch (FfmpegException e) {
			System.err.println(e.getMessage());
		}
		return outputPath;
	}
	
	/**
	 * Method call by high scale tests
	 * @param fileName the name of the output file
	 * @param nbPlaylist the number of playlist to generate
	 * @return list of the output path of the video 
	 */
	public List<String> process(String fileName, int nbPlaylist) {
		if(fileName == null) { fileName = "";}
		
		List<String> outputPaths = new ArrayList<>();
		
		// checks if the videoGeneratorModel match the requirement
		Verify verify = new Verify(videoGeneratorModel);
		try {
			verify.process();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		// converts the videoseq media into .mp4
		ConverterToMp4 converter = new ConverterToMp4(videoGeneratorModel);
		try {
			converter.process();
		} catch (FfmpegException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		// generate nb playlist with the videoGenModel
		PlaylistGen playlist = new PlaylistGen(videoGeneratorModel);
		Optional<String> outputPath; 
		for(int i = 0; i < nbPlaylist; i++) {
			try {
				outputPath = playlist.genPlaylist(fileName + i);
				if(outputPath.isPresent()) {
					outputPaths.add(outputPath.get());
				}
			} catch (FfmpegException e) {
				System.err.println(e.getMessage());
			}
		}
		return outputPaths;
	}
}

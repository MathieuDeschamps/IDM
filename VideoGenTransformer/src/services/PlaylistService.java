package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;

import exceptions.FfmpegException;
import exceptions.FileNotFoundException;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.ConverterToMp4;
import generators.LocationUpdater;
import generators.PlaylistGen;
import generators.Verify;
import generators.VideoGenHelper;
import model.Possibility;
import model.ProjectVideoGen;

public class PlaylistService {
	
	private static final int NB_MAX_ITERATION_GEN_PLAYLIST = 100; 
	
	private VideoGeneratorModel videoGeneratorModel;

	private String parentPath;

	private List<String> outputPaths;

	private Exception error;

	
	/**
	 * @param pathSpecsFile the path to the file (.videogen)
	 */
	public PlaylistService(String pathSpecsFile) {
		this.parentPath = pathSpecsFile.substring(0, pathSpecsFile.lastIndexOf("/") + 1);
		this.videoGeneratorModel = new VideoGenHelper().loadVideoGenerator(URI.createURI(pathSpecsFile));
		this.outputPaths = new ArrayList<>();
	}
	
	/**
	 * 
	 * @return true if correct initiation
	 * 			false otherwise
	 */
	private boolean init(ProjectVideoGen project) {
		// update path
		LocationUpdater updater = new LocationUpdater(videoGeneratorModel);
		boolean hasBeenInitialised = true;
		try {
			updater.process(this.parentPath);
			project.setLocated(true);
		} catch (Exception e) {
			project.addError(e);
			project.setLocated(false);
			hasBeenInitialised = false;
		}
		
		// checks if the videoGeneratorModel match the requirement
		Verify verify = new Verify(videoGeneratorModel);
		try {
			verify.process();
			project.setVerified(true);
		} catch (Exception e) {
			project.setVerified(false);
			project.addError(e);
			hasBeenInitialised = false;
		}
		
		System.out.println("\nConverting videoseq of project " +  project.getTitle() + " ...");
		// converts the videoseq media into .mp4
		ConverterToMp4 converter = new ConverterToMp4(videoGeneratorModel);
		try {
			converter.process();
			project.setConverted(true);
		} catch (Exception e) {
			project.setConverted(false);
			project.addError(e);
			hasBeenInitialised = false;
		}
		return hasBeenInitialised;
	}
	
	
	/**
	 * Methods called by the JHipster application
	 * @param fileRequired the names of the file required in the playlist
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
			Optional<String> optional = playlist.genPlaylist(this.parentPath, "playlist_gen");
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
	 * @param project where the error are logged
	 * @param fileName the name of the output file
	 */
	public void process(ProjectVideoGen project, String fileName) {
		if(fileName == null) { fileName = "";}
		
		boolean isCorrect = init(project);
		if(!isCorrect) {
			return;
		};
				
		// generate nb playlist with the videoGenModel
		PlaylistGen playlist = new PlaylistGen(videoGeneratorModel);
		
		Optional<String> playlistPath; 
		for(int i = 0; i < project.getNbPlaylistToGenerate(); i++) {
			try {
				playlist.process();
				playlistPath = playlist.genPlaylist(project.getDirectory(), i + "_" + fileName);
				if(playlistPath.isPresent()) {
					project.addPlaylistPath(playlistPath.get());				
				}
			} catch (FfmpegException e) {
				project.addError(e);
				return;
			}
		}
	}
}

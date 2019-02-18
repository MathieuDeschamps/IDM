package model;

import java.util.ArrayList;
import java.util.List;

public class ProjectVideoGen {
	
	private String pathVideoGenSpec;
	private String title;
	private List<Exception> errors;
	private int nbPlaylistGenerated;
	private boolean isLocated;
	private boolean isConverted;
	private boolean isVerified;
	private int nbPlaylistToGenerate;
	private String directory;
	private String[] playlistPaths;
	
	public ProjectVideoGen(String title, String directory, String pathVideoGenSpec, int nbPlaylistToGenerate) {
		super();
		this.pathVideoGenSpec = pathVideoGenSpec;
		this.directory = directory;
		this.title = title;
		this.isLocated = false;
		this.isConverted = false;
		this.isVerified = false;
		this.errors = new ArrayList<Exception>();
		this.nbPlaylistGenerated = 0;
		this.nbPlaylistToGenerate = nbPlaylistToGenerate;
		this.playlistPaths = new String[nbPlaylistToGenerate];
	}
	public String getDirectory() {
		return directory;
	}
	public String getPathVideoGenSpec() {
		return pathVideoGenSpec;
	}

	public void addError(Exception error) {
		this.errors.add(error);
	}
	public String getTitle() {
		return title;
	}
	public int getNbPlaylistToGenerate() {
		return nbPlaylistToGenerate;
	}
	public void setLocated(boolean isLocated) {
		this.isLocated = isLocated;
	}
	public void setConverted(boolean isConverted) {
		this.isConverted = isConverted;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public boolean hasError() {
		return this.errors.size() > 0;
	}
	
	public void addPlaylistPath(String playlistPath) {
		this.playlistPaths[nbPlaylistGenerated] = playlistPath;
		nbPlaylistGenerated++;
	}
	public String[] getPlaylistPaths() {
		return playlistPaths;
	}
	
	public String toLog() {
		String log = "";
		log += title + " >";
		log += " Located ";
		if(isLocated) {
			log += "OK";
		}else {
			log +="FAIL";
		}
		log += "| Verified ";
		if(isVerified) {
			log += "OK";
		}else {
			log +="FAIL";
		}
		log += "| Converted ";
		if(isConverted) {
			log += "OK";
		}else {
			log +="FAIL";
		}
		if(!errors.isEmpty()) {
			log += "\n Errors:";
			for(Exception error: errors) {
				log += "\n-" + error.getMessage();
			}
		}
		log += "\n Number of playlist generated: " + nbPlaylistGenerated + "/" + nbPlaylistToGenerate + "\n";
		for(String playlistPath: playlistPaths) {
			if(playlistPath != null) {
				log += playlistPath + "\n";
			}
		}
		
		log += "\n";
		return log;
	}


	
	
}

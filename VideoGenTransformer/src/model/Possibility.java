package model;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;

import exceptions.FfmpegException;
import fr.istic.videoGen.AlternativesMedia;
import fr.istic.videoGen.ImageDescription;
import fr.istic.videoGen.MandatoryMedia;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.OptionalMedia;
import fr.istic.videoGen.VideoDescription;
import tools.Ffmpeg;

public class Possibility {
	
	private List<MediaDescription> possibility;
	
	
	public Possibility() {
		possibility = new ArrayList<MediaDescription>();
	}
	
	public void add(MediaDescription mediaDescription) {
		possibility.add(mediaDescription);
	}
	
	@Override
	public Possibility clone() {
		Possibility clone = new Possibility();
		for(MediaDescription mediaDescription : possibility) {
			clone.add(mediaDescription);
		}
		return clone;
	}
	
	public Optional<MediaDescription> getById(String id){
		for(MediaDescription mediaDescription : possibility) {
			if(mediaDescription instanceof VideoDescription &&
			((VideoDescription) mediaDescription).getVideoid().equals(id)){
				return Optional.of(mediaDescription);
			}else if(mediaDescription instanceof ImageDescription &&
			((ImageDescription) mediaDescription).getImageid().equals(id)) {
				return Optional.of(mediaDescription);				
			}
		}
		return Optional.empty();
	}

	public Optional<MediaDescription> get(int i){
		if(i >= 0 &&  i < possibility.size()) {
			return Optional.of(possibility.get(i));			
		}else {
			return Optional.empty();
		}
	}
	
	public int size() {
		int size = 0;
		File file;
		for(MediaDescription mediaDescription : possibility) {
			file = new File(mediaDescription.getLocation());
			if(file.isFile()) {
				size += file.length();
			}
		}
		return size;
	}
	
	public int duration() {
		int duration = 0;
		for(MediaDescription mediaDescription: possibility) {
			if(mediaDescription instanceof VideoDescription) {
				VideoDescription videoDescription = (VideoDescription) mediaDescription;
				try {
					duration += Ffmpeg.getDuration(videoDescription.getLocation());
				} catch (FfmpegException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(mediaDescription instanceof ImageDescription){
				
			}
		}
		return duration;
	}
	
	public int length() {
		return possibility.size();
	}
	
	/**
	 * 
	 * @return true if the possibility contains a imageDescription element
	 * 			false otherwise
	 */
	public boolean containsImageDescription() {
		for (MediaDescription mediaDescription : this.possibility) {
			if (mediaDescription instanceof ImageDescription) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Retrieve a new possibility without imageDescription element
	 * @return 
	 */
	public Possibility toPlaylist() {
		Possibility playlist = new Possibility();
		MediaDescription mediaDescription;
		
		for(int i = 0; i < this.length(); i++) {
			mediaDescription = this.possibility.get(i);
			if(mediaDescription instanceof VideoDescription) {
				playlist.add(mediaDescription);
			}
		}
		
		return playlist;
	}
	
	
	@Override
	public String toString() {
		String result = "";
		for(MediaDescription mediaDescription : possibility) {
			String id ="";
			if(mediaDescription instanceof VideoDescription) {
				id = ((VideoDescription) mediaDescription).getVideoid();
			}else if (mediaDescription instanceof ImageDescription){
				id = ((ImageDescription) mediaDescription).getImageid();
			}
			result += id + "\t" + mediaDescription.getLocation() + "\n";
		}
		return result;
	}
	
	public String toFfmpeg(String parentPath) {
		String result = "";
		for(MediaDescription mediaDescription : possibility) {
			String id ="";
			if(mediaDescription instanceof VideoDescription) {
				id = ((VideoDescription) mediaDescription).getVideoid();
			}else if (mediaDescription instanceof ImageDescription){
				id = ((ImageDescription) mediaDescription).getImageid();
			}
			result += "file\t" + parentPath + mediaDescription.getLocation() + "\n";
		}
		return result;
	}
}

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.istic.videoGen.ImageDescription;
import fr.istic.videoGen.MediaDescription;
import fr.istic.videoGen.VideoDescription;

public class Possibility {
	
	private List<MediaDescription> possibility;
	
	
	public Possibility() {
		possibility = new ArrayList<MediaDescription>();
	}
	
	public void add(MediaDescription mediaDescription) {
		possibility.add(mediaDescription);
	}
	
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
	
	public int length() {
		return possibility.size();
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
}

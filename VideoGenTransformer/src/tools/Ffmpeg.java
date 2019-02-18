package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.FfmpegException;

/**
 * Class which executs ffmpeg commands
 */
public class Ffmpeg {
	
	/**
	 * Makes a thumbnails of a video
	 * @param inputPath the path of the video
	 * @param videoDuration the duration the video
	 * @param outputPath where is save the thumbnails
	 * @throws FfmpegException if the thumbnails has not been generated
	 */
	public static void makeThumbnails(String inputPath, String videoDuration, String outputPath) throws FfmpegException {
				
		String command = "ffmpeg -y -i "; 
		command += inputPath;
		command += " -r 1 -t 00:00:01 -ss ";
		command += videoDuration;
		command += " -f image2 ";
		command += outputPath;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			File thumbnail = new File(outputPath);
			if(!thumbnail.exists()) {
				throw new FfmpegException("Imposible to generate the thumbnails for " + inputPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Generates the concatenation of videos
	 * @param inputPath where is the text file with the list of video 
	 * @param outputPath where is save the concatenation of video
	 * @throws FfmpegException is the concatenation has not been generated
	 */
	public static void concatVideos(String inputPath, String outputPath) throws FfmpegException {
		String command ="ffmpeg -f concat -safe 0 -i ";
		command += inputPath;
		command += " -c copy ";
		command += outputPath;
		
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			File video = new File(outputPath);
			if(!video.exists()) {
				throw new FfmpegException("Impossible to generate the concatenation of the file " + inputPath);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gives the duration of a video
	 * @param path where is the video
	 * @return the duration of the video in seconds
	 * @throws FfmpegException if the video has not been found
	 */
	public static int getDuration(String path) throws FfmpegException{
		String command = "ffprobe -i "+ path + " -show_format ";
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(command);
			
		} catch (IOException e) {
			throw new FfmpegException("Impossible to get the duration of " + path);
		}
		
		BufferedReader stdInput = new BufferedReader(new 
			     InputStreamReader(process.getInputStream()));

		String result = Utils.readBufferReader(stdInput);
		// parse the output of the command to get the duration
		String startString = "duration=";
		int indexStart = result.indexOf(startString);
		if(indexStart == -1){ 
			throw new FfmpegException("Impossible to find the duration of " + path);
		}
		indexStart += startString.length();
		String tmpString = result.substring(indexStart);
		int indexEnd = tmpString.indexOf('\n');
		if(indexEnd == -1) {
			throw new FfmpegException("Impossible to find the duration of " + path);
		}
		if(indexStart != -1 && indexEnd != -1) {
			tmpString = result.substring(indexStart, indexStart + indexEnd);
			float floatDuration = Float.parseFloat(tmpString);			
			int intDuration = Math.round(floatDuration);
			return intDuration;
		}else {
			throw new FfmpegException("Impossible to parse the duration of " + path);	
		}
	}
	
	/**
	 * Format a video into mp4
	 * @param inputPath where is the video to format
	 * @param outputPath where is save the formatted videos
	 * @throws FfmpegException if the video to format has not been found
	 * 			or if the formatted video has not been generated
	 */
	public static void formatVideo(String inputPath, String outputPath) throws FfmpegException {
		String command = "ffmpeg -i ";
		command += inputPath;
		command += " -acodec libvo_aacenc -vcodec libx264 -s 1920x1080 -r 60 -strict experimental ";
		command += outputPath;
	
			//System.out.println("formatVideo: " + command);
			
			try {
				Process process = Runtime.getRuntime().exec(command);
				process.waitFor();
				File format = new File(outputPath);
				if(!format.exists()){
					throw new FfmpegException("Impossible to format the video " + inputPath);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}

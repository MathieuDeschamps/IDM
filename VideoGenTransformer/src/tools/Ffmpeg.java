package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import exceptions.ImageNotGenerated;
import exceptions.FfmpegException;

public class Ffmpeg {

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
	
	public static void concatVideos(String inputPath, String outputPath) throws FfmpegException {
		String command ="ffmpeg -f concat -safe 0 -i ";
		command += inputPath;
		command += " -c copy ";
		command += outputPath;
		
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			File video = new File(outputPath);
			if(!!video.exists()) {
				throw new FfmpegException("Impossible to generate the concatenation to " + outputPath);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	
	public static void formatVideo(String inputPath, String outputPath) throws FfmpegException {
		String command = "ffmpeg -i ";
		command += inputPath;
		command += " -acodec libvo_aacenc -vcodec libx264 -s 1920x1080 -r 60 -strict experimental ";
		command += outputPath;
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			File format = new File(outputPath);
			if(!format.exists()){
				throw new FfmpegException("Impossible to format the video " + inputPath);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

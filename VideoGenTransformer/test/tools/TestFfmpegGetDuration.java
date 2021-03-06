package tools;


import static org.junit.Assert.*;

import org.junit.Test;

import tools.Ffmpeg;

public class TestFfmpegGetDuration {
	
	@Test
	public void durationAWetHawk() throws Exception {
		String inputPath =  "res/videos/A_Wet_Hawk.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(10, duration);
	}
	
	@Test
	public void durationBearInAForest() throws Exception {
		String inputPath =  "res/videos/Bear_In_A_Forest.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(83, duration);
	}
	
	@Test
	public void durationBokehVideoOfLeaves() throws Exception {
		String inputPath =  "res/videos/Bokeh_Video_Of_Leaves.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(22, duration);
	}
	
	@Test
	public void durationCoffeeMachineDispensingCoffee() throws Exception {
		String inputPath =  "res/videos/Coffee_Machine_Dispensing_Coffee.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(17, duration);
	}
	
	@Test
	public void durationCuteCatFallingAsleep() throws Exception {
		String inputPath =  "res/videos/Cute_Cat_Falling_Asleep.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(37, duration);
	}
	
	@Test
	public void durationPexelsVideos4335() throws Exception {
		String inputPath =  "res/videos/Pexels_Videos_4335.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(16, duration);
	}
	
	@Test
	public void durationPexelsVideos1562544() throws Exception {
		String inputPath =  "res/videos/Pexels_Videos_1562544.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(15, duration);
	}
	
	@Test
	public void durationVideo_Of_Camels() throws Exception {
		String inputPath =  "res/videos/Video_Of_Camels.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(10, duration);
	}
	
	@Test
	public void durationVideo_Of_People_Walking() throws Exception {
		String inputPath =  "res/videos/Video_Of_People_Walking.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		assertEquals(19, duration);
	}

}

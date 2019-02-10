package tools;


import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.ImageNotGenerated;
import tools.Ffmpeg;
import tools.Utils;

public class TestFfmpegMakeThumbnail {
	
	@Test 
	public void testAWetHawk() throws ImageNotGenerated {
		String inputPath =  "res/videos/A_Wet_Hawk.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/A_Wet_Hawk.png");
	}
	
	@Test
	public void testBearInAForest() throws ImageNotGenerated {
		String inputPath =  "res/videos/Bear_In_A_Forest.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Bear_In_A_Forest.png");
	}
	
	@Test
	public void testBokehVideoOfLeaves() throws ImageNotGenerated {
		String inputPath =  "res/videos/Bokeh_Video_Of_Leaves.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Bokeh_Video_Of_Leaves.png");
	}
	
	@Test (expected = ImageNotGenerated.class)
	public void testCoffeeMachineDispensingCoffee() throws ImageNotGenerated {
		String inputPath =  "res/videos/Coffee_Machine_Dispensing_Coffee.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Coffee_Machine_Dispensing_Coffee.png");
		fail("The exception was not thrown");
	}
	
	@Test
	public void testCuteCatFallingAsleep() throws ImageNotGenerated {
		String inputPath =  "res/videos/Cute_Cat_Falling_Asleep.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Cute_Cat_Falling_Asleep.png");
		assertEquals(37, duration);
	}
	
	@Test
	public void testPexelsVideos4335() throws ImageNotGenerated {
		String inputPath =  "res/videos/Pexels_Videos_4335.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Pexels_Videos_4335.png");
	}
	
	@Test (expected = ImageNotGenerated.class)
	public void testPexelsVideos1562544() throws ImageNotGenerated {
		String inputPath =  "res/videos/Pexels_Videos_1562544.mp4";
		int duration = Ffmpeg.getDuration("res/videos/Pexels_Videos_1562544.mp4");
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Pexels_Videos_1562544.png");
		fail("The exception was not thrown");
	}
	
	@Test
	public void testVideo_Of_Camels() throws ImageNotGenerated {
		String inputPath =  "res/videos/Video_Of_Camels.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Video_Of_Camels.png");
	}
	
	@Test
	public void testVideo_Of_People_Walking() throws ImageNotGenerated {
		String inputPath =  "res/videos/Video_Of_People_Walking.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Video_Of_People_Walking.png");
	}
	

	

}

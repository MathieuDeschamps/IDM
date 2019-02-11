package tools;


import static org.junit.Assert.*;

import org.junit.Test;

import tools.Ffmpeg;
import tools.Utils;

public class TestFfmpegMakeThumbnail {
	
	@Test 
	public void testAWetHawk() throws Exception {
		String inputPath =  "res/videos/A_Wet_Hawk.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/A_Wet_Hawk.png");
	}
	
	@Test (expected = Exception.class)
	public void testBearInAForest() throws Exception {
		String inputPath =  "res/videos/Bear_In_A_Forest.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration + 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Bear_In_A_Forest.png");
		fail("The exception was not thrown");
	}
	
	@Test
	public void testBokehVideoOfLeaves() throws Exception {
		String inputPath =  "res/videos/Bokeh_Video_Of_Leaves.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Bokeh_Video_Of_Leaves.png");
	}
	
	@Test
	public void testCoffeeMachineDispensingCoffee() throws Exception {
		String inputPath =  "res/videos/Coffee_Machine_Dispensing_Coffee.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Coffee_Machine_Dispensing_Coffee.png");
	}
	
	@Test
	public void testCuteCatFallingAsleep() throws Exception {
		String inputPath =  "res/videos/Cute_Cat_Falling_Asleep.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Cute_Cat_Falling_Asleep.png");
	}
	
	@Test
	public void testPexelsVideos4335() throws Exception {
		String inputPath =  "res/videos/Pexels_Videos_4335.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Pexels_Videos_4335.png");
	}
	
	@Test (expected = Exception.class)
	public void testPexelsVideos1562544() throws Exception {
		String inputPath =  "res/videos/Pexels_Videos_1562544.mp4";
		int duration = Ffmpeg.getDuration("res/videos/Pexels_Videos_1562544.mp4");
		String videoDuration = Utils.formatHHmmss(duration);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Pexels_Videos_1562544.png");
		fail("The exception was not thrown");
	}
	
	@Test
	public void testVideo_Of_Camels() throws Exception {
		String inputPath =  "res/videos/Video_Of_Camels.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Video_Of_Camels.png");
	}
	
	@Test
	public void testVideo_Of_People_Walking() throws Exception {
		String inputPath =  "res/videos/Video_Of_People_Walking.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Video_Of_People_Walking.png");
	}
	
	@Test
	public void testBraavos() throws Exception {
		String inputPath =  "res/genGOT/Braavos.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Braavos.png");
	}
	
	@Test
	public void testDorne() throws Exception {
		String inputPath =  "res/genGOT/Dorne.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Dorne.png");
	}
	
	@Test
	public void testDragonstone() throws Exception {
		String inputPath =  "res/genGOT/Dragonstone.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Dragonstone.png");
	}
	
	@Test
	public void testEastwatch() throws Exception {
		String inputPath =  "res/genGOT/Eastwatch.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Eastwatch.png");
	}
	
	@Test
	public void testEnding() throws Exception {
		String inputPath =  "res/genGOT/Ending.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Ending.png");
	}
	
	@Test
	public void testHarrenhal() throws Exception {
		String inputPath =  "res/genGOT/Harrenhal.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Harrenhal.png");
	}
	
	@Test
	public void testKing_s_Landing() throws Exception {
		String inputPath =  "res/genGOT/King_s_Landing.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/King_s_Landing.png");
	}
	
	@Test
	public void testMeereen() throws Exception {
		String inputPath =  "res/genGOT/Meereen.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Meereen.png");
	}
	
	@Test
	public void testMoatCailin() throws Exception {
		String inputPath =  "res/genGOT/Moat_Cailin.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Moat_Cailin.png");
	}
	
	@Test
	public void testOldtown() throws Exception {
		String inputPath =  "res/genGOT/Oldtown.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Oldtown.png");
	}
	
	@Test
	public void testOpening() throws Exception {
		String inputPath =  "res/genGOT/Opening.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Opening.png");
	}
	
	@Test
	public void testPentos() throws Exception {
		String inputPath =  "res/genGOT/Pentos.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Pentos.png");
	}
	
	@Test
	public void testPyke() throws Exception {
		String inputPath =  "res/genGOT/Pyke.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Pyke.png");
	}
	
	@Test
	public void testQarth() throws Exception {
		String inputPath =  "res/genGOT/Qarth.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Qarth.png");
	}
	
	@Test
	public void testRiverrun() throws Exception {
		String inputPath =  "res/genGOT/Riverrun.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Riverrun.png");
	}
	
	@Test
	public void testTheEyrie() throws Exception {
		String inputPath =  "res/genGOT/The_Eyrie.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/The_Eyrie.png");
	}
	
	@Test
	public void testTheTwins() throws Exception {
		String inputPath =  "res/genGOT/The_Twins.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/The_Twins.png");
	}
	
	@Test
	public void testTheWall() throws Exception {
		String inputPath =  "res/genGOT/The_Wall.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/The_Wall.png");
	}
	@Test
	public void testVaesDothrak() throws Exception {
		String inputPath =  "res/genGOT/Vaes_Dothrak.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Vaes_Dothrak.png");
	}
	
	@Test
	public void testWinterfell() throws Exception {
		String inputPath =  "res/genGOT/Winterfell.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Winterfell.png");
	}
	
	@Test
	public void testWinterfellBurning() throws Exception {
		String inputPath =  "res/genGOT/Winterfell_burning.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Winterfell_burning.png");
	}
	
	@Test
	public void testYunkai() throws Exception {
		String inputPath =  "res/genGOT/Yunkai.mp4";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Yunkai.png");
	}
	
	
}

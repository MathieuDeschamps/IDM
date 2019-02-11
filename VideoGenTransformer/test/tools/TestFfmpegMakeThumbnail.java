package tools;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

public class TestFfmpegMakeThumbnail {
	
	@Test 
	public void testAWetHawk() throws Exception {
		String inputPath =  "res/videos/A_Wet_Hawk.mp4";
		String outputPath = "res/thumbnails/A_Wet_Hawk.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test (expected = Exception.class)
	public void testBearInAForest() throws Exception {
		String inputPath = "res/videos/Bear_In_A_Forest.mp4";
		String outputPath = "res/thumbnails/Bear_In_A_Forest.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration + 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
		fail("The exception was not thrown");
	}
	
	@Test
	public void testBokehVideoOfLeaves() throws Exception {
		String inputPath = "res/videos/Bokeh_Video_Of_Leaves.mp4";
		String outputPath = "res/thumbnails/Bokeh_Video_Of_Leaves.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testCoffeeMachineDispensingCoffee() throws Exception {
		String inputPath =  "res/videos/Coffee_Machine_Dispensing_Coffee.mp4";
		String outputPath = "res/thumbnails/Coffee_Machine_Dispensing_Coffee.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testCuteCatFallingAsleep() throws Exception {
		String inputPath =  "res/videos/Cute_Cat_Falling_Asleep.mp4";
		String outputPath = "res/thumbnails/Cute_Cat_Falling_Asleep.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testPexelsVideos4335() throws Exception {
		String inputPath =  "res/videos/Pexels_Videos_4335.mp4";
		String outputPath = "res/thumbnails/Pexels_Videos_4335.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test (expected = Exception.class)
	public void testPexelsVideos1562544() throws Exception {
		String inputPath =  "res/videos/Pexels_Videos_1562544.mp4";
		String outputPath = "res/thumbnails/Pexels_Videos_1562544.png";
		int duration = Ffmpeg.getDuration("res/videos/Pexels_Videos_1562544.mp4");
		String videoDuration = Utils.formatHHmmss(duration);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
		fail("The exception was not thrown");
	}
	
	@Test
	public void testVideo_Of_Camels() throws Exception {
		String inputPath =  "res/videos/Video_Of_Camels.mp4";
		String outputPath = "res/thumbnails/Video_Of_Camels.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testVideo_Of_People_Walking() throws Exception {
		String inputPath =  "res/videos/Video_Of_People_Walking.mp4";
		String outputPath = "res/thumbnails/Video_Of_People_Walking.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testBraavos() throws Exception {
		String inputPath =  "res/genGOT/Braavos.mp4";
		String outputPath = "res/thumbnails/Braavos.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testDorne() throws Exception {
		String inputPath =  "res/genGOT/Dorne.mp4";
		String outputPath = "res/thumbnails/Dorne.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testDragonstone() throws Exception {
		String inputPath =  "res/genGOT/Dragonstone.mp4";
		String outputPath = "res/thumbnails/Dragonstone.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testEastwatch() throws Exception {
		String inputPath =  "res/genGOT/Eastwatch.mp4";
		String outputPath =  "res/thumbnails/Eastwatch.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testEnding() throws Exception {
		String inputPath =  "res/genGOT/Ending.mp4";
		String outputPath = "res/thumbnails/Ending.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testHarrenhal() throws Exception {
		String inputPath =  "res/genGOT/Harrenhal.mp4";
		String outputPath = "res/thumbnails/Harrenhal.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testKing_s_Landing() throws Exception {
		String inputPath =  "res/genGOT/King_s_Landing.mp4";
		String outputPath = "res/thumbnails/King_s_Landing.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testMeereen() throws Exception {
		String inputPath =  "res/genGOT/Meereen.mp4";
		String outputPath = "res/thumbnails/Meereen.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testMoatCailin() throws Exception {
		String inputPath =  "res/genGOT/Moat_Cailin.mp4";
		String outputPath = "res/thumbnails/Moat_Cailin.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testOldtown() throws Exception {
		String inputPath =  "res/genGOT/Oldtown.mp4";
		String outputPath = "res/thumbnails/Oldtown.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testOpening() throws Exception {
		String inputPath =  "res/genGOT/Opening.mp4";
		String outputPath = "res/thumbnails/Opening.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testPentos() throws Exception {
		String inputPath =  "res/genGOT/Pentos.mp4";
		String outputPath = "res/thumbnails/Pentos.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testPyke() throws Exception {
		String inputPath =  "res/genGOT/Pyke.mp4";
		String outputPath = "res/thumbnails/Pyke.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testQarth() throws Exception {
		String inputPath =  "res/genGOT/Qarth.mp4";
		String outputPath = "res/thumbnails/Qarth.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testRiverrun() throws Exception {
		String inputPath =  "res/genGOT/Riverrun.mp4";
		String outputPath = "res/thumbnails/Riverrun.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testTheEyrie() throws Exception {
		String inputPath =  "res/genGOT/The_Eyrie.mp4";
		String outputPath = "res/thumbnails/The_Eyrie.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testTheTwins() throws Exception {
		String inputPath =  "res/genGOT/The_Twins.mp4";
		String outputPath = "res/thumbnails/The_Twins.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testTheWall() throws Exception {
		String inputPath =  "res/genGOT/The_Wall.mp4";
		String outputPath = "res/thumbnails/The_Wall.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	@Test
	public void testVaesDothrak() throws Exception {
		String inputPath =  "res/genGOT/Vaes_Dothrak.mp4";
		String outputPath = "res/thumbnails/Vaes_Dothrak.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		Ffmpeg.makeThumbnails(inputPath, videoDuration, "res/thumbnails/Vaes_Dothrak.png");
	}
	
	@Test
	public void testWinterfell() throws Exception {
		String inputPath =  "res/genGOT/Winterfell.mp4";
		String outputPath = "res/thumbnails/Winterfell.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testWinterfellBurning() throws Exception {
		String inputPath =  "res/genGOT/Winterfell_burning.mp4";
		String outputPath = "res/thumbnails/Winterfell_burning.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void testYunkai() throws Exception {
		String inputPath =  "res/genGOT/Yunkai.mp4";
		String outputPath = "res/thumbnails/Yunkai.png";
		int duration = Ffmpeg.getDuration(inputPath);
		String videoDuration = Utils.formatHHmmss(duration - 1);
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.makeThumbnails(inputPath, videoDuration, outputPath);
		assertTrue(outputFile.exists());
	}
	
	
}

package tools;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import exceptions.FfmpegException;

public class TestFfmpegConcatVideos {

	@Test
	public void concatVideoExample1() throws FfmpegException {
		String inputPath = "res/playlists/testConcatVideosExample1.txt";
		String outputPath = "res/playlists/testConcatExample1.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void concatVideoExample2() throws FfmpegException {
		String inputPath = "res/playlists/testConcatVideosExample2.txt";
		String outputPath = "res/playlists/testConcatExample2.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void concatVideoExample3() throws FfmpegException {
		String inputPath = "res/playlists/testConcatVideosExample3.txt";
		String outputPath = "res/playlists/testConcatExample3.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test
	public void concatVideoExample4() throws FfmpegException {
		String inputPath = "res/playlists/testConcatVideosExample4.txt";
		String outputPath = "res/playlists/testConcatExample4.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
	}
	
	
	@Test
	public void concatVideoExample5() throws FfmpegException {
		String inputPath = "res/playlists/testConcatVideosExample5.txt";
		String outputPath = "res/playlists/testConcatExample5.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
	}
	
	
	@Test
	public void concatVideoExample6() throws FfmpegException {
		String inputPath = "res/playlists/testConcatVideosExample6.txt";
		String outputPath = "res/playlists/testConcatExample6.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
	}
	
	@Test(expected = FfmpegException.class)
	public void concatBadVideoPath() throws FfmpegException{
		String inputPath = "res/playlists/testConcatVideosBad1.txt";
		String outputPath = "res/playlists/testConcatBad1.mp4";
		File outputFile = new File(outputPath);
		assertFalse(outputFile.exists());
		Ffmpeg.concatVideos(inputPath, outputPath);
		assertTrue(outputFile.exists());
		fail("The exception was not thrown");
	}

}

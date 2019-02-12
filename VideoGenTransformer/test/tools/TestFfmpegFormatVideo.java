package tools;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFfmpegFormatVideo {

	@Test
	public void shouldFormatMovToMP4() throws Exception{
		Ffmpeg.formatVideo("res/videos/0013_HD_light_540p.mov", "res/videos/0013_HD_light_540p_gen.mp4");
	}

}

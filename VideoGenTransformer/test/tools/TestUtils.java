package tools;
import static org.junit.Assert.*;


import org.junit.Test;

import tools.Utils;

public class TestUtils {

	@Test
	public void testNbLignesEmpty() {
		assertEquals(0, Utils.nbLignes(""));
	}
	
	@Test
	public void testNbLignesNewLine() {
		assertEquals(1, Utils.nbLignes("\n"));
	}
	
	@Test
	public void testNbLignesNewLineSpace() {
		assertEquals(2, Utils.nbLignes("\n "));
	}
	
	@Test
	public void testNbLignesNewLineNewLine() {
		assertEquals(2, Utils.nbLignes("\n\n"));
	}
	
	@Test
	public void testNbLignesNewLineNewLineWord() {
		assertEquals(3, Utils.nbLignes("first line\n\n third line"));
	}
	
	@Test
	public void testNbLignesSpaceNewLine() {
		assertEquals(1, Utils.nbLignes(" \n"));
	}
	
	@Test
	public void testNbLignesOneLine() {
		assertEquals(1, Utils.nbLignes("a line\n"));
	}
		
	@Test
	public void testFormatHHmmssEdgesSec() {
		assertEquals("",Utils.formatHHmmss(0), "00:00:00");
		assertEquals("",Utils.formatHHmmss(1), "00:00:01");
	}
	
	@Test
	public void testFormatHHmmssEdgesMin() {
		assertEquals("",Utils.formatHHmmss(59), "00:00:59");
		assertEquals("",Utils.formatHHmmss(60), "00:01:00");
		assertEquals("",Utils.formatHHmmss(61), "00:01:01");
	}
	
	@Test
	public void testFormatHHmmssEdgesHours() {
		assertEquals("",Utils.formatHHmmss(3599), "00:59:59");
		assertEquals("",Utils.formatHHmmss(3600), "01:00:00");
		assertEquals("",Utils.formatHHmmss(3601), "01:00:01");
	}
	
	@Test
	public void testFormatHHmmssSuite1() {
		assertEquals("",Utils.formatHHmmss(476), "00:07:56");
		assertEquals("",Utils.formatHHmmss(588), "00:09:48");
		assertEquals("",Utils.formatHHmmss(123), "00:02:03");
	}
	
	@Test
	public void testFormatHHmmssSuite2() {
		assertEquals("",Utils.formatHHmmss(1248), "00:20:48");
		assertEquals("",Utils.formatHHmmss(2560), "00:42:40");
		assertEquals("",Utils.formatHHmmss(3569), "00:59:29");
	}
	
	@Test
	public void testFormatHHmmssSuite3() {
		assertEquals("",Utils.formatHHmmss(35298), "09:48:18");
		assertEquals("",Utils.formatHHmmss(75736), "21:02:16");
		assertEquals("",Utils.formatHHmmss(89478), "24:51:18");
	}

}

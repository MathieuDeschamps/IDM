import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;
import fr.istic.videoGen.VideoGeneratorModel;

public class VideoGenTest1 {
	
	@Test
	public void testInJavaTp2Example1() {
		
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		assertNotNull(videoGen);	
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		System.out.println("example1\n" + playlist.toString() + "lenght: " + playlist.length());
		assertTrue(playlist.length() >= 2 && playlist.length() <= 3);
	}
	
	@Test
	public void testInJavaTp2Example2() {
		
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		System.out.println("example2\n" + playlist.toString() + "lenght: " + playlist.length());
		assertTrue(playlist.length() >= 3 && playlist.length() <= 4);
	}
	
	@Test
	public void testInJavaTp2Example3() {
		
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		assertNotNull(videoGen);
		PlaylistGen playlistGen = new PlaylistGen(videoGen);
		Possibility playlist = playlistGen.getPlaylist();
//		System.out.println("example3\n" + playlist.toString() + "lenght: " + playlist.length());
		assertTrue(playlist.length() >= 3 && playlist.length() <= 5);
		
	}
	
	@Test
	public void testInJavaTp3Example1Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example2Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example3Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example4Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());	
	}
	@Test
	public void testInJavaTp3Example5Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}

	@Test
	public void testInJavaTp3Example6Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}

	@Test
	public void testInJavaTp3Example7Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}
	@Test
	public void testInJavaTp3Example8Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}

	@Test
	public void testInJavaTp3Example9Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}
	@Test
	public void testInJavaTp3Example10Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(testFunctions.getNbPossibilities(), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example11Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv11\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example1Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv1\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example2Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv2\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example3Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv3\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example4Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv4\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example5Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv5\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example6Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv6\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example7Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv7\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example8Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv8\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example9Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv9\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example10Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv10\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example11Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		TestFunctions testFunctions = new TestFunctions(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(testFunctions.getNbPossibilities(), TestFunctions.nbLignes(csv) -1);
//		System.out.println("csv11\n" +  csv);
	}
	
	
	
	
}




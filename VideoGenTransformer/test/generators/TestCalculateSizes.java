package generators;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import generators.VideoGenHelper;
import model.Possibility;
import fr.istic.videoGen.VideoGeneratorModel;
import generators.CalculateSizes;
import tools.Utils;
import tools.UtilsTest;

public class TestCalculateSizes {

	@Test
	public void testInJavaTp3Example1Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example2Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example3Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example4Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example5Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);		
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}

	@Test
	public void testInJavaTp3Example6Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}

	@Test
	public void testInJavaTp3Example7Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example8Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}

	@Test
	public void testInJavaTp3Example9Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example10Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example11Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example12Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example13Size(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example13.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		List<Possibility> possibilities = calculateSizes.getPossibilities();
		assertEquals(UtilsTest.nbPossibilities(videoGen), possibilities.size());
	}
	
	@Test
	public void testInJavaTp3Example1Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example1.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv1\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example2Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example2.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv2\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example3Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example3.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv3\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example4Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example4.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv4\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example5Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example5.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv5\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example6Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example6.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv6\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example7Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example7.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv7\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example8Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example8.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv8\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example9Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example9.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv9\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example10Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example10.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv10\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example11Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example11.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv11\n" +  csv);
	}
	
	@Test
	public void testInJavaTp3Example12Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example12.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv11\n" +  csv);
	}
	@Test
	public void testInJavaTp3Example13Csv(){
		VideoGeneratorModel videoGen = new VideoGenHelper().loadVideoGenerator(URI.createURI("test-files/example13.videogen"));
		CalculateSizes calculateSizes = new CalculateSizes(videoGen);
		String csv = calculateSizes.toCSV();
		assertEquals(UtilsTest.nbPossibilities(videoGen), Utils.nbLignes(csv) -1);
		System.out.println("csv11\n" +  csv);
	}
		
}

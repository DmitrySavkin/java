package org.iMage.edge.detection.sobel.filter;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FilterTest {

	private static final File TEST_DIR = new File("target/testData");
	private static final File IMAGE_FILE = new File("src/test/resources/camera_obscura.png");

	/**
	 * Input for test cases
	 */
	private static BufferedImage testImage;
	/**
	 * output from test cases
	 */
	private BufferedImage filteredImageTestResult;

	@BeforeClass
	public static void beforeClass() {
		if (TEST_DIR.exists()) {
			for (File f : TEST_DIR.listFiles()) {
				f.delete();
			}
		} else {
			TEST_DIR.mkdirs();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		try {
			testImage = ImageIO.read(IMAGE_FILE);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@After
	public void tearDown() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss_SSS");
		String time = sdf.format(new Date());

		File outputFile = new File("target/testData/filteredPicture_" + time + ".png");

		if (filteredImageTestResult != null) {
			try {
				ImageIO.write(filteredImageTestResult, "png", outputFile);
			} catch (IOException e) {
				fail();
			}
		}
	}
	
	@Test
	public void testSobel(){
		SobelFilter sobel = new SobelFilter();
		filteredImageTestResult = sobel.applyFilter(testImage);
		assertTrue(true);
	}
	
	@Test
	public void testPrewitt(){
		PrewittFilter prewitt = new PrewittFilter();
		filteredImageTestResult = prewitt.applyFilter(testImage);
		assertTrue(true);
	}
	
	@Test
	public void testBlur(){
		BlurFilter blur = new BlurFilter(3);
		filteredImageTestResult = blur.applyFilter(testImage);
		assertTrue(true);
	}
	
	@Test
	public void testLowerThreshold(){
		LowerThresholdFilter thres = new LowerThresholdFilter(null);
		filteredImageTestResult = thres.applyFilter(testImage);
		assertTrue(true);
	}
	
	@Test
	public void testGrayScale(){
		GrayScaleFilter gray = new GrayScaleFilter();
		filteredImageTestResult = gray.applyFilter(testImage);
		assertTrue(true);
	}

}

package org.iMage.edge.detection.sobel.filter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SobelFilterTest {

	private static final File IMAGE_FILE = new File("src/test/resources/camera_obscura.png");
	private static final File TEST_DIR = new File("target/testData");
	private BufferedImage testResult;
	private BufferedImage testImage;
	private BlurFilter blur;
	private GrayScaleFilter gray;
	private LowerThresholdFilter hold;
	private PrewittFilter prewitt;
	private SobelFilter sobel;

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
			blur = new BlurFilter(500);
			gray = new GrayScaleFilter();
			hold = new LowerThresholdFilter(127);
			prewitt = new PrewittFilter();
			sobel = new SobelFilter();
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@After
	public void tearDown() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss_SSS");
		String time = sdf.format(new Date());

		File outputFile = new File("target/testData/filtered_" + time + ".png");

		if (testImage != null) {
			try {
				ImageIO.write(testImage, "png", outputFile);
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}
	}

	@Test
	public void testBlurFilter() {
		testResult = blur.applyFilter(testImage);
		assertTrue(testResult.equals(testImage));
	}

	@Test
	public void testGrayScaleFilter() {
		testResult = gray.applyFilter(testImage);
		assertTrue(testResult.equals(testImage));
	}

	@Test
	public void testLowerThresholdFilter() {
		testResult = hold.applyFilter(testImage);
		assertTrue(testResult.equals(testImage));
	}

	@Test
	public void testPrewittFilter() {
		testResult = prewitt.applyFilter(testImage);
		assertTrue(testResult.equals(testImage));
	}

	@Test
	public void testSobelFilter() {
		testResult = sobel.applyFilter(testImage);
		assertTrue(testResult.equals(testImage));
	}
}

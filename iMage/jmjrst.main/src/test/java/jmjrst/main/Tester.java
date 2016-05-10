package jmjrst.main;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.jis.generator.Generator;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to run tests
 *
 * @author ucews
 * @version 1.0
 */
public class Tester {

	private Generator generator;
	private BufferedImage buffImage;

	/**
	 * This method initialises a Generator and reads a jpg-picture
	 */
	@Before
	public void setUp() {
		generator = new Generator(null, 0);
		try {
			buffImage = ImageIO.read(new File("src/test/resources/picture.jpg"));
		} catch (IOException exception) {
		}
	}

	/**
	 * This method tests if rotateImage functions properly with an BufferedImage
	 */
	@Test
	public void testRotateBufferedImage() {
		BufferedImage img = new BufferedImage(10, 10, 10);
		BufferedImage tmp = generator.rotateImage(img, 0.0);
		tearDown(tmp);
		assertEquals(tmp, img);
	}

	/**
	 * This method tests if rotateImage functions properly with null as image
	 */
	@Test
	public void testRotateNullImage() {
		BufferedImage img = generator.rotateImage(null, 0.0);
		assertEquals(img, null);
	}

	/**
	 * This method tests if rotateImage throws an IllegalArgumentException
	 */
	@Test
	public void testIllegalArgumentForImageRotate() {
		boolean gotExecption = false;
		try {
			generator.rotateImage(buffImage, 1.0);
		} catch (IllegalArgumentException exception) {
			gotExecption = true;
		}
		assertTrue(gotExecption);
	}

	/**
	 * This method tests if rotateImage throws an NullPointerException
	 */
	@Test
	public void testNullPointerForImageRotate() {
		assertEquals(generator.rotateImage(null, 1.0), null);
	}

	/**
	 * This method tests if rotateImage functions properly for 90 degrees
	 */
	@Test
	public void testRotate90() {
		BufferedImage rotatedImage = generator.rotateImage(buffImage, Generator.ROTATE_90);
		int height = rotatedImage.getHeight();
		int width = rotatedImage.getWidth();
		assertEquals(height, buffImage.getWidth());
		assertEquals(width, buffImage.getHeight());
		tearDown(rotatedImage);
	}

	/**
	 * This method tests if rotateImage functions properly for 270 degrees
	 */
	@Test
	public void testRotate270() {
		BufferedImage rotatedImage = generator.rotateImage(buffImage, Generator.ROTATE_270);
		int height = rotatedImage.getHeight();
		int width = rotatedImage.getWidth();
		assertEquals(height, buffImage.getWidth());
		assertEquals(width, buffImage.getHeight());
		tearDown(rotatedImage);
	}

	/**
	 * This method saves all the pictures created during the tests and creates
	 * the directory target/testData if it doesn't already exists
	 */
	public void tearDown(BufferedImage image) {
		File directory = new File("target/testData");
		if (directory.exists() == false) {
			try {
				directory.mkdir();
			} catch (SecurityException exception) {
			}
		}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss_SSS");
			Calendar calendar = Calendar.getInstance();
			String time = dateFormat.format(calendar.getTime());
			String fileName = directory + "/rotatedPicture_" + time + ".jpg";
			File out = new File(fileName);
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
		}
	}
}

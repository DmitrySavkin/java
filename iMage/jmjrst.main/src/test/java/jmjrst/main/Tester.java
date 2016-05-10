package jmjrst.main;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
		assertEquals(tmp, img);
	}

	/**
	 * This method tests if rotateImage functions properly with null
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
			setUp();
			generator.rotateImage(buffImage, 1.0);
		} catch (IllegalArgumentException exception) {
			gotExecption = true;
		}
		assertTrue(gotExecption);
	}
}

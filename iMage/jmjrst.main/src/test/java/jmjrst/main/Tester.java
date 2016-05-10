package jmjrst.main;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jis.generator.Generator;
import org.junit.Before;

public class Tester {
	
	private Generator generator;
	private BufferedImage buffImage;
	
	@Before
	public void setUp(){
		generator = new Generator(null, 0);
		try{
			buffImage = ImageIO.read(new File("src/test/resources/picture.jpg"));
		}catch(IOException exception){
		}
	}
	
	public void testRotateBufferedImage(){
		BufferedImage img = new BufferedImage(10, 10, 10);
		BufferedImage tmp = generator.rotateImage(img, 0.0);
		assertEquals(tmp, img);
	}
	
	public void testRotateNullImage(){
		BufferedImage img = generator.rotateImage(null, 0.0);
		assertEquals(img, null);
	}
}

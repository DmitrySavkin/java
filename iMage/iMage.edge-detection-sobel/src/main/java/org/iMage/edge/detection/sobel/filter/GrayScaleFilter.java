package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Implements the GrayScaleFilter as requested on worksheet 2.
 */
public class GrayScaleFilter implements ImageFilter {

	/** Default constructor must be available! */
	public GrayScaleFilter() {
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		BufferedImage grayScaledImage = image;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int pixel = image.getRGB(x, y);
				//Shifting bits to get each color
				int r = (pixel >> 16) & 0xff;
				int g = (pixel >> 8) & 0xff;
				int b = (pixel & 0xff);
				int avRGB = (r + b + g) / 3;
				int grayPixel = (avRGB << 16) + (avRGB << 8) + avRGB;
				grayScaledImage.setRGB(x, y, grayPixel);
			}
		}
		return grayScaledImage;
	}
}

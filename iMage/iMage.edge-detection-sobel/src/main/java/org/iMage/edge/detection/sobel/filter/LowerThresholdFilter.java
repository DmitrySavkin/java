package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Filters all pixels that have a grayscale color below a certain threshold and sets them to 0 (makes them black).
 * Pixels above the threshold are converted to grayscale normally (as defined in {@link GrayScaleFilter}).
 */
public class LowerThresholdFilter implements ImageFilter {

	private int threshold;
	/** Default constructor must be available! */
	public LowerThresholdFilter(Integer threshold) {
		this.threshold = threshold != null ? threshold : 127;
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		BufferedImage thresFilteresIamge = image;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int pixel = image.getRGB(x, y);
				//Shifting bits to get each color
				int r = (pixel >> 16) & 0xff;
				int g = (pixel >> 8) & 0xff;
				int b = (pixel & 0xff);
				int avRGB = (r + b + g) / 3;
				if (avRGB <= threshold) {
					avRGB = 0;
				}
				int grayPixel = (avRGB << 16) + (avRGB << 8) + avRGB;
				thresFilteresIamge.setRGB(x, y, grayPixel);
			}
		}
		return thresFilteresIamge;
	}

}

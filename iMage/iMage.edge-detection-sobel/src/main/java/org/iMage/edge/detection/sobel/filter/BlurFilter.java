package org.iMage.edge.detection.sobel.filter;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Implements the blur filter as requested on worksheet 2.
 */
public class BlurFilter implements ImageFilter {

	/** Default constructor must be available! */
	public BlurFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		BufferedImage result = image;
		for (int i = 1; i < result.getHeight() - 1; i++) {
			{
				for (int j = 1; j < result.getWidth() - 1; j++) {
					double averageRGB = 0;
					double averageAlpha = 0;
					int counter = -1;
					while (counter < 2) {
						averageRGB = averageRGB + image.getRGB(j + counter, i - 1) / 9.0;
						averageRGB = averageRGB + image.getRGB(j + counter, i) / 9.0;
						averageRGB = averageRGB + image.getRGB(j + counter, i + 1) / 9.0;
						counter++;
					}
					result.setRGB(j, i, (int) averageRGB);
				}
			}
		}
		return result;
	}

}

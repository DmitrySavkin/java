package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Filters all pixels that have a grayscale color below a certain threshold and
 * sets them to 0 (makes them black). Pixels above the threshold are converted
 * to grayscale normally (as defined in {@link GrayScaleFilter}).
 */
public class LowerThresholdFilter implements ImageFilter {

	/** Default constructor must be available! */
	public LowerThresholdFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		BufferedImage result = image;
		for (int i = 0; i < result.getHeight(); i++) {
			{
				for (int j = 0; j < result.getWidth(); j++) {
					int average = image.getRGB(j, i) / 3;
					if (average < 127) {
						result.setRGB(j, i, 0);
					} else {
						result.setRGB(j, i, average);
					}
				}
			}
		}
		return result;
	}

}

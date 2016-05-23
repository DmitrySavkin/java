package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Filters all pixels that have a grayscale color below a certain threshold and sets them to 0 (makes them black).
 * Pixels above the threshold are converted to grayscale normally (as defined in {@link GrayScaleFilter}).
 */
public class LowerThresholdFilter implements ImageFilter {

	/** Default constructor must be available! */
	public LowerThresholdFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		// TODO Auto-generated method stub
		return null;
	}

}

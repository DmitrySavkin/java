package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Implements the blur filter as requested on worksheet 2.
 */
public class BlurFilter implements ImageFilter {

	private int blurSize;

	public BlurFilter(Integer blurSize) {
		if (blurSize != null) {
			this.blurSize = blurSize;
		} else
			this.blurSize = 3;
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		BufferedImage result = image;
		for (int i = (int) Math.floor((blurSize / 2)); i < result.getHeight() - (int) Math.floor((blurSize / 2)); i++) {
			for (int j = (int) Math.floor((blurSize / 2)); j < result.getWidth()
					- (int) Math.floor((blurSize / 2)); j++) {
				double averageRGB = 0;
				int counter = -(int) Math.floor((blurSize / 2));
				while (counter < blurSize - (int) Math.floor((blurSize / 2))) {
					int runner = -(int) Math.floor((blurSize / 2));
					while (runner < blurSize - (int) Math.floor((blurSize / 2))) {
						averageRGB = averageRGB + image.getRGB(j + counter, i + runner) / (blurSize * blurSize);
						runner++;
					}
					counter++;
				}
				result.setRGB(j, i, (int) averageRGB);
			}
		}
		return result;
	}

}

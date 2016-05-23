package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

public class GrayScaleFilter implements ImageFilter {

	public GrayScaleFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		BufferedImage result = image;
		for (int i = 0; i < result.getHeight(); i++) {
			{
				for (int j = 0; j < result.getWidth(); j++) {
					result.setRGB(j, i, image.getRGB(j, i) / 3);
				}
			}
		}
		return result;
	}
}

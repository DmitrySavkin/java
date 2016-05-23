package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Detects edges via the Sobel filter operator.
 */
public class SobelFilter implements ImageFilter {

	public SobelFilter() {
	}

	private int[][] sobel_x = { { -1, 0, 1 }, { -2, 0, 2 }, { -1, 0, 1 } };
	private int[][] sobel_y = { { -1, -2, -1 }, { 0, 0, 0 }, { 1, 2, 1 } };

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		BufferedImage result = image;
		for (int i = 1; i < image.getWidth() - 1; i++) {
			for (int j = 1; j < image.getHeight() - 1; j++) {
				int pixel_x = (sobel_x[0][0] * image.getRGB(i - 1, j - 1)) + (sobel_x[0][1] * image.getRGB(i, j - 1))
						+ (sobel_x[0][2] * image.getRGB(i + 1, j - 1)) + (sobel_x[1][0] * image.getRGB(i - 1, j))
						+ (sobel_x[1][1] * image.getRGB(i, j)) + (sobel_x[1][2] * image.getRGB(i + 1, j))
						+ (sobel_x[2][0] * image.getRGB(i - 1, j + 1)) + (sobel_x[2][1] * image.getRGB(i, j + 1))
						+ (sobel_x[2][2] * image.getRGB(i + 1, j + 1));
				int pixel_y = (sobel_y[0][0] * image.getRGB(i - 1, j - 1)) + (sobel_y[0][1] * image.getRGB(i, j - 1))
						+ (sobel_y[0][2] * image.getRGB(i + 1, j - 1)) + (sobel_y[1][0] * image.getRGB(i - 1, j))
						+ (sobel_y[1][1] * image.getRGB(i, j)) + (sobel_y[1][2] * image.getRGB(i + 1, j))
						+ (sobel_y[2][0] * image.getRGB(i - 1, j + 1)) + (sobel_y[2][1] * image.getRGB(i, j + 1))
						+ (sobel_y[2][2] * image.getRGB(i + 1, j + 1));
				int value = (int) Math.floor(Math.sqrt((pixel_x * pixel_x) + (pixel_y * pixel_y)));
				result.setRGB(i, j, value);
			}
		}
		return result;
	}
}
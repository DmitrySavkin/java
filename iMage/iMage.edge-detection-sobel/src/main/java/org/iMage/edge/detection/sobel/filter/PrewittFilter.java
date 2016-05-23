package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Detects edges via the Prewitt filter operator.
 */
public class PrewittFilter implements ImageFilter {

	public PrewittFilter() {
	}

	private int[][] prewit_x = { { -1, 0, 1 }, { -1, 0, 1 }, { -1, 0, 1 } };
	private int[][] prewit_y = { { -1, -1, -1 }, { 0, 0, 0 }, { 1, 1, 1 } };

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		BufferedImage result = image;
		for (int i = 1; i < image.getWidth() - 1; i++) {
			for (int j = 1; j < image.getHeight() - 1; j++) {
				int pixel_x = (prewit_x[0][0] * image.getRGB(i - 1, j - 1)) + (prewit_x[0][1] * image.getRGB(i, j - 1))
						+ (prewit_x[0][2] * image.getRGB(i + 1, j - 1)) + (prewit_x[1][0] * image.getRGB(i - 1, j))
						+ (prewit_x[1][1] * image.getRGB(i, j)) + (prewit_x[1][2] * image.getRGB(i + 1, j))
						+ (prewit_x[2][0] * image.getRGB(i - 1, j + 1)) + (prewit_x[2][1] * image.getRGB(i, j + 1))
						+ (prewit_x[2][2] * image.getRGB(i + 1, j + 1));
				int pixel_y = (prewit_y[0][0] * image.getRGB(i - 1, j - 1)) + (prewit_y[0][1] * image.getRGB(i, j - 1))
						+ (prewit_y[0][2] * image.getRGB(i + 1, j - 1)) + (prewit_y[1][0] * image.getRGB(i - 1, j))
						+ (prewit_y[1][1] * image.getRGB(i, j)) + (prewit_y[1][2] * image.getRGB(i + 1, j))
						+ (prewit_y[2][0] * image.getRGB(i - 1, j + 1)) + (prewit_y[2][1] * image.getRGB(i, j + 1))
						+ (prewit_y[2][2] * image.getRGB(i + 1, j + 1));
				int value = (int) Math.floor(Math.sqrt((pixel_x * pixel_x) + (pixel_y * pixel_y)));
				result.setRGB(i, j, value);
			}
		}
		return result;
	}
}

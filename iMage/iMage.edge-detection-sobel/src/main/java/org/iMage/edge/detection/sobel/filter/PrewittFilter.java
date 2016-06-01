package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Detects edges via the Prewitt filter operator.
 */
public class PrewittFilter implements ImageFilter {

	private int[][] kernelX = {
			{-1, 0, 1},
			{-1, 0, 1},
			{-1, 0, 1}
	};
	private int[][] kernelY = {
			{-1, -1, -1},
			{0, 0, 0},
			{1, 1, 1}
	};
	private int[][] kernelZ;
	/** Default constructor must be available! */
	public PrewittFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		kernelZ = new int[3][3];
		int height = image.getHeight();
		int width = image.getWidth();
		int max = 0;
		int sum = 0;
		BufferedImage edgedImage = image;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int xCurrentXY = kernelX[x%3][y%3];
				int yCurrentXY = kernelY[x%3][y%3];
				kernelZ[x%3][y%3]=(int)Math.sqrt(xCurrentXY*xCurrentXY+yCurrentXY*yCurrentXY);
				if (max < kernelZ[x%3][y%3]) {
					max = kernelZ[x%3][y%3];
				}
			}
		}
		float ratio = (float)max / 255;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				sum=(int)(kernelZ[x%3][y%3] / ratio);
				int rgb = 0xff | ((int)sum << 16 | (int)sum << 8 | (int)sum);
				edgedImage.setRGB(x, y, rgb);
			}
		}
		return edgedImage;
	}

}

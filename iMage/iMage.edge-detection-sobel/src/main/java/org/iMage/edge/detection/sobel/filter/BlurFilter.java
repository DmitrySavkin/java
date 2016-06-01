package org.iMage.edge.detection.sobel.filter;

import java.awt.image.BufferedImage;

import org.iMage.edge.detection.base.ImageFilter;

/**
 * Implements the blur filter as requested on worksheet 2.
 */
public class BlurFilter implements ImageFilter {
	
	private int size;

	/** Default constructor must be available! */
	public BlurFilter(int size) {
		this.size = size;
	}

	@Override
	public BufferedImage applyFilter(BufferedImage image) {
		int height = image.getHeight();
		int width = image.getWidth();
		int toDiv = size * size;
		BufferedImage bluredImage = image;
		int toRun = (int)Math.floor(size / 2);
		for (int x = toRun; x < (width - toRun); x++) {
		    for (int y = toRun; y < (height - toRun); y++) {
		    	int average = 0;
		    	for (int k = -toRun; k < (size - toRun); k++) {
		    		for (int j = -toRun; j < (size - toRun); j++) {
		    			int pixel = image.getRGB(x, y);
		    			int a = (pixel >> 24) & 0xff;
		    			int r = (pixel >> 16) & 0xff;
						int g = (pixel >> 8) & 0xff;
						int b = (pixel & 0xff);
						int avRGB = (a + r + b + g) / 4;
						int grayPixel = (avRGB << 24) + (avRGB << 16) + (avRGB << 8) + avRGB;
		    		    average += grayPixel / toDiv;
		    		}
		    	}
		        bluredImage.setRGB(x, y, average);
		    }
		}

		return bluredImage;
	}

}

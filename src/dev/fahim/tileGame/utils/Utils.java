package dev.fahim.tileGame.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.tile.Tile;

public class Utils {

	public static String loadFileAsString(String path) {

		StringBuilder builder = new StringBuilder();

		try {

			InputStream is = Utils.class.getResourceAsStream(path);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			//BufferedReader br = new BufferedReader(new FileReader(Utils.class.getResource(path).toString()));
			//BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();

	}

	public static int parseInt(String number) {

		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static BufferedImage rotateImage(BufferedImage src, double degrees) {
		double radians = Math.toRadians(degrees);

		int srcWidth = src.getWidth();
		int srcHeight = src.getHeight();

		double sin = Math.abs(Math.sin(radians));
		double cos = Math.abs(Math.cos(radians));
		int newWidth = (int) Math.floor(srcWidth * cos + srcHeight * sin);
		int newHeight = (int) Math.floor(srcHeight * cos + srcWidth * sin);

		BufferedImage result = new BufferedImage(newWidth, newHeight, src.getType());
		Graphics2D g = result.createGraphics();
		g.translate((newWidth - srcWidth) / 2, (newHeight - srcHeight) / 2);
		g.rotate(radians, srcWidth / 2, srcHeight / 2);
		g.drawRenderedImage(src, null);

		return result;
	}

	public static BufferedImage[] dye(BufferedImage[] image, Color color) {
		for (int i = 0; i < image.length; i++) {
			image[i] = dye(image[i], color);
		}

		return image;

	}

	public static BufferedImage dye(BufferedImage image, Color color) {
		int w = image.getWidth();
		int h = image.getHeight();
		BufferedImage dyed = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = dyed.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.setComposite(AlphaComposite.SrcAtop);
		g.setColor(color);
		g.fillRect(0, 0, w, h);
		g.dispose();
		return dyed;
	}

	public static void changeCursor(Handler handler, int index) {
		handler.getGame().getFrame().setCursor(Assets.cursors[index]);
	}

}

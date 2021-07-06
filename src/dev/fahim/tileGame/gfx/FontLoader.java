package dev.fahim.tileGame.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import dev.fahim.tileGame.utils.Utils;

public class FontLoader {

	public static Font loadFont(String path, float size)
	{
		try {
			//File f = new File(FontLoader.class.getResource(path).toURI());
			//System.out.println(FontLoader.class.getResourceAsStream(path));
				return Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN,size); 
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

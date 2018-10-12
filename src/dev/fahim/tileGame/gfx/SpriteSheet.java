package dev.fahim.tileGame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
	private int w,h; //1-based
	
	public SpriteSheet(BufferedImage sheet, int w, int h)
	{
		this.sheet=sheet;
		this.w=w;
		this.h=h;
	}
	
	public BufferedImage crop(int m, int n)
	{
		
		int x=(n-1)*w;
		int y=(m-1)*h;
		
		return sheet.getSubimage(x, y, w, h);
		
	}
	
}

package jmim.codenmore.game.grpx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage test;
	
	public SpriteSheet(BufferedImage test)
	{
		this.test=test;
	}
	
	public BufferedImage crop(int x,int y,int width,int height)
	{
		return test.getSubimage(x, y, width, height);
	}
	

}

package dev.fahim.tileGame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.Text;

public class InfoBox extends UIObject{

	private String text;
	private BufferedImage portrait;
	private int portraitW=128, portraitH=128;
	
	public InfoBox(double x, double y, int width, int height, UIManager uiManager, String text, BufferedImage portrait) {
		super(x, y, width, height, uiManager);
		this.text = text;
		this.portrait = portrait;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		int xOffset=0,yOffset=0;
		if(portrait!=null)
		{
			g.drawImage(Assets.slot, (int)x-50, (int)y-50, portraitW+100, portraitH+100, null);
			xOffset=portraitW;
			yOffset=portraitH;
			g.drawImage(portrait, (int)x, (int)y, portraitW, portraitH, null);
		}
		
		Text.drawPara(g, text, (int)x, (int)y+yOffset, width);
		
	}

	@Override
	public void onClick() {
		
	}
	
	public void setText(String s)
	{
		text = s;
	}
	
	public void setPortrait(BufferedImage p)
	{
		portrait = p;
	}

}

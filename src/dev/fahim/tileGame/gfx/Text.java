package dev.fahim.tileGame.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Text {

	public static void drawText(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font)
	{
		g.setColor(c);
		g.setFont(font);
		int x=xPos;
		int y=yPos;
		if(center)
		{
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos + fm.stringWidth(text)/2;
			y= (yPos - fm.getHeight()/2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}
	
	public static int drawPara(Graphics g, String text, int x, int y, int width)
	{
		g.setFont(Assets.baseFont);
		int yOffset=0,lastY=0;
		String t="";
		for(int i=0;i<text.length();i++)
		{
			t+=text.charAt(i);
			int l = g.getFontMetrics(Assets.baseFont).stringWidth(t);
			if(l>width || i==text.length()-1)
			{
				String tt;
				if(i==text.length()-1)
				{
					tt=t;
				}
				else
				{
					tt=t.substring(0,t.length()-1);
				}
				
				g.drawString(tt, (int)(x-40), (int)(y+yOffset+50));
				yOffset+=g.getFontMetrics(Assets.baseFont).getHeight();
				lastY=y+yOffset+60;
				t=t.substring(t.length()-1,t.length());
			}
		}
		return lastY;
	}
	
}

package dev.fahim.tileGame.gfx;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.Entity;
import dev.fahim.tileGame.tile.Tile;

public class GameCamera {

	private Handler handler;
	private double xOffset, yOffset;
	
	public GameCamera(Handler handler, double xOffset, double yOffset)
	{
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e)
	{
		xOffset=e.getX() - handler.getWidth()/2 + e.getW()/2;
		yOffset=e.getY() - handler.getHeight()/2 + e.getH()/2;
		checkBlankSpace();
	}
	
	public void move(double xAmt, double yAmt)
	{
		xOffset+=xAmt;
		yOffset+=yAmt;
		checkBlankSpace();
	}
	
	public void checkBlankSpace()
	{
		
		if(xOffset < 0)
		{
			xOffset = 0;
		}
		else if(xOffset > handler.getWorld().getW() * Tile.w - handler.getWidth())
		{
			xOffset = handler.getWorld().getW() * Tile.w - handler.getWidth();
		}
		
		if(yOffset < 0)
		{
			yOffset = 0;
		}
		else if(yOffset > handler.getWorld().getH() * Tile.h - handler.getHeight())
		{
			yOffset = handler.getWorld().getH() * Tile.h - handler.getHeight();
		}
		
	}

	public void setxOffset(double xOffset) {
		this.xOffset = xOffset;
	}

	public void setyOffset(double yOffset) {
		this.yOffset = yOffset;
	}

	public double getxOffset() {
		return xOffset;
	}

	public double getyOffset() {
		return yOffset;
	}
	
}

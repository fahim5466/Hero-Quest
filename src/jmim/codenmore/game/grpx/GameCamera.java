package jmim.codenmore.game.grpx;

import jmim.codenmore.entity.*;

import jmim.codenmore.game.GameMain;
import jmim.codenmore.game.Handler;
import jmim.codenmore.tile.Tile;

public class GameCamera {
	private float xOffset,yOffset;
	private Handler handler;
	public GameCamera(Handler handler,float xOffset,float yOffset)
	{
		this.xOffset=xOffset;
		this.yOffset=yOffset;
		this.handler=handler;
	}
	
	public void move(float xAm,float yAm)
	{
		xOffset+=xAm;
		yOffset+=yAm;
		checkWhitespace();
	}
	
	public void centerOnEntity(Entity en)
	{
		xOffset=en.getX()-handler.getWidth()/2+en.getWidth()/2;
		yOffset=en.getY()-handler.getHeight()/2+en.getHeight()/2;
		checkWhitespace();
	}
	
	public float getxOffset() {
		return xOffset;
	}
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	public float getyOffset() {
		return yOffset;
	}
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	public void checkWhitespace()
	{
		if(xOffset<0) {
			xOffset=0;
		}
		else if
		(xOffset> handler.getWorld4().getWidth()*Tile.TILEWIDTH-handler.getWidth()) {
				
			xOffset=handler.getWorld4().getWidth()*Tile.TILEWIDTH-handler.getWidth();			
		}
		
		
		if(yOffset<0) {
			yOffset=0;
		}
		else if
		(yOffset>handler.getWorld4().getHeight()*Tile.TILEHEIGHT
				-handler.getHeight()) {
			yOffset=handler.getWorld4().getHeight()*Tile.TILEHEIGHT
					-handler.getHeight();
		}
	}

}

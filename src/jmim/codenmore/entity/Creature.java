package jmim.codenmore.entity;

import java.awt.Graphics;
import java.util.logging.Handler;

import jmim.codenmore.game.*;
import jmim.codenmore.tile.Tile;
import jmim.codenmore.world.World;

public abstract class Creature extends Entity{
	public int health;
	public float speed;
	protected float xMove,yMove;
	public static final int DEFAULT_HEALTH=10;
	public static final float DEFAULT_SPEED=3.0f;
	public static final int DEFAULT_WIDTH=70;
	public static final int DEFAULT_HEIGHT=80;
	World world;
	
	
	
	public  Creature(jmim.codenmore.game.Handler handler,float x,float y,int height,int width)
	{
		super(handler,x,y,height,width);
		health=DEFAULT_HEALTH;
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
		
	}

	public void move()
	{
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
		moveY();
	
	}
	
	public void moveX()
	{
		if(xMove>0)
		{
			int tx=(int)((x+xMove+bound.x+bound.width)/Tile.TILEWIDTH);
			if(!collisionWithtile(tx,(int) ((y+bound.y)/Tile.TILEHEIGHT)) 
					&& (!collisionWithtile(tx,(int)(y+bound.y+bound.width)/Tile.TILEHEIGHT)))
			{
				x+=xMove;
			}
			else
			{
				x=tx*Tile.TILEWIDTH-bound.x-bound.width-1;
			}
			
		}
		
		
		else if(xMove<0)
		{
			int tx=(int)((x+xMove+bound.x)/Tile.TILEWIDTH);
			if(!collisionWithtile(tx,(int) ((y+bound.y)/Tile.TILEHEIGHT)) 
					&& (!collisionWithtile(tx,(int)(y+bound.y+bound.width)/Tile.TILEHEIGHT)))
			{
				x+=xMove;
			}
			else
			{
				x=tx*Tile.TILEWIDTH+Tile.TILEWIDTH-bound.x;
			}
			
		}
	}
	
	public void moveY()
	{
		if(yMove<0)
		{
			int ty=(int)((y+yMove+bound.y)/Tile.TILEHEIGHT);
			
			if(!collisionWithtile((int) ((x+bound.x)/Tile.TILEWIDTH),ty) &&
			(!collisionWithtile((int)((x+bound.x+bound.width)/Tile.TILEWIDTH),ty)))
			{
				y+=yMove;
			}
			else
			{
				y=ty*Tile.TILEHEIGHT+Tile.TILEHEIGHT-bound.y;
			}
		}
		else if(yMove>0)
		{
			int ty=(int)((y+yMove+bound.y+bound.height)/Tile.TILEHEIGHT);
			
			if(!collisionWithtile((int) ((x+bound.x)/Tile.TILEWIDTH),ty) &&
			(!collisionWithtile((int)((x+bound.x+bound.width)/Tile.TILEWIDTH),ty)))
			{
				y+=yMove;
			}
			else
			{
				y=ty*Tile.TILEHEIGHT-bound.y-bound.height-1;
			}
			
		}
	}


	public float getxMove() {
		return xMove;
	}


	public void setxMove(float xMove) {
		this.xMove = xMove;
	}


	public float getyMove() {
		return yMove;
	}


	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public float getSpeed() {
		return speed;
	}
	
	public boolean collisionWithtile(int x,int y)
	{
		return handler.getWorld4().getTile(x, y).isSolid();
	}


	public void setSpeed(float speed) {
		this.speed = speed;
	}
}

package dev.fahim.tileGame.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.fahim.tileGame.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected double x,y;
	protected int w,h;
	protected Rectangle bounds;
	
	public Entity(Handler handler, double x, double y, int w, int h)
	{
		this.handler=handler;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		
		bounds = new Rectangle(0,0,0,0);
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Entity checkEntityCollision(double xOffset, double yOffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(!e.equals(this) && e.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(xOffset, yOffset)))
			{
				return e;
			}
		}
		
		Entity _null=null;
		
		return _null;
		
	}
	
	public Rectangle getCollisionBounds(double xOffset, double yOffset)
	{
		return new Rectangle( (int) (x+bounds.x+xOffset), (int) (y+bounds.y+yOffset), bounds.width, bounds.height);
	}
	
	public Rectangle getBounds()
	{
		return bounds;
	}
	
	public boolean canBlock()
	{
		return true;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
}

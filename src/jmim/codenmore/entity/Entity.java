package jmim.codenmore.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import jmim.codenmore.game.GameMain;
import jmim.codenmore.game.Handler;

public abstract class Entity {
	public float x;
	public float y;
	public int width;
	public int height;
	protected Handler handler;
	 public Rectangle bound;
	
	public Entity(Handler handler2,float x,float y,int width,int height){
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.handler=handler2;
		bound=new Rectangle(0,0,width,height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bound.x + xOffset), (int) (y + bound.y + yOffset), bound.width, bound.height);
	}
	
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getWorld4().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
}

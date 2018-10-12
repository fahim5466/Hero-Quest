package dev.fahim.tileGame.entities;

import java.awt.image.BufferedImage;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Animation;
import dev.fahim.tileGame.gfx.Animator;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.input.AIController;
import dev.fahim.tileGame.input.Controller;
import dev.fahim.tileGame.tile.Tile;

public abstract class Creature extends Entity{

	protected final double DEFAULT_HEALTH = 100;
	protected final double DEFAULT_MANA = 100;
	protected final double DEFAULT_SPEED = 3.0;
	
	protected double health,mana;
	protected double speed;
	
	protected double xMove=0,yMove=0;
	
	protected int hitW,hitH,damage=10;
	
	protected int sightW=300,sightH=300;

	public Animation animDown, animUp, animLeft, animRight;
	public Animation animAttackDown, animAttackUp, animAttackLeft, animAttackRight;
	public Animation animBowDown,animBowUp,animBowLeft,animBowRight;
	public Animation animMagicDown, animMagicUp, animMagicLeft, animMagicRight;
	public Animation animDie;
	protected int facing=3;
	
	protected Animator animator;
	
	protected AIController controller;
	
	public Creature(Handler handler, double x, double y, int w, int h) {
		super(handler, x, y, w, h);
		this.health=DEFAULT_HEALTH;
		this.mana = DEFAULT_MANA;
		this.speed=DEFAULT_SPEED;
		controller = new AIController(handler,this,handler.getKeyManager(),handler.getMouseManager());
	}
	
	public void move()
	{
		
		if(checkEntityCollision(xMove, 0)==null)
		{
			moveX();
		}
		
		if(checkEntityCollision(0,yMove)==null)
		{
			moveY();
		}
		
	}
	
	public void moveX()
	{
		
		if(xMove>0)
		{
			
			int tx = (int) (x + xMove + bounds.x + bounds.width)/Tile.w;
			
			if(
				!collisionWithTile(tx,(int)(y + bounds.y)/Tile.h)
				&&
				!collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/Tile.h)
			  )
			{
				x+=xMove;
			}
			
		}
		else
		{
			
			int tx = (int) (x + xMove + bounds.x)/Tile.w;
			
			//System.out.println((x + xMove + bounds.x)/Tile.w);
			
			if(
				!collisionWithTile(tx,(int)(y + bounds.y)/Tile.h)
				&&
				!collisionWithTile(tx,(int)(y + bounds.y + bounds.height)/Tile.h)
			  )
			{
				x+=xMove;
			}
			
		}
		
	}
	
	public void moveY()
	{
		if(yMove>0)
		{
			
			int ty = (int) (y + yMove + bounds.y + bounds.height)/Tile.h;
			
			if(
				!collisionWithTile((int)(x + bounds.x)/Tile.w,ty)
				&&
				!collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.w,ty)
			  )
			{
				y+=yMove;
			}
			
		}
		else
		{
			
			int ty = (int) (y + yMove + bounds.y)/Tile.h;
			
			if(
				!collisionWithTile((int)(x + bounds.x)/Tile.w,ty)
				&&
				!collisionWithTile((int)(x + bounds.x + bounds.width)/Tile.w,ty)
			  )
			{
				y+=yMove;
			}
			
		}
	}
	
	public boolean collisionWithTile(int x, int y)
	{
		//System.out.println(x+" "+y);
		return handler.getWorld().getTile(y,x).isSolid();
	}
	
	public int getFace()
	{
		return facing;
	}
	
	public void setFace(int i)
	{
		facing=i;
	}
	
	public double getCenterX()
	{
		return x+w/2;
	}
	
	public double getCenterY()
	{
		return y+h/2;
	}
	
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = Math.min(100,health);
	}
	
	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = Math.min(100,mana);
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getxMove() {
		return xMove;
	}

	public void setxMove(double xMove) {
		this.xMove = xMove;
	}

	public double getyMove() {
		return yMove;
	}

	public void setyMove(double yMove) {
		this.yMove = yMove;
	}
	
	public int getHitW() {
		return hitW;
	}

	public void setHitW(int hitW) {
		this.hitW = hitW;
	}

	public int getHitH() {
		return hitH;
	}

	public void setHitH(int hitH) {
		this.hitH = hitH;
	}

	public int getSightW() {
		return sightW;
	}

	public void setSightW(int sightW) {
		this.sightW = sightW;
	}

	public int getSightH() {
		return sightH;
	}

	public void setSightH(int sightH) {
		this.sightH = sightH;
	}

	public Controller getController()
	{
		return controller;
	}

	public Animator getAnimator()
	{
		return animator;
	}
	
	public boolean isDead()
	{
		System.out.println(health);
		return health<=0;
	}
	
}

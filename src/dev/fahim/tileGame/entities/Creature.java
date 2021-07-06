package dev.fahim.tileGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Animation;
import dev.fahim.tileGame.gfx.Animator;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.input.AIController;
import dev.fahim.tileGame.input.Controller;
import dev.fahim.tileGame.tile.Tile;
import dev.fahim.tileGame.utils.Utils;

public abstract class Creature extends Entity {

	protected final double DEFAULT_HEALTH = 100;
	protected final double DEFAULT_MANA = 100;
	protected final double DEFAULT_SPEED = 3.0;

	protected double health, mana;
	protected double speed;

	protected double xMove = 0, yMove = 0;

	//melee range variables
	//used for weapon hit calculation
	protected int hitW, hitH, damage = 10; 

	//how far the creature can see
	protected int sightW = 300, sightH = 300; 

	//Movement animations
	public Animation animDown, animUp, animLeft, animRight;
	
	//Melee attack animations
	public Animation animAttackDown, animAttackUp, animAttackLeft, animAttackRight;
	
	//Bow attack animations
	public Animation animBowDown, animBowUp, animBowLeft, animBowRight;
	
	//Magic attack animations
	public Animation animMagicDown, animMagicUp, animMagicLeft, animMagicRight;
	
	//Dying animation
	public Animation animDie;
	
	//Which way the creature is facing
	protected int facing = 3;

	protected Animator animator;

	protected AIController controller;

	public Creature(Handler handler, double x, double y, int w, int h) {
		super(handler, x, y, w, h);
		this.health = DEFAULT_HEALTH;
		this.mana = DEFAULT_MANA;
		this.speed = DEFAULT_SPEED;
		controller = new AIController(handler, this, handler.getKeyManager(), handler.getMouseManager());
	}

	public void move() {
		
		//check if there will be any collision if i move xMove amount in y direction
		if (checkEntityCollision(xMove, 0) == null) {
			//if no collision is detected move xMove amount in x direction
			moveX();
		}
		
		//check if there will be any collision if i move yMove amount in y direction
		if (checkEntityCollision(0, yMove) == null) {
			//if no collision is detected move yMove amount in y direction
			moveY();
		}

	}

	public void moveX() {
		
		//calculate which tiles collision box will be in after moving in x direction
		//and check if it is allowed to move into those tiles
		
		if (xMove > 0) {
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.w;

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.h)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.h)) {
				if (tx >= 0 && tx < handler.getWorld().getW()) {
					x += xMove;
				}
			}

		} else {

			int tx = (int) (x + xMove + bounds.x) / Tile.w;

			// System.out.println((x + xMove + bounds.x)/Tile.w);

			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.h)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.h)) {
				if (tx >= 0 && tx < handler.getWorld().getW()) {
					x += xMove;
				}
			}

		}

	}

	public void moveY() {
		
		//calculate which tiles collision box will be in after moving in y direction
		//and check if it is allowed to move into those tiles
		
		if (yMove > 0) {

			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.h;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.w, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.w, ty)) {
				if (ty >= 0 && ty < handler.getWorld().getH()) {
					y += yMove;
				}
			}

		} else {

			int ty = (int) (y + yMove + bounds.y) / Tile.h;

			if (!collisionWithTile((int) (x + bounds.x) / Tile.w, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.w, ty)) {
				if (ty >= 0 && ty < handler.getWorld().getH()) {
					y += yMove;
				}
			}

		}
	}

	public boolean collisionWithTile(int x, int y) {
		return handler.getWorldManager().getCurrentWorld().getTile(y, x).isSolid();
	}

	public int getFace() {
		return facing;
	}
	
	public boolean isDead() {
		return health <= 0;
	}
	
	public void drawHealthBar(Graphics g)
	{
		g.setColor(new Color(0,255,0,178));
		if(health<50){g.setColor(new Color(0,255,255,128));}
		if(health<25){g.setColor(new Color(255,0,0,128));}
		g.drawImage(Assets.bar,
			  	(int)(x + bounds.x - 15 - handler.getGameCamera().getxOffset()),
			  	(int)(y + bounds.y + 20 - handler.getGameCamera().getyOffset()),
			  	80,bounds.height+10,null
			  );
		g.fillRect(
				  	(int)(x + bounds.x - 10 - handler.getGameCamera().getxOffset()),
				  	(int)(y + bounds.y + 25 - handler.getGameCamera().getyOffset()),
				  	(int)(70*health)/100,bounds.height
				  );
	}

	public void setFace(int i) {
		facing = i;
	}

	public double getCenterX() {
		return x + w / 2;
	}

	public double getCenterY() {
		return y + h / 2;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = Math.min(100, health);
	}

	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = Math.min(100, mana);
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

	public Controller getController() {
		return controller;
	}

	public Animator getAnimator() {
		return animator;
	}
	
}

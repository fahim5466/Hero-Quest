package dev.fahim.tileGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.utils.Utils;

public class Arrow extends Projectile{
	
	public Arrow(Handler handler, double x, double y, int w, int h, int direction) {
		super(handler, x, y, w, h, direction);
		this.speed=10;
		this.damage=5;
		
		bounds.x=0;
		bounds.y=64;
		bounds.width=64;
		bounds.height=8;
		
		hitSound = handler.getSoundManager().arrowImpactClip;
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Utils.rotateImage(Assets.arrow,rotate()), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), w, h, null);
		
		/*
		g.setColor(Color.red);
		g.fillRect(
			  	(int)(x - handler.getGameCamera().getxOffset()),
			  	(int)(y - handler.getGameCamera().getyOffset()),
			  	w/2,h/2
			  );
		*/
		/*
		g.fillRect(
				  	(int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				  	(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				  	bounds.width,bounds.height
				  );
		*/
	}

}

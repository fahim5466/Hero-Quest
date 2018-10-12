package dev.fahim.tileGame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.worlds.World;

public abstract class TriggerBox extends Entity{

	private World nextLevel;
	
	public TriggerBox(Handler handler, double x, double y, int w, int h) {
		super(handler, x, y, w, h);
	}

	@Override
	public abstract void tick();
	
	public abstract void trigger();

	@Override
	public void render(Graphics g) {
		/*
		g.setColor(Color.green);
		g.fillRect(
			  	(int)(x - handler.getGameCamera().getxOffset()),
			  	(int)(y- handler.getGameCamera().getyOffset()),
			  	w,h
			  );
		*/
	}

}

package dev.fahim.tileGame.entities;

import java.awt.Rectangle;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.states.GameState;
import dev.fahim.tileGame.worlds.World;

public class LevelTrigger extends TriggerBox{

	private World nextLevel;
	private double px,py;
	
	public LevelTrigger(Handler handler, double x, double y, int w, int h, World nextLevel, double px, double py) {
		super(handler, x, y, w, h);
		this.nextLevel = nextLevel;
		this.px = px;
		this.py = py;
	}

	@Override
	public void tick() {
		Rectangle r = new Rectangle((int)x-10,(int)y-10,w+20,h+20);
		if(r.intersects(handler.getGame().getPlayer().getCollisionBounds(0, 0)))
		{
			trigger();
		}
	}
	
	@Override
	public void trigger() {
		GameState g = (GameState)handler.getGame().gameState;
		g.getWorldManager().setCurrentWorld(nextLevel);
		System.out.println("Level changed" + nextLevel);
		handler.getGame().getPlayer().setX(px);
		handler.getGame().getPlayer().setY(py);
	}

}

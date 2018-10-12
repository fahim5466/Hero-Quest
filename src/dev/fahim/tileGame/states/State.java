package dev.fahim.tileGame.states;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;

public abstract class State {
	
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler = handler;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
}

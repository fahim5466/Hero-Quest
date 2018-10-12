package dev.fahim.tileGame.entities.statics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, double x, double y, int width, int height)
	{
		super(handler,x,y,width,height);
	}
	
}

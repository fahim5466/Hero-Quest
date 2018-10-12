package dev.fahim.tileGame.entities;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.states.LootScreen;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.utils.Utils;

public class Loot extends Entity implements Clickable{
	
	public Loot(Handler handler, double x, double y)
	{
		super(handler,x,y,128,128);
	}
	
	public boolean isClicked()
	{
		int mx = handler.getGame().getMouseManager().getMouseX();
		int my = handler.getGame().getMouseManager().getMouseY();
		boolean click = handler.getGame().getMouseManager().isLeftPresssed();
		int tx=(int) (x-handler.getGameCamera().getxOffset());
		int ty=(int) (y-handler.getGameCamera().getyOffset());
		boolean hovering = (tx<=mx && mx<=tx+w && ty<=my && my<=ty+h);
		if(hovering)
		{
			Utils.changeCursor(handler, 1);
		}
		else
		{
			Utils.changeCursor(handler, 0);
		}
		if(hovering && click){return true;}
		return false;	
	}
	
	public void whenClicked()
	{
		Utils.changeCursor(handler, 0);
		StateManager.setCurrentState(new LootScreen(handler,this));
	}

	@Override
	public void tick() {
		if(isClicked())
		{
			whenClicked();
		}
	}
	
	@Override
	public void render(Graphics g)
	{
		g.drawImage(Assets.lootBag,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),w,h,null);
	}

	
}

package dev.fahim.tileGame.states;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.worlds.World;
import dev.fahim.tileGame.worlds.WorldManager;

public class GameState extends State{

	private WorldManager worldManager;
	
	public GameState(Handler handler)
	{
		
		super(handler);
		worldManager = new WorldManager(handler);
		worldManager.init();
		worldManager.setCurrentWorld(worldManager.forest1);
		
	}
	
	@Override
	public void tick() 
	{
		worldManager.tick();
		handler.getGame().getQuestManager().tick();
	}

	@Override
	public void render(Graphics g) 
	{
		worldManager.render(g);
	}
	
	public WorldManager getWorldManager()
	{
		return worldManager;
	}

	
}
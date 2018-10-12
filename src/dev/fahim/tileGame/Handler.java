package dev.fahim.tileGame;

import dev.fahim.tileGame.gfx.GameCamera;
import dev.fahim.tileGame.input.KeyManager;
import dev.fahim.tileGame.input.MouseManager;
import dev.fahim.tileGame.sounds.SoundManager;
import dev.fahim.tileGame.states.GameState;
import dev.fahim.tileGame.worlds.World;

public class Handler {

	private Game game;
	private World world;
	
	public Handler(Game game)
	{
		this.game = game;
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}
	
	public SoundManager getSoundManager()
	{
		return game.getSoundManager();
	}
	
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}
	
	public void setWorld(World w) {
		world = w;
	}
	
}

package dev.fahim.tileGame;

import dev.fahim.tileGame.gfx.GameCamera;
import dev.fahim.tileGame.input.KeyManager;
import dev.fahim.tileGame.input.MouseManager;
import dev.fahim.tileGame.quest.QuestManager;
import dev.fahim.tileGame.sounds.SoundManager;
import dev.fahim.tileGame.states.GameState;
import dev.fahim.tileGame.worlds.World;
import dev.fahim.tileGame.worlds.WorldManager;

public class Handler {

	private Game game;

	public Handler(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public SoundManager getSoundManager() {
		return game.getSoundManager();
	}
	
	public QuestManager getQuestManager() {
		return game.getQuestManager();
	}
	
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public WorldManager getWorldManager() {
		return game.getWorldManager();
	}

	public World getWorld() {
		return game.getWorldManager().getCurrentWorld();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}

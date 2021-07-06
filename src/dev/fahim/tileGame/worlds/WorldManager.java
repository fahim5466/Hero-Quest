package dev.fahim.tileGame.worlds;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.LevelTrigger;
import dev.fahim.tileGame.tile.Tile;

import dev.fahim.tileGame.entities.Orc;
import dev.fahim.tileGame.entities.statics.Tree;

public class WorldManager {

	private Handler handler;

	public World forest1;

	// forest1
	// Mobs
	public Orc orc1_1, orc1_2;

	private World currentWorld;

	public WorldManager(Handler handler) {
		this.handler = handler;
		init();
	}

	public void init() {

		Tile.init();

		forest1 = new World(handler, "/Worlds/forest1.txt", handler.getGame().getPlayer());

		// forest1

		// Mobs

		orc1_1 = new Orc(handler, 540, 30, 280, 280);
		orc1_2 = new Orc(handler, 540, 380, 280, 280);

		forest1.getEntityManager().addEntity(orc1_1);
		forest1.getEntityManager().addEntity(orc1_2);

		// Static entities
		forest1.getEntityManager().addEntity(new Tree(handler, 16 * 10, 16 * -14));
		forest1.getEntityManager().addEntity(new Tree(handler, 16 * 3, 16 * 25));
		forest1.getEntityManager().addEntity(new Tree(handler, 16 * -5, 16));
		forest1.getEntityManager().addEntity(new Tree(handler, 16 * 45, 16 * -14));
		forest1.getEntityManager().addEntity(new Tree(handler, 16 * 35, 16 * 6));

		// TriggerBoxes
		/*
		 * forest1.getEntityManager().addEntity(new LevelTrigger(handler,
		 * handler.getWidth() + 180, handler.getHeight() - 200, 50, 50, world3, -50,
		 * -100));
		 */
	}

	public World getCurrentWorld() {
		return currentWorld;
	}

	public void setCurrentWorld(World w) {
		currentWorld = w;
	}

	public void tick() {
		currentWorld.tick();
	}

	public void render(Graphics g) {
		currentWorld.render(g);
	}

}

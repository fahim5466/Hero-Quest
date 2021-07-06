package dev.fahim.tileGame;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.fahim.tileGame.display.Display;
import dev.fahim.tileGame.entities.Player;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.GameCamera;
import dev.fahim.tileGame.input.KeyManager;
import dev.fahim.tileGame.input.MouseManager;
import dev.fahim.tileGame.quest.QuestManager;
import dev.fahim.tileGame.sounds.SoundManager;
import dev.fahim.tileGame.states.GameState;
import dev.fahim.tileGame.states.InGameUI;
import dev.fahim.tileGame.states.Inventory;
import dev.fahim.tileGame.states.MenuState;
import dev.fahim.tileGame.states.Notif;
import dev.fahim.tileGame.states.Quests;
import dev.fahim.tileGame.states.State;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.utils.Utils;
import dev.fahim.tileGame.worlds.WorldManager;

public class Game implements Runnable {

	// Graphics
	private Display display;
	private String title;
	private int width, height;
	private BufferStrategy bs;
	private Graphics g;

	// Thread
	private boolean keepRunning;
	Thread thread;

	// States
	public State gameState;
	public State menuState;
	public State instructions;
	public State inGameUI;
	public State inventory;
	public State quests;

	// Input
	KeyManager keyManager;
	MouseManager mouseManager;

	// Sounds
	SoundManager soundManager;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;
	
	//Player
	private Player player;

	// Other
	private QuestManager questManager;
	private  String instructions_text = new String("WASD to move around\n"
			+ "Z to shoot arrow\n"
			+ "X to shoot fireball\n"
			+ "I to access inventory\n");

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {

		//Instantiate handler
		handler = new Handler(this);
		
		display = new Display(title, width, height);
		
		//Load assets
		Assets.load(handler);
		
		//Change cursor
		Utils.changeCursor(handler, 0);

		gameCamera = new GameCamera(handler, 0, 0);

		keyManager = new KeyManager();
		mouseManager = new MouseManager();

		soundManager = new SoundManager();

		display.getFrame().addKeyListener(keyManager);

		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		player = new Player(handler, 0, 0, 280, 280);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		instructions = new Notif(handler,
				new Clicker(){
					@Override
					public void leftClick() {
						StateManager.setCurrentState(handler.getGame().menuState);
					}
				}, instructions_text
		);
		
		
		inGameUI = new InGameUI(handler);
		inventory = new Inventory(handler);
		
		questManager = new QuestManager(handler);
		quests = new Quests(handler, questManager);
		
		StateManager.setCurrentState(menuState);

	}

	private void tick() {

		keyManager.tick();
		mouseManager.tick();
		soundManager.tick();

		if (StateManager.getCurrentState() != null) {
			StateManager.getCurrentState().tick();
		}

	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height);

		// Draw here

		if (StateManager.getCurrentState() != null) {
			StateManager.getCurrentState().render(g);
		}

		// End drawing

		bs.show();
		g.dispose();

	}

	public void run() {

		init();

		double fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		double now;
		double lastTime = System.nanoTime();

		while (keepRunning) {

			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}

	}

	public synchronized void start() {

		if (keepRunning) {
			return;
		} else {
			keepRunning = true;
		}

		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {

		if (!keepRunning) {
			return;
		} else {
			keepRunning = false;
		}

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Player getPlayer() {
		return player;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public SoundManager getSoundManager() {
		return soundManager;
	}
	
	public QuestManager getQuestManager() {
		return questManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Frame getFrame() {
		return display.getFrame();
	}

	public WorldManager getWorldManager() {
		GameState g = (GameState) gameState;
		return g.getWorldManager();
	}

}

package dev.fahim.tileGame;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.fahim.tileGame.Item.Food;
import dev.fahim.tileGame.dialogue.DialogueBank;
import dev.fahim.tileGame.display.Display;
import dev.fahim.tileGame.entities.Player;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.GameCamera;
import dev.fahim.tileGame.input.KeyManager;
import dev.fahim.tileGame.input.MouseManager;
import dev.fahim.tileGame.quest.QuestBank;
import dev.fahim.tileGame.quest.QuestManager;
import dev.fahim.tileGame.sounds.SoundManager;
import dev.fahim.tileGame.states.GameState;
import dev.fahim.tileGame.states.InGameUI;
import dev.fahim.tileGame.states.Inventory;
import dev.fahim.tileGame.states.MenuState;
import dev.fahim.tileGame.states.Quests;
import dev.fahim.tileGame.states.State;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.utils.Utils;
import dev.fahim.tileGame.worlds.WorldManager;

public class Game implements Runnable {
	
	//Graphics
	private Display display;
	private String title;
	private int width,height;
	private BufferStrategy bs;
	private Graphics g;
	
	//Thread
	private boolean keepRunning;
	Thread thread;
	
	//States
	private boolean paused = false;
	public State gameState;
	public State menuState;
	public State inGameUI;
	public State inventory;
	public State quests;
	
	//Input
	KeyManager keyManager;
	MouseManager mouseManager;
	
	//Sounds
	SoundManager soundManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	private Player player;
	
	//Other
	private QuestManager questManager;
	public DialogueBank dialogueBank;
	public QuestBank questBank;
	private Food food;
	
	public Game(String title, int width, int height)
	{
		this.title=title;
		this.width=width;
		this.height=height;
	}
	
	private void init()
	{
		
		display = new Display(title,width,height);
		Assets.load();
		jmim.codenmore.game.grpx.Assets.init();
		
		handler = new Handler(this);
		
		Utils.changeCursor(handler,0);
		
		dialogueBank = new DialogueBank(handler);
		questBank = new QuestBank(handler);
		
		food = new Food(handler);
		food.init();
		
		gameCamera = new GameCamera(handler,0,0);
		
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
		inGameUI = new InGameUI(handler);
		inventory = new Inventory(handler);
		questManager = new QuestManager(handler);
		quests = new Quests(handler,questManager);
		questBank.init();
		StateManager.setCurrentState(menuState);
	
	}
	
	private void tick()
	{
		
		keyManager.tick();
		
		soundManager.tick();
		
		if(StateManager.getCurrentState()!=null)
		{
			StateManager.getCurrentState().tick();
		}
		
	}
	
	private void render()
	{
		
		bs = display.getCanvas().getBufferStrategy();
		
		if(bs==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		//Draw here
		
		if(StateManager.getCurrentState()!=null)
		{
			StateManager.getCurrentState().render(g);
		}
		
		//End drawing
		
		bs.show();
		g.dispose();
		
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public MouseManager getMouseManager()
	{
		return mouseManager;
	}
	
	public SoundManager getSoundManager()
	{
		return soundManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Frame getFrame()
	{
		return display.getFrame();
	}
	
	public DialogueBank getDialogueBank()
	{
		return dialogueBank;
	}
	
	public void pause()
	{
		paused = true;
	}
	
	public void resume()
	{
		paused = false;
	}
	
	public WorldManager getWorldManager()
	{
		GameState g = (GameState)gameState;
		return g.getWorldManager();
	}
	
	public QuestManager getQuestManager()
	{
		return questManager;
	}
	
	public void run()
	{
	
		init();
		
		double fps=60;
		double timePerTick = 1000000000/fps;
		double delta=0;
		double now;
		double lastTime = System.nanoTime();
		
		while(keepRunning)
		{
			
			now=System.nanoTime();
			delta+=(now-lastTime)/timePerTick;
			lastTime=now;
			
			if(delta>=1)
			{
				tick();
				render();
				delta--;
			}
		}
		
	}
	
	public synchronized void start()
	{
		
		if(keepRunning)
		{
			return;
		}
		else
		{
			keepRunning=true;
		}
		
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		
		if(!keepRunning)
		{
			return;
		}
		else
		{
			keepRunning=false;
		}
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

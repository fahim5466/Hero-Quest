package jmim.codenmore.game;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import jmim.codenmore.game.*;


import jmim.codenmore.game.display.Display;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.game.grpx.GameCamera;
import jmim.codenmore.game.grpx.ImageLoader;
import jmim.codenmore.game.grpx.SpriteSheet;
import jmim.codenmore.input.Keymanager;
import jmim.codenmore.input.MouseManager;
import jmim.codenmore.state.*;

public class GameMain implements Runnable{
	private Display disp;
	private int width;
	private int height;
	private String title;
	
	private Thread thread;
	private boolean running=false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public State gameState;
	Keymanager Keyy; 
	private BufferedImage testImage;
	private Handler handler;
	private MouseManager mouseManager;
	
	private GameCamera gCamera;
	public MenuState menuState;
	
	
	public GameMain(String title,int width,int height)
	{
		this.width=width;
		this.height=height;
		this.title=title;
		Keyy=new Keymanager();
		mouseManager = new MouseManager();
	}
	
	

	@Override
	public void run() { 
		init();
		
		int fps=80;
		double timesPerTick=1000000000/fps;
		double delta=0;
		long now;
		long lastTime=System.nanoTime();
		while(running)
		{
			now=System.nanoTime();
			delta+=(now-lastTime)/timesPerTick;
			lastTime=now;
		
			if(delta>=1)
				{
				  	tick();
				  	render();
				  	delta--;
				  	}
			
		}
		stop();
	}
	
	
	
	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	private void init() {
		disp=new Display(title,width,height);

		disp.getframe().addKeyListener(Keyy);
		disp.getframe().addMouseListener(mouseManager);
		disp.getframe().addMouseMotionListener(mouseManager);
		disp.getcanvas().addMouseListener(mouseManager);
		disp.getcanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		handler=new Handler(this);
		gCamera=new GameCamera(handler,0,0);
		
		
		
		
		gameState=new GameState(handler);
		menuState=new MenuState(handler);
		State.setState(menuState);
		
	
	}
	

	private void render() {
		bs=disp.getcanvas().getBufferStrategy();
		if(bs==null)
			{
				disp.getcanvas().createBufferStrategy(3);
				return;
			}
		
		
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
	

		if(State.getState() !=null)
		{
			State.getState().render(g);
		}
		
		
		/*.setColor(Color.BLUE);
	    g.fillOval(x, 50, 50,50);
		g.setColor(Color.red);
		g.fillOval(y, 120, 50, 50); */
		
		
		
		bs.show();
		g.dispose();
	}
	
	public Keymanager getkey()
	{
		return Keyy;
	}
	
	public GameCamera getCamera()
	{
		return gCamera;
	}
	
	

	private void tick() {
		Keyy.handle();
		if(State.getState() !=null)
		{
			State.getState().tick();
		}
		
	
	}
	

	synchronized void start()
	{
		if(running)
			return;
		running=true;
		thread=new Thread(this);
		thread.start();	
	}
	
	
	private synchronized void stop()
	{
		if(!running)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
}

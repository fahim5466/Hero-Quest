package dev.fahim.tileGame.gfx;

import java.awt.image.BufferedImage;

import dev.fahim.tileGame.utils.Timer;

public class Animation {

	private int speed, index;
	private BufferedImage[] frames;
	private Timer timer;
	private int cycle=0; //how many animation cycles have been completed
	
	public Animation(int speed, BufferedImage[] frames)
	{
		this.speed = speed;
		this.frames = frames;
		
		timer = new Timer(speed);
		
	}

	public void tick()
	{
		
		timer.tick();
		
		if(timer.getCycle() == 1)
		{
			timer.reset();
			index++;
			if(index==frames.length)
			{
				index=0;
				cycle++;
			}
		}
		
	}
	
	public void reset()
	{
		timer.reset();
		index=0;
		cycle=0;
	}
	
	public BufferedImage getCurrentFrame()
	{
		return frames[index];
	}
	
	public BufferedImage[] getFrames()
	{
		return frames;
	}
	
	public int getCycle()
	{
		return cycle;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}

	
}

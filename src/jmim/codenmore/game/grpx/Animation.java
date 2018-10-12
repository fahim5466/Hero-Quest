package jmim.codenmore.game.grpx;

import java.awt.image.BufferedImage;

public class Animation {
	public int speed,index;
	private BufferedImage [] frames;
	private long lastTime,timer;
	
	
	public Animation(int speed,BufferedImage[] frames)
	{
		this.speed=speed;
		this.frames=frames;
		index=0;
		lastTime=System.currentTimeMillis();
	}
	
	public BufferedImage curentFrame()
	{
		return frames[index];
	}
	
	public void tick()
	{
		timer+=System.currentTimeMillis()-lastTime;
		lastTime=System.currentTimeMillis();
		
		if(timer>speed)
		{
			index++;
			timer=0;
			if(index>=frames.length)
				index=0;
		}
	}
	


}

package dev.fahim.tileGame.utils;

public class Timer {

	private long lastTime, timer;
	private int cycle;
	private int speed;
	private boolean active;
	
	public Timer(int speed)
	{
		this.speed = speed;
		reset();
	}
	
	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(timer>speed)
		{
			cycle++;
		}
	}
	
	public void reset()
	{
		timer=0;
		lastTime=System.currentTimeMillis();
		cycle=0;
		active=false;
	}

	public long getLastTime() {
		return lastTime;
	}

	public void setLastTime(long lastTime) {
		this.lastTime = lastTime;
	}

	public long getTimer() {
		return timer;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}

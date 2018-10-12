package jmim.codenmore.state;

import java.awt.Graphics;
import jmim.codenmore.game.Handler;


public abstract class State {
	
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler=handler;
	}





	public abstract void tick();
	public abstract void render(Graphics g);
	
	public static State currentState=null;
	public static void setState(State state)
	{
		currentState=state;
	}
	public static State getState()
	{
		return currentState;
	}
	

}

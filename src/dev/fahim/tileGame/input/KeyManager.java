package dev.fahim.tileGame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean keys[],cantPress[],justPressed[];
	public boolean up,down,left,right,z,x,i,q;
	
	public KeyManager()
	{
		keys = new boolean[256];
		cantPress = new boolean[256];
		justPressed = new boolean[256];
	}
	
	public void tick()
	{
		
		for(int i=0;i<keys.length;i++)
		{
			
			//tick 1: player first presses a key and justPressed is set to true.
			// 		  during this tick keyPressed function returns true for that key and player is pressing that key
			
			//tick 2: justPressed is set to false and cantPress is set to true
			//		  during this tick keyPressed function returns false for that key even though player is pressing that key
			
			//suppose player lets go of the key at tick 'n'
			
			//tick 3 to n-1: during this tick keyPressed function returns false for that key even though player is pressing that key
			
			//tick n: player lets go of the key and cantPress is set to false
			//   	  during this tick keyPressed function returns false for that key and player is not pressing that key
			
			//From the time the player presses the key until he lets go of it
			//the keypress is acknowledged for only one tick
			
			if(cantPress[i] && !keys[i])
			{
				cantPress[i]=false;
			}
			else if(justPressed[i])
			{
				cantPress[i]=true;
				justPressed[i]=false;
			}
			else if(!cantPress[i] && keys[i])
			{
				justPressed[i]=true;
			}
		}
		
		up=keys[KeyEvent.VK_W];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_A];
		right=keys[KeyEvent.VK_D];
		z=keys[KeyEvent.VK_Z];
		x=keys[KeyEvent.VK_X];
		i=justPressed[KeyEvent.VK_I];
		q=justPressed[KeyEvent.VK_Q];
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		//System.out.println("Pressed");
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

}

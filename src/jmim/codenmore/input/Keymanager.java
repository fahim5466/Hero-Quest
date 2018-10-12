package jmim.codenmore.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keymanager implements KeyListener{
	
	public boolean [] keys;
	public boolean up,down,left,right;
	
	public Keymanager()
	{
		keys=new boolean[256];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	
	
	public void handle()
	{
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_RIGHT];
	}

}

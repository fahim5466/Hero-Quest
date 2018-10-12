package dev.fahim.tileGame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

	private boolean leftPressed=false, rightPressed=false;
	private boolean justLeftPressed=false, justRightPressed=false;
	private boolean cantLeftPress=false, cantRightPress=false;
	private int mouseX, mouseY;
	
	public boolean isLeftPresssed()
	{
		return leftPressed;
	}
	
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		mouseX = e.getX();
		mouseY = e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			
			leftPressed = true;
			
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			
			rightPressed = true;
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			leftPressed=false;
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			rightPressed=false;
		}
		
	}

}

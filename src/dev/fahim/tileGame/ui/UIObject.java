package dev.fahim.tileGame.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import dev.fahim.tileGame.input.MouseManager;

public abstract class UIObject {
	
	protected double x,y;
	protected int width, height;
	protected boolean hovering = false;
	protected Rectangle bounds;
	protected UIManager uiManager;
	
	public UIObject(double x, double y, int width, int height, UIManager uiManager)
	{
		
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.uiManager=uiManager;
		
		bounds=new Rectangle((int)x,(int)y,width,height);
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void onClick();
	
	public void setHover()
	{
		if(bounds.contains(uiManager.getMouseManager().getMouseX(),uiManager.getMouseManager().getMouseY()))
		{
			hovering=true;
		}
		else
		{
			hovering=false;
		}
	}
	
	public boolean isLeftClicked()
	{
		
		if(hovering && uiManager.getMouseManager().isLeftPresssed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Getters and setters
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		bounds=new Rectangle((int)x,(int)y,width,height);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		bounds=new Rectangle((int)x,(int)y,width,height);
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

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
}

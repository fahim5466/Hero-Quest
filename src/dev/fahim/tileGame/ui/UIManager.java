package dev.fahim.tileGame.ui;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.fahim.tileGame.input.MouseManager;

public class UIManager {

	private MouseManager mouseManager;
	private ArrayList<UIObject> uiObjects;
	
	public UIManager(MouseManager mouseManager)
	{
		this.mouseManager=mouseManager;
		
		uiObjects = new ArrayList<UIObject>();
		
	}
	
	public void tick()
	{
		for(UIObject o : uiObjects)
		{
			o.tick();
		}
	}
	
	public void render(Graphics g)
	{
		for(UIObject o : uiObjects)
		{
			o.render(g);
		}
	}
	
	public MouseManager getMouseManager()
	{
		return mouseManager;
	}
	
	public void addUIObject(UIObject o)
	{
		uiObjects.add(o);
	}
	
	public void removeUIObject(UIObject o)
	{
		uiObjects.remove(o);
	}
	
	public ArrayList<UIObject> getList()
	{
		return uiObjects;
	}
	
}

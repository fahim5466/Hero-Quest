package dev.fahim.tileGame.ui;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.fahim.tileGame.input.MouseManager;

public class SlotManager {

	private MouseManager mouseManager;
	private ArrayList<UISlot> slots;
	private int page = 0;
	private UISlot currentItem = null;
	
	public SlotManager(MouseManager mouseManager)
	{
		this.mouseManager = mouseManager;
		slots = new ArrayList<UISlot>();
	}
	
	public void tick()
	{
		
		int i = page*25;
		
		for(int j=i;j<i+25;j++)
		{
			if(j>=slots.size()){break;}
			slots.get(j).setX(100+((j%25)%5)*64);
			slots.get(j).setY(100+((j%25)/5)*64);
			slots.get(j).tick();
		}
		
	}
	
	public void render(Graphics g)
	{
		int i = page*25;
		
		for(int j=i;j<i+25;j++)
		{
			if(j>=slots.size()){break;}
			slots.get(j).render(g);
		}
	}
	
	public void changeCurrentItem(UISlot s)
	{
		if(currentItem!=null){currentItem.deselect();}
		currentItem = s;
		s.select();
	}
	
	public UISlot getCurrentItem()
	{
		return currentItem;
	}
	
	public void setCurrentItem(UISlot s)
	{
		currentItem = s;
	}
	
	public void addSlot(UISlot s)
	{
		slots.add(s);
	}
	
	public void removeSlot(UISlot s)
	{
		slots.remove(s);
	}
	
	public ArrayList<UISlot> getSlots()
	{
		return slots;
	}
	
	public void nextPage()
	{
		if(page*25<slots.size()){page++;}
	}
	
	public void prevPage()
	{
		if(page!=0){page--;}
	}
	
}

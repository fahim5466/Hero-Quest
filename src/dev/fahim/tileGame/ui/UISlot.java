package dev.fahim.tileGame.ui;

import java.awt.Graphics;

import dev.fahim.tileGame.Item.Item;
import dev.fahim.tileGame.gfx.Assets;

public class UISlot extends UIObject{

	private SlotManager slotManager;
	private boolean selected=false;
	private Item item;
	
	public UISlot(UIManager uiManager, SlotManager slotManager, Item item) {
		super(0, 0, 64, 64, uiManager);
		this.slotManager = slotManager;
		this.item = item;
	}

	@Override
	public void tick() {
		
		setHover();
		onClick();
		
	}

	@Override
	public void render(Graphics g) {
		
		if(selected)
		{
			g.drawImage(Assets.selectedSlot,(int)x,(int)y,width,height,null);
		}
		else if(hovering)
		{
			g.drawImage(Assets.hoveringSlot,(int)x,(int)y,width,height,null);
		}
		else
		{
			g.drawImage(Assets.slot,(int)x,(int)y,width,height,null);
		}
		
		g.drawImage(item.getTexture(), (int)x+15, (int)y+15, width-30, height-30, null);
		
	}

	@Override
	public void onClick() {
		
		if(isLeftClicked())
		{
			slotManager.changeCurrentItem(this);
			InfoBox i = (InfoBox)(uiManager.getList().get(0));
			i.setPortrait(item.getTexture());
			i.setText(item.getDescription());
		}
	}
	
	public void select()
	{
		selected=true;
	}
	
	public void deselect()
	{
		selected=false;
	}
	
	public Item getItem()
	{
		return item;
	}

}

package dev.fahim.tileGame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.InfoBox;
import dev.fahim.tileGame.ui.SlotManager;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;

public class Inventory extends State{

	private UIManager uiManager;
	private SlotManager slotManager;
	
	public Inventory(Handler handler) {
		super(handler);
		
		uiManager = new UIManager(handler.getMouseManager());
		slotManager = new SlotManager(handler.getMouseManager());
		
		uiManager.addUIObject(new InfoBox(100+200+5*64, 100, 200, 200, uiManager,
				new String(""), null
				));
		
		UIImageButton use = new UIImageButton((5*64)/2,100+5*64+75,200,50,uiManager,new String("Use"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					if(slotManager.getCurrentItem()!=null)
					{
						slotManager.getCurrentItem().getItem().use();
						slotManager.getSlots().remove(slotManager.getCurrentItem());
						slotManager.setCurrentItem(null);
						InfoBox i = (InfoBox) uiManager.getList().get(0);
						i.setPortrait(null);
						i.setText(new String(""));
					}
				}
				}	
			);
		
		UIImageButton back = new UIImageButton(670,15,100,50,uiManager,new String("Back"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					StateManager.setCurrentState(handler.getGame().inGameUI);
				}
				}	
			);
		
		uiManager.addUIObject(use);
		uiManager.addUIObject(back);
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		slotManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.whiteBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
		uiManager.render(g);
		slotManager.render(g);
	}

	public UIManager getUiManager() {
		return uiManager;
	}

	public SlotManager getSlotManager() {
		return slotManager;
	}

}

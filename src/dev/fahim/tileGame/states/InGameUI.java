package dev.fahim.tileGame.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;

public class InGameUI extends State {

	private UIManager uiManager;
	private BufferedImage BG;
	
	//Buttons
	UIImageButton inventory, quests;
	
	public InGameUI(Handler handler)
	{
		super(handler);
		
		uiManager = new UIManager(handler.getMouseManager());
		BG = Assets.whiteBG;
		
		UIImageButton inventory = new UIImageButton(175,200,200,50,uiManager,new String("Inventory"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
			new Clicker(){

			@Override
			public void leftClick() {
				StateManager.setCurrentState(handler.getGame().inventory);
				
			}
			}	
		);
		
		UIImageButton quests = new UIImageButton(425,200,200,50,uiManager,new String("Quests"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					StateManager.setCurrentState(handler.getGame().quests);
					
				}
				}	
			);
		
		UIImageButton back = new UIImageButton(670,15,100,50,uiManager,new String("Back"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					StateManager.setCurrentState(handler.getGame().gameState);
					
				}
				}	
			);
		
		uiManager.addUIObject(inventory);
		uiManager.addUIObject(quests);
		uiManager.addUIObject(back);
		
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
	
		g.drawImage(BG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
		//Drawing health bar
		g.setFont(Assets.baseFont);
		g.drawString("Health", 50, 50);
		g.drawImage(Assets.GameButton, 120, 35, 515, 20, null);
		double health = handler.getGame().getPlayer().getHealth();
		g.setColor(Color.green);
		if(health<50){g.setColor(Color.yellow);}
		if(health<25){g.setColor(Color.red);}
		g.fillRect(127, 38,(int) health*5, 13);
		
		//Drawing mana bar
		g.setColor(Color.black);
		g.drawString("Mana", 50, 100);
		g.drawImage(Assets.GameButton, 120, 85, 515, 20, null);
		double mana = handler.getGame().getPlayer().getMana();
		g.setColor(Color.blue);
		g.fillRect(127, 88,(int) mana*5, 13);
		
		uiManager.render(g);
		
	}
	
}

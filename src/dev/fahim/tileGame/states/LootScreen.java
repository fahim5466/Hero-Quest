package dev.fahim.tileGame.states;

import java.awt.Graphics;
import java.util.Random;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.Item.Food;
import dev.fahim.tileGame.entities.Loot;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.InfoBox;
import dev.fahim.tileGame.ui.SlotManager;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;
import dev.fahim.tileGame.ui.UISlot;

public class LootScreen extends State {

	private UIManager uiManager;
	private SlotManager slotManager;
	private Loot l;
	
	public LootScreen(Handler handler, Loot l) {
		super(handler);
		this.l = l;
		
		uiManager = new UIManager(handler.getMouseManager());
		slotManager = new SlotManager(handler.getMouseManager());
		
		generateLoot();
		
		uiManager.addUIObject(new InfoBox(100+200+5*64, 100, 200, 200, uiManager,
				new String(""), null
				));
		
		UIImageButton loot = new UIImageButton((5*64)/2,100+5*64+75,200,50,uiManager,new String("Loot"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					if(slotManager.getCurrentItem()!=null)
					{
						handler.getGame().getPlayer().addToInventory(slotManager.getCurrentItem().getItem());
						slotManager.getSlots().remove(slotManager.getCurrentItem());
						slotManager.setCurrentItem(null);
						InfoBox i = (InfoBox) uiManager.getList().get(0);
						i.setPortrait(null);
						i.setText(new String(""));
					}
				}
				}	
			);
		
		UIImageButton next = new UIImageButton(100+5*64-50,40,50,50,uiManager,new String(">>"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					slotManager.nextPage();
				}
				}	
			);
		
		UIImageButton prev = new UIImageButton(100+5*64-100,40,50,50,uiManager,new String("<<"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					slotManager.prevPage();
				}
				}	
			);
		
		UIImageButton back = new UIImageButton(100,40,200,50,uiManager,new String("Back"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					handler.getWorld().getEntityManager().removeEntity(l);
					StateManager.setCurrentState(handler.getGame().gameState);
				}
				}	
			);
		
		uiManager.addUIObject(loot);
		uiManager.addUIObject(next);
		uiManager.addUIObject(prev);
		uiManager.addUIObject(back);
		
		//slotManager.addSlot(new UISlot(uiManager, slotManager, Food.foods.get(0)));
		
	}

	public void generateLoot()
	{
		
		int a = (int)(Math.random()*5+1);
		//System.out.println(a);
		for(int i=0;i<a;i++)
		{
			int b = (int)(Math.random()*5);
			//System.out.println(b);
			slotManager.addSlot(new UISlot(uiManager,slotManager,Food.foods.get(b)));
		}
		
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

}

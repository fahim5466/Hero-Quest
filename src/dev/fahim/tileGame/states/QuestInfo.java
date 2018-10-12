package dev.fahim.tileGame.states;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.Text;
import dev.fahim.tileGame.quest.Quest;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;

public class QuestInfo extends State{

	private UIManager uiManager;
	
	private Quest q;
	
	public QuestInfo(Handler handler, Quest q) {
		super(handler);
		uiManager = new UIManager(handler.getMouseManager());
		this.q = q;
		
		UIImageButton back = new UIImageButton(670,15,100,50,uiManager,new String("Back"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					StateManager.setCurrentState(handler.getGame().quests);
					
				}
				}	
			);
		
		uiManager.addUIObject(back);
		
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.whiteBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		uiManager.render(g);
		int t = Text.drawPara(g, q.getDescription(), 50, 50, handler.getWidth());
		Text.drawPara(g,q.getCurrentPhase().getDesc(),80,t-20, handler.getWidth());
	}

}

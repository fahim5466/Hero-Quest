package dev.fahim.tileGame.states;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.Text;
import dev.fahim.tileGame.quest.QuestManager;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;

public class Quests extends State{

	private UIManager uiManager;
	
	private QuestManager questManager;
	private int[] ys;
	private int yOffset=0;
	private int yOffsetMax;
	private boolean first=true;
	
	public Quests(Handler handler, QuestManager questManager) {
		super(handler);
		uiManager = new UIManager(handler.getMouseManager());
		
		UIImageButton back = new UIImageButton(670,15,100,50,uiManager,new String("Back"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				new Clicker(){

				@Override
				public void leftClick() {
					StateManager.setCurrentState(handler.getGame().inGameUI);
				}
				}	
			);
		
		uiManager.addUIObject(back);
		
		this.questManager = questManager;
		ys = new int[256];
	}

	@Override
	public void tick() {
		
		if(first)
		{
			first=false;
			return;
		}
		
		uiManager.tick();
		
		int my = handler.getMouseManager().getMouseY();
		int mx = handler.getMouseManager().getMouseX();
		
		for(int i=0;i<questManager.getQuests().size();i++)
		{
			if(my>=ys[i]+40 && my<=ys[i+1] && mx>=0 && mx<=handler.getWidth()-150+80)
			{
				if(handler.getMouseManager().isLeftPresssed())
				{
					StateManager.setCurrentState(new QuestInfo(handler, questManager.getQuests().get(i)));
				}
			}
		}
		
		if(mx>=handler.getWidth()-32 && mx<=handler.getWidth())
		{
			if(my>=0 && my<=32)
			{
				if(handler.getMouseManager().isLeftPresssed())
				{scrollUp();}
			}
			else if(my>=558 && my<=600)
			{
				if(handler.getMouseManager().isLeftPresssed())
				{scrollDown();}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.whiteBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		
		g.drawImage(Assets.upointer, handler.getWidth()-32, 0, null);
		g.drawImage(Assets.dpointer, handler.getWidth()-32, 558, null);
		
		uiManager.render(g);
		
		ys[0]=40;
		
		for(int i=0; i<questManager.getQuests().size();i++)
		{
			ys[i+1]=Text.drawPara(g, questManager.getQuests().get(i).getTitle(), 80, ys[i]+40, handler.getWidth()-150);
			int my = handler.getMouseManager().getMouseY();
			int mx = handler.getMouseManager().getMouseX();
			if(my>=ys[i]+40 && my<=ys[i+1] && mx>=0 && mx<=handler.getWidth()-150+80)
			{
				g.drawImage(Assets.selectedBox, 0, ys[i]+40, handler.getWidth()-150+80, ys[i+1]-ys[i]-40, null);
			}
			else
			{
				g.drawImage(Assets.box, 0, ys[i]+40, handler.getWidth()-150+80, ys[i+1]-ys[i]-40, null);
			}
		}
		
		if(yOffset==0)
		{
			yOffsetMax=Math.max(0,ys[ys.length-1]-handler.getHeight());
		}
		
	}
	
	public void scrollUp()
	{
		yOffset-=10;
		yOffset=Math.max(0, yOffset);
	}
	
	public void scrollDown()
	{
		yOffset+=10;
		yOffset=Math.min(yOffsetMax,yOffset);
	}
	
	public QuestManager getQuestManager()
	{
		return questManager;
	}

}

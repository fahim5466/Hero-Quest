package dev.fahim.tileGame.states;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.dialogue.Dialogue;
import dev.fahim.tileGame.dialogue.Option;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.Text;
import dev.fahim.tileGame.utils.Utils;

public class DialogueScreen extends State{

	private Dialogue currentDialogue;
	private int[] ys;
	private int yOffset=0;
	private int yOffsetMax;
	private boolean first=true;
	
	public DialogueScreen(Handler handler, Dialogue currentDialogue) {
		super(handler);
		this.currentDialogue = currentDialogue;
		ys = new int[currentDialogue.getOptions().size()+1];
	}
	
	public void setCurrentDialogue(Dialogue d)
	{
		currentDialogue = d;
	}
	
	@Override
	public void tick() {
		
		if(first)
		{
			first=false;
			return;
		}
		
		int my = handler.getMouseManager().getMouseY();
		int mx = handler.getMouseManager().getMouseX();
		
		for(int i=1;i<ys.length;i++)
		{
			if(my>=ys[i-1]+40 && my<=ys[i] && mx>=0 && mx<=handler.getWidth()-150+80)
			{
				if(handler.getMouseManager().isLeftPresssed())
				{
					currentDialogue.getOptions().get(i-1).execute();
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
		
		ys[0]=Text.drawPara(g, currentDialogue.getText(), 80, -yOffset, handler.getWidth()-150);
		
		for(int i=0; i<currentDialogue.getOptions().size();i++)
		{
			ys[i+1]=Text.drawPara(g, currentDialogue.getOptions().get(i).getText(), 80, ys[i]+40, handler.getWidth()-150);
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

}

package dev.fahim.tileGame.states;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.Text;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;

public class Notif extends State{

	private UIManager uiManager;
	Clicker clicker;
	private String s;
	
	public Notif(Handler handler, Clicker clicker, String s) {
		super(handler);
		this.clicker = clicker;
		this.s = s;
		uiManager = new UIManager(handler.getMouseManager());
		
		UIImageButton ok = new UIImageButton(handler.getWidth()/2-50,handler.getHeight()-100,100,50,uiManager,new String("Ok"),Assets.GameButton,Assets.GameDarkButton,Assets.GameClickedButton,
				clicker	
			);
		
		uiManager.addUIObject(ok);
		
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.whiteBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		uiManager.render(g);
		
		String paras[] = s.split("\n");
		int lastY = 50;
		for(int i=0; i<paras.length; i++)
		{
			String s = paras[i];
			int w = s.length()*10;
			lastY = Text.drawPara(g, s, 150, lastY, w);
		}
		
		//int t = Text.drawPara(g, s, handler.getWidth()/2-w/2, handler.getHeight()/2-h/2, w);
		
		
	}

}

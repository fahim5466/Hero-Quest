package dev.fahim.tileGame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.gfx.Text;

public class UIImageButton extends UIObject{

	private BufferedImage normal,hover,clicked;
	private String text;
	private Clicker clicker;
	
	public UIImageButton(double x, double y, int width, int height, UIManager uiManager, String text, BufferedImage normal, BufferedImage hover, BufferedImage clicked, Clicker clicker) {
		super(x, y, width, height,uiManager);
		this.text = text;
		this.normal = normal;
		this.hover = hover;
		this.clicked = clicked;
		this.clicker=clicker;
	}

	@Override
	public void tick() {
		setHover();
		onClick();
	}

	@Override
	public void render(Graphics g) {
		
		if(hovering)
		{
			g.drawImage(hover, (int) x, (int) y, width, height, null);
		}
		else
		{
			g.drawImage(normal, (int) x, (int) y, width, height, null);
		}
		
		Text.drawText(g, text, (int)x, (int)y+height/2, true, Color.black, Assets.baseFont);
		
	}

	@Override
	public void onClick() {
		
		if(isLeftClicked()){clicker.leftClick();}
		
	}

}

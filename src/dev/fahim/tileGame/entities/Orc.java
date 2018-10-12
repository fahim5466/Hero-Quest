package dev.fahim.tileGame.entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.dialogue.Dialogue;
import dev.fahim.tileGame.gfx.Animation;
import dev.fahim.tileGame.gfx.Animator;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.states.DialogueScreen;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.utils.Utils;

public class Orc extends Creature implements Clickable{

	private Dialogue currentDialogue=null;
	
	public Orc(Handler handler, double x, double y, int w, int h) {
		super(handler, x, y, w, h);
		
		bounds.x = 118;
		bounds.y = 174;
		bounds.width = 40;
		bounds.height = 20;
		
		setSpeed(1);
		
		animDown = new Animation(100, Assets.orc_down);
		animUp = new Animation(100, Assets.orc_up);
		animLeft = new Animation(100, Assets.orc_left);
		animRight = new Animation(100, Assets.orc_right);
		
		animAttackDown = new Animation(75,Assets.orc_attack_down); 
		animAttackUp = new Animation(75,Assets.orc_attack_up);
		animAttackLeft = new Animation(75,Assets.orc_attack_left);
		animAttackRight = new Animation(75,Assets.orc_attack_right);
		
		animBowDown = new Animation(75, Assets.player_bow_down);
		animBowUp = new Animation(75, Assets.player_bow_up);
		animBowLeft = new Animation(75, Assets.player_bow_left);
		animBowRight = new Animation(75, Assets.player_bow_right);
		
		animMagicDown = new Animation(100, Assets.player_magic_down);
		animMagicUp = new Animation(100, Assets.player_magic_up);
		animMagicLeft = new Animation(100, Assets.player_magic_left);
		animMagicRight = new Animation(100, Assets.player_magic_right);
		
		animDie = new Animation(100,Assets.orc_die);
		
		animator=new Animator(handler,this);
		
	}

	@Override
	public void tick() {
		
		if(isClicked())
		{
			if(currentDialogue!=null)
			{
				Utils.changeCursor(handler, 0);
				StateManager.setCurrentState(new DialogueScreen(handler, currentDialogue));
			}
		}
		
		xMove=0;
		yMove=0;
		
		controller.tick();
		
		controller.AItick();
		
		animator.animate();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(animator.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), w, h, null);
		
		/*
		g.setColor(Color.green);
		g.fillRect(
				  	(int)(x + w/4 - handler.getGameCamera().getxOffset()),
				  	(int)(y + h/4 - handler.getGameCamera().getyOffset()),
				  	w/2,h/2
				  );
		*/
		
		drawHealthBar(g);
		
	}
	
	public void drawHealthBar(Graphics g)
	{
		g.setColor(new Color(0,255,0,178));
		if(health<50){g.setColor(new Color(0,255,255,178));}
		if(health<25){g.setColor(new Color(255,0,0,178));}
		g.drawImage(Assets.bar,
			  	(int)(x + bounds.x - 15 - handler.getGameCamera().getxOffset()),
			  	(int)(y + bounds.y + 20 - handler.getGameCamera().getyOffset()),
			  	80,bounds.height+10,null
			  );
		g.fillRect(
				  	(int)(x + bounds.x - 10 - handler.getGameCamera().getxOffset()),
				  	(int)(y + bounds.y + 25 - handler.getGameCamera().getyOffset()),
				  	(int)(70*health)/100,bounds.height
				  );
	}
	
	public void setCurrentDialogue(Dialogue d)
	{
		currentDialogue = d;
	}

	@Override
	public boolean isClicked() {
		if(
				handler.getMouseManager().getMouseX()>=x - handler.getGameCamera().getxOffset()+w/4 && handler.getMouseManager().getMouseX()<=x - handler.getGameCamera().getxOffset()+3*(w/4)
				&&
				handler.getMouseManager().getMouseY()>=y - handler.getGameCamera().getyOffset()+h/4 && handler.getMouseManager().getMouseY()<=y - handler.getGameCamera().getyOffset()+3*(h/4)
				&&
				Math.abs(handler.getGame().getPlayer().getBounds().x+handler.getGame().getPlayer().getX()-this.getBounds().x-this.x)<=100
				&&
				Math.abs(handler.getGame().getPlayer().getBounds().y+handler.getGame().getPlayer().getY()-this.getBounds().y-this.y)<=100
				)
		{
			Utils.changeCursor(handler, 1);
			if(
					handler.getMouseManager().isRightPressed()
					){return true;}
		}
		else
		{
			Utils.changeCursor(handler, 0);
		}
		return false;
	}

	@Override
	public void whenClicked() {
		
	}

}

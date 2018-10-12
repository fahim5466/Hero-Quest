package dev.fahim.tileGame.entities;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.Item.Item;
import dev.fahim.tileGame.gfx.Animation;
import dev.fahim.tileGame.gfx.Animator;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.input.Controller;
import dev.fahim.tileGame.input.PlayerController;
import dev.fahim.tileGame.states.Inventory;
import dev.fahim.tileGame.states.Notif;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.UISlot;

public class Player extends Creature{
	
	protected PlayerController controller;
	
	public Player(Handler handler, double x, double y, int w, int h) {
		super(handler, x, y, w, h);
		
		bounds.x = 118;
		bounds.y = 174;
		bounds.width = 40;
		bounds.height = 20;
		
		animDown = new Animation(100, Assets.player_down);
		animUp = new Animation(100, Assets.player_up);
		animLeft = new Animation(100, Assets.player_left);
		animRight = new Animation(100, Assets.player_right);
		
		animAttackDown = new Animation(75,Assets.player_attack_down); 
		animAttackUp = new Animation(75,Assets.player_attack_up);
		animAttackLeft = new Animation(75,Assets.player_attack_left);
		animAttackRight = new Animation(75,Assets.player_attack_right);
		
		animBowDown = new Animation(100, Assets.player_bow_down);
		animBowUp = new Animation(100, Assets.player_bow_up);
		animBowLeft = new Animation(100, Assets.player_bow_left);
		animBowRight = new Animation(100, Assets.player_bow_right);
		
		animMagicDown = new Animation(100, Assets.player_magic_down);
		animMagicUp = new Animation(100, Assets.player_magic_up);
		animMagicLeft = new Animation(100, Assets.player_magic_left);
		animMagicRight = new Animation(100, Assets.player_magic_right);
		
		animDie = new Animation(200,Assets.player_die);
		
		animator=new Animator(handler, this);
		
		controller = new PlayerController(handler,this,handler.getKeyManager(),handler.getMouseManager());
		
	}

	@Override
	public void tick() {
		
		if(isDead())
		{
			StateManager.setCurrentState(new Notif(handler,
					new Clicker(){

					@Override
					public void leftClick() {
						System.exit(0);
					
					}
					}
					,"Game Over!!"));
		}
		
		xMove=0;
		yMove=0;
		
		handler.getGameCamera().centerOnEntity(this);
		
		controller.playertick();
		
		controller.tick();
		
		animator.animate();
		
	}

	@Override
	public void render(Graphics g) {
	
		g.drawImage(animator.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), w, h, null);
		
		/*
		g.setColor(Color.red);
		g.fillRect(
				  	(int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				  	(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				  	bounds.width,bounds.height
				  );
		*/
		
		
		drawHealthBar(g);
		
	}
	
	public void drawHealthBar(Graphics g)
	{
		g.setColor(new Color(0,255,0,178));
		if(health<50){g.setColor(new Color(0,255,255,128));}
		if(health<25){g.setColor(new Color(255,0,0,128));}
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
	
	public Controller getController()
	{
		return controller;
	}
	
	public void addToInventory(Item item)
	{
		Inventory i = (Inventory)handler.getGame().inventory;
		i.getSlotManager().addSlot(new UISlot(i.getUiManager(),i.getSlotManager(),item));
	}

}

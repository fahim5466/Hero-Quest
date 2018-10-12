package jmim.codenmore.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jmim.codenmore.game.Handler;
import jmim.codenmore.game.grpx.Animation;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.game.grpx.ImageLoader;
import jmim.codenmore.world.World;

public class Player extends Creature{
	
	public World world;
	Entity en;
	Animation animDown,animLeft;
	private Animation animUp;
	private Animation animRight;

	public Player(Handler handler,float x,float y) {
		super(handler,x, y,Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
		bound.x=0;
		bound.y=0;
		bound.width=70;
		bound.height=80;
		
		animDown=new Animation(500,Assets.player_down);
		animLeft=new Animation(500,Assets.player_left);
		animUp=new Animation(500,Assets.player_up);
		animRight=new Animation(500,Assets.player_right);
	}

	@Override
	public void tick() {
		
		getKeyInput();
		move();
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		handler.getGameCamera().centerOnEntity(this);
		
			}
	
	public void getKeyInput()
	{
		xMove=0;
		yMove=0;
		
		if(handler.getKey().up)
			yMove=-speed;
		if(handler.getKey().down)
			yMove=speed;
		if(handler.getKey().left)
			xMove=-speed;
		if(handler.getKey().right)
			xMove=speed;
	}
	
	

	@Override
	public void render(Graphics g) {
		BufferedImage e=ImageLoader.loadImage("/Texture/elf.png.png");
		g.drawImage(getCurrentAnimationFrame(),(int) (x-handler.getGameCamera().getxOffset()),
				(int) (y-handler.getGameCamera().getyOffset()),
				width,height,null);
		//g.setColor(Color.BLUE);
		//g.fillRect((int) (x+bound.x-handler.getGameCamera().getxOffset()), (int)(y+bound.y-handler.getGameCamera().getyOffset()), bound.width, bound.height);
		//bush=1,fence=2,grass=3;
	}
	
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animLeft.curentFrame();
		}else if(xMove > 0){
			return animRight.curentFrame();
		}else if(yMove < 0){
			return animUp.curentFrame();
		}else{
			return animDown.curentFrame();
		}
	}
	

}

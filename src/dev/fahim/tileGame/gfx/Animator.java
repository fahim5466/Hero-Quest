package dev.fahim.tileGame.gfx;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.Arrow;
import dev.fahim.tileGame.entities.Creature;
import dev.fahim.tileGame.utils.Utils;

public class Animator {

	private Creature c;
	private Handler handler;
	private boolean fixed=false;
	private Animation currentAnimation;
	private ArrayList<Animation> animations;
	
	private boolean dye=false;
	private Color dyeColor;
	
	public Animator(Handler handler, Creature c)
	{
		this.c = c;
		this.handler = handler;
		
		currentAnimation=c.animDown;
		
		
		animations = new ArrayList<Animation>();
		animations.add(c.animDown);
		animations.add(c.animLeft);
		animations.add(c.animRight);
		animations.add(c.animUp);
		animations.add(c.animAttackDown);
		animations.add(c.animAttackLeft);
		animations.add(c.animAttackRight);
		animations.add(c.animAttackUp);
		animations.add(c.animBowDown);
		animations.add(c.animBowLeft);
		animations.add(c.animBowRight);
		animations.add(c.animBowUp);
		animations.add(c.animMagicDown);
		animations.add(c.animMagicLeft);
		animations.add(c.animMagicRight);
		animations.add(c.animMagicUp);
		animations.add(c.animDie);
		
	}
	
	public void animate()
	{
		
		if(fixed)
		{
			currentAnimation.tick();
			if(currentAnimation.getCycle()==1)
			{
				fixed=false;
				
				if(currentAnimation==c.animDie){return;}
				
				c.getController().animInfo();
				
				if(c.getFace()==1){currentAnimation=c.animUp;}
				else if(c.getFace()==2){currentAnimation=c.animRight;}
				else if(c.getFace()==3){currentAnimation=c.animDown;}
				else if(c.getFace()==4){currentAnimation=c.animLeft;}
			}
		}
		else
		{
			
		if(c.getController().isLeftPressed())
		{
			if(c.getFace()==1)
			{
				currentAnimation=c.animAttackUp;
				fixed=true;
			}
			else if(c.getFace()==2)
			{
				currentAnimation=c.animAttackRight;
				fixed=true;
			}
			else if(c.getFace()==3)
			{
				currentAnimation=c.animAttackDown;
				fixed=true;
			}
			else if(c.getFace()==4)
			{
				currentAnimation=c.animAttackLeft;
				fixed=true;
			}
				
		}
		else if(c.getController().isZ())
		{
			if(c.getFace()==1)
			{
				currentAnimation=c.animBowUp;
				fixed=true;
			}
			else if(c.getFace()==2)
			{
				currentAnimation=c.animBowRight;
				fixed=true;
			}
			else if(c.getFace()==3)
			{
				currentAnimation=c.animBowDown;
				fixed=true;
			}
			else if(c.getFace()==4)
			{
				currentAnimation=c.animBowLeft;
				fixed=true;
			}
				
		}
		else if(c.getController().isX())
		{
			if(c.getFace()==1)
			{
				currentAnimation=c.animMagicUp;
				fixed=true;
			}
			else if(c.getFace()==2)
			{
				currentAnimation=c.animMagicRight;
				fixed=true;
			}
			else if(c.getFace()==3)
			{
				currentAnimation=c.animMagicDown;
				fixed=true;
			}
			else if(c.getFace()==4)
			{
				currentAnimation=c.animMagicLeft;
				fixed=true;
			}
				
		}
		else if(c.getController().isLeft())
		{
			
			currentAnimation=c.animLeft;
			c.setFace(4);
			
		}
		else if(c.getController().isRight())
		{
			currentAnimation=c.animRight;
			c.setFace(2);
		}
		else if(c.getController().isDown())
		{
			currentAnimation=c.animDown;
			c.setFace(3);
			
		}
		else if(c.getController().isUp())
		{
			currentAnimation=c.animUp;
			c.setFace(1);
		}
		else
		{
			
			currentAnimation.reset();
			
		}
		
		currentAnimation.tick();
		
		}
		
		for(Animation a : animations)
		{
			if(a!=currentAnimation)
			{
				a.reset();
			}
		}
		
	}
	
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
	}

	public void die()
	{
		currentAnimation = c.animDie;
		fixed=true;
	}
	
	public BufferedImage getCurrentFrame()
	{
		if(dye){return Utils.dye(currentAnimation.getCurrentFrame(), dyeColor);}
		return currentAnimation.getCurrentFrame();
	}
	
	public boolean isFixed()
	{
		return fixed;
	}

	public boolean isDye() {
		return dye;
	}

	public void setDye(boolean dye) {
		this.dye = dye;
	}

	public Color getDyeColor() {
		return dyeColor;
	}

	public void setDyeColor(Color dyeColor) {
		this.dyeColor = dyeColor;
	}
	
	
	
}

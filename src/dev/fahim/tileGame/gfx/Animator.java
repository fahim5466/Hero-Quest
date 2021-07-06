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
	
	//once an animation starts, no other animation can start until the current one finishes
	//fixed indicates if any animation is ongoing
	private boolean fixed=false;
	
	private Animation currentAnimation;
	private ArrayList<Animation> animations;
	
	//if the sprite will be dyed with any color
	private boolean dye=false;
	private Color dyeColor;
	
	public Animator(Handler handler, Creature c)
	{
		this.c = c;
		this.handler = handler;
		
		//by default faces towards the screen
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
				//one animation cycle finished
				
				fixed=false;
				
				if(currentAnimation==c.animDie){return;}
				
				if (currentAnimation == c.animBowUp
					|| currentAnimation == c.animBowDown
					|| currentAnimation == c.animBowLeft
					|| currentAnimation == c.animBowRight)
				{
					c.getController().shootArrow();
				}
				
				if (currentAnimation == c.animMagicUp
					|| currentAnimation == c.animMagicDown
					|| currentAnimation == c.animMagicLeft
					|| currentAnimation == c.animMagicRight)
				{
					c.getController().shootFireball();
				}
				
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
				//creature is performing melee attack
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
				//creature is performing ranged attack
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
				//creature is performing magic attack
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
				//creature is moving left
				currentAnimation=c.animLeft;
				c.setFace(4);
				
			}
			else if(c.getController().isRight())
			{
				//creature is moving right
				currentAnimation=c.animRight;
				c.setFace(2);
			}
			else if(c.getController().isDown())
			{
				//creature is moving down
				currentAnimation=c.animDown;
				c.setFace(3);
				
			}
			else if(c.getController().isUp())
			{
				//creature is moving up
				currentAnimation=c.animUp;
				c.setFace(1);
			}
			else
			{
				//this is important
				//if the creature is doing nothing
				//then he will stand still facing the direction his 'face' variable is set to
				//this is simulated by setting animation to one of the move animations
				//and resetting it at each tick
				//because we are resetting at each tick the animation is not animated
				//for example if creature is facing right
				//current animation is set to animRight and is reset at each tick
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

package dev.fahim.tileGame.entities;

import javax.sound.sampled.Clip;

import dev.fahim.tileGame.Handler;

public abstract class Projectile extends Entity{

	protected double speed;
	protected int direction;
	protected double xMove, yMove;
	protected int damage;
	protected Clip hitSound;
	
	public Projectile(Handler handler, double x, double y, int w, int h, int direction) {
		super(handler, x, y, w, h);
		this.direction = direction;
	}

	@Override
	public void tick() {
		
		//if projectile moves out of map remove it
		if(x<-100 || y<-100 || x>handler.getWidth()+700 || y>handler.getHeight()+700)
		{
			handler.getWorld().getEntityManager().removeEntity(this);
		}
		
		xMove=0; yMove=0;
		
		if(direction==1){yMove=-speed;}
		else if(direction==2){xMove=speed;}
		else if(direction==3){yMove=speed;}
		else{xMove=-speed;}
		
		Entity ret = checkEntityCollision(xMove,yMove);
		
		if(ret!=null)
		{
			
			boolean falseAlert=false;
			if(ret instanceof Creature && ret==handler.getWorld().getEntityManager().getPlayer()){falseAlert=true;}
			
			if(!falseAlert)
			{
				handler.getSoundManager().play(hitSound);
				handler.getWorld().getEntityManager().removeEntity(this);
				if(ret instanceof Creature)
				{
					((Creature) ret).setHealth(((Creature) ret).getHealth()-damage);
					((Creature) ret).getController().hurt(true);
				}
			
			}
		}
		
		x+=xMove;
		y+=yMove;
		
	}
	
	public int getRotation()
	{
		if(direction==2){return 0;}
		else if(direction==3){return 90;}
		else if(direction==4){return 180;}
		else{return 270;}
			
	}
	
	public boolean canBlock()
	{
		return false;
	}

}

package dev.fahim.tileGame.input;

import java.util.LinkedList;
import java.util.Queue;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.Creature;
import dev.fahim.tileGame.entities.Player;
import dev.fahim.tileGame.tile.Tile;

public class AIController extends Controller{
	
	private int i; // for shortest path finding
	
	public AIController(Handler handler, Creature c, KeyManager keyManager, MouseManager mouseManager) {
		super(handler, c, keyManager, mouseManager);
	}
	
	public void AItick()
	{
		findShortPath();
		
		/*
		if(c.getCollisionBounds(c.getxMove(), c.getyMove()).intersects
			(getPlayer().getCollisionBounds(0,0))
		)
		{
			getPlayer().setHealth(getPlayer().getHealth()-1);
			getPlayer().getController().hurt(true);
			System.out.println("Ouch!");
		}
		*/
		
		
		
	}
	
	public  void findErraticPath()
	{
		int xTolerance=0;
		int yTolerance=0;
		
		if(Math.abs(getPlayer().getX() - c.getX()) == xTolerance)
		{
			setRight(false);
			setLeft(false);
		}
		else if(getPlayer().getX() - c.getX() > xTolerance)
		{
			setRight(true);
			setLeft(false);
		}
		else
		{
			setLeft(true);
			setRight(false);
		}

		if(Math.abs(getPlayer().getY() - c.getY()) == yTolerance)
		{
			setDown(false);
			setUp(false);
		}
		else if(getPlayer().getY() - c.getY() > yTolerance)
		{
			setDown(true);
			setUp(false);
		}
		else
		{
			setUp(true);
			setDown(false);
		}
		
	}
	
	public void findShortPath()
	{
		
		Player p = handler.getWorld().getEntityManager().getPlayer();
		
		int px = (int)(p.getX()+p.getBounds().x)/Tile.w;
		int py = (int)(p.getY()+p.getBounds().y)/Tile.h;
		
		int cx = (int)(c.getX()+c.getBounds().x)/Tile.w;
		int cy = (int)(c.getY()+c.getBounds().y)/Tile.h;
		
		int dx = (int)(c.getX()+c.getBounds().x+c.getBounds().width)/Tile.w;
		int dy = (int)(c.getY()+c.getBounds().y+c.getBounds().height)/Tile.h;
		
		//System.out.println(px+" "+py+" "+cx+" "+cy+" "+dx+" "+dy);
		
		if(cx!=dx ||cy!=dy)
		{
			//setLeftPressed(false);
			return;
		}
		
		/*
		if(Math.abs(p.getX()-c.getX())>c.getSightW() || Math.abs(p.getY()-c.getY())>c.getSightH())
		{
			setUp(false);
			setDown(false);
			setLeft(false);
			setRight(false);
			setLeftPressed(false);
			return;
		}
		*/
		
		int r=canHit(getPlayer());
		
		//System.out.println(r);
		
		if(r!=0)
		{
			c.setFace(r);
			setUp(false);
			setDown(false);
			setLeft(false);
			setRight(false);
			setLeftPressed(true);
			return;
		}
		else
		{
			setLeftPressed(false);
		}
		
		
		boolean vis[][] = new boolean[handler.getWorld().getH()][handler.getWorld().getW()];
		
		int mn=100000;
		
		Queue<Integer> qx = new LinkedList<>();
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> lv = new LinkedList<>();
		
		initVis(vis,cx,cy,px,py);
		qx.clear(); qy.clear(); lv.clear();
		seti(0);
		
		if(isOk(cx+1,cy,vis))
		{
			//System.out.println("Right");
			qx.add(cx+1);
			qy.add(cy);
			lv.add(0);
			
			vis[cy][cx]=false;
			
			if(dijkstra(px,py,vis,qx,qy,lv) && i<mn)
			{
				setUp(false);
				setDown(false);
				setLeft(false);
				setRight(true);
				mn=i;
			}
			
			//System.out.println(i);
			
		}
		
		initVis(vis,cx,cy,px,py);
		qx.clear(); qy.clear(); lv.clear();
		seti(0);
		
		if(isOk(cx,cy+1,vis))
		{
			//System.out.println("Down");
			qx.add(cx);
			qy.add(cy+1);
			lv.add(0);
			
			vis[cy][cx]=false;
			
			if(dijkstra(px,py,vis,qx,qy,lv) && i<mn)
			{
				setUp(false);
				setDown(true);
				setLeft(false);
				setRight(false);
				mn=i;
			}
			
			//System.out.println(i);
			
		}
		
		initVis(vis,cx,cy,px,py);
		qx.clear(); qy.clear(); lv.clear();
		seti(0);
		
		if(isOk(cx-1,cy,vis))
		{
			//System.out.println("Left");
			qx.add(cx-1);
			qy.add(cy);
			lv.add(0);
			
			vis[cy][cx]=false;
		
			if(dijkstra(px,py,vis,qx,qy,lv) && i<mn)
			{
				setUp(false);
				setDown(false);
				setLeft(true);
				setRight(false);
				mn=i;
			}
			
			//System.out.println(i);
			
		}
		
		initVis(vis,cx,cy,px,py);
		qx.clear(); qy.clear(); lv.clear();
		seti(0);
		
		if(isOk(cx,cy-1,vis))
		{
			//System.out.println("Up");
			qx.add(cx);
			qy.add(cy-1);
			lv.add(0);
			
			vis[cy][cx]=false;
		
			if(dijkstra(px,py,vis,qx,qy,lv) && i<mn)
			{
				setUp(true);
				setDown(false);
				setLeft(false);
				setRight(false);
				mn=i;
			}
			
			//System.out.println(i);
			
		}
		
	}
	
	public void initVis(boolean vis[][], int cx, int cy, int px, int py)
	{
		
		for(int i=0;i<handler.getWorld().getH();i++)
		{
			for(int j=0;j<handler.getWorld().getW();j++)
			{
				vis[i][j]=handler.getWorld().getTileMap().getMap()[i][j];
			}
		}
		
		vis[cy][cx]=true;
		vis[py][px]=true;
		
	}
	
	public boolean dijkstra(int px, int py, boolean vis[][], Queue<Integer> qx, Queue<Integer> qy, Queue<Integer> lv)
	{
		
		while(qx.peek()!=null)
		{
			
			int x=qx.poll();
			int y=qy.poll();
			int l=lv.poll();
			
			if(!vis[y][x]){continue;}
			else{vis[y][x]=false;}
			
			//System.out.println(x+" "+y+" "+l);
			
			/*
			for(int i=0;i<handler.getWorld().getH();i++)
			{
				for(int j=0;j<handler.getWorld().getW();j++)
				{
					int t;
					if(vis[i][j]){t=1;}
					else{t=0;}
					System.out.print(t+" ");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			*/
			
			int cx=x;
			int cy=y;
			int dx = (int)(cx*Tile.w+c.getBounds().width)/Tile.w;
			int dy = (int)(cy*Tile.h+c.getBounds().height)/Tile.h;
			
			//System.out.println(cx+" "+cy+" "+dx+" "+dy);
			
			seti(l+1);
			
			if(cx==px && cy==py
			   )
			{
				//System.out.println(cx+" "+cy+" "+dx+" "+dy);
				return true;
			}
			
			if(isOk(x+1,y,vis)){qx.add(x+1); qy.add(y); lv.add(l+1);}
			if(isOk(x,y+1,vis)){qx.add(x); qy.add(y+1); lv.add(l+1);}
			if(isOk(x-1,y,vis)){qx.add(x-1); qy.add(y); lv.add(l+1);}
			if(isOk(x,y-1,vis)){qx.add(x); qy.add(y-1); lv.add(l+1);}
			
		}
		
		return false;
		
	}
	
	public boolean isOk(int x, int y, boolean vis[][])
	{
		if(x>=0 && x<handler.getWorld().getW()
			&& y>=0 && y<handler.getWorld().getH() && vis[y][x]){return true;}
		else{return false;}
	}
	
	public int geti()
	{
		return i;
	}
	
	public void seti(int i)
	{
		this.i=i;
	}

}

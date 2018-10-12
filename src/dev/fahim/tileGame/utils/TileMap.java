package dev.fahim.tileGame.utils;

import dev.fahim.tileGame.entities.Entity;
import dev.fahim.tileGame.tile.Tile;
import dev.fahim.tileGame.worlds.World;

public class TileMap {

	private boolean map[][];
	World world;
	
	public TileMap(int x, int y, World world)
	{
		
		this.world = world;
		
		map = new boolean[x][y];
		
	}
	
	public void tick()
	{
		
		for(int i=0;i<world.getH();i++)
		{
			for(int j=0;j<world.getW();j++)
			{
				if(world.getTile(i, j).isSolid())
				{
					map[i][j]=false;
				}
				else
				{
					map[i][j]=true;
				}
			}
		}
		
		for(Entity e : world.getEntityManager().getEntities())
		{
			
			int xStart = (int)((e.getX()+e.getBounds().x)/Tile.w);
			int xEnd = (int)((e.getX()+e.getBounds().x+e.getBounds().width)/Tile.w);
			int yStart = (int)((e.getY()+e.getBounds().y)/Tile.h);
			int yEnd = (int)((e.getY()+e.getBounds().y+e.getBounds().height)/Tile.h);
			
			
			for(int i=xStart;i<=xEnd;i++)
			{
				for(int j=yStart;j<=yEnd;j++)
				{
					//System.out.println(i+" "+j);
					if(i<0 || j<0 || i>=world.getW() || j>=world.getH()){continue;}
					map[j][i]=false;
				}
			}
			
			
			//System.out.println(e.getX()+e.getBounds().x+" "+e.getY()+e.getBounds().y);
			
			//if(yStart<0 || yStart>=world.getH() || xStart<0 || xStart>=world.getW()){continue;}
			
			//map[yStart][xStart]=false;
			
		}
		
		
		//debugPrint();
		
	}
	
	public void debugPrint()
	{
		
		for(int i=0;i<world.getH();i++)
		{
			for(int j=0;j<world.getW();j++)
			{
				int t;
				if(map[i][j]){t=1;}
				else{t=0;}
				System.out.print(t+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
	}
	
	public boolean[][] getMap()
	{
		return map;
	}
	
}

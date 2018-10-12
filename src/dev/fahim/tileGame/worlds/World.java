package dev.fahim.tileGame.worlds;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.EntityManager;
import dev.fahim.tileGame.entities.Player;
import dev.fahim.tileGame.entities.Orc;
import dev.fahim.tileGame.tile.Tile;
import dev.fahim.tileGame.utils.TileMap;
import dev.fahim.tileGame.utils.Utils;

public class World {

	private Handler handler;
	private int w,h; //in terms of tiles
	public int spawnX, spawnY; //in terms of co-ordinates
	private EntityManager entityManager;
	private TileMap tileMap;
	
	private int[][] tiles;
	
	public World(Handler handler, String path, Player player)
	{
		this.handler=handler;
		loadWorld(path);
		entityManager = new EntityManager(handler, player);
		tileMap = new TileMap(h,w,this);
		
		/*
		
		IMPORTANT!!
		  
		Unfortunately because of how short-path finding code works every entity who needs it
		must be placed such that its entire collision box fits inside a single tile
		  
		*/
		
		//Mobs
		//entityManager.addEntity(new Zombie(handler, 550,30,128*2,128*2));
		//entityManager.addEntity(new Zombie(handler, 550,390,128*2,128*2));
		//entityManager.addEntity(new Zombie(handler, 16*30,16*20,128*2,128*2));
		//entityManager.addEntity(new Zombie(handler, 16*30,16*50,128*2,128*2));
		
		//Static entities
		/*
		entityManager.addEntity(new Tree(handler,16*10,16*-14));
		entityManager.addEntity(new Tree(handler,16*3,16*25));
		entityManager.addEntity(new Tree(handler,16*15,16*10));
		entityManager.addEntity(new Tree(handler,16*45,16*-14));
		entityManager.addEntity(new Tree(handler,16*35,16*6));
		*/
	}

	public void tick()
	{
		tileMap.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		//Tiles
		int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset()/Tile.w);
		int xEnd = (int) Math.min(w,(handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.w + 1);
		int yStart = (int) Math.max(0,handler.getGameCamera().getyOffset()/Tile.h);;
		int yEnd = (int) Math.min(h,(handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.h + 1);;
		
		for(int i=yStart;i<yEnd;i++)
		{
			for(int j=xStart;j<xEnd;j++)
			{
				getTile(i,j).render(g, (int)(j*Tile.w - handler.getGameCamera().getxOffset()),
									   (int)(i*Tile.h - handler.getGameCamera().getyOffset()) );
			}
		}
		
		//Entities
		entityManager.render(g);
		
	}
	
	public Tile getTile(int x, int y)
	{
		
		if(x<0 || y<0 || x>=w || y>=h)
		{
			return Tile.stoneTile;
		}
		
		int ind = tiles[x][y];
		//System.out.println(ind);
		Tile t = Tile.tiles[ind];
		
		if(t==null)
		{
			return Tile.dirtTile;
		}
		else
		{
			return t;
		}
		
	}
	
	private void loadWorld(String path)
	{
		
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		w=Utils.parseInt(tokens[0]);
		h=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		
		tiles = new int[h][w];
		
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				tiles[i][j] = Utils.parseInt(tokens[i*w+j+4]);
			}
		}
		
		/*
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				System.out.print(tiles[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		*/
	}
	
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public TileMap getTileMap()
	{
		return tileMap;
	}
	
}

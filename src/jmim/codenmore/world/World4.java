package jmim.codenmore.world;

import java.awt.Graphics;

import jmim.codenmore.entity.EntityManager;
import jmim.codenmore.entity.Player;
import jmim.codenmore.entity.statics.Balloon;
import jmim.codenmore.entity.statics.Banner;
import jmim.codenmore.entity.statics.Bomb;
import jmim.codenmore.entity.statics.Bush;
import jmim.codenmore.entity.statics.Bush2;
import jmim.codenmore.entity.statics.Bush3;
import jmim.codenmore.entity.statics.Cart;
import jmim.codenmore.entity.statics.CityBush;
import jmim.codenmore.entity.statics.CityTent;
import jmim.codenmore.entity.statics.CityTent1;
import jmim.codenmore.entity.statics.Coop;
import jmim.codenmore.entity.statics.Coop2;
import jmim.codenmore.entity.statics.Decor3;
import jmim.codenmore.entity.statics.DecorFloor;
import jmim.codenmore.entity.statics.DecorFloor2;
import jmim.codenmore.entity.statics.Door;
import jmim.codenmore.entity.statics.Door2;
import jmim.codenmore.entity.statics.Drum;
import jmim.codenmore.entity.statics.FallTree;
import jmim.codenmore.entity.statics.FallTree2;
import jmim.codenmore.entity.statics.FallTree3;
import jmim.codenmore.entity.statics.FallTree4;
import jmim.codenmore.entity.statics.Fence;
import jmim.codenmore.entity.statics.Flag;
import jmim.codenmore.entity.statics.Fountain;
import jmim.codenmore.entity.statics.House;
import jmim.codenmore.entity.statics.Mattress;
import jmim.codenmore.entity.statics.Mattress1;
import jmim.codenmore.entity.statics.Pond;
import jmim.codenmore.entity.statics.Post;
import jmim.codenmore.entity.statics.Post1;
import jmim.codenmore.entity.statics.Shop;
import jmim.codenmore.entity.statics.ShopTable;
import jmim.codenmore.entity.statics.Statue;
import jmim.codenmore.entity.statics.Table;
import jmim.codenmore.entity.statics.Table2;
import jmim.codenmore.entity.statics.Tent;
import jmim.codenmore.entity.statics.TileHead;
import jmim.codenmore.entity.statics.Torch;
import jmim.codenmore.entity.statics.Tree1;
import jmim.codenmore.entity.statics.Tree2;
import jmim.codenmore.entity.statics.Water;
import jmim.codenmore.entity.statics.WaterNarrow;
import jmim.codenmore.entity.statics.WeirdGrass;
import jmim.codenmore.game.GameMain;
import jmim.codenmore.game.Handler;
import jmim.codenmore.tile.Tile;
import jmim.codenmore.utils.Utils;

public class World4 {
	
	int width,height;
	private int[][] worldTiles;
	int spawnX,spawnY;
	private int xStart=0;
	private int xEnd=0;
	private int yStart=0;
	private int yEnd=0;
	private Handler handler;
	private EntityManager entityManager;
	
	public World4(Handler handler,String path)
	{
		this.handler=handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		
		entityManager.addEntity(new FallTree2(handler, 16*2, 16*4));
		//entityManager.addEntity(new FallTree(handler, 16*0, 16*10));
		entityManager.addEntity(new FallTree(handler, 16*0, 16*24));
		
		entityManager.addEntity(new FallTree3(handler, 16*0, 16*15));
		entityManager.addEntity(new FallTree3(handler, 16*2, 16*33));
		entityManager.addEntity(new FallTree2(handler, 16*5, 16*39));
		entityManager.addEntity(new FallTree3(handler, 16*10, 16*41));
		
		entityManager.addEntity(new Drum(handler, 16*28, 16*30));
		entityManager.addEntity(new Drum(handler, 16*28+140, 16*30));
		entityManager.addEntity(new Drum(handler, 16*28+150, 16*30+40));
		entityManager.addEntity(new CityTent(handler, 16*28, 16*30));
		entityManager.addEntity(new CityTent1(handler, 520, 16*36));
		entityManager.addEntity(new Mattress(handler, 16*30, 16*38+50));
		
		entityManager.addEntity(new Drum(handler, 16*12, 16*20));
		entityManager.addEntity(new Drum(handler, 16*12+140, 16*20));
		entityManager.addEntity(new Drum(handler, 16*12+150, 16*20+40));
		entityManager.addEntity(new CityTent(handler, 16*12, 16*20));
		
		entityManager.addEntity(new Drum(handler, 16*18, 16*40));
		entityManager.addEntity(new Drum(handler, 16*18+140, 16*40));
		entityManager.addEntity(new Drum(handler, 16*18+150, 16*40+40));
		entityManager.addEntity(new CityTent(handler, 16*18, 16*40));
		
		entityManager.addEntity(new CityTent1(handler, 260, 16*26));
		entityManager.addEntity(new CityTent1(handler, 360,16*46));
		entityManager.addEntity(new Mattress1(handler, 16*13, 16*28+50));
		entityManager.addEntity(new Coop(handler, 16*33, 0));
		entityManager.addEntity(new Coop2(handler, 16*33+215, 0));
		entityManager.addEntity(new Cart(handler, 16*37, 16*10));
		entityManager.addEntity(new Drum(handler, 16*37+302, 16*8));
		entityManager.addEntity(new Table(handler,16*26 , 16*5));
		entityManager.addEntity(new Shop(handler, 16*48, 16*20));
		entityManager.addEntity(new Table2(handler, 16*34, 16*18));
		entityManager.addEntity(new DecorFloor(handler, 16*34, 16*50));
		entityManager.addEntity(new DecorFloor2(handler, 16*34+190, 16*50+100));
		entityManager.addEntity(new House(handler, 16*2, 16*46));
		
		
		entityManager.addEntity(new FallTree2(handler, 0, 16*6));
		entityManager.addEntity(new FallTree2(handler, 190, 16*6));
		
		//entityManager.addEntity(new CityBush(handler, 16*50, 16*46));
		
		entityManager.addEntity(new FallTree3(handler, 16*53, 16*33));
		//entityManager.addEntity(new Bush3(handler, 16*43, 16*38));
		entityManager.addEntity(new Bush3(handler, 16*17, 16*1));
		entityManager.addEntity(new CityBush(handler, 16*22, 16*1));
		
		entityManager.addEntity(new Decor3(handler, 16*46, 16*44));
		entityManager.addEntity(new Balloon(handler, 16*48-30, 16*20-80));
		entityManager.addEntity(new Balloon(handler, 16*48-30+70, 16*20-80));
		
		
		
		
		loadWorld(path);
		
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		
	}
	
	public void tick()
	{
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		
		xStart=(int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		xEnd=(int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth()) /Tile.TILEWIDTH+1);
		yStart=(int) Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		yEnd=(int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGHT+1);
		
		
		for(int i=yStart;i<yEnd;i++)
			{for(int j=xStart;j<xEnd;j++)
			{
				getTile(j,i).render(g, (int)(j*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()), 
						(int)(i*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));

			}
		
		
	}entityManager.render(g);
	}
	
	public Tile getTile(int p,int q)
	{
		if(p<0 || q<0 || p>=width || q>=height )
			return Tile.grassTile;
		
			Tile t=Tile.tiles [ worldTiles [p] [q] ] ;
		if(t==null)
			return Tile.grassTile;
		else return t;
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void loadWorld(String path)
	{
		String file=Utils.loadStringtoformWorld(path);
		String[]tokens=file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		
		worldTiles=new int [width][height];
		for(int i=0;i<height;i++)
			{for(int j=0;j<width;j++)
			{
				worldTiles[j][i]=Utils.parseInt(tokens[(j+i*width)+4]);
			}
		
	}
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

}

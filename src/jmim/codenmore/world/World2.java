package jmim.codenmore.world;

import java.awt.Graphics;

import jmim.codenmore.entity.EntityManager;
import jmim.codenmore.entity.Player;
import jmim.codenmore.entity.statics.Banner;
import jmim.codenmore.entity.statics.Bomb;
import jmim.codenmore.entity.statics.Bush;
import jmim.codenmore.entity.statics.Door;
import jmim.codenmore.entity.statics.Door2;
import jmim.codenmore.entity.statics.Fence;
import jmim.codenmore.entity.statics.Flag;
import jmim.codenmore.entity.statics.Fountain;
import jmim.codenmore.entity.statics.Pond;
import jmim.codenmore.entity.statics.Post;
import jmim.codenmore.entity.statics.Post1;
import jmim.codenmore.entity.statics.Statue;
import jmim.codenmore.entity.statics.Tent;
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

public class World2 {
	
	int width,height;
	private int[][] worldTiles;
	int spawnX,spawnY;
	private int xStart=0;
	private int xEnd=0;
	private int yStart=0;
	private int yEnd=0;
	private Handler handler;
	private EntityManager entityManager;
	
	public World2(Handler handler,String path)
	{
		this.handler=handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		//entityManager.addEntity(new Bush(handler, 48, 16*18));
		/*entityManager.addEntity(new Bush(handler, 16*54, 16*58));
		entityManager.addEntity(new Bush(handler, 16*45, 16*62));
		
		entityManager.addEntity(new Water(handler, 420, 134));
		entityManager.addEntity(new Water(handler, 470, 134));
		entityManager.addEntity(new Water(handler, 420, 184));
		entityManager.addEntity(new Water(handler, 470, 184));
		
		entityManager.addEntity(new Water(handler, 420, 234));
		entityManager.addEntity(new Water(handler, 470, 234));
		entityManager.addEntity(new WaterNarrow(handler, 520, 134));
		entityManager.addEntity(new WaterNarrow(handler, 520, 184));
		
		
		entityManager.addEntity(new WaterNarrow(handler, 520, 234));
		//entityManager.addEntity(new Water(handler, 351, 150));
		/*entityManager.addEntity(new Water(handler, 367, 150));
		entityManager.addEntity(new WaterNarrow(handler, 383, 150));
		
		entityManager.addEntity(new Water(handler, 335, 166));
		entityManager.addEntity(new Water(handler, 351, 166));
		entityManager.addEntity(new Water(handler, 367, 166));
		entityManager.addEntity(new WaterNarrow(handler, 383, 166));
		
		entityManager.addEntity(new Water(handler, 335, 182));
		entityManager.addEntity(new Water(handler, 351, 182));
		entityManager.addEntity(new Water(handler, 367, 182));
		entityManager.addEntity(new WaterNarrow(handler, 383, 182));*/
		
		/*entityManager.addEntity(new Bush(handler, 16*34, 16*38));
		entityManager.addEntity(new Bush(handler, 16*47, 16*35));
		
		entityManager.addEntity(new Post1(handler, 16*58, 192));
		entityManager.addEntity(new Post1(handler, 16*52, 115));
		
		entityManager.addEntity(new Fence(handler, 500, 270));
		entityManager.addEntity(new Fence(handler, 392, 270));
		entityManager.addEntity(new Fence(handler, 448, 270));
		
		entityManager.addEntity(new Fence(handler, 0, 16*33));
		entityManager.addEntity(new Fence(handler, 50, 16*33));
		entityManager.addEntity(new Fence(handler, 50*2, 16*33));
		entityManager.addEntity(new Fence(handler, 50*3, 16*33));
		entityManager.addEntity(new Fence(handler, 50*4, 16*33));
		entityManager.addEntity(new Fence(handler, 50*5, 16*33));
		entityManager.addEntity(new Fence(handler, 50*6, 16*33));
		entityManager.addEntity(new Fence(handler, 50*7, 16*33));
		
		entityManager.addEntity(new Post(handler, 50*8, 16*32));
		
		entityManager.addEntity(new Fence(handler, 50*11, 16*33));
		entityManager.addEntity(new Fence(handler, 50*12, 16*33));
		entityManager.addEntity(new Fence(handler, 50*13, 16*33));
		entityManager.addEntity(new Fence(handler, 50*14, 16*33));
		entityManager.addEntity(new Fence(handler, 50*15, 16*33));
		entityManager.addEntity(new Fence(handler, 50*15, 16*33));
		entityManager.addEntity(new Fence(handler, 50*17, 16*33));
		entityManager.addEntity(new Fence(handler, 50*18, 16*33));
		entityManager.addEntity(new Fence(handler, 50*19, 16*33));
		
		
		entityManager.addEntity(new Bush(handler, 16*43, 16*38));
		entityManager.addEntity(new Bush(handler, 16*52, 16*44));
		entityManager.addEntity(new Bush(handler, 16*14, 16*50));
		entityManager.addEntity(new Bush(handler, 16*44, 16*50));
		entityManager.addEntity(new Bush(handler, 16*55, 16*40));
		entityManager.addEntity(new Bush(handler, 16*57, 16*55));
		entityManager.addEntity(new Bush(handler, 16*23, 16*55));
		
		
		entityManager.addEntity(new Tent(handler, 16*27, 16*42));
		entityManager.addEntity(new Tent(handler, 16*22, 16*47));
		entityManager.addEntity(new Tent(handler, 16*33, 16*45));
		
		entityManager.addEntity(new Flag(handler, 16*32, 16*42));
		
		entityManager.addEntity(new Tree1(handler, 16*1, 16*34));
		entityManager.addEntity(new Tree1(handler, 16*7, 16*34));
		entityManager.addEntity(new Tree1(handler, 16*13, 16*34));
		entityManager.addEntity(new Tree1(handler, 16*10, 16*46));
		entityManager.addEntity(new Tree1(handler, 16*2, 16*40));
		entityManager.addEntity(new Tree1(handler, 16*5, 16*50));
		entityManager.addEntity(new Tree1(handler, 16*45, 16*40));
		entityManager.addEntity(new Tree1(handler, 16*55, 16*40));
		entityManager.addEntity(new Tree1(handler, 16*49, 16*43));
		//entityManager.addEntity(new Tree1(handler, 16*33, 16*48));
		entityManager.addEntity(new Tree1(handler, 16*37, 16*51));
		
		entityManager.addEntity(new Tree2(handler, 16*10, 16*55));
		entityManager.addEntity(new Tree2(handler, 16*8, 16*38));
		entityManager.addEntity(new Tree2(handler, 16*17, 16*55));*/
		entityManager.addEntity(new Pond(handler, 16*27, 16*32));
		entityManager.addEntity(new Torch(handler, 16*3, 16*6));
		entityManager.addEntity(new Torch(handler, 16*15, 16*1));
		entityManager.addEntity(new Torch(handler, 16*10, 16*1));
		entityManager.addEntity(new Torch(handler, 16*20, 16*1));
		entityManager.addEntity(new Torch(handler, 16*25, 16*1));
		entityManager.addEntity(new Torch(handler, 16*30, 16*1));
		entityManager.addEntity(new Torch(handler, 16*35, 16*1));
		
		entityManager.addEntity(new Banner(handler, 650, 16*5));
		entityManager.addEntity(new Banner(handler, 650, 16*10));
		entityManager.addEntity(new Banner(handler, 650, 16*15));
		entityManager.addEntity(new Banner(handler, 650, 16*28));
		entityManager.addEntity(new Banner(handler, 650, 16*33));
		entityManager.addEntity(new Banner(handler, 650, 16*38));
		entityManager.addEntity(new Banner(handler, 650, 16*43));
		entityManager.addEntity(new Banner(handler, 650, 16*48));
		entityManager.addEntity(new Banner(handler, 650, 16*53));
		entityManager.addEntity(new Banner(handler, 650, 16*58));
		
		entityManager.addEntity(new Fountain(handler, 16*19, 16*18));
		entityManager.addEntity(new Fountain(handler, 16*24, 16*18));
		entityManager.addEntity(new Fountain(handler, 16*29, 16*18));
		entityManager.addEntity(new Fountain(handler, 16*34, 16*18));
		
		
		
		entityManager.addEntity(new Statue(handler, 16*8, 16*16));
		entityManager.addEntity(new Door2(handler, 650, 16*21));
		entityManager.addEntity(new Door(handler, 200, 0));
		
		entityManager.addEntity(new Bomb(handler, 200, 250));
		
		
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

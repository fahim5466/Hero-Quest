package jmim.codenmore.world;

import java.awt.Graphics;

import jmim.codenmore.entity.EntityManager;
import jmim.codenmore.entity.Player;
import jmim.codenmore.entity.statics.Barn;
import jmim.codenmore.entity.statics.Bush;
import jmim.codenmore.entity.statics.Bush2;
import jmim.codenmore.entity.statics.Bush3;
import jmim.codenmore.entity.statics.FallTree;
import jmim.codenmore.entity.statics.FallTree2;
import jmim.codenmore.entity.statics.FallTree3;
import jmim.codenmore.entity.statics.FallTree4;
import jmim.codenmore.entity.statics.Fence;
import jmim.codenmore.entity.statics.Fence2;
import jmim.codenmore.entity.statics.FenceGate;
import jmim.codenmore.entity.statics.Flag;
import jmim.codenmore.entity.statics.Flower;
import jmim.codenmore.entity.statics.Forest;
import jmim.codenmore.entity.statics.Pond2;
import jmim.codenmore.entity.statics.PondTile1;
import jmim.codenmore.entity.statics.Post;
import jmim.codenmore.entity.statics.Post1;
import jmim.codenmore.entity.statics.Post2;
import jmim.codenmore.entity.statics.Stable;
import jmim.codenmore.entity.statics.Tent;
import jmim.codenmore.entity.statics.Tree1;
import jmim.codenmore.entity.statics.Tree2;
import jmim.codenmore.entity.statics.TreeCluster;
import jmim.codenmore.entity.statics.TreeDown10;
import jmim.codenmore.entity.statics.TreeDown11;
import jmim.codenmore.entity.statics.TreeDown12;
import jmim.codenmore.entity.statics.TreeDown13;
import jmim.codenmore.entity.statics.TreeDown14;
import jmim.codenmore.entity.statics.TreeDown15;
import jmim.codenmore.entity.statics.TreeDown16;
import jmim.codenmore.entity.statics.TreeDown9;
import jmim.codenmore.entity.statics.TreeMiddle;
import jmim.codenmore.entity.statics.Water;
import jmim.codenmore.entity.statics.WaterNarrow;
import jmim.codenmore.entity.statics.WeirdGrass;
import jmim.codenmore.entity.statics.Well;
import jmim.codenmore.game.GameMain;
import jmim.codenmore.game.Handler;
import jmim.codenmore.tile.Tile;
import jmim.codenmore.utils.Utils;

public class World3 {
	
	int width,height;
	private int[][] worldTiles;
	int spawnX,spawnY;
	private int xStart=0;
	private int xEnd=0;
	private int yStart=0;
	private int yEnd=0;
	private Handler handler;
	private EntityManager entityManager;
	
	public World3(Handler handler,String path)
	{
		this.handler=handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new FallTree2(handler, 16*2, 16*4));
		entityManager.addEntity(new FallTree(handler, 16*0, 16*10));
		entityManager.addEntity(new FallTree(handler, 16*0, 16*24));
		
		entityManager.addEntity(new FallTree3(handler, 16*0, 16*15));
		entityManager.addEntity(new FallTree3(handler, 16*2, 16*33));
		entityManager.addEntity(new FallTree2(handler, 16*5, 16*39));
		entityManager.addEntity(new FallTree3(handler, 16*10, 16*41));
		
		/*entityManager.addEntity(new Water(handler, 420, 234));
		entityManager.addEntity(new Water(handler, 470, 234));
		entityManager.addEntity(new WaterNarrow(handler, 520, 134));
		entityManager.addEntity(new WaterNarrow(handler, 520, 184));
		
		
		/*entityManager.addEntity(new WaterNarrow(handler, 520, 234));
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
		entityManager.addEntity(new Bush(handler, 16*47, 16*35));*/
		
		entityManager.addEntity(new Post1(handler, 16*21, 16*12));
		entityManager.addEntity(new Post2(handler, 350, 16*1));
		/*entityManager.addEntity(new Fence(handler, 500, 270));
		entityManager.addEntity(new Fence(handler, 392, 270));*/
		entityManager.addEntity(new Barn(handler, 16*25, 16*11));
		
		entityManager.addEntity(new Fence2(handler, 16*0, 16*49));
		entityManager.addEntity(new Fence2(handler, 60, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*2, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*3, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*4, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*5, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*6, 16*49));
		
		entityManager.addEntity(new Bush3(handler, 60*13, 16*48));
		entityManager.addEntity(new Bush3(handler, 60*14, 16*48));
		
		entityManager.addEntity(new Fence2(handler, 60*11, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*12, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*13, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*14, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*15, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*16, 16*49));
		entityManager.addEntity(new Fence2(handler, 60*17, 16*49));
		
		entityManager.addEntity(new Stable(handler, 16*6, 16*22));
		
		entityManager.addEntity(new Fence2(handler, 16*13, 16*9));
		entityManager.addEntity(new Fence2(handler, 16*13+60, 16*9));
		
		entityManager.addEntity(new Fence2(handler, 16*22, 16*7));
		entityManager.addEntity(new Fence2(handler, 16*22+60, 16*7));
		entityManager.addEntity(new Fence2(handler, 16*22+(60*2), 16*7));
		entityManager.addEntity(new Fence2(handler, 16*22+(60*3), 16*7));
		
		
		
		entityManager.addEntity(new Fence2(handler, 290, 16*1));
		entityManager.addEntity(new Fence2(handler, 230, 16*1));
		entityManager.addEntity(new Fence2(handler, 170, 16*1));
		
		
		
		
		entityManager.addEntity(new FallTree4(handler, 16*16, 16*41));
		entityManager.addEntity(new Bush3(handler, 16*23, 16*5));
		entityManager.addEntity(new Bush3(handler, 16*23+55, 16*5));
		entityManager.addEntity(new FallTree4(handler, 16*25, 16*43));
		entityManager.addEntity(new FallTree3(handler, 16*38, 16*25));
		entityManager.addEntity(new FallTree4(handler, 16*1, 16*41));
		entityManager.addEntity(new Flower(handler, 16*25, 16*36));
		entityManager.addEntity(new Flower(handler, 16*25+30+5, 16*36));
		entityManager.addEntity(new Flower(handler, 16*25+60+10, 16*36));
		
		entityManager.addEntity(new Pond2(handler, 16*47, 16*23));
		entityManager.addEntity(new Well(handler, 16*41, 16*37));
		
		
		entityManager.addEntity(new Flower(handler, 16*25, 16*38));
		entityManager.addEntity(new Flower(handler, 16*25+30+5, 16*38));
		entityManager.addEntity(new Flower(handler, 16*25+60+10, 16*38));
		
		entityManager.addEntity(new Flower(handler, 16*25, 16*40));
		
		entityManager.addEntity(new Flower(handler, 16*25+30+5, 16*40));
		entityManager.addEntity(new Flower(handler, 16*25+60+10, 16*40));
		
		
		entityManager.addEntity(new TreeMiddle(handler, 800, 16*7));
		entityManager.addEntity(new TreeMiddle(handler, 650, 16*7));
		
		entityManager.addEntity(new TreeDown11(handler, 600, 86));
		entityManager.addEntity(new TreeDown10(handler, 650, 16*6));
		entityManager.addEntity(new TreeDown10(handler, 700, 16*6));
		entityManager.addEntity(new TreeDown11(handler, 750, 16*6));
		entityManager.addEntity(new TreeDown12(handler, 800, 16*6));
		entityManager.addEntity(new TreeDown13(handler, 850, 16*6));
		entityManager.addEntity(new TreeDown12(handler, 900, 16*6));
		entityManager.addEntity(new TreeDown13(handler, 950, 16*6));
		
		entityManager.addEntity(new TreeDown15(handler, 550, 1));
		entityManager.addEntity(new TreeDown15(handler, 500, 1));
		
		entityManager.addEntity(new TreeDown13(handler, 450, 1));
		entityManager.addEntity(new TreeDown13(handler, 500, 16));
		entityManager.addEntity(new TreeDown13(handler, 530, 27));
		entityManager.addEntity(new TreeDown13(handler, 570, 40));
		entityManager.addEntity(new TreeDown13(handler, 520, 50));
		entityManager.addEntity(new TreeDown13(handler, 590, 80));
		
		
		
		entityManager.addEntity(new TreeDown15(handler, 600, 16*2));
		entityManager.addEntity(new TreeDown15(handler, 700, 16*2));
		entityManager.addEntity(new TreeDown15(handler, 800, 16*2));
		entityManager.addEntity(new TreeDown15(handler, 900, 16*2));
		
		entityManager.addEntity(new TreeDown15(handler, 650, 16*1));
		entityManager.addEntity(new TreeDown15(handler, 800, 16*1));
		
		entityManager.addEntity(new Fence2(handler, 16*37, 16*9));
		entityManager.addEntity(new Fence2(handler, 16*37+60, 16*9));
		entityManager.addEntity(new Fence2(handler, 16*37+200, 16*9));
		entityManager.addEntity(new Fence2(handler, 16*37+260, 16*9));
		entityManager.addEntity(new Fence2(handler, 16*37+320, 16*9));
		
		
		
		
		//entityManager.addEntity(new FenceGate(handler, 16*37+120, 16*9));
		/*entityManager.addEntity(new Forest(handler, 0, 170)) ;
		entityManager.addEntity(new Forest(handler, 0, 0));*/
		
		
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

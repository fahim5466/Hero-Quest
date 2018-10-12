package dev.fahim.tileGame.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.fahim.tileGame.gfx.Assets;

public class Tile {
	public static final int w = 50;
	public static final int h = 50;
	protected final int id;
	private BufferedImage texture;
	public static Tile[] tiles=new Tile[10000];
	public static Tile stoneTile = new StoneTile(Assets.stone,1);
	public static Tile dirtTile = new DirtTile(Assets.dirt,0);
	
	public static void init()
	{
		
		for(int i=0;i<11;i++)
		{
			for(int j=0;j<8;j++)
			{
				new Tile(Assets.greens[i*8+j],i*8+j+1004);
			}
		}
		
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<13;j++)
			{
				new Tile(Assets.greens2[i*13+j],i*13+j+1092);
			}
		}
		
		
		
	}
	
	public Tile(BufferedImage texture,int id)
	{
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
	}

	public int getId() {
		return id;
	}
	
	public void tick()
	{
		
	}
	
	public void render(Graphics g,int x,int y)
	{
		g.drawImage(texture,x,y,w,h,null);

	}
	
	public boolean isSolid()
	{
		return false;
	}

}

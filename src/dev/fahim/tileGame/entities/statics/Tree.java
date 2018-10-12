package dev.fahim.tileGame.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.tile.Tile;

public class Tree extends StaticEntity{
	
	public Tree(Handler handler, double x, double y) {
		super(handler, x, y, Tile.w*3, Tile.h*6);
		bounds.x = Tile.w;
		bounds.y = Tile.w*5;
		bounds.width = Tile.w;
		bounds.height = Tile.h;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
	
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), w, h, null);
		/*
		g.setColor(Color.red);
		g.fillRect(
				  	(int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				  	(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				  	bounds.width,bounds.height
				  );
		*/
	}

}

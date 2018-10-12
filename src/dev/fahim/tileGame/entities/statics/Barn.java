package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.tile.Tile;
import jmim.codenmore.game.grpx.Assets;


public class Barn extends StaticEntity {

	public Barn(Handler handler, float x, float y) {
		super(handler, x, y, Tile.w*6, Tile.h*6);
		
		bounds.x = 0;
		bounds.y = Tile.w*3;
		bounds.width = Tile.w*6;
		bounds.height = Tile.h*3;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.barn, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.tile.Tile;
import jmim.codenmore.game.grpx.Assets;

public class FallTree extends StaticEntity {

	public FallTree(Handler handler, float x, float y) {
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
		g.drawImage(Assets.falltree1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

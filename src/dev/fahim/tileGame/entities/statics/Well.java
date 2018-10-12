package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.tile.Tile;
import jmim.codenmore.game.grpx.Assets;

public class Well extends StaticEntity {

	public Well(Handler handler, float x, float y) {
		super(handler, x, y, Tile.w*2, Tile.h*4);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.w*2;
		bounds.height = Tile.h*4;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.well, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

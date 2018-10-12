package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.tile.Tile;
import jmim.codenmore.game.grpx.Assets;

public class Pond2 extends StaticEntity {

	public Pond2(Handler handler, float x, float y) {
		super(handler, x, y, Tile.w*4, Tile.h*6);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = Tile.w*4;
		bounds.height = Tile.h*6;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.pond2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

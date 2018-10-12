package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.tile.Tile;
import jmim.codenmore.game.grpx.Assets;

public class Stable extends StaticEntity {

	public Stable(Handler handler, float x, float y) {
		super(handler, x, y, Tile.w*4, Tile.h*6);
		
		bounds.x = 0;
		bounds.y = Tile.h*4;
		bounds.width = Tile.w*4;
		bounds.height = Tile.h*2;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.stable, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}
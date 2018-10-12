package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.tile.Tile;
import jmim.codenmore.game.grpx.Assets;

public class Flower extends StaticEntity {

	public Flower(Handler handler, float x, float y) {
		super(handler, x, y, Tile.w, Tile.h*2);
		
		bounds.x = 0;
		bounds.y = Tile.h-20;
		bounds.width = Tile.w;
		bounds.height = Tile.h;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.flower, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

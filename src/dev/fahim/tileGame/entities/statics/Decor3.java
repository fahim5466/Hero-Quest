package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import dev.fahim.tileGame.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class Decor3 extends StaticEntity {

	public Decor3(Handler handler, float x, float y) {
		super(handler, x, y, 100, 100);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 100;
		bounds.height = 100;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.decorFloor3, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

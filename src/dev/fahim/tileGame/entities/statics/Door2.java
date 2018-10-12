package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import dev.fahim.tileGame.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class Door2 extends StaticEntity {

	public Door2(Handler handler, float x, float y) {
		super(handler, x, y, 50, 65);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 0;
		bounds.height = 0;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.door2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

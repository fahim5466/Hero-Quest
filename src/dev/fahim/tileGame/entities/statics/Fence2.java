package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import dev.fahim.tileGame.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class Fence2 extends StaticEntity {

	public Fence2(Handler handler, float x, float y) {
		super(handler, x, y, 70, 70);
		
		bounds.x = 0;
		bounds.y = 25;
		bounds.width = 70;
		bounds.height = 35;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.fence1, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

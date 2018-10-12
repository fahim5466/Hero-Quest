package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import dev.fahim.tileGame.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class Drum extends StaticEntity {

	public Drum(Handler handler, float x, float y) {
		super(handler, x, y, 50, 90);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 50;
		bounds.height = 90;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.drum, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

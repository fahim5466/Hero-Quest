package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import dev.fahim.tileGame.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class Torch extends StaticEntity {

	public Torch(Handler handler, float x, float y) {
		super(handler, x, y, 40, 40);
		
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
		g.drawImage(Assets.torch, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getW(), null);
	}

}

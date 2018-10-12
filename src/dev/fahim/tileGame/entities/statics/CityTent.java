package dev.fahim.tileGame.entities.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import dev.fahim.tileGame.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class CityTent extends StaticEntity {

	public CityTent(Handler handler, float x, float y) {
		super(handler, x, y, 190, 160);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 190;
		bounds.height = 160;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.cityTent, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getW(), getH(), null);
	}

}

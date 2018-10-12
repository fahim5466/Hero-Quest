package jmim.codenmore.entity.statics;

import java.awt.Graphics;

import jmim.codenmore.entity.Entity;
import jmim.codenmore.game.Handler;
import jmim.codenmore.game.grpx.Assets;
import jmim.codenmore.tile.Tile;

public class Post2 extends StaticEntity {

	public Post2(Handler handler, float x, float y) {
		super(handler, x, y, 20, 150);
		
		bound.x = 0;
		bound.y = 0;
		bound.width = 0;
		bound.height = 0;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.post2, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
	}

}

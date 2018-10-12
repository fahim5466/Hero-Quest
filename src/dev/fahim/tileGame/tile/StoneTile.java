package dev.fahim.tileGame.tile;

import java.awt.image.BufferedImage;

public class StoneTile extends Tile {

	public StoneTile(BufferedImage texture, int id) {
		super(texture, id);
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
	
}

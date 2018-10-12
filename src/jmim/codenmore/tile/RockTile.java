package jmim.codenmore.tile;

import java.awt.image.BufferedImage;

import jmim.codenmore.game.grpx.Assets;

public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.rock, id);
		
	}
	
	public boolean isSolid()
	{
		return true;
	}


}

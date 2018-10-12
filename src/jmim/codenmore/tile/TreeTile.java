package jmim.codenmore.tile;

import java.awt.image.BufferedImage;

import jmim.codenmore.game.grpx.Assets;

public class TreeTile extends Tile{

	public TreeTile( int id) {
		super(Assets.tree, id);
		
	}
	
	public boolean isSolid()
	{
		return true;
	}

}

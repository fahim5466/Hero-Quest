package dev.fahim.tileGame.Item;

import java.awt.image.BufferedImage;

import dev.fahim.tileGame.Handler;

public abstract class Item {

	protected BufferedImage texture;
	protected String description;
	
	public Item(BufferedImage texture, String text)
	{
		this.texture = texture;
		this.description = text;
	}
	
	public abstract void use();
	
	public BufferedImage getTexture()
	{
		return texture;
	}
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String s)
	{
		description = s;
	}
	
}

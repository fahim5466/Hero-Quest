package dev.fahim.tileGame.dialogue;

import dev.fahim.tileGame.ui.Clicker;

public class Option {

	private String text;
	private Clicker clicker;
	
	public Option(String text, Clicker clicker)
	{
		this.text = text;
		this.clicker = clicker;
	}
	
	public void execute()
	{
		clicker.leftClick();
	}
	
	
	public String getText()
	{
		return text;
	}
	
}

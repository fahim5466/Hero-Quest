package dev.fahim.tileGame.dialogue;

import java.util.ArrayList;

public class Dialogue {
	
	private String text;
	private ArrayList<Option> options = new ArrayList<Option>();
	
	public Dialogue(String text)
	{
		this.text = text;
	}
	
	public void addOption(Option o)
	{
		options.add(o);
	}

	public String getText() {
		return text;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}
	
}

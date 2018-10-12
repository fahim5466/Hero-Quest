package dev.fahim.tileGame.quest;

import dev.fahim.tileGame.Handler;

public class Phase{

	private Handler handler;
	
	private Checker checker;
	private String description;

	private Quest q;
	
	public Phase(Handler handler, Checker c, String description, Quest q)
	{
		this.handler = handler;
		this.checker = c;
		this.description = description;
		this.q = q;
	}
	
	public void tick()
	{
		checker.check(handler, q);
	}
	
	public String getDesc()
	{
		return description;
	}
	
}

package dev.fahim.tileGame.quest;

import java.util.ArrayList;

import dev.fahim.tileGame.Handler;

public class Quest {

	private Handler handler;
	
	private String title;
	private String description;
	private ArrayList<Phase> phases;
	private int currentPhase=0;
	private boolean completed=false;
	
	public Quest( Handler handler, String title, String description)
	{
		this.handler = handler;
		this.title = title;
		this.description = description;
		phases = new ArrayList<Phase>();
	}
	
	public void tick()
	{
		if(phases.isEmpty()){return;}
		phases.get(currentPhase).tick();
	}
	
	public void addPhase(Phase p)
	{
		phases.add(p);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Phase> getPhases() {
		return phases;
	}

	public void setPhases(ArrayList<Phase> phases) {
		this.phases = phases;
	}

	public Phase getCurrentPhase() {
		return phases.get(currentPhase);
	}

	public void setCurrentPhase(int currentPhase) {
		this.currentPhase = currentPhase;
	}
	
	public void complete()
	{
		completed=true;
	}
	
	public boolean isComplete()
	{
		return completed;
	}
	
}

package dev.fahim.tileGame.quest;

import java.util.ArrayList;

import dev.fahim.tileGame.Handler;

public class QuestManager {

	private Handler handler;
	private QuestBank questBank;
	private ArrayList<Quest> quests;
	private ArrayList<Quest> delete;
	
	public QuestManager(Handler handler)
	{
		this.handler = handler;
		
		quests = new ArrayList<Quest>();
		delete = new ArrayList<Quest>();
		
		questBank = new QuestBank(handler, this);
	}
	
	public void tick()
	{
		
		for(Quest q : quests)
		{
			if(q.isComplete()){delete.add(q);}
		}
		
		for(Quest q : delete)
		{
			quests.remove(q);
		}
		
		delete.clear();
		
		for(Quest q : quests)
		{
			q.tick();
		}
	}
	
	public void addQuest(Quest q)
	{
		quests.add(q);
	}
	
	public void removeQuest(Quest q)
	{
		quests.remove(q);
	}
	
	public ArrayList<Quest> getQuests()
	{
		return quests;
	}
	
}

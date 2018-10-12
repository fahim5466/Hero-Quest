package dev.fahim.tileGame.quest;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.states.Notif;
import dev.fahim.tileGame.states.Quests;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.worlds.WorldManager;

public class QuestBank {

	private Handler handler;
	
	public Quest a_simple_mission;
	
	public QuestBank(Handler handler)
	{
		this.handler = handler;
	}
	
	public void init()
	{
		
		a_simple_mission = new Quest(handler, "A Simple Mission",
				"Some bandits have made camp near the old farm raiding caravans and passers-by."
				+ "The king has ordered you to bring the king's justice to the fiends!"
				);
		
		
		a_simple_mission.addPhase(
				new Phase(handler,
						new Checker()
						{
							public void check(Handler handler, Quest q)
							{
								WorldManager w=handler.getGame().getWorldManager();
								if(w.orc1_1.isDead() && w.orc1_2.isDead() && w.orc2_1.isDead() && w.orc2_2.isDead()
									&& w.orc3_1.isDead() && w.orc3_2.isDead()	)
								{
									q.complete();
									StateManager.setCurrentState(new Notif(handler,
											new Clicker(){

											@Override
											public void leftClick() {
												StateManager.setCurrentState(handler.getGame().gameState);
											
											}
											}
											,"A simple mission completed!!"));
								}
							}
						},
						"Kill the Orcs in the forest and near the farm", a_simple_mission
						)
				);
		
		Quests q=(Quests)handler.getGame().quests;
		q.getQuestManager().addQuest(a_simple_mission);
	}
	
}

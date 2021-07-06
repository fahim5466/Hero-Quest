package dev.fahim.tileGame.quest;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.states.Notif;
import dev.fahim.tileGame.states.Quests;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.worlds.WorldManager;

public class QuestBank {

	private Handler handler;
	private QuestManager questManager;

	public Quest a_simple_mission;

	public QuestBank(Handler handler, QuestManager questManager) {
		this.handler = handler;
		this.questManager = questManager;
		init();
	}

	private void init() {

		a_simple_mission = new Quest(handler, "A Simple Mission",
				"Some bandits have made camp in the old forest raiding caravans and passers-by."
						+ "The king has ordered you to bring the king's justice to the fiends!");

		a_simple_mission.addPhase(new Phase(handler, new Checker() {
			public void check(Handler handler, Quest q) {
				WorldManager w = handler.getGame().getWorldManager();
				if (w.orc1_1.isDead() && w.orc1_2.isDead()) {
					q.complete();
					StateManager.setCurrentState(new Notif(handler, new Clicker() {

						@Override
						public void leftClick() {
							StateManager.setCurrentState(handler.getGame().gameState);

						}
					}, "A simple mission completed!!"));
				}
			}
		}, "Kill the Orcs in the forest", a_simple_mission));

		questManager.addQuest(a_simple_mission);
	}

}

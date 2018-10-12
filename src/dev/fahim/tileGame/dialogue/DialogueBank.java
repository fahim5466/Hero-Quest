package dev.fahim.tileGame.dialogue;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.ui.Clicker;

public class DialogueBank {

	public Handler handler;
	
	public Dialogue d;
	
	public DialogueBank(Handler handler)
	{
		this.handler = handler;
		init();
	}
	
	public void init()
	{
		d = new Dialogue(new String("What's in that bag and why are you hiding it here?"));
		d.addOption(new Option(new String("No! I'm tired of doing what you say."
				+"But this is the only thing that's made the last three years bearable."
				+"You've taken her back? You can't be serious?"),
				new Clicker()
				{

					@Override
					public void leftClick() {
						System.out.println("blah");
					}
			
				}
				));
		d.addOption(new Option(new String("I've forgotten what it's like to feel young."),
				new Clicker()
				{

					@Override
					public void leftClick() {
						
					}
			
				}
				));
		d.addOption(new Option(new String("Do you ever think we should just stop doing this?"),
				new Clicker()
				{

					@Override
					public void leftClick() {
						
					}
			
				}
				));
		
		
		d.addOption(new Option(new String("Farewell"),
				new Clicker()
				{

					@Override
					public void leftClick() {
						StateManager.setCurrentState(handler.getGame().gameState);
					}
			
				}
				));
		
	}
	
}

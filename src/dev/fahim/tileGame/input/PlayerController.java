package dev.fahim.tileGame.input;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.Player;
import dev.fahim.tileGame.states.StateManager;

public class PlayerController extends Controller{

	private Player player;
	private boolean i;
	
	public PlayerController(Handler handler, Player player, KeyManager keyManager, MouseManager mouseManager) {
		super(handler, player, keyManager, mouseManager);
		this.player = player;
	}
	
	public void playertick()
	{
		getInput();
		if(i)
		{
			StateManager.setCurrentState(handler.getGame().inGameUI);
		}
	}
	
	public void getInput()
	{
		up=keyManager.up;
		down=keyManager.down;
		left=keyManager.left;
		right=keyManager.right;
		leftPressed=mouseManager.isLeftPresssed();
		rightPressed=mouseManager.isRightPressed();
		z=keyManager.z;
		x=keyManager.x;
		i=keyManager.i;
	}

}

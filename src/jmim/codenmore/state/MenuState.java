package jmim.codenmore.state;

import java.awt.Color;
import java.awt.Graphics;

import jmim.codenmore.UserInterFace.ImageButton;
import jmim.codenmore.UserInterFace.ImageChangeManager;
import jmim.codenmore.UserInterFace.UserInterface;
import jmim.codenmore.game.Handler;
import jmim.codenmore.game.grpx.Assets;

public class MenuState extends State{
	

	private ImageChangeManager manager1;

	public MenuState(Handler handler) {
		super(handler);
		
		manager1 = new ImageChangeManager(handler);
		handler.getMouseManager().setManager(manager1);

		manager1.addObject(new ImageButton(200, 200, 128, 64, Assets.btn_start, new UserInterface() {

			public void onClick() {
				handler.getMouseManager().setManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}
	

	@Override
	public void tick() {
		manager1.tick();
	}

	@Override
	public void render(Graphics g) {
		manager1.render(g);

}
}

package dev.fahim.tileGame.states;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.ui.Clicker;
import dev.fahim.tileGame.ui.UIImageButton;
import dev.fahim.tileGame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	// Buttons
	UIImageButton play, instructions;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler.getMouseManager());

		UIImageButton play = new UIImageButton(300, 275, 200, 50, uiManager, new String("Play"), Assets.GameButton,
				Assets.GameDarkButton, Assets.GameClickedButton, new Clicker() {

					@Override
					public void leftClick() {
						StateManager.setCurrentState(handler.getGame().gameState);

					}
				});
		
		UIImageButton instruct = new UIImageButton(300, 350, 200, 50, uiManager, new String("Instructions"), Assets.GameButton,
				Assets.GameDarkButton, Assets.GameClickedButton, new Clicker() {

			@Override
			public void leftClick() {
				StateManager.setCurrentState(handler.getGame().instructions);

			}
		});

		uiManager.addUIObject(play);
		uiManager.addUIObject(instruct);

	}

	@Override
	public void tick() {

		uiManager.tick();

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.menuBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		g.drawImage(Assets.title, 150, 100, 500, 100, null);

		uiManager.render(g);

		/*
		 * g.setColor(Color.red); g.fillRect(handler.getMouseManager().getMouseX(),
		 * handler.getMouseManager().getMouseY(), 8, 8);
		 */

	}

}

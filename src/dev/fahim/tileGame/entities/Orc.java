package dev.fahim.tileGame.entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Animation;
import dev.fahim.tileGame.gfx.Animator;
import dev.fahim.tileGame.gfx.Assets;
import dev.fahim.tileGame.states.StateManager;
import dev.fahim.tileGame.utils.Utils;

public class Orc extends Creature {

	public Orc(Handler handler, double x, double y, int w, int h) {
		super(handler, x, y, w, h);

		bounds.x = 118;
		bounds.y = 174;
		bounds.width = 40;
		bounds.height = 20;

		setSpeed(1);

		animDown = new Animation(100, Assets.orc_down);
		animUp = new Animation(100, Assets.orc_up);
		animLeft = new Animation(100, Assets.orc_left);
		animRight = new Animation(100, Assets.orc_right);

		animAttackDown = new Animation(75, Assets.orc_attack_down);
		animAttackUp = new Animation(75, Assets.orc_attack_up);
		animAttackLeft = new Animation(75, Assets.orc_attack_left);
		animAttackRight = new Animation(75, Assets.orc_attack_right);

		animBowDown = new Animation(75, Assets.player_bow_down);
		animBowUp = new Animation(75, Assets.player_bow_up);
		animBowLeft = new Animation(75, Assets.player_bow_left);
		animBowRight = new Animation(75, Assets.player_bow_right);

		animMagicDown = new Animation(100, Assets.player_magic_down);
		animMagicUp = new Animation(100, Assets.player_magic_up);
		animMagicLeft = new Animation(100, Assets.player_magic_left);
		animMagicRight = new Animation(100, Assets.player_magic_right);

		animDie = new Animation(100, Assets.orc_die);

		animator = new Animator(handler, this);

	}

	@Override
	public void tick() {

		xMove = 0;
		yMove = 0;

		controller.tick();

		controller.AItick();

		animator.animate();

	}

	@Override
	public void render(Graphics g) {

		g.drawImage(animator.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), w, h, null);

		/*
		 * g.setColor(Color.green); g.fillRect( (int)(x + w/4 -
		 * handler.getGameCamera().getxOffset()), (int)(y + h/4 -
		 * handler.getGameCamera().getyOffset()), w/2,h/2 );
		 */

		drawHealthBar(g);

	}

}

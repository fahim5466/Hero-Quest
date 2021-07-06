package dev.fahim.tileGame.input;

import java.awt.Color;
import java.awt.Rectangle;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.entities.Arrow;
import dev.fahim.tileGame.entities.Creature;
import dev.fahim.tileGame.entities.Entity;
import dev.fahim.tileGame.entities.Fireball;
import dev.fahim.tileGame.entities.Loot;
import dev.fahim.tileGame.entities.Player;
import dev.fahim.tileGame.utils.Timer;

public class Controller {

	protected Handler handler;
	protected Creature c;
	protected KeyManager keyManager;
	protected MouseManager mouseManager;

	protected boolean up, down, left, right, z, x;
	protected boolean leftPressed, rightPressed;

	protected Timer hurtTimer = new Timer(300);

	public Controller(Handler handler, Creature c, KeyManager keyManager, MouseManager mouseManager) {
		this.handler = handler;
		this.c = c;
		this.keyManager = keyManager;
		this.mouseManager = mouseManager;
	}

	public void tick() {

		updateTimers();

		if (hurtTimer.getCycle() == 1) {
			hurt(false);
		}

		if (c.getHealth() <= 0) {
			handler.getSoundManager().play(handler.getSoundManager().dieClip);
			if (c.getAnimator().getCurrentAnimation() == c.animDie) {
				if (c.animDie.getCycle() == 1) {
					handler.getWorld().getEntityManager().removeEntity(c);
					handler.getWorld().getEntityManager().addEntity(
							new Loot(handler, c.getX() + c.getBounds().x - 32, c.getY() + c.getBounds().y - 32));
				}
			} else {
				c.getAnimator().die();
			}
		}

		if (c.getAnimator().isFixed()) {
			return;
		}

		if (isLeftPressed()) {

			calculateHit(20);

		}

		if (isX()) {
			if (c.getMana() <= 0) {
				setX(false);
			} else {
				c.setMana(c.getMana() - 20);
			}
		}

		tryMove();

		c.move();

	}

	public void shootArrow()
	{
		handler.getSoundManager().play(handler.getSoundManager().arrowShotClip);
		handler.getWorld().getEntityManager().addEntity(
				new Arrow(handler, c.getCenterX() - 30, c.getCenterY() - 24, 64, 64, c.getFace())
				);
	}
	
	public void shootFireball()
	{
		handler.getSoundManager().play(handler.getSoundManager().fireballClip);
		handler.getWorld().getEntityManager().addEntity(
				new Fireball(handler, c.getCenterX() - 30, c.getCenterY() - 24, 64, 64, c.getFace())
				);		
	}

	public void hurt(boolean status) {
		hurtTimer.reset();
		hurtTimer.setActive(status);
		c.getAnimator().setDye(status);
		c.getAnimator().setDyeColor(new Color(255, 0, 0, 128));
	}

	public void updateTimers() {

		if (hurtTimer.isActive()) {
			hurtTimer.tick();
		}

	}

	public void calculateHit(int damage) {

		Rectangle r;

		if (c.getFace() == 1) {

			c.setHitH(c.getBounds().height * 3);
			c.setHitW(c.getBounds().width);

			r = new Rectangle((int) (c.getX() + c.getBounds().x), (int) (c.getY() + c.getBounds().y - c.getHitH()),
					c.getHitW(), c.getHitH());
		} else if (c.getFace() == 2) {

			c.setHitH(c.getBounds().height);
			c.setHitW(c.getBounds().width * 2);

			r = new Rectangle((int) (c.getX() + c.getBounds().x + c.getBounds().width),
					(int) (c.getY() + c.getBounds().y), c.getHitW(), c.getHitH());
		} else if (c.getFace() == 3) {

			c.setHitH(c.getBounds().height * 3);
			c.setHitW(c.getBounds().width);

			r = new Rectangle((int) (c.getX() + c.getBounds().x),
					(int) (c.getY() + c.getBounds().y + c.getBounds().height), c.getHitW(), c.getHitH());
		} else {
			c.setHitH(c.getBounds().height);
			c.setHitW(c.getBounds().width * 2);

			r = new Rectangle((int) (c.getX() + c.getBounds().x - c.getHitW()), (int) (c.getY() + c.getBounds().y),
					c.getHitW(), c.getHitH());
		}

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (!(e instanceof Creature)) {
				continue;
			}

			if (r.intersects(e.getCollisionBounds(0, 0))) {
				Creature t = (Creature) e;
				t.setHealth(t.getHealth() - damage);
				t.getController().hurt(true);
				handler.getSoundManager().play(handler.getSoundManager().swordHitClip);
				// System.out.println("Hit!");
			}
		}

	}

	public int canHit(Creature t) {

		Rectangle r;

		r = new Rectangle((int) (c.getX() + c.getBounds().x),
				(int) (c.getY() + c.getBounds().y - c.getBounds().height * 3), c.getBounds().width,
				c.getBounds().height * 3);

		if (r.intersects(t.getCollisionBounds(0, 0))) {
			return 1;
		}

		r = new Rectangle((int) (c.getX() + c.getBounds().x + c.getBounds().width), (int) (c.getY() + c.getBounds().y),
				c.getBounds().width * 2, c.getBounds().height);

		if (r.intersects(t.getCollisionBounds(0, 0))) {
			return 2;
		}

		r = new Rectangle((int) (c.getX() + c.getBounds().x), (int) (c.getY() + c.getBounds().y + c.getBounds().height),
				c.getBounds().width, c.getBounds().height * 3);

		if (r.intersects(t.getCollisionBounds(0, 0))) {
			return 3;
		}

		r = new Rectangle((int) (c.getX() + c.getBounds().x - c.getBounds().width * 2),
				(int) (c.getY() + c.getBounds().y), c.getBounds().width * 2, c.getBounds().height);

		if (r.intersects(t.getCollisionBounds(0, 0))) {
			return 4;
		}

		return 0;

	}

	public void tryMove() {

		if (isUp()) {
			c.setyMove(-c.getSpeed());
		} else if (isDown()) {
			c.setyMove(c.getSpeed());
		}

		if (isLeft()) {
			c.setxMove(-c.getSpeed());
		} else if (isRight()) {
			c.setxMove(c.getSpeed());
		}

	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isZ() {
		return z;
	}

	public void setZ(boolean z) {
		this.z = z;
	}

	public boolean isX() {
		return x;
	}

	public void setX(boolean x) {
		this.x = x;
	}

	public boolean isLeftPressed() {
		return leftPressed;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public Player getPlayer() {
		return handler.getWorld().getEntityManager().getPlayer();
	}

}

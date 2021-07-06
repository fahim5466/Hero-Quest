package dev.fahim.tileGame.gfx;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import dev.fahim.tileGame.Item.Food;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.utils.Utils;

public class Assets {

	// menu assets
	public static BufferedImage GameButton, GameDarkButton, GameClickedButton;
	public static BufferedImage whiteBG, menuBG, title;

	// game assets
	public static BufferedImage dirt;
	public static BufferedImage grass;
	public static BufferedImage stone;
	public static BufferedImage tree;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] orc_down, orc_up, orc_left, orc_right;
	public static BufferedImage[] player_attack_down, player_attack_up, player_attack_left, player_attack_right;
	public static BufferedImage[] orc_attack_down, orc_attack_up, orc_attack_left, orc_attack_right;
	public static BufferedImage[] player_magic_down, player_magic_up, player_magic_left, player_magic_right;
	public static BufferedImage[] player_die;
	public static BufferedImage[] orc_die;
	public static BufferedImage arrow, fireball;
	public static BufferedImage[] player_bow_down, player_bow_up, player_bow_left, player_bow_right;
	public static Font baseFont;
	public static BufferedImage[] greens, greens2;
	public static BufferedImage lootBag;
	public static BufferedImage slot, hoveringSlot, selectedSlot;
	public static BufferedImage[][] foods;
	public static BufferedImage box, selectedBox, bar;
	public static BufferedImage lpointer, rpointer, upointer, dpointer;
	
	//items
	public static Food food;

	// Cursors
	public static Cursor cursors[];

	public static void load(Handler handler) {
		GameButton = ImageLoader.loadImage("/Textures/button.png");
		GameDarkButton = ImageLoader.loadImage("/Textures/buttonDark.png");
		GameClickedButton = ImageLoader.loadImage("/Textures/buttonDark.png");

		whiteBG = ImageLoader.loadImage("/UI/whiteBG.png");
		menuBG = ImageLoader.loadImage("/UI/menuBG.png");
		title = ImageLoader.loadImage("/UI/title.png");

		BufferedImage tileSheet = ImageLoader.loadImage("/Textures/tileSheet.png");

		SpriteSheet playerDown = new SpriteSheet(ImageLoader.loadImage("/Textures/playerWalkDown.png"), 128, 128);
		SpriteSheet playerUp = new SpriteSheet(ImageLoader.loadImage("/Textures/playerWalkUp.png"), 128, 128);
		SpriteSheet playerLeft = new SpriteSheet(ImageLoader.loadImage("/Textures/playerWalkLeft.png"), 128, 128);
		SpriteSheet playerRight = new SpriteSheet(ImageLoader.loadImage("/Textures/playerWalkRight.png"), 128, 128);

		SpriteSheet orcDown = new SpriteSheet(ImageLoader.loadImage("/Textures/orcDown.png"), 128, 128);
		SpriteSheet orcUp = new SpriteSheet(ImageLoader.loadImage("/Textures/orcUp.png"), 128, 128);
		SpriteSheet orcLeft = new SpriteSheet(ImageLoader.loadImage("/Textures/orcLeft.png"), 128, 128);
		SpriteSheet orcRight = new SpriteSheet(ImageLoader.loadImage("/Textures/orcRight.png"), 128, 128);

		SpriteSheet playerBowDown = new SpriteSheet(ImageLoader.loadImage("/Textures/playerBowDown.png"), 128, 128);
		SpriteSheet playerBowUp = new SpriteSheet(ImageLoader.loadImage("/Textures/playerBowUp.png"), 128, 128);
		SpriteSheet playerBowLeft = new SpriteSheet(ImageLoader.loadImage("/Textures/playerBowLeft.png"), 128, 128);
		SpriteSheet playerBowRight = new SpriteSheet(ImageLoader.loadImage("/Textures/playerBowRight.png"), 128, 128);

		SpriteSheet playerMagicDown = new SpriteSheet(ImageLoader.loadImage("/Textures/playerMagicDown.png"), 128, 128);
		SpriteSheet playerMagicUp = new SpriteSheet(ImageLoader.loadImage("/Textures/playerMagicUp.png"), 128, 128);
		SpriteSheet playerMagicLeft = new SpriteSheet(ImageLoader.loadImage("/Textures/playerMagicLeft.png"), 128, 128);
		SpriteSheet playerMagicRight = new SpriteSheet(ImageLoader.loadImage("/Textures/playerMagicRight.png"), 128,
				128);

		SpriteSheet playerAttackDown = new SpriteSheet(ImageLoader.loadImage("/Textures/playerAttackDown.png"), 128,
				128);
		SpriteSheet playerAttackUp = new SpriteSheet(ImageLoader.loadImage("/Textures/playerAttackUp.png"), 128, 128);
		SpriteSheet playerAttackLeft = new SpriteSheet(ImageLoader.loadImage("/Textures/playerAttackLeft.png"), 128,
				128);
		SpriteSheet playerAttackRight = new SpriteSheet(ImageLoader.loadImage("/Textures/playerAttackRight.png"), 128,
				128);

		SpriteSheet orcAttackDown = new SpriteSheet(ImageLoader.loadImage("/Textures/orcAttackDown.png"), 128, 128);
		SpriteSheet orcAttackUp = new SpriteSheet(ImageLoader.loadImage("/Textures/orcAttackUp.png"), 128, 128);
		SpriteSheet orcAttackLeft = new SpriteSheet(ImageLoader.loadImage("/Textures/orcAttackLeft.png"), 128, 128);
		SpriteSheet orcAttackRight = new SpriteSheet(ImageLoader.loadImage("/Textures/orcAttackRight.png"), 128, 128);

		SpriteSheet playerDie = new SpriteSheet(ImageLoader.loadImage("/Textures/playerDie.png"), 128, 128);
		SpriteSheet orcDie = new SpriteSheet(ImageLoader.loadImage("/Textures/orcDie.png"), 128, 128);

		player_down = new BufferedImage[9];
		player_up = new BufferedImage[9];
		player_left = new BufferedImage[9];
		player_right = new BufferedImage[9];

		orc_down = new BufferedImage[9];
		orc_up = new BufferedImage[9];
		orc_left = new BufferedImage[9];
		orc_right = new BufferedImage[9];

		player_bow_down = new BufferedImage[9];
		player_bow_up = new BufferedImage[9];
		player_bow_left = new BufferedImage[9];
		player_bow_right = new BufferedImage[9];

		player_magic_down = new BufferedImage[7];
		player_magic_up = new BufferedImage[7];
		player_magic_left = new BufferedImage[7];
		player_magic_right = new BufferedImage[7];

		player_attack_down = new BufferedImage[6];
		player_attack_up = new BufferedImage[6];
		player_attack_left = new BufferedImage[6];
		player_attack_right = new BufferedImage[6];

		orc_attack_down = new BufferedImage[6];
		orc_attack_up = new BufferedImage[6];
		orc_attack_left = new BufferedImage[6];
		orc_attack_right = new BufferedImage[6];

		player_die = new BufferedImage[6];
		orc_die = new BufferedImage[6];

		for (int j = 1; j <= 3; j++) {
			for (int i = 1; i <= 3; i++) {

				player_up[(i - 1) * 3 + j - 1] = playerUp.crop(j, i);
				player_left[(i - 1) * 3 + j - 1] = playerLeft.crop(j, i);
				player_down[(i - 1) * 3 + j - 1] = playerDown.crop(j, i);
				player_right[(i - 1) * 3 + j - 1] = playerRight.crop(j, i);

				orc_up[(i - 1) * 3 + j - 1] = orcUp.crop(j, i);
				orc_left[(i - 1) * 3 + j - 1] = orcLeft.crop(j, i);
				orc_down[(i - 1) * 3 + j - 1] = orcDown.crop(j, i);
				orc_right[(i - 1) * 3 + j - 1] = orcRight.crop(j, i);

				player_bow_up[(i - 1) * 3 + j - 1] = playerBowUp.crop(j, i);
				player_bow_left[(i - 1) * 3 + j - 1] = playerBowLeft.crop(j, i);
				player_bow_down[(i - 1) * 3 + j - 1] = playerBowDown.crop(j, i);
				player_bow_right[(i - 1) * 3 + j - 1] = playerBowRight.crop(j, i);

				if ((i - 1) * 3 + j - 1 < 7) {
					player_magic_up[(i - 1) * 3 + j - 1] = playerMagicUp.crop(j, i);
					player_magic_left[(i - 1) * 3 + j - 1] = playerMagicLeft.crop(j, i);
					player_magic_down[(i - 1) * 3 + j - 1] = playerMagicDown.crop(j, i);
					player_magic_right[(i - 1) * 3 + j - 1] = playerMagicRight.crop(j, i);
				}

			}
		}

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {

				player_attack_up[(i - 1) * 2 + j - 1] = playerAttackUp.crop(i, j);
				player_attack_left[(i - 1) * 2 + j - 1] = playerAttackLeft.crop(i, j);
				player_attack_down[(i - 1) * 2 + j - 1] = playerAttackDown.crop(i, j);
				player_attack_right[(i - 1) * 2 + j - 1] = playerAttackRight.crop(i, j);

				orc_attack_up[(i - 1) * 2 + j - 1] = orcAttackUp.crop(i, j);
				orc_attack_left[(i - 1) * 2 + j - 1] = orcAttackLeft.crop(i, j);
				orc_attack_down[(i - 1) * 2 + j - 1] = orcAttackDown.crop(i, j);
				orc_attack_right[(i - 1) * 2 + j - 1] = orcAttackRight.crop(i, j);
			}
		}

		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				player_die[(i - 1) * 2 + j - 1] = playerDie.crop(i, j);
				orc_die[(i - 1) * 2 + j - 1] = orcDie.crop(i, j);
			}
		}

		arrow = ImageLoader.loadImage("/Textures/arrow.png");

		fireball = ImageLoader.loadImage("/Textures/fireball.png");

		dirt = tileSheet.getSubimage(16, 16 * 7, 16, 16);

		grass = tileSheet.getSubimage(0, 16 * 7, 16, 16);

		stone = tileSheet.getSubimage(0, 16 * 20, 16, 16);

		tree = tileSheet.getSubimage(16 * 3, 0, 16 * 3, 16 * 6);

		greens = new BufferedImage[11 * 8];
		greens2 = new BufferedImage[14 * 13];

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 8; j++) {
				greens[i * 8 + j] = tileSheet.getSubimage(16 * j, 16 * i + 16 * 6, 16, 16);
			}
		}

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 13; j++) {
				greens2[i * 13 + j] = tileSheet.getSubimage(16 * j + 16 * 12, 16 * i + 16 * 12, 16, 16);
			}
		}

		greens2[151] = Utils.rotateImage(greens2[135], 180);
		greens2[150] = Utils.rotateImage(greens2[135], 90);
		greens2[169] = Utils.rotateImage(greens2[136], 270);
		greens2[170] = Utils.rotateImage(greens2[150], 180);
		greens2[171] = Utils.rotateImage(greens2[138], 180);
		greens2[172] = Utils.rotateImage(greens2[138], 270);

		baseFont = FontLoader.loadFont("/Fonts/Alagard.ttf", 20);

		lootBag = ImageLoader.loadImage("/Textures/lootbag.png");

		slot = ImageLoader.loadImage("/Textures/Slot.png");
		selectedSlot = ImageLoader.loadImage("/Textures/SelectedSlot.png");
		hoveringSlot = ImageLoader.loadImage("/Textures/HoveringSlot.png");

		SpriteSheet foodSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/food.png"), 43, 43);

		foods = new BufferedImage[8][8];

		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				foods[i - 1][j - 1] = foodSheet.crop(i, j);
			}
		}
		
		food = new Food(handler);

		box = ImageLoader.loadImage("/Textures/box.png");
		selectedBox = Utils.dye(box, new Color(100, 200, 100, 200));
		bar = ImageLoader.loadImage("/Textures/bar.png");
		lpointer = ImageLoader.loadImage("/Textures/lpointer.png");
		upointer = ImageLoader.loadImage("/Textures/upointer.png");
		rpointer = ImageLoader.loadImage("/Textures/rpointer.png");
		dpointer = ImageLoader.loadImage("/Textures/dpointer.png");

		cursors = new Cursor[10];

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Image dfault = (Image) ImageLoader.loadImage("/Textures/cursor.png");
		Image interact = (Image) ImageLoader.loadImage("/Textures/cursor2.png");
		cursors[0] = toolkit.createCustomCursor(dfault, new Point(0, 0), "Default");
		cursors[1] = toolkit.createCustomCursor(interact, new Point(0, 0), "Interact");

	}

}

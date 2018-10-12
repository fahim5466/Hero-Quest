package dev.fahim.tileGame.worlds;

import java.awt.Graphics;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.dialogue.DialogueBank;
import dev.fahim.tileGame.entities.LevelTrigger;
import dev.fahim.tileGame.entities.Orc;
import dev.fahim.tileGame.entities.statics.*;
import dev.fahim.tileGame.entities.statics.Barn;
import dev.fahim.tileGame.entities.statics.Bush3;
import dev.fahim.tileGame.entities.statics.FallTree;
import dev.fahim.tileGame.entities.statics.FallTree2;
import dev.fahim.tileGame.entities.statics.FallTree3;
import dev.fahim.tileGame.entities.statics.FallTree4;
import dev.fahim.tileGame.entities.statics.Fence2;
import dev.fahim.tileGame.entities.statics.Flower;
import dev.fahim.tileGame.entities.statics.Stable;
import dev.fahim.tileGame.entities.statics.Tree;
import dev.fahim.tileGame.entities.statics.TreeDown10;
import dev.fahim.tileGame.entities.statics.TreeDown11;
import dev.fahim.tileGame.entities.statics.TreeDown12;
import dev.fahim.tileGame.entities.statics.TreeDown13;
import dev.fahim.tileGame.entities.statics.TreeDown15;
import dev.fahim.tileGame.entities.statics.TreeMiddle;
import dev.fahim.tileGame.entities.statics.Well;
import dev.fahim.tileGame.tile.Tile;


public class WorldManager {

	private Handler handler;
	
	public World forest1,world1,world2,world3,world4,world8;
	
	//forest1
	//Mobs
	public Orc orc1_1,orc1_2,orc2_1,orc2_2,orc3_1,orc3_2;
	
	private World currentWorld;
	
	private DialogueBank dialogueBank;
	
	public WorldManager(Handler handler)
	{
		this.handler = handler;
		dialogueBank = handler.getGame().getDialogueBank();
		init();
	}
	
	public void init()
	{
		
		Tile.init();
		jmim.codenmore.tile.Tile.init();
		
		forest1 = new World(handler,"res/Worlds/world7.txt",handler.getGame().getPlayer());
		world3 = new World(handler,"res/Worlds/world3.txt",handler.getGame().getPlayer());
		world4 = new World(handler,"res/Worlds/world4.txt",handler.getGame().getPlayer());
		world8 = new World(handler,"res/Worlds/world8.txt",handler.getGame().getPlayer());
		//forest1
		
		//Mobs
		
		orc1_1 = new Orc(handler, 540,30,280,280);
		orc1_2 = new Orc(handler, 540,380,280,280);
		
		forest1.getEntityManager().addEntity(orc1_1);
		forest1.getEntityManager().addEntity(orc1_2);
		//orc1_1.setCurrentDialogue(dialogueBank.d);
		//forest1.getEntityManager().addEntity(new Orc(handler, 475,310,280,280));
		//forest1.getEntityManager().addEntity(new Zombie(handler, 16*30,16*50,280,280));
		
		
		//Static entities
		forest1.getEntityManager().addEntity(new Tree(handler,16*10,16*-14));
		forest1.getEntityManager().addEntity(new Tree(handler,16*3,16*25));
		forest1.getEntityManager().addEntity(new Tree(handler,16*-5,16));
		forest1.getEntityManager().addEntity(new Tree(handler,16*45,16*-14));
		forest1.getEntityManager().addEntity(new Tree(handler,16*35,16*6));
		
		//TriggerBoxes
		forest1.getEntityManager().addEntity(new LevelTrigger(handler, handler.getWidth()+180, handler.getHeight()-200, 50, 50, world3, -50, -100));
		
		//Jamima's
		
		//world3

		//TriggerBoxes
		world3.getEntityManager().addEntity(new LevelTrigger(handler, -30, 50, 50, 50, forest1, handler.getWidth(), handler.getHeight()-350));
		world3.getEntityManager().addEntity(new LevelTrigger(handler, world3.getW()*Tile.w-30, 200, 50, 100, world4, -50, -50));
		
		//Mobs
		orc2_1 = new Orc(handler, 440,380,280,280);
		orc2_2 = new Orc(handler, 540,380,280,280);
		
		world3.getEntityManager().addEntity(orc2_1);
		world3.getEntityManager().addEntity(orc2_2);
		
		//Static entities
		world3.getEntityManager().addEntity(new FallTree2(handler, 16*2, 16*4));
		world3.getEntityManager().addEntity(new FallTree(handler, 16*0, 16*10));
		world3.getEntityManager().addEntity(new FallTree(handler, 16*0, 16*24));
		
		world3.getEntityManager().addEntity(new FallTree3(handler, 16*0, 16*15));
		//world3.getEntityManager().addEntity(new FallTree3(handler, 16*2, 16*33));
		//world3.getEntityManager().addEntity(new FallTree2(handler, 16*5, 16*39));
		//world3.getEntityManager().addEntity(new FallTree3(handler, 16*10, 16*41));
		
		//world3.getEntityManager().addEntity(new Post1(handler, 16*21, 16*12));
		//world3.getEntityManager().addEntity(new Post2(handler, 350, 16*1));
		/*world3.getEntityManager().addEntity(new Fence(handler, 500, 270));
		world3.getEntityManager().addEntity(new Fence(handler, 392, 270));*/
		world3.getEntityManager().addEntity(new Barn(handler, 16*30, 16*8));
		
		world3.getEntityManager().addEntity(new Fence2(handler, 16*0, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*2, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*3, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*4, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*5, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*6, 16*49));
		
		world3.getEntityManager().addEntity(new Bush3(handler, 60*13, 16*48));
		world3.getEntityManager().addEntity(new Bush3(handler, 60*14, 16*48));
		
		world3.getEntityManager().addEntity(new Fence2(handler, 60*11, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*12, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*13, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*14, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*15, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*16, 16*49));
		world3.getEntityManager().addEntity(new Fence2(handler, 60*17, 16*49));
		
		world3.getEntityManager().addEntity(new Stable(handler, 16*6, 16*22));
		
		world3.getEntityManager().addEntity(new Fence2(handler, 16*13, 16*9));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*13+60, 16*9));
		
		world3.getEntityManager().addEntity(new Fence2(handler, 16*22, 16*7));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*22+60, 16*7));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*22+(60*2), 16*7));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*22+(60*3), 16*7));
		
		
		
		world3.getEntityManager().addEntity(new Fence2(handler, 290, 16*1));
		world3.getEntityManager().addEntity(new Fence2(handler, 230, 16*1));
		world3.getEntityManager().addEntity(new Fence2(handler, 170, 16*1));
		
		
		
		
		//world3.getEntityManager().addEntity(new FallTree4(handler, 16*16, 16*41));
		world3.getEntityManager().addEntity(new Bush3(handler, 16*23, 16*5));
		world3.getEntityManager().addEntity(new Bush3(handler, 16*23+55, 16*5));
		//world3.getEntityManager().addEntity(new FallTree4(handler, 16*25, 16*43));
		//world3.getEntityManager().addEntity(new FallTree3(handler, 16*38, 16*25));
		//world3.getEntityManager().addEntity(new FallTree4(handler, 16*1, 16*41));
		world3.getEntityManager().addEntity(new Flower(handler, 16*25, 16*36));
		world3.getEntityManager().addEntity(new Flower(handler, 16*25+30+5, 16*36));
		world3.getEntityManager().addEntity(new Flower(handler, 16*25+60+10, 16*36));
		
		//world3.getEntityManager().addEntity(new Pond2(handler, 16*47, 16*23));
		world3.getEntityManager().addEntity(new Well(handler, 16*41, 16*37));
		
		
		world3.getEntityManager().addEntity(new Flower(handler, 16*25, 16*38));
		world3.getEntityManager().addEntity(new Flower(handler, 16*25+30+5, 16*38));
		world3.getEntityManager().addEntity(new Flower(handler, 16*25+60+10, 16*38));
		
		world3.getEntityManager().addEntity(new Flower(handler, 16*25, 16*40));
		
		world3.getEntityManager().addEntity(new Flower(handler, 16*25+30+5, 16*40));
		world3.getEntityManager().addEntity(new Flower(handler, 16*25+60+10, 16*40));
		
		
		world3.getEntityManager().addEntity(new TreeMiddle(handler, 800, 16*7));
		world3.getEntityManager().addEntity(new TreeMiddle(handler, 650, 16*7));
		
		world3.getEntityManager().addEntity(new TreeDown11(handler, 600, 86));
		world3.getEntityManager().addEntity(new TreeDown10(handler, 650, 16*6));
		world3.getEntityManager().addEntity(new TreeDown10(handler, 700, 16*6));
		world3.getEntityManager().addEntity(new TreeDown11(handler, 750, 16*6));
		world3.getEntityManager().addEntity(new TreeDown12(handler, 800, 16*6));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 850, 16*6));
		world3.getEntityManager().addEntity(new TreeDown12(handler, 900, 16*6));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 950, 16*6));
		
		world3.getEntityManager().addEntity(new TreeDown15(handler, 550, 1));
		world3.getEntityManager().addEntity(new TreeDown15(handler, 500, 1));
		
		world3.getEntityManager().addEntity(new TreeDown13(handler, 450, 1));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 500, 16));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 530, 27));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 570, 40));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 520, 50));
		world3.getEntityManager().addEntity(new TreeDown13(handler, 590, 80));
		
		
		
		world3.getEntityManager().addEntity(new TreeDown15(handler, 600, 16*2));
		world3.getEntityManager().addEntity(new TreeDown15(handler, 700, 16*2));
		world3.getEntityManager().addEntity(new TreeDown15(handler, 800, 16*2));
		world3.getEntityManager().addEntity(new TreeDown15(handler, 900, 16*2));
		
		world3.getEntityManager().addEntity(new TreeDown15(handler, 650, 16*1));
		world3.getEntityManager().addEntity(new TreeDown15(handler, 800, 16*1));
		
		world3.getEntityManager().addEntity(new Fence2(handler, 16*37, 16*9));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*37+60, 16*9));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*37+200, 16*9));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*37+260, 16*9));
		world3.getEntityManager().addEntity(new Fence2(handler, 16*37+320, 16*9));
		//world3.getEntityManager().addEntity(new WeirdGrass(handler, 16*40, 16*47));
		
		//world4
		
		//TriggerBoxes
		world4.getEntityManager().addEntity(new LevelTrigger(handler, 0, 100, 50, 100, world3, world3.getW()*Tile.w-200, 100));
		
		//Mobs
		orc3_1 = new Orc(handler, 340,150,280,280);
		orc3_2 = new Orc(handler, 390,250,280,280);
		
		world4.getEntityManager().addEntity(orc3_1);
		world4.getEntityManager().addEntity(orc3_2);
		
		//static entities
		
		world4.getEntityManager().addEntity(new FallTree2(handler, 16*2, 16*4));
		//entityManager.addEntity(new FallTree(handler, 16*0, 16*10));
		world4.getEntityManager().addEntity(new FallTree(handler, 16*0, 16*24));
		
		world4.getEntityManager().addEntity(new FallTree3(handler, 16*0, 16*15));
		world4.getEntityManager().addEntity(new FallTree3(handler, 16*2, 16*33));
		world4.getEntityManager().addEntity(new FallTree2(handler, 16*5, 16*39));
		world4.getEntityManager().addEntity(new FallTree3(handler, 16*10, 16*41));
		
		world4.getEntityManager().addEntity(new Drum(handler, 16*38, 16*30));
		world4.getEntityManager().addEntity(new Drum(handler, 16*38+140, 16*30));
		world4.getEntityManager().addEntity(new Drum(handler, 16*38+150, 16*30+40));
		world4.getEntityManager().addEntity(new CityTent(handler, 16*38, 16*30));
		world4.getEntityManager().addEntity(new CityTent1(handler, 670, 16*36));
		//world4.getEntityManager().addEntity(new Mattress(handler, 16*30, 16*38+50));
		
		world4.getEntityManager().addEntity(new Drum(handler, 16*12, 16*20));
		world4.getEntityManager().addEntity(new Drum(handler, 16*12+140, 16*20));
		world4.getEntityManager().addEntity(new Drum(handler, 16*12+150, 16*20+40));
		world4.getEntityManager().addEntity(new CityTent(handler, 16*12, 16*20));
		
		world4.getEntityManager().addEntity(new Drum(handler, 16*18, 16*40));
		world4.getEntityManager().addEntity(new Drum(handler, 16*18+140, 16*40));
		world4.getEntityManager().addEntity(new Drum(handler, 16*18+150, 16*40+40));
		world4.getEntityManager().addEntity(new CityTent(handler, 16*18, 16*40));
		
		world4.getEntityManager().addEntity(new CityTent1(handler, 260, 16*26));
		world4.getEntityManager().addEntity(new CityTent1(handler, 360,16*46));
		world4.getEntityManager().addEntity(new Mattress1(handler, 16*13, 16*28+50));
		world4.getEntityManager().addEntity(new Coop(handler, 16*33, 0));
		world4.getEntityManager().addEntity(new Coop2(handler, 16*33+215, 0));
		world4.getEntityManager().addEntity(new Cart(handler, 16*37, 16*10));
		world4.getEntityManager().addEntity(new Drum(handler, 16*37+302, 16*8));
		world4.getEntityManager().addEntity(new Table(handler,16*26 , 16*5));
		world4.getEntityManager().addEntity(new Shop(handler, 16*48, 16*20));
		world4.getEntityManager().addEntity(new Table2(handler, 16*34, 16*18));
		world4.getEntityManager().addEntity(new DecorFloor(handler, 16*34, 16*50));
		world4.getEntityManager().addEntity(new DecorFloor2(handler, 16*34+190, 16*50+100));
		world4.getEntityManager().addEntity(new House(handler, 16*2, 16*46));
		
		
		world4.getEntityManager().addEntity(new FallTree2(handler, 0, 16*6));
		world4.getEntityManager().addEntity(new FallTree2(handler, 190, 16*6));
		
		//entityManager.addEntity(new CityBush(handler, 16*50, 16*46));
		
		world4.getEntityManager().addEntity(new FallTree3(handler, 16*53, 16*33));
		//entityManager.addEntity(new Bush3(handler, 16*43, 16*38));
		world4.getEntityManager().addEntity(new Bush3(handler, 16*17, 16*1));
		world4.getEntityManager().addEntity(new CityBush(handler, 16*22, 16*1));
		
		world4.getEntityManager().addEntity(new Decor3(handler, 16*46, 16*44));
		world4.getEntityManager().addEntity(new Balloon(handler, 16*48-30, 16*20-80));
		world4.getEntityManager().addEntity(new Balloon(handler, 16*48-30+70, 16*20-80));
		
	}
	
	public World getCurrentWorld()
	{
		return currentWorld;
	}
	
	public void setCurrentWorld(World w)
	{
		currentWorld = w;
		handler.setWorld(w);
	}
	
	public void tick()
	{
		currentWorld.tick();
	}
	
	public void render(Graphics g)
	{
		currentWorld.render(g);
	}
	
}

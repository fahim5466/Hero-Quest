package jmim.codenmore.state;

import java.awt.Graphics;
import jmim.codenmore.game.Handler;

import jmim.codenmore.entity.Player;
import jmim.codenmore.entity.statics.Bush;
import jmim.codenmore.world.World;
import jmim.codenmore.world.World2;
import jmim.codenmore.world.World3;
import jmim.codenmore.world.World4;
public class GameState extends State{
	
	private World world;
	private World2 world2;
	private World3 world3;
	private World4 world4;
	
	public GameState(Handler handler) {
		super(handler);
		//world=new World(handler,"RES/World/worlds.txt");
		//handler.setWorld(world);
		//world2=new World2(handler,"RES/World/world2.txt");
				//handler.setWorld2(world2);
				
				//world3=new World3(handler,"RES/World/world3.txt");
				//handler.setWorld3(world3);
				
				world4=new World4(handler,"RES/World/World4.txt");
				handler.setWorld4(world4);
	}

	
	

	@Override
	public void tick() {
		//world2.tick();
		//world3.tick();
		world4.tick();

		
		
	}

	@Override
	public void render(Graphics g) {
		//world2.render(g);
		
		//world3.render(g);
		
		world4.render(g);
	
		
		
	}

}

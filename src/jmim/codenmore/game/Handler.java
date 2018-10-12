package jmim.codenmore.game;

import jmim.codenmore.game.grpx.GameCamera;
import jmim.codenmore.input.Keymanager;
import jmim.codenmore.input.MouseManager;
import jmim.codenmore.world.World;
import jmim.codenmore.world.World2;
import jmim.codenmore.world.World3;
import jmim.codenmore.world.World4;

public class Handler {
	
	private GameMain game;
	private World world;
	private World2 world2;
	private World3 world3;
	private World4 world4;
	
	public Handler(GameMain game)
	{
		this.game=game;
		
	}
	
	
	public GameMain getGame() {
		return game;
	}
	public void setGame(GameMain game) {
		this.game = game;
	}
	
	
	public int getWidth()
	{
		return game.getWidth();
	}
	
	public int getHeight()
	{
		return game.getHeight();
	}
	
	public GameCamera getGameCamera()
	{
		return game.getCamera();
	}
	
	public Keymanager getKey()
	{
		return game.getkey();
		
	}
	
	
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
		
	}
	
	
	
	
	public World getWorld()
	{
		return world;	
	}
	
	public World2 getWorld2()
	{
		return world2;	
	}
	public World3 getWorld3()
	{
		return world3;	
	}
	public World4 getWorld4()
	{
		return world4;	
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
	
	public void setWorld2(World2 world2) {
		this.world2 = world2;
	}
	
	public void setWorld3(World3 world3) {
		this.world3 = world3;
	}
	public void setWorld4(World4 world4) {
		this.world4 = world4;
	}
	

}

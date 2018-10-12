package dev.fahim.tileGame.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import dev.fahim.tileGame.Handler;

public class EntityManager {

	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>()
			{
				@Override
				public int compare(Entity a, Entity b)
				{
					if(a.getY()+a.getH()<b.getY()+b.getH())
					{
						return -1;
					}
					else
					{
						return 1;
					}
				}
			};
	
	public EntityManager(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		entities.add(player);
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	public void removeEntity(Entity e)
	{
		entities.remove(e);
	}
	
	public void tick()
	{
		
		for(int i=0;i<entities.size();i++)
		{
			entities.get(i).tick();
		}
		
		entities.sort(renderSorter);
		
	}
	
	public void render(Graphics g)
	{
		
		for(int i=0;i<entities.size();i++)
		{
			entities.get(i).render(g);
		}
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public Entity getLastEntity()
	{
		return entities.get(entities.size()-1);
	}
	
}

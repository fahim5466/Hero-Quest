package dev.fahim.tileGame.Item;

import java.util.ArrayList;

import dev.fahim.tileGame.Handler;
import dev.fahim.tileGame.gfx.Assets;

public class Food {

	public static ArrayList<Item> foods;
	private Handler handler;
	
	public Food(Handler handler)
	{
		this.handler = handler;
	}
	
	public void init()
	{
		
		foods = new ArrayList<Item>();
		
		//Cookie
		foods.add(new Item(Assets.foods[0][0],"A delicious cookie!")
				{

					@Override
					public void use() {
						handler.getGame().getPlayer().setHealth(handler.getGame().getPlayer().getHealth()+10);
						handler.getGame().getPlayer().setMana(handler.getGame().getPlayer().getMana()+10);
					}
				}
				);
		
		//Chocolate
		foods.add(new Item(Assets.foods[0][1],"Yumm! Dark chocolate")
		{

			@Override
			public void use() {
				handler.getGame().getPlayer().setHealth(handler.getGame().getPlayer().getHealth()+20);
				handler.getGame().getPlayer().setMana(handler.getGame().getPlayer().getMana()+20);
			}
		}
		);
		
		//Ale
		foods.add(new Item(Assets.foods[0][2],"Ale from the North")
		{

			@Override
			public void use() {
				handler.getGame().getPlayer().setHealth(handler.getGame().getPlayer().getHealth()+15);
				handler.getGame().getPlayer().setMana(handler.getGame().getPlayer().getMana()+15);
			}
		}
		);
		
		//Tequila
		foods.add(new Item(Assets.foods[0][3],"Tequila from the south")
		{

			@Override
			public void use() {
				handler.getGame().getPlayer().setHealth(handler.getGame().getPlayer().getHealth()+5);
				handler.getGame().getPlayer().setMana(handler.getGame().getPlayer().getMana()+5);
			}
		}
		);
		
		//Tonic
		foods.add(new Item(Assets.foods[0][4],"Tonic made from a secret recipe")
		{

			@Override
			public void use() {
				handler.getGame().getPlayer().setHealth(handler.getGame().getPlayer().getHealth()+50);
				handler.getGame().getPlayer().setMana(handler.getGame().getPlayer().getMana()+50);
			}
		}
		);
		
	}
	
}

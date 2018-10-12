package jmim.codenmore.UserInterFace;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import jmim.codenmore.game.Handler;

public class ImageChangeManager {
	
	private Handler handler;
	private ArrayList<ImageObject> objects;
	
	public ImageChangeManager(Handler handler){
		this.handler = handler;
		objects = new ArrayList<ImageObject>();
	}
	
	public void tick(){
		for(ImageObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g){
		for(ImageObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e){
		for(ImageObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e){
		for(ImageObject o : objects)
			o.onMouseRelease(e);
	}
	
	public void addObject(ImageObject o){
		objects.add(o);
	}
	
	public void removeObject(ImageObject o){
		objects.remove(o);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<ImageObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<ImageObject> objects) {
		this.objects = objects;
	}

}

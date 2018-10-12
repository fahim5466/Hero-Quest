package jmim.codenmore.game.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private JFrame frame;
	private String title;
	private int width,height;
	private Canvas canvas;
	
	public Display(String title,int width,int height)
	{
		this.title=title;
		this.width=width;
		this.height=height;
		CreateDisplay();
		
	}
	public void CreateDisplay()
	{
		frame=new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getcanvas()
	{
		return canvas;
	}
	
	public JFrame getframe()
	{
		return frame;
	}
}
	
	



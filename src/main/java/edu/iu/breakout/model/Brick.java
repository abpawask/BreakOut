package edu.iu.breakout.model;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Sprite {
	
	public static final int BRICK_WIDTH= 60;
	
	public static final int BRICK_HEIGHT = 20;
	
	public static final Color BRICK_COLOR = Color.RED;
	
	private boolean destroyed;
	
	public Brick(){
		destroyed = false;
		width = BRICK_WIDTH;
		height= BRICK_HEIGHT;
	}
	
	public Brick(int x, int y){
		this();
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		if(!destroyed){
			g.setColor(BRICK_COLOR);
			g.fillRect(x, y,width,height);
			g.setColor(Color.gray);			
			g.drawRect(x, y, width,height);	
		}
			

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

}

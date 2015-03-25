package edu.iu.breakout.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Paddle extends Sprite{
	
	public static final int PADDLE_WIDTH= 50;
	
	public static final int PADDLE_HEIGHT= 10;

	public static final int PADDLE_LEFT=2;
	
	public static final int PADDLE_RIGHT = 250;
	
	public static final Color PADDLE_COLOR= Color.GREEN;
	
	private int dx;
	
	public Paddle(){
		width = PADDLE_WIDTH;
		height = PADDLE_HEIGHT;
	}
			
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(PADDLE_COLOR);
		g.fillRect(x, y,50,10);
		g.setColor(Color.gray);
		
		g.drawRect(x, y, 50,10);
		
	}

	@Override
	public void move() {
		
		x= x + dx;
		
		if(x <= PADDLE_LEFT){
			x = PADDLE_LEFT;
		}		
		else if(x >= PADDLE_RIGHT){
			x = PADDLE_RIGHT;
		}
		
	}

	

}

package edu.iu.breakout.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball extends Sprite {

	public final static int BALL_RIGHT = 280;
	
	public final static int BALL_DIAMETER = 16;
	
	public final static Color BALL_COLOR= Color.black;
	
	private int xdir;
	
	private int ydir;
	
	public Ball(){
		xdir = 1;
		ydir = -1;
		
		width = BALL_DIAMETER;
		height = BALL_DIAMETER;
	}
	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(BALL_COLOR);
		g.fillOval( x, y, BALL_DIAMETER,BALL_DIAMETER);
		g.setColor(Color.gray);
		g.drawOval(x, y, BALL_DIAMETER,BALL_DIAMETER);

	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		x = x + xdir;
		y = y + ydir;
		
		if(x==0){
			xdir = 1;
		}
		else if (x >= BALL_RIGHT){
			xdir = -1;
		}
		
		if(y==0){
			ydir = 1;
		}
		
		if(y > 380){
			ydir = -1;
		}
	}

	public int getXdir() {
		return xdir;
	}

	public void setXdir(int xdir) {
		this.xdir = xdir;
	}

	public int getYdir() {
		return ydir;
	}

	public void setYdir(int ydir) {
		this.ydir = ydir;
	}

}

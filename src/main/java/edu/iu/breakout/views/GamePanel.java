package edu.iu.breakout.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

import edu.iu.breakout.model.Sprite;

public class GamePanel extends JPanel{
	
	private Graphics2D bufferedGraphics;
	
	private BufferedImage image;
	
	private Sprite paddle;
	
	private List<Sprite> sprites;
	
	public GamePanel(){
		
		super();
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(300, 400));
		//image = new BufferedImage(300, 400 , BufferedImage.TYPE_INT_RGB);
		//bufferedGraphics = image.createGraphics();
	}
	
	@Override
	public void paint(Graphics g){
		
		super.paintComponent(g);
		
				
		
		for(Sprite sprite: sprites){
			sprite.draw(g);
		}
		
		//g.drawImage(image, 0, 0, this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
		
	}	

	public List<Sprite> getSprites() {
		return sprites;
	}

	public void setSprites(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	
}

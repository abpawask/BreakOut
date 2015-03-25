package edu.iu.breakout.views;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import edu.iu.breakout.model.Ball;
import edu.iu.breakout.model.Brick;
import edu.iu.breakout.model.Paddle;
import edu.iu.breakout.model.Sprite;

public class GamePanelTestCase {

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() throws InterruptedException {
		JFrame gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gamePanel = new GamePanel();
		gameFrame.add(gamePanel);
		gameFrame.setSize(300, 400);
		gameFrame.setVisible(true);
		
		Paddle paddle = new Paddle();
		paddle.setX(150);
		paddle.setY(300);
		
		Ball ball = new Ball();
		ball.setX(140);
		ball.setY(160);
		
		List<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(paddle);
		sprites.add(ball);
		
		Brick[] bricks = new Brick[4];
		
		bricks[0] = new Brick(20, 40);
		
		bricks[1] = new Brick(120, 40);
		
		bricks[2] = new Brick( 20, 70);
		
		bricks[3] = new Brick(120, 70);
		
		sprites.add(bricks[0]);
		sprites.add(bricks[1]);
		sprites.add(bricks[2]);
		sprites.add(bricks[3]);
		
		gamePanel.setSprites(sprites);
		
		gamePanel.repaint();
		while(true){
			
		}
	}

}

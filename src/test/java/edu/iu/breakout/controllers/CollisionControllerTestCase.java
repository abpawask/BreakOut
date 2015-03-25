package edu.iu.breakout.controllers;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.iu.breakout.model.Ball;
import edu.iu.breakout.model.Brick;
import edu.iu.breakout.model.Paddle;

public class CollisionControllerTestCase {

	private CollisionController collisionController;
	
	private Ball ball;
	
	private Paddle paddle;
	
	private Brick[] bricks;
	
	@Before
	public void setUp() throws Exception {
		
		ball = new Ball();
		paddle = new Paddle();		
		bricks = new Brick[2];
		
		for(int i=0;i< bricks.length;i++){
			bricks[i] = new Brick();
		}
		
		collisionController = new CollisionController();
		collisionController.setBall(ball);
		collisionController.setPaddle(paddle);
		collisionController.setBricks(bricks);
	}

	@Test
	public void testCollisionBetweenBallAndBrick() {
		Brick destroyedBrick = bricks[0];
		Brick undestroyedBrick = bricks[1];
		ball.setX(20);
		ball.setY(20);
		
		destroyedBrick.setX(22);
		destroyedBrick.setY(22);
		destroyedBrick.setDestroyed(false);
		
		undestroyedBrick.setX(50);
		undestroyedBrick.setY(50);
		undestroyedBrick.setDestroyed(false);
		
		collisionController.handleCollision();
		
		Assert.assertTrue(destroyedBrick.isDestroyed());
		Assert.assertFalse(undestroyedBrick.isDestroyed());		
	}
	
	@Test
	public void testCollisionAtPaddleLeftEdge(){
		ball.setX(6);
		ball.setY(10);
		ball.setYdir(1);
		paddle.setX(8);
		paddle.setY(10);
		
		collisionController.handleCollision();
		
		Assert.assertEquals(-1,ball.getXdir());
		Assert.assertEquals(-1,ball.getYdir());
	}
	
	@Test
	public void testCollisionAtPaddleRightEdge(){
		ball.setX(48);
		ball.setY(12);
		
		ball.setXdir(-1);
		ball.setYdir(1);
		paddle.setX(10);
		paddle.setY(10);
		
		collisionController.handleCollision();
		
		Assert.assertEquals(1,ball.getXdir());
		Assert.assertEquals(-1,ball.getYdir());
	}
	
	@Test
	public void testCollisionAtPaddleCentre(){
		ball.setX(32);
		ball.setY(12);
		
		ball.setXdir(1);
		ball.setYdir(1);
		paddle.setX(10);
		paddle.setY(10);
		
		collisionController.handleCollision();
		
		Assert.assertEquals(0,ball.getXdir());
		Assert.assertEquals(-1,ball.getYdir());
	}

}

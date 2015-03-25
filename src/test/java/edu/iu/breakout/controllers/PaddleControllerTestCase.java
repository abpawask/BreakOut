package edu.iu.breakout.controllers;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.iu.breakout.model.Paddle;

public class PaddleControllerTestCase {
	
	PaddleController paddleController;
	
	JPanel gamePanel;
	
	Paddle paddle;

	@Before
	public void setUp() throws Exception {
		
		paddle = new Paddle();
		gamePanel = new JPanel();
		
		paddleController = new PaddleController(paddle, gamePanel);
		
	}	
	
	@Test
	public void testLeftKeyPress(){
		paddle.setDx(1);
		KeyEvent leftKeyPressEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, 0,0, KeyEvent.VK_LEFT);
		gamePanel.getKeyListeners()[0].keyPressed(leftKeyPressEvent);
		Assert.assertEquals(-2, paddle.getDx());		
	}
	
	@Test
	public void testRightKeyPress(){
		paddle.setDx(1);
		KeyEvent rightKeyPressEvent = new KeyEvent(gamePanel, KeyEvent.KEY_PRESSED, 0,0, KeyEvent.VK_RIGHT);
		gamePanel.getKeyListeners()[0].keyPressed(rightKeyPressEvent);
		Assert.assertEquals(2, paddle.getDx());
	}
	
	@Test
	public void testLeftKeyRelease(){
		paddle.setDx(1);
		KeyEvent leftKeyReleaseEvent = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, 0,0, KeyEvent.VK_LEFT);
		gamePanel.getKeyListeners()[0].keyReleased(leftKeyReleaseEvent);
		Assert.assertEquals(0, paddle.getDx());		
	}
	
	@Test
	public void testRightKeyRelease(){
		paddle.setDx(1);
		KeyEvent rightKeyReleaseEvent = new KeyEvent(gamePanel, KeyEvent.KEY_RELEASED, 0,0, KeyEvent.VK_RIGHT);
		gamePanel.getKeyListeners()[0].keyReleased(rightKeyReleaseEvent);
		Assert.assertEquals(0, paddle.getDx());
	}

}

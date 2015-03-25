package edu.iu.breakout.commands;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import edu.iu.breakout.model.Brick;

public class DestroyBrickCommandTestCase {
	
	private Brick brick;
	
	private DestroyBrickCommand destroyBrickCommand;
	@Before
	public void setUp() throws Exception {
		brick = new Brick();
		brick.setDestroyed(false);
		
		destroyBrickCommand = new DestroyBrickCommand(brick);
	}

	@Test
	public void testExecute() {
		destroyBrickCommand.execute();
		
		Assert.assertTrue(brick.isDestroyed());
	}
	
	@Test
	public void testUndo(){
		destroyBrickCommand.undo();
		
		Assert.assertFalse(brick.isDestroyed());
	}
	
	@Test
	public void testReplay(){
		
		destroyBrickCommand.execute();
		destroyBrickCommand.replay();
		
		Assert.assertTrue(brick.isDestroyed());
	}

}

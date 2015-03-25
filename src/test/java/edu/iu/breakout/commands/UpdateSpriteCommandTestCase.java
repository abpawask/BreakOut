package edu.iu.breakout.commands;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import edu.iu.breakout.commands.UpdateSpriteCommand;
import edu.iu.breakout.model.Sprite;

public class UpdateSpriteCommandTestCase {

	
	private UpdateSpriteCommand updateSpriteCommand;
	
	private Sprite sprite;
	
	@Before
	public void setUp() throws Exception {
		
		sprite = Mockito.mock(Sprite.class);
		
		Mockito.when(sprite.getX()).thenReturn(Integer.valueOf(4));
		Mockito.when(sprite.getY()).thenReturn(Integer.valueOf(5));
		
		updateSpriteCommand = new UpdateSpriteCommand(sprite);
	}

	@Test
	public void testExecute() {
		
		Mockito.when(sprite.getX()).thenReturn(Integer.valueOf(2));
		Mockito.when(sprite.getY()).thenReturn(Integer.valueOf(3));
		
		updateSpriteCommand.execute();
		Mockito.verify(sprite, Mockito.times(1)).move();
	}
	
	@Test
	public void testUndo(){
		ArgumentCaptor<Integer> xArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor<Integer> yArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		
		updateSpriteCommand.undo();
		
		Mockito.verify(sprite, Mockito.times(1)).setX(xArgumentCaptor.capture());
		Mockito.verify(sprite, Mockito.times(1)).setY(yArgumentCaptor.capture());
		
		int actualX = xArgumentCaptor.getValue().intValue();
		int actualY = yArgumentCaptor.getValue().intValue();
		
		Assert.assertEquals(4, actualX);
		Assert.assertEquals(5, actualY);
		
	}
	
	@Test
	public void testReplay(){
		Mockito.when(sprite.getX()).thenReturn(Integer.valueOf(2));
		Mockito.when(sprite.getY()).thenReturn(Integer.valueOf(3));
		
		updateSpriteCommand.execute();
		
		ArgumentCaptor<Integer> xArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor<Integer> yArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		
		updateSpriteCommand.replay();
		
		Mockito.verify(sprite, Mockito.times(1)).setX(xArgumentCaptor.capture());
		Mockito.verify(sprite, Mockito.times(1)).setY(yArgumentCaptor.capture());
		
		int actualX = xArgumentCaptor.getValue().intValue();
		int actualY = yArgumentCaptor.getValue().intValue();
		
		Assert.assertEquals(2, actualX);
		Assert.assertEquals(3, actualY);
	}

}

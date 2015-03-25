package edu.iu.breakout.commands;

import static org.junit.Assert.*;

import java.util.LinkedList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CommandInvokerTestCase {

	private CommandInvoker commandInvoker;
	
	@Before
	public void setUp() throws Exception {
		commandInvoker = new CommandInvoker();
	}

	@Test
	public void testExecute() {
		Command command = Mockito.mock(Command.class);
		
		commandInvoker.execute(command);
		
		Mockito.verify(command, Mockito.times(1)).execute();
		
		LinkedList<Command> commands = commandInvoker.getCommands();
		
		Assert.assertEquals(1,commands.size());
		Assert.assertTrue(commands.contains(command));
	}
	
	@Test
	public void testExecuteNullCommand(){
		commandInvoker.execute(null);		
		LinkedList<Command> commands = commandInvoker.getCommands();		
		Assert.assertEquals(0,commands.size());
		
	}

	@Test
	public void testUndo() {
		LinkedList<Command> commands = commandInvoker.getCommands();
		
		Command command = Mockito.mock(Command.class);
		commands.add(command);
		
		commandInvoker.undo();
		
		Mockito.verify(command, Mockito.times(1)).undo();
	}
	
	@Test
	public void testUndoForEmptyCommandList(){
		commandInvoker.undo();
	}

	@Test
	public void testReplay() {
		Command command = Mockito.mock(Command.class);
		
		commandInvoker.replay(command);
		Mockito.verify(command, Mockito.times(1)).replay();
	}
	
	@Test
	public void testReplayForNullCommand(){
		commandInvoker.replay(null);
	}

}

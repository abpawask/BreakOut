package edu.iu.breakout.commands;

import java.util.LinkedList;

public class CommandInvoker {
	
	LinkedList<Command> commands;
	
	public CommandInvoker(){
		commands = new LinkedList<Command>();
	}
	
	public void execute(Command command){		
		if(command!=null){
			commands.add(command);
			command.execute();
		}		
	}
	
	public void undo(){
		
		Command lastCommand = commands.removeLast();
		
		if(lastCommand != null){
			lastCommand.undo();
		}
	}
	
	public void replay(Command command){
		command.undo();
	}

	public LinkedList<Command> getCommands() {
		return commands;
	}
}

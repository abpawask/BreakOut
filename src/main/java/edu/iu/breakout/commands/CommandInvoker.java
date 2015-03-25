package edu.iu.breakout.commands;

import java.util.LinkedList;

public class CommandInvoker {
	
	private LinkedList<Command> commands;
	
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
		
		if(!commands.isEmpty()){
			Command lastCommand = commands.removeLast();
			
			if(lastCommand != null){
				lastCommand.undo();
			}
		}		
	}
	
	public void replay(Command command){
		if(command!=null){
			command.replay();
		}
	}

	public LinkedList<Command> getCommands() {
		return commands;
	}
}

package edu.iu.breakout.commands;

public interface Command {
	void execute();
	
	void undo();
}

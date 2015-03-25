package edu.iu.breakout.commands;

import edu.iu.breakout.model.Brick;

public class DestroyBrickCommand implements Command {
	
	private Brick brick;
	
	private boolean previousState;
	
	private boolean currentState;
	
	public DestroyBrickCommand(Brick brick){
		this.brick = brick;
		previousState = brick.isDestroyed();
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		brick.setDestroyed(true);
		currentState = true;
	}

	public void undo() {
		// TODO Auto-generated method stub
		brick.setDestroyed(previousState);
	}

	public void replay() {
		// TODO Auto-generated method stub
		brick.setDestroyed(currentState);
	}

}

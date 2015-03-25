package edu.iu.breakout.commands;

import edu.iu.breakout.model.Sprite;

public class UpdateSpriteCommand implements Command {
	
	private Sprite sprite;
	
	private int oldX;
	
	private int oldY;
	
	private int currentX;
	
	private int currentY;
	
	public UpdateSpriteCommand(Sprite sprite){
		this.sprite = sprite;
		oldX = sprite.getX();
		oldY = sprite.getY();
	}

	public void execute() {
		// TODO Auto-generated method stub
		sprite.move();
		currentX = sprite.getX();
		currentY = sprite.getY();
	}

	public void undo() {
		
		sprite.setX(oldX);
		sprite.setY(oldY);
	}

	public void replay() {
		// TODO Auto-generated method stub
		sprite.setX(currentX);
		sprite.setY(currentY);
	}

}

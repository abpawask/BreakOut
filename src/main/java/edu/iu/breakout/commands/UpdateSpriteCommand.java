package edu.iu.breakout.commands;

import edu.iu.breakout.model.Paddle;
import edu.iu.breakout.model.Sprite;

public class UpdateSpriteCommand implements Command {
	
	Sprite sprite;
	
	int oldX;
	
	int oldY;
	
	public UpdateSpriteCommand(Sprite sprite){
		this.sprite = sprite;
		oldX = sprite.getX();
		oldY = sprite.getY();
	}

	public void execute() {
		// TODO Auto-generated method stub
		sprite.move();
	}

	public void undo() {
		
		sprite.setX(oldX);
		sprite.setY(oldY);
	}

}

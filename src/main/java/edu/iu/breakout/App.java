package edu.iu.breakout;

import edu.iu.breakout.controllers.GameEngine;
import edu.iu.breakout.views.BreakoutView;

public class App {

	public void startGame(){
		BreakoutView gameFrame = new BreakoutView();
		
		GameEngine engine = new GameEngine();
		engine.setBreakOutView(gameFrame);
		
		engine.initGame();
		//engine.startGame();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.startGame();

	}

}

package edu.iu.breakout.controllers;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.iu.breakout.commands.Command;
import edu.iu.breakout.commands.CommandInvoker;
import edu.iu.breakout.commands.UpdateSpriteCommand;
import edu.iu.breakout.model.Ball;
import edu.iu.breakout.model.Brick;
import edu.iu.breakout.model.Paddle;
import edu.iu.breakout.model.Sprite;
import edu.iu.breakout.views.BreakoutView;
import edu.iu.breakout.views.ControlPanel;
import edu.iu.breakout.views.GamePanel;

public class GameEngine implements Runnable {

	private BreakoutView breakOutView;
	private ControlPanel controlPanel;
	private JPanel gamePanel;

	private PaddleController paddleController;
	private CollisionController collisionController;

	private CommandInvoker commandInvoker;

	private Paddle paddle;
	private Ball ball;
	private Brick[] bricks;
	
	private Thread gameThread;
	private Thread replayThread;

	boolean runGame;

	public GameEngine() {
		commandInvoker = new CommandInvoker();
	}

	public BreakoutView getBreakOutView() {
		return breakOutView;
	}

	public void setBreakOutView(BreakoutView breakOutView) {
		this.breakOutView = breakOutView;
	}

	public void initGame() {
		initModels();
		initViews();
		breakOutView.setVisible(true);

		paddleController = new PaddleController(paddle, gamePanel);
		collisionController = new CollisionController();
		collisionController.setCommandInvoker(commandInvoker);
		collisionController.setBall(ball);
		collisionController.setPaddle(paddle);
		collisionController.setBricks(bricks);

		JButton startButton = controlPanel.getStartButton();
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});

		JButton pauseButton = controlPanel.getPauseButton();
		pauseButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				runGame = false;
			}
		});

		JButton undoButton = controlPanel.getUndoButton();
		undoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				performUndo();
			}
		});

		JButton replayButton = controlPanel.getReplayButton();
		replayButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startReplay();
			}
		});
	}

	public void startGame() {
		
		paddleController.setFocus();
		runGame = true;

		gameThread = new Thread(this);
		gameThread.start();
	}
	

	private void initModels() {
		paddle = new Paddle();
		
		ball = new Ball();		

		bricks = new Brick[4];
		bricks[0] = new Brick();
		bricks[1] = new Brick();
		bricks[2] = new Brick();
		bricks[3] = new Brick();
		
		resetSprites();
	}

	private void initViews() {
		GamePanel gamePanel = new GamePanel();

		List<Sprite> sprites = new ArrayList<Sprite>();
		sprites.add(paddle);
		sprites.add(ball);

		for (int i = 0; i < bricks.length; i++) {
			sprites.add(bricks[i]);
		}

		gamePanel.setSprites(sprites);
		this.gamePanel = gamePanel;

		controlPanel = new ControlPanel();

		BorderLayout gameFrameLayout = new BorderLayout();
		gameFrameLayout.setVgap(5);

		Container contentPane = breakOutView.getContentPane();
		contentPane.setLayout(gameFrameLayout);
		contentPane.add(gamePanel, BorderLayout.NORTH);
		contentPane.add(controlPanel, BorderLayout.CENTER);
	}
	
	private void resetSprites(){
		paddle.setX(150);
		paddle.setY(300);
		
		ball.setX(140);
		ball.setY(160);
		
		bricks[0].setX(20);
		bricks[0].setY(40);		
		bricks[0].setDestroyed(false);
		
		bricks[1].setX(120);
		bricks[1].setY(40);		
		bricks[1].setDestroyed(false);
		
		bricks[2].setX(20);
		bricks[2].setY(70);		
		bricks[2].setDestroyed(false);
		
		bricks[3].setX(120);
		bricks[3].setY(70);
		bricks[3].setDestroyed(false);
	}

	private void checkCollision() {
		collisionController.handleCollision();
	}

	private void performUndo() {
		commandInvoker.undo();
		gamePanel.repaint();
	}

	private void startReplay() {

		replayThread = new Thread(new Runnable() {

			public void run() {
				performReplay();
			}

		});

		replayThread.start();
	}

	private void performReplay() {
		
		resetSprites();
		LinkedList<Command> commands = commandInvoker.getCommands();

		for (Command command : commands) {
			commandInvoker.replay(command);			
			gamePanel.repaint();

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void run() {

		while (runGame) {

			checkCollision();

			UpdateSpriteCommand updateBallCommand = new UpdateSpriteCommand(
					ball);
			commandInvoker.execute(updateBallCommand);

			UpdateSpriteCommand updatePaddleCommand = new UpdateSpriteCommand(
					paddle);
			commandInvoker.execute(updatePaddleCommand);

			gamePanel.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

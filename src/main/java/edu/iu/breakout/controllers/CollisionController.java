package edu.iu.breakout.controllers;

import edu.iu.breakout.model.Ball;
import edu.iu.breakout.model.Brick;
import edu.iu.breakout.model.Paddle;

public class CollisionController {

	private Ball ball;

	private Paddle paddle;

	private Brick[] bricks;

	private void handleCollisionBetweenBallAndBrick() {

		for (int i = 0; i < bricks.length; i++) {
			if (!bricks[i].isDestroyed()) {
				if (ball.getBoundary().intersects(bricks[i].getBoundary())) {
					bricks[i].setDestroyed(true);
				}
			}
		}

	}

	private void handleCollisionBetweenBallAndPaddle() {

		if (ball.getBoundary().intersects(paddle.getBoundary())) {

			int paddleLeftEnd = (int) paddle.getBoundary().getMinX();
			int paddleRightEnd = (int) paddle.getBoundary().getMaxX();

			int ballLeftEnd = (int) ball.getBoundary().getMinX();
			int ballRightEnd = (int) ball.getBoundary().getMaxX();

			ball.setYdir(-1 * ball.getYdir());

			if (ballLeftEnd <= paddleLeftEnd + 10) {
				ball.setXdir(-1);

			} else if (ballRightEnd >= paddleRightEnd - 10) {
				ball.setXdir(1);

			} else if ((ballLeftEnd >= paddleLeftEnd + 20 && ballLeftEnd <= paddleRightEnd - 20)) {
				ball.setXdir(0);
			}

		}
	}

	public void handleCollision() {
		handleCollisionBetweenBallAndPaddle();
		handleCollisionBetweenBallAndBrick();
	}	

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	
	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}	

	public void setBricks(Brick[] bricks) {
		this.bricks = bricks;
	}

}

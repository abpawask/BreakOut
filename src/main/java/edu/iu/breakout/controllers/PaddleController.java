package edu.iu.breakout.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import edu.iu.breakout.model.Paddle;

public class PaddleController {

	private JPanel gamePanel;

	private Paddle paddle;

	public PaddleController(Paddle paddle, JPanel gamePanel) {
		this.paddle = paddle;
		this.gamePanel = gamePanel;
		this.gamePanel.addKeyListener(new TAdapter());
		setFocus();
	}

	public void setFocus() {
		this.gamePanel.setFocusable(true);
		this.gamePanel.requestFocusInWindow();
	}

	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				paddle.setDx(0);
			}

			if (key == KeyEvent.VK_RIGHT) {
				paddle.setDx(0);
			}
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_LEFT) {
				paddle.setDx(-2);
			}

			if (key == KeyEvent.VK_RIGHT) {
				paddle.setDx(2);
			}
		}

	}
}

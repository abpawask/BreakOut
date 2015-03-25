package edu.iu.breakout.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ControlPanel extends JLabel {

	private JButton startButton;
	
	private JButton pauseButton;
	
	private JButton undoButton;
	
	private JButton replayButton;
	
	public ControlPanel(){
		FlowLayout controlPanelLayout = new FlowLayout();
		setLayout(controlPanelLayout);
		
		startButton = new JButton("Start");
		pauseButton = new JButton("Pause");
		undoButton = new JButton("Undo");
		replayButton = new JButton("Replay");
		
		add(startButton);
		add(pauseButton);
		add(undoButton);
		add(replayButton);
	}



	public JButton getStartButton() {
		return startButton;
	}



	public JButton getPauseButton() {
		return pauseButton;
	}



	public JButton getUndoButton() {
		return undoButton;
	}



	public JButton getReplayButton() {
		return replayButton;
	}
}

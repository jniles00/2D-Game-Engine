package com.window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import com.constants.Constants;

public class Window extends JFrame implements Runnable {

	Graphics2D graphics2D;
	KeyListen keyListener = new KeyListen();

	Rect playerOne;
	Rect playerTwo;
	Rect ball;

	// Initialiser
	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false); // Stops the user from being able to resize the window
		this.setVisible(true); // Sets the window to be visible
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the game when clicking on the X in the top right
		this.addKeyListener(keyListener); // Sets up the Key Listener
		graphics2D = (Graphics2D) this.getGraphics(); // Casting to Graphics2D

		// x = 0, y = 0, width = 30, height = 60, color = white
		playerOne = new Rect(Constants.HORIZONTAL_PADDING, 40, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT,
				Constants.PLAYER_COLOUR);
		playerTwo = new Rect(Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH - Constants.HORIZONTAL_PADDING, 40,
				Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PLAYER_COLOUR);
		ball = new Rect(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, Constants.BALL_WIDTH,
				Constants.BALL_WIDTH, Constants.PLAYER_COLOUR);
	}

	public void Update(double deltaTime) {
		// Setting up the windows colour
		graphics2D.setColor(Color.black);
		graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

		playerOne.drawRect(graphics2D);
		playerTwo.drawRect(graphics2D);
		ball.drawRect(graphics2D);
		
//		if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
//		System.out.println("The player is pressing the up arrow key");
//	} else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
//		System.out.println("The player is pressing down key arrow");
//	}
	}

	@Override
	public void run() {
		double lastFrameTime = 0.0; // Used to judge how much time has passed in between frames
		while (true) {
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime; // Gives us the value of time passed between frames
			lastFrameTime = time; // Gives accurate value of time since the last frame was rendered

			Update(deltaTime);

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
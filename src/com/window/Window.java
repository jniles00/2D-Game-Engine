package com.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import com.constants.Constants;

public class Window extends JFrame implements Runnable {

	public Graphics2D graphics2D;
	public KeyListen keyListener = new KeyListen();
	public PlayerController playerController;

	public Rect playerOne;
	public Rect playerTwo;
	public Rect ball;

	// Initialiser
	public Window() {
		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false); // Stops the user from being able to resize the window
		this.setVisible(true); // Sets the window to be visible
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits the game when clicking on the X in the top right
		this.addKeyListener(keyListener); // Sets up the Key Listener
		Constants.INSETS_TOP = this.getInsets().top; // Gets the position of the top of the window
		Constants.INSETS_BOTTOM = this.getInsets().bottom; // Gets the position of the bottom of the window
		graphics2D = (Graphics2D) this.getGraphics(); // Casting to Graphics2D

		// x = 0, y = 0, width = 30, height = 60, color = white
		playerOne = new Rect(Constants.HORIZONTAL_PADDING, 40, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT,
				Constants.PLAYER_COLOUR);
		playerController = new PlayerController(playerOne, keyListener);

		playerTwo = new Rect(Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH - Constants.HORIZONTAL_PADDING, 40,
				Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PLAYER_COLOUR);
		ball = new Rect(Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT / 2, Constants.BALL_WIDTH,
				Constants.BALL_WIDTH, Constants.PLAYER_COLOUR);
	}

	public void Update(double deltaTime) {

		doubleBuffering();

		playerController.update(deltaTime);

//		if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
//		System.out.println("The player is pressing the up arrow key");
//	} else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
//		System.out.println("The player is pressing down key arrow");
//		}
	}

	// Double buffering technique to smooth out the frame rate
	public void doubleBuffering() {

		// Creates an image and gets the width and height of the image called
		// doubleBufferImage
		Image doubleBufferImage = createImage(getWidth(), getHeight());
		// Draws everything to this graphic which is not displayed to the user, this
		// image is then returned to the screen and drawn to the it. This draws
		// everything incrementally to the screen.
		Graphics doubleBufferGraphics = doubleBufferImage.getGraphics();
		this.draw(doubleBufferGraphics);

		// Draws it at 0, 0 and then "this" tells it to get the width and height
		graphics2D.drawImage(doubleBufferImage, 0, 0, this);
	}

	public void draw(Graphics graphics) {

		// Casting graphics2D to Graphics2D
		Graphics2D graphics2D = (Graphics2D) graphics;

		// Setting up the windows colour
		graphics2D.setColor(Color.black);
		graphics2D.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

		playerOne.drawRect(graphics2D);
		playerTwo.drawRect(graphics2D);
		ball.drawRect(graphics2D);
	}

	@Override
	public void run() {
		double lastFrameTime = 0.0; // Used to judge how much time has passed in between frames
		while (true) {
			double time = Time.getTime();
			double deltaTime = time - lastFrameTime; // Gives us the value of time passed between frames
			lastFrameTime = time; // Gives accurate value of time since the last frame was rendered

			Update(deltaTime);

//			try {
//				Thread.sleep(30);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
}
package com.window;

import java.awt.event.KeyEvent;

import com.constants.Constants;

public class PlayerController {

	public Rect rect;
	public KeyListen keyListener;

	public PlayerController(Rect rect, KeyListen keyListener) {
		this.rect = rect;
		this.keyListener = keyListener;
	}

	// Constructor for the A.I
	public PlayerController(Rect rect) {
		this.rect = rect;
		this.keyListener = null;
	}

	public void update(double deltaTime) {
		// Checks if player is hitting up or down. If not then the AI will move
		if (keyListener != null) {
			// If the player presses the down key
			if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
				MoveDown(deltaTime);
			} else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
				MoveUp(deltaTime);
			}
		}
	}

	public void MoveUp(double deltaTime) {
		// Checks to see if the paddle is touching the top of the window
		if (rect.y - Constants.PLAYER_SPEED * deltaTime > Constants.INSETS_TOP) {
			// Short hand version of the key pressed up
			this.rect.y -= Constants.PLAYER_SPEED * deltaTime; // If up is pressed, then it will move the rectangle up
		}
	}

	public void MoveDown(double deltaTime) {
		if ((rect.y + Constants.PLAYER_SPEED * deltaTime) + rect.height < Constants.SCREEN_HEIGHT
				- Constants.INSETS_BOTTOM) {
			this.rect.y = (double) (this.rect.y + Constants.PLAYER_SPEED * deltaTime); // Then by casting to double, it
																						// will move the // rectangle
																						// down
		}
	}
}
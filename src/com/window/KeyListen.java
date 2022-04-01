package com.window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListen implements KeyListener {

	private boolean keyPressed[] = new boolean[128]; // This variable uses KeyEvents which pulls from 128 ASCII key
														// codes

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		keyPressed[keyEvent.getKeyCode()] = true;

	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		keyPressed[keyEvent.getKeyCode()] = false;

	}
	
	public boolean isKeyPressed(int keyCode) {
		return keyPressed[keyCode];	// returns if the keyPressed is true inside the array
	}
}

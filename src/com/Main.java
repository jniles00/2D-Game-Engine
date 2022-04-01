package com;

import com.window.Window;

public class Main {

	public static void main(String[] args) {
		Window window = new Window(); // In order to have a window there needs to be a thread
		Thread t1 = new Thread(window); // Having a new thread for the window allows it to be put to sleep
		t1.start();

	}
}
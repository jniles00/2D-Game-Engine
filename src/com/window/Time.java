package com.window;

public class Time {

	public static double timeStarted = System.nanoTime();	// Returns the systems current time in nano seconds
	
	public static double getTime() {
		// System.nanoTime returns the value as an Integer, * it by 1E-9 converts it into seconds 
		return (System.nanoTime() - timeStarted) * 1E-9;
	}
}
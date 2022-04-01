package com.window;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rect {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private Color colour;
	
	// Default Constructor
	public Rect() {};
	
	// Constructor
	public Rect(int x, int y, int width, int height, Color colour) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.colour = colour;
	}

	public void drawRect(Graphics2D graphics2d) {
	graphics2d.setColor(colour);	// Sets the colour of the rectangle
	graphics2d.fillRect(x, y, width, height);	// Draws a rectangle  a specified position on the screen
	}
}
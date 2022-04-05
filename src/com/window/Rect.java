package com.window;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Rect {
	
	public double x;
	public double y;
	public double width;
	public double height;
	
	private Color colour;
	
	// Default Constructor
	public Rect() {};
	
	// Constructor
	public Rect(double x, double y, double width, double height, Color colour) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.colour = colour;
	}

	public void drawRect(Graphics2D graphics2d) {
	graphics2d.setColor(colour);	// Sets the colour of the rectangle
	graphics2d.fill(new Rectangle2D.Double(x, y, width, height)); // Draws a rectangle  a specified position on the screen
	}
}
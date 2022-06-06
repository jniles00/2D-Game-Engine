package com.window;

import com.constants.Constants;

public class Ball {
	
	public Rect rect;
	public Rect leftPaddle, rightPaddle;
	
	private double velocityX = -100.0;
	private double velocityY = 10.0;

	public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle) {
		this.rect = rect;
		this.leftPaddle = leftPaddle;
		this.rightPaddle = rightPaddle;
	}

	public void update(double deltaTime) {
		// if the velocity is less than 0 the ball is moving to the left, else it is moving right
		if(velocityX < 0) {
			// Checks if the ball is left and in y range of the paddle, it has hit the paddle
			if(this.rect.x <= this.leftPaddle.x + this.leftPaddle.width && 
					this.rect.x + this.rect.width >= this.leftPaddle.x &&
					this.rect.y >= this.leftPaddle.y && 
					this.rect.y <= this.leftPaddle.y + this.leftPaddle.height) {
				// Change the direction of the ball
				this.velocityX *= -1;
				this.velocityY *= 1;
			} // Check if ball has gone past left paddle, if so displays message
			else if(this.rect.x + this.rect.width < this.leftPaddle.x + this.leftPaddle.height) {
				System.out.println("Player one has lost");
			}
			// Reverse of what is happening above
		} else if(velocityX > 0) {
			if(this.rect.x + this.rect.width >= this.rightPaddle.x &&
					this.rect.x <= this.rightPaddle.x + this.rightPaddle.width &&
					this.rect.y <= this.rightPaddle.y + this.rightPaddle.height) {
				this.velocityX *= -1;
				this.velocityY *= -1;
			} // Same as player one loss message  
			else if(this.rect.x + this.rect.width > this.rightPaddle.x + this.rightPaddle.height) {
				System.out.println("Player two has lost");
			}
		}
		
		// Controls the ball hitting the top/bottom of the screen
		if(velocityY > 0) {
			// if the ball touches the bottom of the screen then it will change direction
			if(this.rect.y + this.rect.height > Constants.SCREEN_HEIGHT) {
				this.velocityY *= -1;
			}
			// Changes direction when touching top of screen
		} else if(velocityY < 0) {
			if(this.rect.y < Constants.INSETS_TOP) {
				this.velocityY *= -1;
			}
		}
		
		// Controls the movement of the ball based on the deltaTime (frame count)
		this.rect.x += velocityX * deltaTime;
		this.rect.y += velocityY * deltaTime;
	}
}
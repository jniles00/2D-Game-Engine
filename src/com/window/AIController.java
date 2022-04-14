package com.window;

public class AIController {
	public PlayerController playerController;
	public Rect ball;

	public AIController(PlayerController playerController, Rect ball) {
		super();
		this.playerController = playerController;
		this.ball = ball;
	}

	public void update(double deltaTime) {
		playerController.update(deltaTime);

		if (ball.y < playerController.rect.y) { // If the ball is lower than the player position then the AI will move
												// up
			playerController.MoveUp(deltaTime);
		} else if (ball.y + ball.height > playerController.rect.y + playerController.rect.height) { // else if the ball is greater than the player
			playerController.MoveDown(deltaTime); 					 // height, it will move down

		}
	}
}
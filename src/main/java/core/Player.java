package core;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class Player {
    private ImageView sprite;
    private double x = 100;
    private double y = 400;
    private double velocityY = 0;
    private boolean jumping = false;

    private final double GRAVITY = 0.5;
    private final double JUMP_FORCE = -10;
    private final double MOVE_SPEED = 5;

    public Player(Pane gamePane) {
        Image image = new Image("sprites/yusuke.png");
        sprite = new ImageView(image);
        sprite.setFitHeight(80);
        sprite.setFitWidth(80);
        sprite.setX(x);
        sprite.setY(y);
        gamePane.getChildren().add(sprite);
    }

    public void update() {
        if (jumping) {
            velocityY += GRAVITY;
            y += velocityY;

            if (y >= 400) {
                y = 400;
                velocityY = 0;
                jumping = false;
            }
        }

        sprite.setX(x);
        sprite.setY(y);
    }

    public void handleKeyPress(KeyCode code) {
        switch (code) {
            case LEFT -> x -= MOVE_SPEED;
            case RIGHT -> x += MOVE_SPEED;
            case SPACE -> {
                if (!jumping) {
                    jumping = true;
                    velocityY = JUMP_FORCE;
                }
            }
        }
    }
}
package ru.nsu.spooky.oop.snakegame;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import static javafx.scene.input.KeyCode.*;

public class Controller {
    private Field field;
    AnimationTimer timer;
    int width = 21;
    int height = 21;
    MainWindow mainWindow;

    public Controller(MainWindow mainWindow) {
        this.field = new Field(width, height);
        this.mainWindow = mainWindow;
    }

    public Field getField() {
        return field;
    }

    public void direction(KeyCode code) {
        if (code == UP && field.snake.getDirection() != Block.DOWN) {
            field.snake.setDirection(Block.UP);
        }
        if (code == DOWN && field.snake.getDirection() != Block.UP) {
            field.snake.setDirection(Block.DOWN);
        }
        if (code == LEFT && field.snake.getDirection() != Block.RIGHT) {
            field.snake.setDirection(Block.LEFT);
        }
        if (code == RIGHT && field.snake.getDirection() != Block.LEFT) {
            field.snake.setDirection(Block.RIGHT);
        }
    }

    public void startTimer() {
        final long[] timeStamp = {System.nanoTime()};
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - timeStamp[0] > field.speed) {

                    field.update();
                    timeStamp[0] = now;

                    if (field.checkCollapse()) {
                        timer.stop();
                        mainWindow.setGameOverAlert();
                    }
                    mainWindow.score.setText("Score: " + field.score);
                }
            }
        };
        timer.start();
    }

}


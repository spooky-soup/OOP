package ru.nsu.spooky.oop.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.input.KeyCode.*;

public class MainWindow extends Application {

    static int block_size = 30;
    public static long speed = 400000000;
    int width = 21;
    int height = 21;
    int startLength = 10;
    Label score;
    Field field;
    VBox root;
    AnimationTimer timer;

    @Override
    public void start(Stage stage) {
        this.root = new VBox(10);
        root.setPadding(new Insets(10));

        this.field = new Field(width, height);
        field.setSnake(new Snake(startLength, field));

        score = new Label("Score: 0");
        score.setFont(Font.font("tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));

        final long[] timeStamp = {System.nanoTime()};
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - timeStamp[0] > speed) {
                    field.update();
                    timeStamp[0] = now;
                    if (field.checkCollapse()) {
                        timer.stop();
                        Alert end = new Alert(Alert.AlertType.INFORMATION);
                        end.setHeaderText("You died...");
                        end.setContentText("Your score: " + field.score);
                        field.setBackground(new Background(new BackgroundFill(Color.SLATEGRAY, null, null)));
                        Platform.runLater(end::showAndWait);
                        end.setOnHidden(e -> {
                            root.getChildren().clear();
                            field = new Field(width, height);
                            field.setSnake(new Snake(startLength, field));
                            score.setText("Score: 0");
                            root.getChildren().addAll(field, score);
                            start();
                        });
                    }
                    score.setText("Score: " + field.score);
                }
            }
        };
        timer.start();
        root.getChildren().addAll(field, score);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == UP && field.snake.getDirection() != Block.DOWN) {
                field.snake.setDirection(Block.UP);
            }
            if (e.getCode() == DOWN && field.snake.getDirection() != Block.UP) {
                field.snake.setDirection(Block.DOWN);
            }
            if (e.getCode() == LEFT && field.snake.getDirection() != Block.RIGHT) {
                field.snake.setDirection(Block.LEFT);
            }
            if (e.getCode() == RIGHT && field.snake.getDirection() != Block.LEFT) {
                field.snake.setDirection(Block.RIGHT);
            }
        });

        stage.setTitle("Snake Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
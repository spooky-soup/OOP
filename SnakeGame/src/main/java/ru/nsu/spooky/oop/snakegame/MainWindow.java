package ru.nsu.spooky.oop.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainWindow extends Application {
    @FXML
    private Button startButton;

    static int INIT_SPEED = 400000000;
    static int INIT_LENGTH = 3;
    static int block_size = 30;
    int width = 21;
    int height = 21;
    Label score;
    Field field;
    VBox root;
    AnimationTimer timer;
    Controller controller;
    Stage globalStage;

    public MainWindow() {
    }

    @Override
    public void start(Stage stage) {
        this.globalStage = stage;
        root = new VBox(10);
        root.setPadding(new Insets(10));

        startButton = new Button();
        startButton.setText("Start game");
        startButton.setAlignment(Pos.CENTER);
        startButton.setOnAction(event -> startGame());

        root.getChildren().add(startButton);
        Scene startScene = new Scene(root);
        stage.setTitle("Snake Game");
        stage.setWidth(width*block_size+20);
        stage.setHeight(height*block_size+100);
        //stage.setResizable(true);
        stage.setScene(startScene);
        stage.show();
    }

    public void startGame() {
        Stage stage = (Stage) startButton.getScene().getWindow();
        root = new VBox();
        root.setPadding(new Insets(10));
        controller = new Controller(this);
        this.field = controller.getField();
        initScore();
        controller.startTimer();

        root.getChildren().addAll(field, score);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(e -> controller.direction(e.getCode()));
        stage.setTitle("Snake Game");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
    }

    public void setGameOverAlert() {
        Alert end = new Alert(Alert.AlertType.INFORMATION);
        end.setHeaderText("You died...");
        end.setContentText("Your score: " + field.score);
        field.setBackground(new Background(new BackgroundFill(Color.SLATEGRAY, null, null)));
        Platform.runLater(end::showAndWait);
        end.setOnHidden(e -> {
            this.root.getChildren().clear();
            field = new Field(width, height);
            score.setText("Score: 0");
            this.root.getChildren().addAll(field, score);
            start(globalStage);
        });
    }

    private void initScore() {
        score = new Label("Score: 0");
        score.setFont(Font.font("tahoma", FontWeight.BOLD, FontPosture.REGULAR, 20));
    }

    public static void main(String[] args) {
        launch();
    }
}
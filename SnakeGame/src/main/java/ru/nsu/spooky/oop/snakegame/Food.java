package ru.nsu.spooky.oop.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Food extends Circle {
    int posX, posY;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Food(int x, int y) {
        super(MainWindow.block_size * 0.5, Color.SALMON);
        posX = x;
        posY = y;

        setTranslateX((posX + 0.5) * MainWindow.block_size);
        setTranslateY((posY + 0.5) * MainWindow.block_size);

        setFill(Color.SALMON);
        setStroke(Color.ORANGE);
    }
}

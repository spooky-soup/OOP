package ru.nsu.spooky.oop.snakegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    int posX, posY;
    int prevX, prevY;
    int maxX, maxY;
    Block prev;
    int direction = UP;
    public Block(int x, int y, Block p, Field field) {
        super(MainWindow.block_size, MainWindow.block_size);
        this.posX = x;
        this.posY = y;
        this.prev = p;
        this.maxX = field.getW();
        this.maxY = field.getH();
        setTranslateX(posX * MainWindow.block_size);
        setTranslateY(posY * MainWindow.block_size);
        this.setFill(Color.CORNFLOWERBLUE);
    }

    public void update() {
        prevX = posX;
        prevY = posY;
        if (prev == null) {
            switch (direction) {
                case UP -> moveUp();
                case DOWN -> moveDown();
                case LEFT -> moveLeft();
                case RIGHT -> moveRight();
            }
        }
        else {
            posX = prev.prevX;
            posY = prev.prevY;
        }
        updatePosition();
    }

    public void updatePosition() {
        setTranslateX(posX * MainWindow.block_size);
        setTranslateY(posY * MainWindow.block_size);
    }

    public void moveUp() {
        posY = posY == 0 ? maxY-1 : posY - 1;
    }

    public void moveDown() {
        posY = posY == maxY-1 ? 0 : posY + 1;
    }

    public void moveLeft() {
        posX = posX == 0 ? maxX - 1 : posX - 1;
    }

    public void moveRight() {
        posX = posX == maxX-1 ? 0 : posX + 1;
    }
}

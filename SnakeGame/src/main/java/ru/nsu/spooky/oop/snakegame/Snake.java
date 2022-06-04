package ru.nsu.spooky.oop.snakegame;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {
    ArrayList<Block> blocks = new ArrayList<>();

    Block head;
    Block tail;

    public Snake(int length, Field field) {
        int startPosX = field.getW() / 2;
        int startPosY = field.getH() / 2;

        head = new Block(startPosX, startPosY, null, field);
        head.setFill(Color.AQUAMARINE);
        blocks.add(head);

        tail = head;

        for (int i = 1; i < length; i++) {
            Block b = new Block(startPosX, startPosY + i, tail, field);
            blocks.add(b);
            tail = b;
        }
    }

    public void setDirection(int dir) {
        head.direction = dir;
    }

    public int getDirection() {
        return head.direction;
    }
}

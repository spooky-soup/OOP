package ru.nsu.spooky.oop.snakegame;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Field extends Pane {

    int height;
    int width;
    public Snake snake;
    public int score;
    public long speed;
    ArrayList<Block> blocks = new ArrayList<>();
    Food food;

    public Field(int w, int h) {
        this.height = h;
        this.width = w;
        this.speed = MainWindow.INIT_SPEED;
        this.score = 0;
        setMinSize(w * MainWindow.block_size, h * MainWindow.block_size);
        setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN, null, null)));
        setBorder(new Border(new BorderStroke(Color.DARKSLATEGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
        this.setSnake(new Snake(MainWindow.INIT_LENGTH, this));
        addFood();
    }

    public void addFood() {
        if (food != null) {
            getChildren().remove(food);
        }
        food = new Food((int) (Math.random() * (width - 2)) + 1, (int) (Math.random() * (height - 2)) + 1);
        //Исключение того, что еда на змейке:
        for (Block b : blocks) {
            if(food.getPosX() == b.posX && food.getPosY() == b.posY) {
                addFood();
                return;
            }
        }
        getChildren().add(food);
    }

    public boolean isEaten(Food food) {
        if (food == null) return false;
        return food.getPosX() == snake.head.posX && food.getPosY() == snake.head.posY;
    }

    public void update() {
        for (Block b : blocks) {
            b.update();
        }
        if (isEaten(food)) {
            score++;
            speed = (speed * 95)/100;
            extendSnake();
            addFood();
        }
    }

    public void setSnake(Snake s) {
        this.snake = s;
        for(Block b : s.blocks) {
            addBlock(b);
        }
    }

    public void extendSnake() {
        Block newTail = new Block(snake.tail.prevX, snake.tail.prevY, snake.tail, this);
        snake.tail = newTail;
        addBlock(newTail);
    }

    public boolean checkCollapse() {
        for (int i = 1; i < blocks.size(); i++) {
            if (snake.head.posX == blocks.get(i).posX & snake.head.posY == blocks.get(i).posY) {
                blocks.get(i).setFill(Color.DARKRED);
                if (food != null) {
                    getChildren().remove(food);
                }
                return true;
            }
        }
        return false;
    }

    private void addBlock(Block b) {
        getChildren().add(b);
        blocks.add(b);
    }

    public int getH() {
        return height;
    }

    public int getW() {
        return width;
    }
}

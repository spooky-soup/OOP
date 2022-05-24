package ru.nsu.fit.pizzeria;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        int ordersLimit = 5;
        int storageLimit = 5;
        Pizzeria pizzeria = new Pizzeria(ordersLimit, storageLimit, 3, 3);
        Thread mainThread = new Thread(pizzeria);
        mainThread.start();
    }
}

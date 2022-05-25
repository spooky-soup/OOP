package ru.nsu.fit.pizzeria;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        int ordersLimit = 5;
        int storageLimit = 5;
        Pizzeria pizzeria = new Pizzeria(new File("initializationData.json"));
        Thread mainThread = new Thread(pizzeria);
        mainThread.start();
    }
}

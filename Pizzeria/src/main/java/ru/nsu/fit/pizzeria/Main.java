package ru.nsu.fit.pizzeria;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> orders = new LinkedBlockingQueue<Integer>();
        BlockingQueue<Integer> storage = new LinkedBlockingQueue<Integer>();
        Pizzeria pizzeria = new Pizzeria(orders, storage, 1, 1);
        Thread mainThread = new Thread(pizzeria);
        mainThread.start();
    }
}

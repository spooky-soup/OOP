package ru.nsu.fit.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pizzeria implements Runnable{
    private AtomicBoolean opened;
    public MyBlockingQueue orders;
    public MyBlockingQueue storage;
    int ordersCount;
    List<Integer> bakersExp;
    List<Integer> couriersSpeed;

    public Pizzeria(int ordersLimit, int storageLimit, int bakersNum, int couriersNum) {
        this.orders = new MyBlockingQueue(ordersLimit);
        this.storage = new MyBlockingQueue(storageLimit);
        this.ordersCount = 0;
        this.opened = new AtomicBoolean(false);
        this.bakersExp = List.of(5, 5, 5);
        this.couriersSpeed = List.of(3, 3, 3);
    }

    public boolean isOpened() {
        return opened.get();
    }

    public void run() {
        opened.set(true);
        System.out.println("Pizzeria is opened!");
        Thread bakerThread = new Thread(new BakerManager(this));
        Thread courierThread = new Thread(new CourierManager(this));
        Thread clientThread = new Thread(new Client(this));
        bakerThread.start();
        clientThread.start();
        courierThread.start();
    }
    public void close() {
        System.out.println("Pizzeria is closed!");
        opened.set(false);
    }
}

package ru.nsu.fit.pizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pizzeria implements Runnable{
    private AtomicBoolean opened;
    public BlockingQueue<Integer> orders;
    public BlockingQueue<Integer> storage;
    int ordersCount;
    List<Integer> bakersExp;
    List<Integer> couriersSpeed;

    public Pizzeria(BlockingQueue<Integer> orders, BlockingQueue<Integer> storage, int bakersNum, int couriersNum) {
        this.orders = orders;
        this.storage = storage;
        this.ordersCount = 0;
        //this.opened.set(true);
        this.opened = new AtomicBoolean(false);
        this.bakersExp = List.of(1);
        this.couriersSpeed = List.of(1);
    }

    public boolean isOpened() {
        return opened.get();
    }

    public void run() {
        //BakerManager bakerManager = new BakerManager(this);
        //CourierManager courierManager = new CourierManager(this);
        //bakerManager.run();
        //courierManager.run();
        //client.run();
        //Client client = new Client(this);
        opened.set(true);
        System.out.println("Pizzeria is opened!");
        Thread bakerThread = new Thread(new BakerManager(this));
        Thread courierThread = new Thread(new CourierManager(this));
        Thread clientThread = new Thread(new Client(this));
        bakerThread.start();
        courierThread.start();
        clientThread.start();
    }
    public void close() {
        System.out.println("Pizzeria is closed!");
        opened.set(false);
    }
}

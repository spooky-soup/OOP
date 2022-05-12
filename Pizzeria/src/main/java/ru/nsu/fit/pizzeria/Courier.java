package ru.nsu.fit.pizzeria;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

class Courier implements Runnable{

    private final BlockingQueue<Integer> storage; //LinkedBlockingDeque()
    boolean isFree;
    final private int carryingTime;
    final private int capacity;

    Courier(Pizzeria pizzeria, int carryingTime, int capacity) {
        this.storage = pizzeria.storage;
        this.carryingTime = carryingTime;
        this.capacity = capacity;
        this.isFree = true;
    }

    @Override
    public void run() {
        ArrayList<Integer> carryOrders = new ArrayList<Integer>();
        this.isFree = false;
        int freeSpace = capacity;
        try {
            while (storage.size() != 0 && freeSpace != 0) {
                int orderNumber = storage.take();
                System.out.println("[order " + orderNumber + "] - carrying");
                carryOrders.add(orderNumber);
                freeSpace = freeSpace - 1;
            }
            Thread.sleep(carryingTime);
            for (int ord : carryOrders) {
                System.out.println("[order " + ord+ "] - carried");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

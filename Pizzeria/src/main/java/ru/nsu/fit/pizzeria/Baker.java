package ru.nsu.fit.pizzeria;

import java.util.concurrent.BlockingQueue;

public class Baker implements Runnable{
    final private BlockingQueue<Integer> storage;
    final private BlockingQueue<Integer> orders;
    //final private Pizzeria pizzeria;
    final private int bakeTime;
    boolean isFree;

    public Baker(Pizzeria pizzeria, int exp) {
        this.storage = pizzeria.storage;
        this.orders = pizzeria.orders;
        bakeTime = 15000/exp;
        this.isFree = true;
    }

    @Override
    public void run() {
        try {
            this.isFree = false;
            int orderNumber = orders.take();
            System.out.println("[order " + orderNumber + "] - baking");
            Thread.sleep(bakeTime);
            storage.add(orderNumber);
            System.out.println("[order " + orderNumber + "] - baked");
            this.isFree = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

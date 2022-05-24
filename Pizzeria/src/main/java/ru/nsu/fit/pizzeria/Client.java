package ru.nsu.fit.pizzeria;

public class Client implements Runnable{
    Pizzeria pizzeria;
    public Client(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }
    int orderCount = 0;
    @Override
    public void run() {
        while(pizzeria.isOpened()) {
            try {
                System.out.println("new order!");
                pizzeria.orders.put(orderCount);
                orderCount++;
                Thread.sleep((int) (Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

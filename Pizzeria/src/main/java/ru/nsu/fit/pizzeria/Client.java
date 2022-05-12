package ru.nsu.fit.pizzeria;

public class Client implements Runnable{
    Pizzeria pizzeria;
    public Client(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }
    @Override
    public void run() {
        while(!pizzeria.isOpened()) {}
        while(pizzeria.isOpened()) {
            try {
                System.out.println("new order!");
                Thread.sleep((int) (Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

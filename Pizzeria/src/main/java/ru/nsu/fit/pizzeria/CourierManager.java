package ru.nsu.fit.pizzeria;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CourierManager implements Runnable{
    final Pizzeria pizzeria;

    public CourierManager(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    @Override
    public void run() {
        int couriersNum = pizzeria.couriersSpeed.size();
        ExecutorService couriersPool = Executors.newFixedThreadPool(couriersNum);
        Courier[] couriers = new Courier[couriersNum];
        for (int i = 0; i < couriersNum; i++) {
            couriers[i] = new Courier(pizzeria, pizzeria.couriersSpeed.get(i), pizzeria.couriersCapacity);
        }

        while (pizzeria.isOpened() || pizzeria.orders.isEmpty()) {
            for (Courier courier : couriers) {
                if (courier.isFree) {
                    couriersPool.submit(courier);
                    break;
                }
            }
        }
        couriersPool.shutdown();
    }

}

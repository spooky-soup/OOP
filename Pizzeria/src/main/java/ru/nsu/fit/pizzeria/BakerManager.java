package ru.nsu.fit.pizzeria;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BakerManager implements Runnable {
    final Pizzeria pizzeria;

    BakerManager(Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
    }

    @Override
    public void run() {
        int bakersNum = pizzeria.bakersExp.size();
        ExecutorService bakersPool = Executors.newFixedThreadPool(bakersNum);
        Baker[] bakers = new Baker[bakersNum];
        for (int i = 0; i < bakersNum; i++) {
            bakers[i] = new Baker(pizzeria, pizzeria.bakersExp.get(i));
        }

        while (pizzeria.isOpened() || !pizzeria.orders.isEmpty()) {
            for (Baker baker : bakers) {
                if (baker.isFree) {
                    bakersPool.submit(baker);
                    break;
                }
            }
        }
        bakersPool.shutdown();
    }
}


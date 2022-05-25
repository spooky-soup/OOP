package ru.nsu.fit.pizzeria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Pizzeria implements Runnable {
    public int couriersCapacity;
    private int storageLimit;
    private int ordersLimit;
    private final AtomicBoolean opened;
    public MyBlockingQueue orders;
    public MyBlockingQueue storage;
    List<Integer> bakersExp;
    List<Integer> couriersSpeed;

    public Pizzeria(File parametersFile) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            PizzeriaParameters params = mapper.readValue(parametersFile, PizzeriaParameters.class);
            this.storageLimit = params.getStorageLimit();
            this.ordersLimit = params.getOrdersLimit();
            this.couriersCapacity = params.getCouriersCapacity();
            this.bakersExp = params.getBakersExp();
            this.couriersSpeed = params.getCouriersSpeed();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.orders = new MyBlockingQueue(ordersLimit);
        this.storage = new MyBlockingQueue(storageLimit);
        this.opened = new AtomicBoolean(false);
    }

        public boolean isOpened () {
            return opened.get();
        }

        public void run () {
            opened.set(true);
            System.out.println("Pizzeria is opened!");
            Thread bakerThread = new Thread(new BakerManager(this));
            Thread courierThread = new Thread(new CourierManager(this));
            Thread clientThread = new Thread(new Client(this));
            bakerThread.start();
            clientThread.start();
            courierThread.start();
        }
        public void close () {
            System.out.println("Pizzeria is closed!");
            opened.set(false);
        }



        static class PizzeriaParameters {
            private int[] bakersExp;
            private int[] couriersSpeed;
            private int couriersCapacity;
            private int storageLimit;
            private int ordersLimit;

            public int getOrdersLimit() {
                return ordersLimit;
            }

            public int getStorageLimit() {
                return storageLimit;
            }

            public List<Integer> getBakersExp() {
                return Arrays.stream(bakersExp).boxed().toList();
            }

            public List<Integer> getCouriersSpeed() {
                return Arrays.stream(couriersSpeed).boxed().toList();
            }

            public int getCouriersCapacity() {
                return couriersCapacity;
            }
    }
}

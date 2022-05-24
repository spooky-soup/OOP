package ru.nsu.fit.pizzeria;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyBlockingQueue {
    private final int limit;
    private final Queue<Integer> queue = new ArrayDeque<>();

    public MyBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void put(Integer item) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        boolean isEmpty = queue.isEmpty();
        queue.add(item);
        if (isEmpty)
            notifyAll();
    }

    public synchronized Integer get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        boolean isFull = isFull();
        Integer item = queue.poll();
        if (isFull)
            notifyAll();
        return item;
    }

    private boolean isFull() {
        return queue.size() == limit;
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

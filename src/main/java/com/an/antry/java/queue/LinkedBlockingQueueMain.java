package com.an.antry.java.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueMain {

    public static void main(String[] args) {
        Basket basket = new Basket();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer("Producer001", basket);
        Producer producer2 = new Producer("Producer002", basket);
        Consumer consumer = new Consumer("Customer001", basket);
        service.submit(producer);
        service.submit(producer2);
        service.submit(consumer);

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdownNow();
    }
}

class Basket {
    BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);

    // Produce apple
    public void produce() throws InterruptedException {
        // If basket is full, wait new position. Put to the tailer
        basket.offer("An apple");
    }

    // Eat apple
    public String consume() throws InterruptedException {
        // If basket is empty, wait have new apple here. Take from the header
        return basket.take();
    }
}

class Producer implements Runnable {
    private String name;
    private Basket basket;

    public Producer(String instance, Basket basket) {
        this.name = instance;
        this.basket = basket;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Farmer produce apple: " + name);
                basket.produce();
                System.out.println("! Finished produce one apple: " + name);
                Thread.sleep(400);
            }
        } catch (InterruptedException ex) {
            System.out.println("Producer Interrupted");
        }
    }
}

class Consumer implements Runnable {
    private String instance;
    private Basket basket;

    public Consumer(String instance, Basket basket) {
        this.instance = instance;
        this.basket = basket;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Customer eat apple: " + instance);
                System.out.println(basket.consume());
                System.out.println("! Finished eat one apple: " + instance);
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Consumer Interrupted");
        }
    }
}
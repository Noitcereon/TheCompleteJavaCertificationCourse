package me.noitcereon.learning.threads;

import me.noitcereon.learning.threads.inventory.InventoryManager;
import me.noitcereon.learning.threads.producer_consumer.Consumer;
import me.noitcereon.learning.threads.producer_consumer.Producer;
import me.noitcereon.learning.threads.producer_consumer_queue.ConsumerWithQueue;
import me.noitcereon.learning.threads.producer_consumer_queue.ProducerWithQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class ThreadingApp {
    public static void main(String[] args) throws InterruptedException {
        introductionToThreads(false);

        introToThreadSafety(false);

        threadSafetyUsingCollections(false);

        producerConsumerPattern(false);

        producerConsumerPatternWithQueue(true);
    }

    private static void producerConsumerPatternWithQueue(boolean shouldRun) {
        if(shouldRun == false) return;
        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<>(5);
        ProducerWithQueue producer = new ProducerWithQueue(questionQueue);
        ConsumerWithQueue consumer = new ConsumerWithQueue(questionQueue);

        Thread producerThread1 = new Thread(producer, "Producer-1");
        Thread consumerThread1 = new Thread(consumer, "Consumer-1");
        Thread producerThread2 = new Thread(producer, "Producer-2");
        Thread consumerThread2 = new Thread(consumer, "Consumer-2");
        producerThread1.start();
        consumerThread1.start();
        producerThread2.start();
        consumerThread2.start();
    }

    /**
     * Method invoking the code made during lesson 53 (lecture 39)
     */
    private static void producerConsumerPattern(boolean shouldRun) {
        if(shouldRun == false) return;
        List<Integer> questionList = new ArrayList<>();
        Thread t1 = new Thread(new Producer(questionList));
        Thread t2 = new Thread(new Consumer(questionList));

        t1.start();
        t2.start();
    }

    @SuppressWarnings({"java:S1604", "java:S125"})
    private static void threadSafetyUsingCollections(boolean shouldRun) throws InterruptedException {
        if(shouldRun == false) return;
        // Key take away: Use thread safe collections, when working multithreaded.
        // Example: CopyOnWriteArrayList in the java.util.concurrent package

        InventoryManager manager = new InventoryManager();

        Thread inventoryTask = new Thread(new Runnable() {
            @Override
            public void run() {
                manager.populateSoldProducts();
            }
        });
        Thread displayTask = new Thread(manager::displaySoldProducts);

        inventoryTask.start();
        // You can use the Thread's .join method to wait until it has completed running.
        // Example: inventoryTask.join();
        Thread.sleep(1000); // Wait a bit so there is something to display...
        displayTask.start();
        Thread.sleep(1000); // Wait a bit more, so there is more to display.
        Thread displayTask2 = new Thread(manager::displaySoldProducts);
        displayTask2.start();
    }

    private static void introToThreadSafety(boolean shouldRun) {
        if(shouldRun == false) return;
        Sequence sequence = new Sequence();

        Worker worker1 = new Worker(sequence);
        worker1.start();

        Worker worker2 = new Worker(sequence);
        worker2.start();
    }

    private static void introductionToThreads(boolean shouldRun) {
        if(shouldRun == false) return;
        System.out.println("Starting thread 1");
        Thread t1 = new Thread(new Task("Thread-A"));
        t1.start();

        System.out.println("Starting thread 2");
        Thread t2 = new Thread(() -> {
            System.out.println("I am an annonymous method, implementing Runnable interface.");
            int sleepMs = 20;
            for(int i=0; i<100;i++){
                try {
                    sleep(sleepMs);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println("number " + i + " - " + Thread.currentThread().getName());
            }
        }); // Can't reuse the same thread instance (t1)
        t2.start();
    }
}


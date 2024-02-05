package me.noitcereon.learning.threads;

import me.noitcereon.learning.threads.inventory.InventoryManager;

import static java.lang.Thread.sleep;

public class ThreadingApp {
    public static void main(String[] args) throws InterruptedException {
        introductionToThreads(false);

        introToThreadSafety(false);

        threadSafetyUsingCollections(true);
    }
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
        // Example: inventoryTask.join(); NOSONAR
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


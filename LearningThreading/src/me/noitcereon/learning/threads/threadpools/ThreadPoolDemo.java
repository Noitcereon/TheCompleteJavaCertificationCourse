package me.noitcereon.learning.threads.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2); // Recycles threads

        Runnable processor = new MessageProcessor(1);
        executor.execute(processor);

        Runnable processor2 = new MessageProcessor(2);
        executor.execute(processor2);

        Runnable processor3 = new MessageProcessor(3);
        executor.execute(processor3);

        Runnable processor4 = new MessageProcessor(4);
        executor.execute(processor4);
        System.out.println("Submitted all tasks. Will commence graceful shutdown.");

        executor.shutdown(); // graceful shutdown by completing accepted tasks before shutdown.
        // executor.shutdownNow(); // Force shutdown, without completing all tasks.
        boolean isExecutorOff = executor.awaitTermination(5, TimeUnit.SECONDS); // Checks if executor is terminated after given timeout.
        if(isExecutorOff) System.out.println("executor is still not off after 5 seconds!");
        int seconds = 5;
        while(executor.isTerminated() == false){
            System.out.println("Executor still running after (" + seconds + "s)");
            Thread.sleep(1000);
            seconds++;
        }
        System.out.println("Executor has shut down.");
    }
}

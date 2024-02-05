package me.noitcereon.learning.threads.producer_consumer_queue;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class ProducerWithQueue implements Runnable {
    private final BlockingQueue<Integer> questionQueue;
    private int questionNo;

    public ProducerWithQueue(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    private void askQuestion(int questionNo) throws InterruptedException {
        boolean questionAdded = questionQueue.offer(questionNo);
        if (!questionAdded) {
            System.out.println(Thread.currentThread().getName() + " is waiting for questions to be answered by Consumer.");
            Thread.sleep(3000);
            this.questionNo--;
        } else {
            System.out.println(Thread.currentThread().getName() + " asked question " + questionNo);
        }
    }

    @Override
    public void run() {
        LocalTime endTime = LocalTime.now().plusSeconds(10);
        while (endTime.isAfter(LocalTime.now())) {
            try {
                synchronized (this) { // This synchronized ensures we CAN have multiple Producers and maintain thread safety.
                    askQuestion(++questionNo);
                }
            } catch (InterruptedException e) {
                e.printStackTrace(); // NOSONAR
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is no longer asking questions");
    }
}

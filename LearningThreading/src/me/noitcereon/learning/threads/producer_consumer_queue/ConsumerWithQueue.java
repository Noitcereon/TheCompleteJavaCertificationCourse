package me.noitcereon.learning.threads.producer_consumer_queue;

import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("CallToPrintStackTrace")
public class ConsumerWithQueue implements Runnable{
    private final BlockingQueue<Integer> questionQueue;

    public ConsumerWithQueue(BlockingQueue<Integer> questionQueue) {
        this.questionQueue = questionQueue;
    }

    private void answerQuestion() throws InterruptedException {
        Integer questionNo = questionQueue.poll(2000, TimeUnit.MILLISECONDS);
        if(questionNo == null){
            System.out.println(Thread.currentThread().getName() + " is waiting for questions from Producer...");
            return;
        }
        System.out.println(Thread.currentThread().getName() + " started handling question " + questionNo);
        Thread.sleep(3000); // simulate taking time to answer question
        System.out.println(Thread.currentThread().getName() + " answered question: " + questionNo);
    }

    @Override
    public void run() {
        LocalTime endTime = LocalTime.now().plusSeconds(30);
        while(LocalTime.now().isBefore(endTime)){
            try {
                synchronized (this){ // Assuming 2 threads are running the same instance this should be thread safe.
                    answerQuestion();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is shutting down and will no longer answer questions.");
    }
}

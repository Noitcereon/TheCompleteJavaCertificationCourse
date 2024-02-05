package me.noitcereon.learning.threads;

import static java.lang.Thread.sleep;

public class ThreadingApp {
    public static void main(String[] args){
        introductionToThreads(false);

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
                }
                System.out.println("number " + i + " - " + Thread.currentThread().getName());
            }
        }); // Can't reuse the same thread instance (t1)
        t2.start();
    }
}

class Task implements Runnable{
    private final String name;
    public Task(String name){
        this.name = name;
    }

    @Override
    public void run(){
        Thread.currentThread().setName(name);
        int sleepMs = 20;
        for(int i=0; i<100;i++){
            try {
                sleep(sleepMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("number " + i + " - " + Thread.currentThread().getName());
        }
    }
}
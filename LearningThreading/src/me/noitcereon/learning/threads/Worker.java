package me.noitcereon.learning.threads;

public class Worker extends Thread {
    Sequence sequence;

    public Worker(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " got value: " + sequence.getNext());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

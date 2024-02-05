package me.noitcereon.learning.threads;

public class Sequence {
    private int value = 0;

    // Synchronized keyword locks the method, so only 1 thread can access the getNext method for this instance.
    public synchronized int getNext() {
        value++;
        return value;
    }
}

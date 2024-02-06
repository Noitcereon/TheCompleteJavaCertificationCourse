package me.noitcereon.learning.threads.threadpools;

public class MessageProcessor implements Runnable{
    private int messageId;

    public MessageProcessor(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " RECEIVED Message '" + messageId + "'");
        respondToMessage(); // make thread sleep to simulate work.
        System.out.println(Thread.currentThread().getName() + " (DONE) Processing Message '" + messageId + "'");
    }

    private void respondToMessage() {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

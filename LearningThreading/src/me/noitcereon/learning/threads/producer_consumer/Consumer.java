package me.noitcereon.learning.threads.producer_consumer;

import java.util.List;

@SuppressWarnings({"java:S2189", "java:S2142"}) // Since they're just example lessons.
public class Consumer implements Runnable {
    private final List<Integer> questionList;

    public Consumer(List<Integer> questionIds) {
        this.questionList = questionIds;
    }

    public void answerQuestion() throws InterruptedException {
        synchronized (questionList) {
            while (questionList.isEmpty()) {
                System.out.println("Waiting for questions to answer");
                questionList.wait();
            }
        }
        synchronized (questionList) {
            Thread.sleep(5000); // simulate working on answering a question. NOSONAR
            System.out.println("ANSWERED Question: " + questionList.remove(0));
            questionList.notify(); // NOSONAR java:S2446
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                answerQuestion();
            }
        } catch (InterruptedException e) {
            // IGNORE.
        }
    }
}

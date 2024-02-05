package me.noitcereon.learning.threads.producer_consumer;

import java.time.LocalTime;
import java.util.List;

@SuppressWarnings({"java:S2189", "java:S2142"}) // Since they're just example lessons.
public class Producer implements Runnable {
    private final List<Integer> questionList;
    private int questionNo;
    static final int LIMIT = 5;

    public Producer(List<Integer> questionIds) {
        this.questionList = questionIds;
    }

    public void readQuestion(int questionNo) throws InterruptedException {
        synchronized (questionList) {
            while (questionList.size() == LIMIT) {
                System.out.println("Questions have piled up... Wait for answers before asking more questions.");
                questionList.wait();
            }
        }
        synchronized (questionList) {
            System.out.println("New question: " + questionNo);
            questionList.add(questionNo);
            Thread.sleep(100); // Calling Thead.sleep() in multithreaded environment can, worse case, cause deadlock NOSONAR
            questionList.notify(); // NOSONAR
        }
    }

    @Override
    public void run() {
        try {
            LocalTime endTime = LocalTime.now().plusSeconds(60);
            while (endTime.isAfter(LocalTime.now())) {
                readQuestion(questionNo++);
            }
        } catch (InterruptedException e) {
            // IGNORE.
        }
    }
}

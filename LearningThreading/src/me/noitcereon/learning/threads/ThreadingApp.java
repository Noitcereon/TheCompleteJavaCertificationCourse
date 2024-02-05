package me.noitcereon.learning.threads;
public class ThreadingApp {
    public static void main(String[] args){
        Task taskRunner = new Task();
        taskRunner.start();
        System.out.println("Hello there!");

        Task taskRunner2 = new Task(); // Can't reuse the same thread instance (taskRunner)
        taskRunner2.start();
    }
}

class Task extends Thread{
    @Override
    public void run(){
        for(int i=0; i<1000;i++){
            System.out.println("number " + i);
        }
    }
}
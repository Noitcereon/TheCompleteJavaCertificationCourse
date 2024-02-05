package me.noitcereon.learning.threads;

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
                Thread.sleep(sleepMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("number " + i + " - " + Thread.currentThread().getName());
        }
    }
}
package dev.yaroslavDraigal.subtask1;

public class Task5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        });

        thread.start();
        thread.interrupt();
    }
}
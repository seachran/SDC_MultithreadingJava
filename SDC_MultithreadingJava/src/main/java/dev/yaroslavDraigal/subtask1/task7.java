package dev.yaroslavDraigal.subtask1;

public class Task7 {
    public static void main(String[] args) {
        Runnable yieldThread = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Yield thread: " + i);
                Thread.yield();
            }
        };

        Runnable normalThread = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Normal thread: " + i);
            }
        };

        new Thread(yieldThread).start();
        new Thread(normalThread).start();
    }
}
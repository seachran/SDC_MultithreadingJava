package dev.yaroslavDraigal.subtask1;

public class Task1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child thread: Line " + i);
            }
        });

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread: Line " + i);
        }
    }
}
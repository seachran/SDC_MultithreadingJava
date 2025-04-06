package dev.yaroslavDraigal.subtask1;

public class Task4 {
    public static void main(String[] args) {
        String[][] messages = {
            {"Thread 1 - A", "Thread 1 - B"},
            {"Thread 2 - A", "Thread 2 - B"},
            {"Thread 3 - A", "Thread 3 - B"},
            {"Thread 4 - A", "Thread 4 - B"},
            {"Thread 5 - A", "Thread 5 - B"},
        };

        for (int i = 0; i < messages.length; i++) {
            final String[] msgs = messages[i];
            new Thread(() -> {
                for (String msg : msgs) {
                    System.out.println(msg);
                }
            }).start();
        }
    }
}
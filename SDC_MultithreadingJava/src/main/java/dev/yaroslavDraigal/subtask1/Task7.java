package dev.yaroslavDraigal.subtask1;

public class Task7 {
    public static void main(String[] args) {
        Runnable yieldThread = () -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                if (i % 100 == 0) {
                    System.out.println("Yield thread: " + i);
                }
                Thread.yield();
            }
            long duration = System.currentTimeMillis() - start;
            System.out.println("Yield thread finished in " + duration + " ms");
        };

        Runnable normalThread = () -> {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                if (i % 100 == 0) {
                    System.out.println("Normal thread: " + i);
                }
            }
            long duration = System.currentTimeMillis() - start;
            System.out.println("Normal thread finished in " + duration + " ms");
        };

        Thread yThread = new Thread(yieldThread, "YieldThread");
        Thread nThread = new Thread(normalThread, "NormalThread");

        yThread.start();
        nThread.start();
    }
}
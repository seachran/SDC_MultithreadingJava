package dev.yaroslavDraigal.subtask1;

class WalkThread implements Runnable {
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (i % 100000 == 0) System.out.println("Walking...");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("WalkThread finished in " + duration + " ms");
    }
}

class TalkThread implements Runnable {
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (i % 100000 == 0) System.out.println("Talking...");
        }
        long duration = System.currentTimeMillis() - start;
        System.out.println("TalkThread finished in " + duration + " ms");
    }
}

public class Task6 {
    public static void main(String[] args) {
        Thread walkMin = new Thread(new WalkThread(), "Min");
        Thread talkMax = new Thread(new TalkThread(), "Max");

        walkMin.setPriority(Thread.MIN_PRIORITY);
        talkMax.setPriority(Thread.MAX_PRIORITY);

        System.out.println("WalkThread priority: " + walkMin.getPriority());
        System.out.println("TalkThread priority: " + talkMax.getPriority());

        walkMin.start();
        talkMax.start();
    }
}
package dev.yaroslavDraigal.subtask1;

class WalkThread implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) System.out.println("Walking...");
    }
}

class TalkThread implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) System.out.println("Talking...");
    }
}

public class Task6 {
    public static void main(String[] args) {
        Thread walkMin = new Thread(new WalkThread(), "Min");
        Thread talkMax = new Thread(new TalkThread(), "Max");

        walkMin.setPriority(Thread.MIN_PRIORITY);
        talkMax.setPriority(Thread.MAX_PRIORITY);

        walkMin.start();
        talkMax.start();
    }
}
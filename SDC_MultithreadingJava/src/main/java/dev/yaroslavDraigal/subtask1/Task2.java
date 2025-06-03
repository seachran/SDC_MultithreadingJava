package dev.yaroslavDraigal.subtask1;

class T1Thread extends Thread {
    public T1Thread(Runnable runnable) {
        super(runnable);
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable is running");
    }
}

public class Task2 {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        T1Thread thread = new T1Thread(runnable);
        thread.start();
    }
}
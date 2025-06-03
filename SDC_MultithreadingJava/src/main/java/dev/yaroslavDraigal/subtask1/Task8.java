package dev.yaroslavDraigal.subtask1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class SharedFlag {
    private boolean flag = false;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition flagChanged = lock.newCondition();

    public void toggle() {
        lock.lock();
        try {
            flag = !flag;
            flagChanged.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public boolean isTrue() {
        lock.lock();
        try {
            return flag;
        } finally {
            lock.unlock();
        }
    }

    public void awaitTrue() throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                flagChanged.await();
            }
        } finally {
            lock.unlock();
        }
    }
}

class Producer extends Thread {
    private final SharedFlag shared;
    private final int delay;

    Producer(SharedFlag shared, int delay) {
        this.shared = shared;
        this.delay = delay;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                shared.toggle();
                TimeUnit.MILLISECONDS.sleep(delay);
            }
        } catch (InterruptedException ignored) {}
    }
}

class Consumer extends Thread {
    private final SharedFlag shared;
    private int countdown;
    private final int interval;

    Consumer(SharedFlag shared, int countdown, int interval) {
        this.shared = shared;
        this.countdown = countdown;
        this.interval = interval;
    }

    public void run() {
        try {
            while (countdown > 0) {
                shared.awaitTrue();
                while (shared.isTrue() && countdown > 0) {
                    System.out.println("Countdown: " + countdown);
                    countdown -= interval;
                    TimeUnit.MILLISECONDS.sleep(interval);
                }
            }
        } catch (InterruptedException ignored) {}
    }
}

public class Task8 {
    public static void main(String[] args) {
        int M = 100;
        int K = 1000;

        SharedFlag shared = new SharedFlag();
        Producer producer = new Producer(shared, M);
        Consumer consumer = new Consumer(shared, K, M / 10);

        producer.start();
        consumer.start();

        try {
            consumer.join();
            producer.interrupt();
        } catch (InterruptedException ignored) {}
    }
}

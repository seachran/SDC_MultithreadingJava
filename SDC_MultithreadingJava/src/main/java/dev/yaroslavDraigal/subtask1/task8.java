package dev.yaroslavDraigal.subtask1;

class Producer extends Thread {
    volatile boolean flag = false;
    int delay;

    Producer(int delay) {
        this.delay = delay;
    }

    public void run() {
        while (true) {
            flag = !flag;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class Consumer extends Thread {
    Producer producer;
    int countdown;
    int interval;

    Consumer(Producer producer, int countdown, int interval) {
        this.producer = producer;
        this.countdown = countdown;
        this.interval = interval;
    }

    public void run() {
        while (countdown > 0) {
            if (producer.flag) {
                System.out.println("Countdown: " + countdown);
                countdown -= interval;
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}

public class Task8 {
    public static void main(String[] args) {
        Producer producer = new Producer(100);
        Consumer consumer = new Consumer(producer, 1000, 100);

        producer.start();
        consumer.start();
    }
}
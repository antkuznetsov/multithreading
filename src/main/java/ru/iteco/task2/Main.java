package ru.iteco.task2;

public class Main {
    public static void main(String[] args) {
        MyBigInteger num = new MyBigInteger();

        Worker[] workers = new Worker[20];

        for (int i = 0; i < 20; i++) {
            workers[i] = new Worker(num);
        }

        for (Worker worker: workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(num.curval().intValue() == 2000);
    }
}
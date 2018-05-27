package ru.iteco.task2;

public class Worker extends Thread {

    private volatile MyBigInteger mbi;

    public Worker(MyBigInteger mbi) {
        this.mbi = mbi;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            mbi.next();
        }
    }
}

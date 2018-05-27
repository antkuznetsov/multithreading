package ru.iteco.task1;

public class Reader extends Thread {

    private Service service;

    public Reader(Service service) {
        this.service = service;
        start();
    }

    @Override
    public void run() {
        System.out.println(service.getData());
    }
}
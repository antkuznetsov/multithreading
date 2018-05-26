package ru.iteco;

import java.util.Map;

public class Reader extends Thread {

    private Service service;

    public Reader(Service service) {
        this.service = service;
        start();
    }

    @Override
    public void run() {
        String data = service.getData();
        System.out.println(data);
    }
}

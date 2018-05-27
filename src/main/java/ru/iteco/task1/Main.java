package ru.iteco.task1;

public class Main {

    public static void main(String[] args) {

        Service service = new Service("data.txt");

        for (int i = 0; i < 10000; i++) {
            new Reader(service);
        }
    }
}
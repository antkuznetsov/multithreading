package ru.iteco;

public class Main {

    public static void main(String[] args) {

        Service service = new Service("C:\\Users\\anton.kuznetsov\\IdeaProjects\\multithreading\\src\\data.txt");

        for (int i = 0; i < 10000; i++) {
            new Reader(service);
        }
    }
}
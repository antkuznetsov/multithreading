package ru.iteco.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private Map<String, String> data = new HashMap<>();
    private volatile AtomicInteger counter = new AtomicInteger(0);

    public Service(String filePath) {

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            String strLine;
            while ((strLine = br.readLine()) != null){
                String[] row = strLine.split("-");
                data.put(row[0], row[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getData() {
        try {
            Thread.sleep(1); // иначе System.out не успевает выводить в правильном виде :)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (counter.get() == 5) {
            System.out.println("Кеш очищен!");
            counter.set(0);
        }
        counter.addAndGet(1);
        return data.toString() + "(" + counter + ")";
    }
}
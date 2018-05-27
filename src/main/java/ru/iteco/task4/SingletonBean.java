package ru.iteco.task4;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean implements MyBean {
    private static int count = 0;

    public SingletonBean() {
        SingletonBean.count++;
        System.out.println(">> SingletonBean created");
    }

    public static int getCount() {
        return count;
    }
}
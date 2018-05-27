package ru.iteco.task4;

import org.springframework.stereotype.Component;

@Component
public class PrototypeBean implements MyBean {
    private static int count = 0;

    public PrototypeBean() {
        PrototypeBean.count++;
        System.out.println(">> PrototypeBean created");
    }

    public static int getCount() {
        return count;
    }
}

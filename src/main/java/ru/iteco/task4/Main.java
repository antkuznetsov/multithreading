package ru.iteco.task4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan
public class Main {

    private static List<MyBean> list = new ArrayList<>();

    @Bean
    @Scope("prototype")
    MyBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    @Scope("singleton")
    MyBean singletonBean() {
        return new SingletonBean();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        for (int i = 0; i < 5; i++) {
            list.add(context.getBean("prototypeBean", PrototypeBean.class));
            list.add(context.getBean("singletonBean", SingletonBean.class));
        }
        System.out.println("------------------------");
        System.out.println("SingletonBean count: " + SingletonBean.getCount());
        System.out.println("PrototypeBean count: " + PrototypeBean.getCount());
    }
}
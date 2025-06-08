package com.chuntang.test;

import com.chuntang.coinfig.MainConfig;
import com.chuntang.coinfig.MainConfig2;
import org.example.Main;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames
             ) {
            System.out.println(name);
        }
    }
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name:beanDefinitionNames
//        ) {
//            System.out.println(name);
//        }
        System.out.println("ioc容器创建完成");
        //默认是单实例
        Object person = applicationContext.getBean("Person");
        Object person2 = applicationContext.getBean("Person");
//        System.out.println(person == person2);
    }
}

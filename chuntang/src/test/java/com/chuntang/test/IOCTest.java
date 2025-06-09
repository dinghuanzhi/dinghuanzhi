package com.chuntang.test;

import com.chuntang.bean.Blue;
import com.chuntang.bean.Person;
import com.chuntang.coinfig.MainConfig;
import com.chuntang.coinfig.MainConfig2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
   @Test
    public void testImport(){
       printBeans(applicationContext);
       Blue bean = applicationContext.getBean(Blue.class);
       System.out.println(bean);
   }
    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames
             ) {
            System.out.println(name);
        }
    }
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

    @Test
    public void test03(){
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType
             ) {
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }
}

package com.chuntang.coinfig;

import com.chuntang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration  //告诉spring这个个配置类
@ComponentScan(value = "com.chuntang",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookSrevice.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class}),
},useDefaultFilters =false)
//@ComponentScan指定要扫描的包
//excludeFilters =Filter[] 指定扫描的时候按照什么规则排除哪些组件
//includeFilters =Filter[] 指定扫描的时候只要哪些组件
//FilterType.ANNOTATION 按照注解
//FilterType.ASSIGNABLE_TYPE 按照给定的类型
//FilterType.ASPECTJ ASPECTJ表达式（不常用）
//FilterType.REGEX 正则表达式 （不常用）
//FilterType.CUSTOM 自定义规则
public class MainConfig {

    @Bean(value = "Person")  //给容器中注册一个bean  类型为返回值的类型  id默认用方法名作为id（原来用xml配置时有类型和id ）
    public Person person01(){
        return new Person("lisi",20,"男");
    }
}

package com.chuntang.coinfig;

import com.chuntang.bean.Person;
import org.springframework.context.annotation.*;

//配置类==配置文件
@Configuration  //告诉spring这个个配置类
public class MainConfig2 {


    //默认是单实例
    /*@Scope调整作用域
    * prototype:多实例 ioc容器启动并不会调用方法放在容器中，而是每次获取的时候才会调用方法创建对象
    * singleton：单实例（默认值）ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器（map.get()）中拿
    * request：同一次请求创建一个实例（web环境）
    * session：同一个session创建一个实例（web环境）
    *
    *
    * 懒加载：
    *       单实例bean：默认容器启动的时候创建对象
    *       懒加载：容器启动的时候不创建对象，第一次使用（获取）Bean时创建对象,并进行初始化
     */
//    @Scope("prototype")
    @Lazy
    @Bean(value = "Person")  //给容器中注册一个bean  类型为返回值的类型  id默认用方法名作为id（原来用xml配置时有类型和id ）
    public Person person(){
        System.out.println("给容器中添加Person....");
        return new Person("zhangsan",25);
    }
}

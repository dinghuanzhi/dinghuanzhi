package com.chuntang.coinfig;

import com.chuntang.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;

/*
*
*bean的生命周期：
*           bean创建 ---- 初始化 ----销毁的过程
* 容器管理bean的生命周期
* 我们可以自定义初始化和销毁方法:容器在bean进行到当前生命周期的时候调我们自定义的初始化和销毁方法
*
* *构造（对象创建）
 *       单实例：在容器启动的时候创建对象
 *       多实例：在每次获取的时候创建对象
 * BeanPostProcess.postProcessBeforeInitialization
 * 初始化：
 *BeanPostProcess.postProcessAfterInitialization
 *      对象创建完成，并赋值好属性，调用初始化方法。。。
 * 销毁：
 *      单实例：容器关闭的时候销毁
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
*
*   1.通过@Bean方法指定初始化initMethod 和 销毁方法destroyMethod
*
*   2.通过让bean实现InitializingBean（定义初始化逻辑），  DisposableBean（定义销毁逻辑）
*
*   3.可以使用JSR250
*     @Postconstruct：在bean创建完成并且属性赋值完成；来执行初始化方法
*     @PreDestory：在容器销毁Bean之前通知我们进行清理工作
*
*   4.BeanPostProcess【interface】：bean的后置处理器
*           在bean初始化前后进行处理工作
*           postProcessBeforeInitialization：在初始化之前工作
*           postProcessAfterInitialization:在初始化之后工作
 */
@ComponentScan("com.chuntang.bean")
@Configuration
public class MainConfigOfLifeCycle {
    //@Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }


}

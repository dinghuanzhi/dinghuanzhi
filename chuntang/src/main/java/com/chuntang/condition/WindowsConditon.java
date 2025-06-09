package com.chuntang.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断系统是否为Windows
public class WindowsConditon implements Condition {
    /*
    *ConditionContext:判断条件能使用的上下文（环境）
    * AnnotatedTypeMetadata：注释信息
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //判断是否windows系统
        //1.能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2.能获取到类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3.获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //3.获取到Bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        //可以判断容器中的注册情况，也可以给容器注册bean
        boolean person = registry.containsBeanDefinition("Person");
        String property = environment.getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}

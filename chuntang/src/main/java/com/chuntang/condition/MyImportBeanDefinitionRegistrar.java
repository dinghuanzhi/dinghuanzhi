package com.chuntang.condition;

import com.chuntang.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /*
    *annotationMetadata:当前类的注解信息
    * BeanDefinitionRegistry:BeanDefinition注册类
    *    把所有需要添加到容器的Bean：调用
    *     BeanDefinitionRegistry.registerBeanDefinition方法自定义手工注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.chuntang.bean.Red");
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.chuntang.bean.Blue");
        if(red&&blue){
            //指定bean的注册信息(bean的类型，bean的scop作用域。。。。 )
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean，指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}

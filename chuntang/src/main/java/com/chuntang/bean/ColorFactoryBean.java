package com.chuntang.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {
    //返回一个color对象,这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean->getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
    //是否为单例
    //返回true：这个bean是单实例，在容器中只会保留一份
    //返回false：代表多实例，每次获取都会创建一个新的
    @Override
    public boolean isSingleton() {
        return false;
    }
}

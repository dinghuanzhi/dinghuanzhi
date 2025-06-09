package com.chuntang.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImoprtSelect implements ImportSelector {

    //返回值就是导入到容器的组件的全类名
    //AnnotationMetadata：当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.chuntang.bean.Blue","com.chuntang.bean.Yellow"};
    }
}

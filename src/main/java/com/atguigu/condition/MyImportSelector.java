package com.atguigu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑,返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是要导入容器中的组件全类名
     *
     * AnnotationMetadata: 当前标注@Import注解的类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //不要返回null,返回空数组
        return new String[]{"com.atguigu.bean.Blue","com.atguigu.bean.Yellow"};
    }
}

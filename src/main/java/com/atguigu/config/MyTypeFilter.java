package com.atguigu.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author Mr.Li
 * @version 1.0
 * @Description:
 * @Modified By:
 * @date 2019/11/30 19:04
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * metadataReader: 读取到的当前正在扫描的类的信息
     * metadataReaderFactory: 可以获取到其他任何类信息的
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的类名
        String className = classMetadata.getClassName();
        System.out.println("类名为: " + className);
        //如果className中只要包含"ao",那么返回true
        if (className.contains("ao")){
            return true;
        }

        //获取当前类资源信息,比如类路径等等
        Resource resource = metadataReader.getResource();
        return false;
    }
}

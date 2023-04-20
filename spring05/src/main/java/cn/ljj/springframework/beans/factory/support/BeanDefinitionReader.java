package cn.ljj.springframework.beans.factory.support;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.core.io.Resource;
import cn.ljj.springframework.core.io.ResourceLoader;

/**
 * 用于bean定义读取器的简单接口
 * @author LJJ
 * @date 2023/4/20 15:46
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource)throws BeansException;

    void loadBeanDefinitions(Resource... resources)throws BeansException;

    void loadBeanDefinitions(String location)throws BeansException;
}

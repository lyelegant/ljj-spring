package cn.ljj.springframework.beans.factory.config;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改BeanDefinition属性信息
 * @author LJJ
 * @date 2023/4/23 15:50
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的BeanDefinition加载完成之后，实例化Bean对象之前，提供修改BeanDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}

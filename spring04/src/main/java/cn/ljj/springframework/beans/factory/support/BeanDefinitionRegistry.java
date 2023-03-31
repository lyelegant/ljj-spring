package cn.ljj.springframework.beans.factory.support;

import cn.ljj.springframework.beans.factory.config.BeanDefinition;

/**
 * bean定义注册器
 * @author LJJ
 * @date 2023/3/28 10:10
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 beanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}

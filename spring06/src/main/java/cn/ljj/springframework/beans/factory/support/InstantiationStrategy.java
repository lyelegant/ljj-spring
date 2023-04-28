package cn.ljj.springframework.beans.factory.support;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean 实例化策略
 * @author LJJ
 * @date 2023/3/28 14:17
 */
public interface InstantiationStrategy {

    /**
     * 实例化策略，交由具体实现类处理（可能有多种实例化方式：jdk实例化、cglib实例化）
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiation(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}

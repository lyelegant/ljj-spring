package cn.ljj.springframework.beans.factory.config;

import cn.ljj.springframework.beans.BeansException;

/**
 * 用于修改新实例化Bean 对象的扩展点
 * @author LJJ
 * @date 2023/4/23 15:56
 */
public interface BeanPostProcessor {

    /**
     * Bean 对象执行初始化之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * Bean 对象执行初始化之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException;
}

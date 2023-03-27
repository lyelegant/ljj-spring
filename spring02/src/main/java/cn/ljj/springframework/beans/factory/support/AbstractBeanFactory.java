package cn.ljj.springframework.beans.factory.support;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.BeanFactory;
import cn.ljj.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author ljj
 * @date 2023/3/26 18:09
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        // 如果存在bean对象直接返回
        if (Objects.nonNull(bean)){
            return bean;
        }
        // 获取bean定义信息
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);
    }

    /**
     * 获取bean定义信息
     * 具体获取定义信息交给子类实现
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建bean
     * 如何创建通过子类具体实现并返回bean对象
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}

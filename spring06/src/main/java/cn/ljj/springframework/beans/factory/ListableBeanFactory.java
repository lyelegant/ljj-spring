package cn.ljj.springframework.beans.factory;

import cn.ljj.springframework.beans.BeansException;

import java.util.Map;

/**
 * bean工厂实现扩展的接口{@link BeanFactory}
 * 枚举其所有的bean实例，而不是bean查找
 * 按名称逐一列出，BeanFactory实现
 * 预加载所有bean定义（例如XML的工厂）可以实现
 * @author LJJ
 * @date 2023/4/23 16:17
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回Bean实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}

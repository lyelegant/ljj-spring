package cn.ljj.springframework.beans.factory.config;

import cn.ljj.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 配置接口将由其他bean工厂实现
 * 提供除bean工厂之外，配置bean工厂的设施BeanFactory中的客户端方法
 * 接口
 * @author LJJ
 * @date 2023/4/23 15:54
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}

package cn.ljj.springframework.beans.factory;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.ljj.springframework.beans.factory.config.BeanDefinition;
import cn.ljj.springframework.beans.factory.config.BeanPostProcessor;
import cn.ljj.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 配置接口将由其他可列表的bean工厂实现
 * 除了ConfigurationBeanFactory之外，还分析和修改bean定义，并预实例化singleton
 * @author LJJ
 * @date 2023/4/23 16:25
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName)throws BeansException;

    void preInstantiateSingletons()throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}

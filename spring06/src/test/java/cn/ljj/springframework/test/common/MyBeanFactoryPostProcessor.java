package cn.ljj.springframework.test.common;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.PropertyValue;
import cn.ljj.springframework.beans.PropertyValues;
import cn.ljj.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ljj.springframework.beans.factory.config.BeanDefinition;
import cn.ljj.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author LJJ
 * @date 2023/4/24 17:10
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：字节跳动"));
    }
}

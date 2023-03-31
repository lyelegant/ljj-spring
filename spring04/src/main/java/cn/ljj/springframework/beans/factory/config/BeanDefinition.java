package cn.ljj.springframework.beans.factory.config;

import cn.ljj.springframework.beans.PropertyValues;

/**
 * bean 定义信息
 * 
 * @author ljj
 * @date 2023/3/26 17:39
 */
@SuppressWarnings("rawtypes")
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null? propertyValues : new PropertyValues();
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}

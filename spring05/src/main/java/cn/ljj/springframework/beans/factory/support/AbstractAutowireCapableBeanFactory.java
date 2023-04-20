package cn.ljj.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.PropertyValue;
import cn.ljj.springframework.beans.PropertyValues;
import cn.ljj.springframework.beans.factory.config.BeanDefinition;
import cn.ljj.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author LJJ
 * @date 2023/3/28 10:02
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 采用cglib  SimpleInstantiationStrategy
     */
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition,beanName,args);
            // bean填充属性
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructorToUse = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors){
            // 入参不为空，且和构造方法入参长度相同。赋值该构造器
            if (Objects.nonNull(args) && ctor.getParameterTypes().length == args.length){
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiation(beanDefinition,beanName,constructorToUse,args);
    }

    /**
     * bean 属性填充
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (Objects.nonNull(propertyValues)){
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()){
                    String name = propertyValue.getName();
                    Object value = propertyValue.getValue();
                    if (value instanceof BeanReference){
                        // a 依赖 b,获取 b 的实例化
                        BeanReference beanReference = (BeanReference) value;
                        value = getBean(beanReference.getBeanName());
                    }
                    // 属性填充
                    BeanUtil.setFieldValue(bean,name,value);
                }
            }
        }catch (Exception e){
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

package cn.ljj.springframework.beans.factory.config;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.BeanFactory;

/**
 * BeanFactory 的扩展
 * 接口将由能够自动布线，前提为现有的Bean实例
 * @author LJJ
 * @date 2023/4/23 16:26
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcessors接口实现类的 postProcessBeforeInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)throws BeansException;

    /**
     * 执行BeanPostProcessors接口实现类的 postProcessAfterInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)throws BeansException;

}

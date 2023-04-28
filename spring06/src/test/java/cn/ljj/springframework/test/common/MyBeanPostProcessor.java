package cn.ljj.springframework.test.common;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.config.BeanPostProcessor;
import cn.ljj.springframework.test.bean.UserService;

/**
 * @author LJJ
 * @date 2023/4/24 17:07
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

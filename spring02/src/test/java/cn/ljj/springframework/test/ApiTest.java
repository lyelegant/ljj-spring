package cn.ljj.springframework.test;

import cn.ljj.springframework.beans.factory.config.BeanDefinition;
import cn.ljj.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ljj.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 简单bean容器
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        // 初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 第一次获取bean
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryInfo();
        // 第二次获取bean
        UserService userService2 = (UserService)beanFactory.getBean("userService");
        userService.queryInfo();
        // 两次获取都是同一个对象
        System.out.println(userService.equals(userService2));
    }
}

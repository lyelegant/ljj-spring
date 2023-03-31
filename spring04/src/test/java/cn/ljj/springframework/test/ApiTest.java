package cn.ljj.springframework.test;

import cn.ljj.springframework.beans.PropertyValue;
import cn.ljj.springframework.beans.PropertyValues;
import cn.ljj.springframework.beans.factory.config.BeanDefinition;
import cn.ljj.springframework.beans.factory.config.BeanReference;
import cn.ljj.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ljj.springframework.test.bean.UserDao;
import cn.ljj.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 简单bean容器
 */
public class ApiTest {

    @Test
    public void testBeanFactory(){
        // 初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // UserService 设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        // UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}

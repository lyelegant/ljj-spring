package cn.ljj.springframework.test;

import cn.ljj.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ljj.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.ljj.springframework.test.bean.UserService;
import cn.ljj.springframework.test.common.MyBeanFactoryPostProcessor;
import cn.ljj.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactoryAndBean_PostProcessor(){
        // 初始化 beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 读取配置文件&注册Bean
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
        // BeanDefinition加载完成&Bean实例化之前，修改BeanDefinition的属性值
        MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        myBeanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        // Bean实例化之后，修改Bean属性信息
        MyBeanPostProcessor myBeanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(myBeanPostProcessor);
        // 获取Bean对象调用
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }
}

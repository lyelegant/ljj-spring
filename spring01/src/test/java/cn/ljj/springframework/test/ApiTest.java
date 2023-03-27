package cn.ljj.springframework.test;

import cn.ljj.springframework.BeanDefinition;
import cn.ljj.springframework.BeanFactory;
import cn.ljj.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 简单bean容器
 */
public class ApiTest {

    @Test
    public void test(){
        BeanFactory beanFactory = this.loading();
        // 从bean工厂中获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryInfo();

    }

    /**
     * 获取bean工厂，并加载注册bean
     * @return
     */
    private BeanFactory loading(){
        BeanFactory beanFactory = new BeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        return beanFactory;
    }
}

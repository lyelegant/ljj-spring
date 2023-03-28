package cn.ljj.springframework.test;

import cn.ljj.springframework.beans.factory.config.BeanDefinition;
import cn.ljj.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ljj.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        // 获取bean
        UserService userService = (UserService)beanFactory.getBean("userService","Jason");
        userService.queryInfo();
    }

    /**
     * 无构造函数
     */
    @Test
    public void testNewInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    /**
     * 有构造函数
     * @throws Exception
     */
    @Test
    public void testConstructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService user = declaredConstructor.newInstance("小飞棍");
        System.out.println(user);
    }

    /**
     * 获取构造函数信息
     * @throws Exception
     */
    @Test
    public void testParameterTypes()throws Exception{
        Class<UserService> userServiceClass = UserService.class;
        Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[1];
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService jason = declaredConstructor.newInstance("Jason");
        System.out.println(jason);
    }

    /**
     * Cglib 实例化
     */
    @Test
    public void testCglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object o = enhancer.create(new Class[]{String.class},new Object[]{"张三"});
        System.out.println(o);
    }
}

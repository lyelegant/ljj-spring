package cn.ljj.springframework.beans.factory.config;

/**
 * 单例注册bean
 * @author ljj
 * @date 2023/3/26 17:42
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}

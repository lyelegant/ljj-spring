package cn.ljj.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean工厂
 */
@SuppressWarnings({ "all" })
public class BeanFactory {

    /** 线程安全的hashmap **/
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}

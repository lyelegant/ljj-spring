package cn.ljj.springframework.beans.factory.config;

/**
 * bean 定义信息
 * 
 * @author ljj
 * @date 2023/3/26 17:39
 */
@SuppressWarnings("rawtypes")
public class BeanDefinition {

    private Class beanClass;

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
}

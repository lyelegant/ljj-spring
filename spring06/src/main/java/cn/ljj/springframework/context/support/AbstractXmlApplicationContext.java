package cn.ljj.springframework.context.support;

import cn.ljj.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.ljj.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @link-ApplicationContext 方便基类实现，从包含bean定义的Xml文档配置
 * 通过 @link-XmlBeanDefinitionReader 理解
 * @author LJJ
 * @date 2023/4/24 16:28
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}

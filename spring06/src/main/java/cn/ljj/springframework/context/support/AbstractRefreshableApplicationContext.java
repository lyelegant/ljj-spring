package cn.ljj.springframework.context.support;

import cn.ljj.springframework.beans.BeansException;
import cn.ljj.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.ljj.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author LJJ
 * @date 2023/4/24 10:17
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}

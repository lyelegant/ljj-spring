package cn.ljj.springframework.context.support;

import cn.ljj.springframework.beans.BeansException;

/**
 * 独立的XML应用程序上下文，采用上下文定义文件从类路径，将普通路径解释为类路径资源名称
 * 包括包路径（例如“mypackage/myresource.txt”）测试工具以及嵌入JAR中的应用程序上下文。
 * XML 文件应用上下文
 * @author LJJ
 * @date 2023/4/24 16:58
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {

    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     * @param configLocation
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    /**
     * 从XML中加载BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }
}

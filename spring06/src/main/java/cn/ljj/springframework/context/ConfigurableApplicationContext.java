package cn.ljj.springframework.context;

import cn.ljj.springframework.beans.BeansException;

/**
 * 配置应用程序上下文的工具中的应用程序上下文客户端方法
 * @link ApplicationContext 接口
 * @author LJJ
 * @date 2023/4/24 9:43
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}

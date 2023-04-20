package cn.ljj.springframework.beans.factory;

import cn.ljj.springframework.beans.BeansException;

/**
 * bean工厂
 * @author ljj
 * @date 2023/3/26 17:29
 */
public interface BeanFactory {

    /**
     * 根据名称获取bean对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据名称获取bean对象，包含有参构造方法
     * @param name
     * @param arg
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... arg) throws BeansException;
}

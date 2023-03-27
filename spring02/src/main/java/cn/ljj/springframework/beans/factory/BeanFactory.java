package cn.ljj.springframework.beans.factory;

import cn.ljj.springframework.beans.BeansException;

/**
 * bean工厂
 * @author ljj
 * @date 2023/3/26 17:29
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}

package cn.ljj.springframework.beans.factory.config;

/**
 * bean 的引用
 * @author LJJ
 * @date 2023/3/29 16:51
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

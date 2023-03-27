package cn.ljj.springframework;

/**
 * bean信息
 * 用于保存bean的信息
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return this.bean;
    }
}

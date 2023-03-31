package cn.ljj.springframework.beans;

/**
 * 定义bean异常
 * @author ljj
 * @date 2023/3/26 17:27
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

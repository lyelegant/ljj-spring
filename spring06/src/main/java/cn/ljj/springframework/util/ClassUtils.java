package cn.ljj.springframework.util;

/**
 * @author LJJ
 * @date 2023/4/20 14:52
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable ex){
            // 无法访问线程上下文ClassLoader - 正在回退到系统类加载器。。。
        }
        if (cl == null){
            // 没有线程上下文类加载器->使用该类的类加载器
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}

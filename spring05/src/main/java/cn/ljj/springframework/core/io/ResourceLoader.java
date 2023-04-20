package cn.ljj.springframework.core.io;

/**
 * 资源获取接口，传递location地址
 * @author LJJ
 * @date 2023/4/20 15:15
 */
public interface ResourceLoader {

    /**
     * 用于从类路径加载的伪URL前缀：“classpath：”
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}

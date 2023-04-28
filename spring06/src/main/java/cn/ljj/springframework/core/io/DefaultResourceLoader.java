package cn.ljj.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author LJJ
 * @date 2023/4/20 15:18
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"Location must not be null");
        // 字符串是否包含该前缀
        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            // 包含使用当前项目下的资源
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                // 使用http方式获取资源
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 如果http方式获取报错则表示是本地其他路径下的资源
                return new FileSystemResource(location);
            }
        }
    }
}

package cn.ljj.springframework.core.io;

import cn.hutool.core.lang.Assert;
import cn.ljj.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过类加载器读取ClassPath下的文件信息
 * @author LJJ
 * @date 2023/4/20 14:48
 */
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,(ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path,"Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null? classLoader: ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // 主要读取过程
        InputStream stream = classLoader.getResourceAsStream(path);
        if (stream == null){
            throw new FileNotFoundException(this.path+" cannot be opened because it don`t exist");
        }
        return stream;
    }
}

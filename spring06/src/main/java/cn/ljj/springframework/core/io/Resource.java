package cn.ljj.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源处理器
 * @author LJJ
 * @date 2023/4/20 14:47
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}

package cn.ljj.springframework.beans;

/**
 * bean 属性信息
 * @author LJJ
 * @date 2023/3/29 16:35
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

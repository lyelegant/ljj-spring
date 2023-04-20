package cn.ljj.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LJJ
 * @date 2023/3/29 16:38
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : this.propertyValueList){
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }
}

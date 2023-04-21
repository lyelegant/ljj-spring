package cn.ljj.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LJJ
 * @date 2023/3/29 17:02
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "阿杰");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}

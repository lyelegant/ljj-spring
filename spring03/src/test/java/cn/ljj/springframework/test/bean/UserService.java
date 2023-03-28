package cn.ljj.springframework.test.bean;

public class UserService {

    private String name;

    public UserService(){
        this.name = "无";
    }

    public UserService(String name){
        this.name = name;
    }

    public void queryInfo(){
        System.out.println("用户信息载入中，"+this.name+"来咯");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}

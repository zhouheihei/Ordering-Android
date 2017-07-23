package app.nosleep.com.model;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午9:42
 * author:zzh
 * override:用户信息实体类
 */

public class UserInfoModel {
    private int userinfoId;     //用户id
    private String userinfoName;//用户名
    private String userinfoPwd; //用户密码

    public int getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(int userinfoId) {
        this.userinfoId = userinfoId;
    }

    public String getUserinfoName() {
        return userinfoName;
    }

    public void setUserinfoName(String userinfoName) {
        this.userinfoName = userinfoName;
    }

    public String getUserinfoPwd() {
        return userinfoPwd;
    }

    public void setUserinfoPwd(String userinfoPwd) {
        this.userinfoPwd = userinfoPwd;
    }
}

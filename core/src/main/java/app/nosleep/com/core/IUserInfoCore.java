package app.nosleep.com.core;

import java.util.List;

import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午9:11
 * author:zzh
 * override:
 */

public interface IUserInfoCore {
    void add(String username,String userpwd,ActionCallBackListener<String> listener);

    void update(String id,String username,String userpwd,ActionCallBackListener<String> listener);
    void delete(String id,ActionCallBackListener<String> listener);
    void queryByAll(ActionCallBackListener<List<UserInfoModel>> listener);
    void queryById(String id,ActionCallBackListener<UserInfoModel> listener);
    void queryByNameAndPwd(String username,String userpwd,ActionCallBackListener<UserInfoModel> listener);
    void queryByLogin(String username,String userpwd,ActionCallBackListener<UserInfoModel> listener);
}

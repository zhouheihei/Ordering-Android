package app.nosleep.com.api;

import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午11:09
 * author:zzh
 * override:
 */

public interface IUserInfoApi {
    /**
     * 添加用户
     * @param user 用户对象
     */
    void add(UserInfoModel user,ApiCallBackCroe<Void> callback);

    /**
     * 更新用户信息
     * @param user   用户对象
     */
    void update(UserInfoModel user,ApiCallBackCroe<Void> callback);

    /**
     * 删除用户
     * @param userid 用户ID
     */
    void delete(int userid,ApiCallBackCroe<Void> callback);

    /**
     * 根据用户ID查询用户信息
     * @param id    用户ID
     * @return  用户我对象,否则为ＮＵＬＬ
     */
    void queryByUserId(String id,ApiCallBackCroe<UserInfoModel> callback);

    /**
     * 根据用户名和密码查询用户信息
     * @param name  用户名
     * @param pwd   用户密码
     * @return      用户对象
     */
    void queryByNameAndPwd(String name,String pwd,ApiCallBackCroe<UserInfoModel> callback);

    /**
     * 用户登陆验证
     * @param name    用户名
     * @param pwd     用户密码
     * @return        false 失败,true 成功
     */
    void userLogin(String name,String pwd,ApiCallBackCroe<Void> callback);

    /**
     * 根据SQL查询用户信息
     * @param sql
     * @return  用户集合
     */
    void queryBySql(String sql);

    /**
     * 查询所有用户
     * @return 用户集合
     */
    void queryByAll(ApiCallBackCroe<UserInfoModel> callback);

}

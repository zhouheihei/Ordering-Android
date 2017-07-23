package app.nosleep.com.core;

import android.content.Context;

import java.util.List;

import app.nosleep.com.api.IUserInfoApi;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.api.mysql.UserInfoApiImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午10:51
 * author:zzh
 * override:
 */

public class UserInfoCoreImpl implements IUserInfoCore{
    private Context mContext;
    private IUserInfoApi mApi;
    public UserInfoCoreImpl(Context pContext){
        this.mContext=pContext;
        mApi=new UserInfoApiImpl(mContext);
    }

    @Override
    public void add(String username, String userpwd, final ActionCallBackListener<String> listener) {
        UserInfoModel user= new UserInfoModel();
        user.setUserinfoName(username);
        user.setUserinfoPwd(userpwd);
        mApi.add(user, new ApiCallBackCroe<Void>() {
            @Override
            public void onSuccess(Response<Void> Data) {
                if(Data.getEvent()==110){
                    listener.onFailure("error","网络繁忙，请稍后再试！");
                }else {
                    listener.onSuccess(Data.getMsg());
                }

            }

            @Override
            public void onFailure(int errorEvent, String message) {
                listener.onFailure(errorEvent+"",message);
            }
        });
    }

    @Override
    public void update(String id, String username, String userpwd, ActionCallBackListener<String> listener) {

    }

    @Override
    public void delete(String id, ActionCallBackListener<String> listener) {

    }

    @Override
    public void queryByAll(ActionCallBackListener<List<UserInfoModel>> listener) {

    }

    @Override
    public void queryById(String id, ActionCallBackListener<UserInfoModel> listener) {

    }

    @Override
    public void queryByNameAndPwd(String username, String userpwd, ActionCallBackListener<UserInfoModel> listener) {

    }

    @Override
    public void queryByLogin(String username, String userpwd, final ActionCallBackListener<UserInfoModel> listener) {
        mApi.queryByNameAndPwd(username, userpwd, new ApiCallBackCroe<UserInfoModel>() {
            @Override
            public void onSuccess(Response<UserInfoModel> Data) {
                if(Data.getEvent()==110){
                    listener.onFailure("error","网络繁忙，请稍后再试！");
                }else {
                    listener.onSuccess(Data.getObj());
                }
            }

            @Override
            public void onFailure(int errorEvent, String message) {
                listener.onFailure(errorEvent+"",message);
            }
        });
    }

    //    public void add(UserInfoModel user){
//        mApi.add(user,null);
//    }
//
//    @Override
//    public void add(String username, String userpwd) {
//        try{
//            UserInfoModel user= new UserInfoModel();
//            user.setUserinfoName(username);
//            user.setUserinfoPwd(userpwd);
//            mApi.add(user,null);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(String id, String username, String userpwd) {
//        try{
//            UserInfoModel user = new UserInfoModel();
//            user.setUserinfoId(Integer.getInteger(id));
//            user.setUserinfoName(username);
//            user.setUserinfoPwd(userpwd);
//            mApi.update(user,null);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(String id) {
//        try {
//            mApi.delete(Integer.getInteger(id),null);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<UserInfoModel> queryByAll() {
//        return mApi.queryByAll(null);
//    }
//
//    @Override
//    public UserInfoModel queryById(String id) {
//        return mApi.queryByUserId(id,null);
//    }
//
//    @Override
//    public UserInfoModel queryByNameAndPwd(String username, String userpwd) {
//        return mApi.queryByNameAndPwd(username,userpwd,null);
//    }
//
//    @Override
//    public boolean queryByLogin(String username, String userpwd) {
//        return mApi.userLogin(username,userpwd,null);
//    }
}

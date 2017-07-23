package app.nosleep.com.api;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午10:33
 * author:zzh
 * override:用户信息数据库操作类
 */

public class UserInfoApiImpl implements IUserInfoApi{
    @Override
    public void add(UserInfoModel user, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void update(UserInfoModel user, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void delete(int userid, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void queryByUserId(String id, ApiCallBackCroe<UserInfoModel> callback) {

    }

    @Override
    public void queryByNameAndPwd(String name, String pwd, ApiCallBackCroe<UserInfoModel> callback) {

    }

    @Override
    public void userLogin(String name, String pwd, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void queryBySql(String sql) {

    }

    @Override
    public void queryByAll(ApiCallBackCroe<UserInfoModel> callback) {

    }

    //    private Context mContext;
//    private BaseSQLiteOpenHelper mBSOH;
//
//    public UserInfoApiImpl(Context pContext){
//        this.mContext=pContext;
//        this.mBSOH=new BaseSQLiteOpenHelper(mContext);
//    }
//
//    public void add(UserInfoModel user,null){
//        String sql ="insert into tb_userinfo(userinfoname,userinfopwd) values('"
//                +user.getUserinfoName()+"','"
//                +user.getUserinfoPwd()+"')";
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void update(UserInfoModel user) {
//        String sql ="update tb_userinfo set "+
//                "userinfoname="+user.getUserinfoName()+
//                ",userinfopwd="+user.getUserinfoPwd()+
//                " where userinfoid="+user.getUserinfoId();
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void delete(int userid) {
//        String sql ="delete tb_userinfo where userinfoid="+userid;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public UserInfoModel queryByUserId(String id) {
//        String sql ="select * from tb_userinfo where userinfoid="+id;
//        List<UserInfoModel> list= this.queryBySql(sql);
//        if(list.size()>0){
//            return list.get(0);
//        }
//        return  null;
//    }
//
//    @Override
//    public UserInfoModel queryByNameAndPwd(String name, String pwd) {
//        String sql = "select * from tb_userinfo where userinfoname='"+
//                name+"' and userinfopwd='"+
//                pwd+"'";
//        Log.v("API",sql);
//        List<UserInfoModel> list =this.queryBySql(sql);
//        if(null!=list&&list.size()>0){
//            return list.get(0);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean userLogin(String name, String pwd) {
//        if(this.queryByNameAndPwd(name,pwd)!=null){
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public List<UserInfoModel> queryBySql(String sql) {
//        Log.v("API",""+sql);
//        Cursor c=mBSOH.getBySql(sql);
//        List<UserInfoModel> list = new ArrayList<>();
//        while (c.moveToNext()){
//            UserInfoModel _user = new UserInfoModel();
//            _user.setUserinfoId(c.getInt(c.getColumnIndex("userinfoId")));
//            _user.setUserinfoName(c.getString(c.getColumnIndex("userinfoName")));
//            _user.setUserinfoPwd(c.getString(c.getColumnIndex("userinfoPwd")));
//            list.add(_user);
//        }
//        return list;
//    }
//
//    @Override
//    public List<UserInfoModel> queryByAll() {
//        String sql ="select * from tb_userinfo";
//        return  this.queryBySql(sql);
//    }

}

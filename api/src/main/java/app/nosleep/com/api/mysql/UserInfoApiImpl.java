package app.nosleep.com.api.mysql;
import android.content.Context;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import app.nosleep.com.api.IUserInfoApi;
import app.nosleep.com.api.R;
import app.nosleep.com.api.mysql.Util.HttpUtil;
import app.nosleep.com.api.mysql.Util.MyAsyncHttpResonseHandler;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.UserInfoModel;
import cz.msebera.android.httpclient.Header;

/**
 * Created by nosleep on 17-4-28.
 * 日期：17-4-28上午11:14
 * author:zzh
 * override:
 */

public class UserInfoApiImpl implements IUserInfoApi{
    Context mContext = null;
    HttpUtil mUtil = null;
    String BASEURL="";
    //需要传入调用者Context 初始化HTTP对象
    public UserInfoApiImpl(Context pContext){
        this.mContext=pContext;
        this.mUtil=HttpUtil.getHttpClient("UserInfo");
        this.BASEURL=mContext.getString(R.string.BASEURL);
    }
    @Override
    public void add(UserInfoModel user, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.users_add);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("phone",user.getUserinfoName());
        _params.put("pwd",user.getUserinfoPwd());
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<Void>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<Void>>(){}.getType();
                Response<Void> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
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
    public void queryByNameAndPwd(String name, String pwd, final ApiCallBackCroe<UserInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.users_login);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("phone",name);
        _params.put("pwd",pwd);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<UserInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<UserInfoModel>>(){}.getType();
                Response<UserInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
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
}

package app.nosleep.com.api.mysql.Util;

import android.preference.PreferenceActivity;
import android.util.Log;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import app.nosleep.com.model.Response;
import cz.msebera.android.httpclient.Header;


/**
 * Created by nosleep on 16-9-16.
 * 日期：16-9-16下午2:17
 * author:zzh
 * override: 实现LOOPJ POST  GET 回调函数接口
 *           对Response BODY 进行处理，调用onSuccessCallback回调
 */

public abstract class MyAsyncHttpResonseHandler<T> extends AsyncHttpResponseHandler {
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Log.v("database","#Util层#-#回调函数MyHandler#----POST发送成功！");
        String resbody="";
        try {
            if(resbody!=null){
                resbody = new String(responseBody, "UTF-8");
                Log.v("database","----------------------------成功返回服务器内容----------------------------");
                Log.v("database",resbody);
                Log.v("database","----------------------------成功返回服务器内容----------------------------");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            onSuccessCallBack(statusCode,headers,resbody);
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Log.v("database","#Util层#-#回调函数MyHandler#----POST发送失败！");
            Log.v("Test",""+statusCode);
            onFailureCallBack(400, null,"网路失败！");
        }
//    }

    /**
     * GSON对象转换
     * @param body   json数据
     * @param typeOf 转换对象
     * @return Response对象
     */
    public Response<T> getGsonToObject(String body , Type typeOf){
        Response<T> rs=null;
        try {
            Log.v("getGsion",body);
            Gson gson = new Gson();
            rs=gson.fromJson(body, typeOf);
        }catch (Exception ex){
            rs=new Response<T>();
            rs.setEvent(110);
            rs.setMsg("网络不通！返回内容空！");
            Log.v("getGsion",ex.toString());
        }finally {
            return rs;
        }
    }
    public abstract void onSuccessCallBack(int statusCode,Header[] headers,String body);
    public abstract void onFailureCallBack(int statusCode, Header[] headers, String body);

}

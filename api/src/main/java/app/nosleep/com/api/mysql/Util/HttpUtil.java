package app.nosleep.com.api.mysql.Util;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;

import app.nosleep.com.model.Response;

/**
 * Created by nosleep on 16-8-10.
 * 日期：2016年08月10日11:32:10
 * 作者：zzh
 * override：HTTP工具包，封装了Loopj，使用了Gson
 * 功能：1.获取对象 2.post 3.get 4.form to Gson
 */

public class HttpUtil {
    private static AsyncHttpClient mClient = null;
    public static HttpUtil mHttpUtil = null;
    public HttpUtil(AsyncHttpClient client) {
        this.mClient = client;
        mClient.setTimeout(5000);
        mClient.setMaxRetriesAndTimeout(2,1000);
    }

    /**
     * 获取一个http工具类对象
     *
     * @return 工具类对象
     */
    public static HttpUtil getHttpClient(String name) {
        if (mHttpUtil == null) {
            mHttpUtil = new HttpUtil(new AsyncHttpClient());
            Log.v("database","新建HTTPClient");
        }
        Log.v("database","初始化HTTPClient完成!是谁"+name);
        return mHttpUtil;
    }
    public static void post(String pUrl, RequestParams pParams, MyAsyncHttpResonseHandler callback){
        Log.v("database","#Util层#-#POST#----发送！！！:"+ pUrl);
        mClient.post(pUrl,pParams,callback);
        Log.v("database","#######################————————等————————#########################");
    }
    public static Response post(String pUrl, RequestParams pParams, Type type){
        Log.v("database","工具类，开始发送请求！！");
        mClient.post(pUrl,pParams,null);
        return null;
    }

    public static void get(String pUrl, RequestParams pParams, MyAsyncHttpResonseHandler callback) {
        mClient.get(pUrl,pParams,callback);
    }

    public static void upLoadFile(String pUrl, MyAsyncHttpResonseHandler callback){
        Log.v("database","工具类，上传文件！！");
        RequestParams pParams=new RequestParams();
        pParams.put("file","");
    }
}


package app.nosleep.com.api;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.api.mysql.Util.HttpUtil;
import app.nosleep.com.api.mysql.Util.MyAsyncHttpResonseHandler;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.UserInfoModel;
import cz.msebera.android.httpclient.Header;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午11:52
 * author:zzh
 * override:
 */

public class RestaurantInfoImpl implements IRestaurantInfoApi{

    Context mContext = null;
    HttpUtil mUtil = null;
    String BASEURL="";
    //需要传入调用者Context 初始化HTTP对象
    public RestaurantInfoImpl(Context pContext){
        this.mContext=pContext;
        this.mUtil=HttpUtil.getHttpClient("UserInfo");
        this.BASEURL=mContext.getString(R.string.BASEURL);
    }

    @Override
    public void add(RestaurantInfoModel rtinfo, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.rtinfo_add);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("rtname",rtinfo.getRtrtName());
        _params.put("rtmarks",rtinfo.getRtrtRemarks());
        _params.put("rtphone",rtinfo.getRtrtPhone());
        _params.put("address",rtinfo.getRtrtaddress());
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
    public void delete(String rtid, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void update(RestaurantInfoModel rtinfo, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void queryBySql(String sql) {
    }

    @Override
    public void queryByAll(final ApiCallBackCroe<RestaurantInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.rtinfo_querybyall);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("select","");
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<RestaurantInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<RestaurantInfoModel>>(){}.getType();
                Response<RestaurantInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryByName(String name, ApiCallBackCroe<RestaurantInfoModel> callback) {

    }

    @Override
    public void queryById(String id, final ApiCallBackCroe<RestaurantInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.rtinfo_byid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("id",id);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<RestaurantInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<RestaurantInfoModel>>(){}.getType();
                Response<RestaurantInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }
    //    @Override
//    public void add(RestaurantInfoModel rtinfo) {
//        String sql ="insert into tb_restaurantinfo(rtrtName,rtrtremarks,rtrtphone,rtrtaddress) values('"
//                +rtinfo.getRtrtName()+"','"
//                +rtinfo.getRtrtRemarks()+"','"
//                +rtinfo.getRtrtPhone()+"','"
//                +rtinfo.getRtrtaddress()+"')";
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void delete(String rtid) {
//        String sql ="delete tb_restaurantinfo where userinfoid="+rtid;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void update(RestaurantInfoModel rtinfo) {
//        String sql ="update tb_restaurantinfo set "+
//                "rtrtName="+rtinfo.getRtrtName()+
//                ",rtrtremarks="+rtinfo.getRtrtRemarks()+
//                ",rtrtphone="+rtinfo.getRtrtPhone()+
//                ",rtrtaddress="+rtinfo.getRtrtaddress()+
//                " where rtrtId="+rtinfo.getRtrtId();
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public List<RestaurantInfoModel> queryBySql(String sql) {
//        Log.v("API",""+sql);
//        Cursor c=mBSOH.getBySql(sql);
//        List<RestaurantInfoModel> list = new ArrayList<>();
//        while (c.moveToNext()){
//            RestaurantInfoModel _rt = new RestaurantInfoModel();
//            _rt.setRtrtId(c.getInt(c.getColumnIndex("rtrtId")));
//            _rt.setRtrtName(c.getString(c.getColumnIndex("rtrtName")));
//            _rt.setRtrtRemarks(c.getString(c.getColumnIndex("rtrtremarks")));
//            _rt.setRtrtPhone(c.getString(c.getColumnIndex("rtrtphone")));
//            _rt.setRtrtaddress(c.getString(c.getColumnIndex("rtrtaddress")));
//            list.add(_rt);
//        }
//        return list;
//    }
//
//    @Override
//    public List<RestaurantInfoModel> queryByAll() {
//        String sql ="select * from tb_restaurantinfo";
//        return  this.queryBySql(sql);
//    }
//
//    @Override
//    public List<RestaurantInfoModel> queryByName(String name) {
//        String sql ="select * from tb_restaurantinfo where rtrtName like '%"+name+"%'";
//        return  this.queryBySql(sql);
//    }
//
//    @Override
//    public RestaurantInfoModel queryById(String id) {
//        String sql ="select * from tb_restaurantinfo where rtrtId="+id;
//        List<RestaurantInfoModel> list = this.queryBySql(sql);
//        if(list.size()>0){
//            return list.get(0);
//        }
//        return null;
//    }
}

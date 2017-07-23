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
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.SeatInfoModel;
import cz.msebera.android.httpclient.Header;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午2:53
 * author:zzh
 * override:
 */

public class FoodInfoApiImpl implements IFoodInfoApi {
    Context mContext = null;
    HttpUtil mUtil = null;
    String BASEURL="";
    //需要传入调用者Context 初始化HTTP对象
    public FoodInfoApiImpl(Context pContext){
        this.mContext=pContext;
        this.mUtil=HttpUtil.getHttpClient("UserInfo");
        this.BASEURL=mContext.getString(R.string.BASEURL);
    }
    @Override
    public void add(FoodInfoModel food, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.foodinfo_add);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("foodname",food.getFoodName());
        _params.put("foodprice",food.getFoodPrice());
        _params.put("foodpictrue",food.getFoodPictrue());
        _params.put("foodtrtrid",food.getFoodRtrtId());
        _params.put("foodunit",food.getFoodunit());
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
    public void delete(String id, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void update(FoodInfoModel food, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void queryBySql(String sql) {

    }

    @Override
    public void queryByAll(final ApiCallBackCroe<FoodInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.foodinfo_querybyall);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("select","");
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                Response<FoodInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryByrtId(String rtid, final ApiCallBackCroe<FoodInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.foodinfo_querybyrtid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("rtid",rtid);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                Response<FoodInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryById(String id, final ApiCallBackCroe<FoodInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.foodinfo_querybyid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("id",id);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                Response<FoodInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryByIdStr(String idstr, final ApiCallBackCroe<FoodInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.foodinfo_querybyidstr);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("idstr",idstr);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<FoodInfoModel>>(){}.getType();
                Response<FoodInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    //    private Context mContext;
//    private BaseSQLiteOpenHelper mBSOH;
//
//    public FoodInfoApiImpl(Context pContext){
//        this.mContext=pContext;
//        this.mBSOH=new BaseSQLiteOpenHelper(mContext);
//    }
//
//    @Override
//    public void add(FoodInfoModel food) {
//        String sql ="insert into tb_foodinfo(foodName,foodprice,foodpictrue,foodrtrtid,foodunit) values('"
//                +food.getFoodName()+"',"
//                +food.getFoodPrice()+",'"
//                +food.getFoodPictrue()+"',"
//                +food.getFoodRtrtId()+",'"
//                +food.getFoodunit()+"')";
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void delete(String id) {
//        String sql ="delete tb_foodinfo where foodId="+id;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void update(FoodInfoModel food) {
//        String sql ="update tb_seatinfo set "+
//                "foodName="+food.getFoodName()+
//                ",foodprice="+food.getFoodPrice()+
//                ",foodpictrue="+food.getFoodPictrue()+
//                ",foodrtrtid="+food.getFoodRtrtId()+
//                ",foodunit="+food.getFoodunit()+
//                " where foodId="+food.getFoodId();
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public List<FoodInfoModel> queryBySql(String sql) {
//        Log.v("API",""+sql);
//        Cursor c=mBSOH.getBySql(sql);
//        List<FoodInfoModel> list = new ArrayList<>();
//        while (c.moveToNext()){
//            FoodInfoModel _foot = new FoodInfoModel();
//            _foot.setFoodId(c.getInt(c.getColumnIndex("foodId")));
//            _foot.setFoodName(c.getString(c.getColumnIndex("foodName")));
//            _foot.setFoodPrice(c.getInt(c.getColumnIndex("foodprice")));
//            _foot.setFoodPictrue(c.getString(c.getColumnIndex("foodpictrue")));
//            _foot.setFoodRtrtId(c.getInt(c.getColumnIndex("foodrtrtid")));
//            _foot.setFoodunit(c.getString(c.getColumnIndex("foodunit")));
//            list.add(_foot);
//        }
//        return list;
//    }
//
//    @Override
//    public List<FoodInfoModel> queryByAll() {
//        String sql ="select * from tb_foodinfo";
//        return  this.queryBySql(sql);
//    }
//
//    @Override
//    public List<FoodInfoModel> queryByrtId(String rtid) {
//        String sql ="select * from tb_foodinfo where foodrtrtid="+rtid;
//        List<FoodInfoModel> list = this.queryBySql(sql);
//        return list;
//    }
//
//    @Override
//    public FoodInfoModel queryById(String id) {
//        String sql ="select * from tb_foodinfo where foodId="+id;
//        List<FoodInfoModel> list = this.queryBySql(sql);
//        if(list.size()>0){
//            return list.get(0);
//        }
//        return null;
//    }
}

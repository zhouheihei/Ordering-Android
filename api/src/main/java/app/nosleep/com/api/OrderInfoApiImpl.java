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
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.Response;
import cz.msebera.android.httpclient.Header;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午3:45
 * author:zzh
 * override:
 */

public class OrderInfoApiImpl implements IOrderInfoApi {
    Context mContext = null;
    HttpUtil mUtil = null;
    String BASEURL="";
    //需要传入调用者Context 初始化HTTP对象
    public OrderInfoApiImpl(Context pContext){
        this.mContext=pContext;
        this.mUtil=HttpUtil.getHttpClient("UserInfo");
        this.BASEURL=mContext.getString(R.string.BASEURL);
    }
    @Override
    public void add(OrderInfoModel order, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_add);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("userid",order.getOrderUserInfoId());
        _params.put("datatime",order.getOrderDateTime());
        _params.put("seatid",order.getSeatId());
        _params.put("rtid",order.getRtrtId());
        _params.put("statu",order.getOrderStatu());
        _params.put("enddatet",order.getEnddatetime());
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
    public void update(OrderInfoModel order, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_update);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("orderId",order.getOrderId());
        _params.put("userid",order.getOrderUserInfoId());
        _params.put("datatime",order.getOrderDateTime());
        _params.put("seatid",order.getSeatId());
        _params.put("rtid",order.getRtrtId());
        _params.put("statu",order.getOrderStatu());

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
        public void updateByFoodId(String orderid, String idlist, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_updatebyfoodstr);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("orderid",orderid);
        _params.put("foodlist",idlist);
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
    public void queryBySql(String sql, ApiCallBackCroe<OrderInfoModel> callback) {

    }

    @Override
    public void queryByAll(final ApiCallBackCroe<OrderInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_querybyall);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("select","");
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                Response<OrderInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryById(String id, final ApiCallBackCroe<OrderInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_querybyid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("id",id);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                Response<OrderInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryByUserId(String Userid, final ApiCallBackCroe<OrderInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_querybyuserid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("Userid",Userid);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                Response<OrderInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryByIsCreate(String starttime, String endtime,String seatid, final ApiCallBackCroe<OrderInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.orderinfo_querybyiscreate);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("starttime",starttime);
        _params.put("endtime",endtime);
        _params.put("seatid",seatid);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<OrderInfoModel>>(){}.getType();
                Response<OrderInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }
    //    private Context mContext;
//    private BaseSQLiteOpenHelper mBSOH;
//
//    public OrderInfoApiImpl(Context pContext){
//        this.mContext=pContext;
//        this.mBSOH=new BaseSQLiteOpenHelper(mContext);
//    }
//
//    @Override
//    public void add(OrderInfoModel order) {
//        String sql ="insert into tb_orderinfo(orderuserinfoid,orderdatetime,seatid,rtrtid,orderstatu,foodorderidstr) values("
//                +order.getOrderUserInfoId()+",'"
//                +order.getOrderDateTime()+"',"
//                +order.getSeatId()+","
//                +order.getRtrtId()+",'"
//                +order.getOrderStatu()+"','"
//                +order.getFoodorderidstr()+"')"
//                ;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void delete(String id) {
//        String sql ="delete tb_orderinfo where orderId="+id;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void update(OrderInfoModel order) {
//        String sql ="update tb_orderinfo set "+
//                "orderuserinfoid="+order.getOrderUserInfoId()+
//                ",orderdatetime='"+order.getOrderDateTime()+
//                "',seatid="+order.getSeatId()+
//                ",rtrtid="+order.getRtrtId()+
//                ",orderstatu='"+order.getOrderStatu()+
//                "' where orderId="+order.getOrderId();
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void updateByFoodId(String orderid, String idlist) {
//        String sql ="update tb_orderinfo set "+
//                "foodorderidstr='"+idlist+
//                "' where orderId="+orderid;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public List<OrderInfoModel> queryBySql(String sql) {
//        Log.v("API",""+sql);
//        Cursor c=mBSOH.getBySql(sql);
//        List<OrderInfoModel> list = new ArrayList<>();
//        while (c.moveToNext()){
//            OrderInfoModel _orderinfo = new OrderInfoModel();
//            _orderinfo.setOrderId(c.getInt(c.getColumnIndex("orderId")));
//            _orderinfo.setOrderUserInfoId(c.getInt(c.getColumnIndex("orderuserinfoid")));
//            _orderinfo.setOrderDateTime(c.getString(c.getColumnIndex("orderdatetime")));
//            _orderinfo.setSeatId(c.getInt(c.getColumnIndex("seatid")));
//            _orderinfo.setRtrtId(c.getInt(c.getColumnIndex("rtrtid")));
//            _orderinfo.setOrderStatu(c.getString(c.getColumnIndex("orderstatu")));
//            _orderinfo.setFoodorderidstr(c.getString(c.getColumnIndex("foodorderidstr")));
//            list.add(_orderinfo);
//        }
//        return list;
//    }
//
//    @Override
//    public List<OrderInfoModel> queryByAll() {
//        String sql ="select * from tb_orderinfo";
//        return  this.queryBySql(sql);
//    }
//
//    @Override
//    public OrderInfoModel queryById(String id) {
//        String sql ="select * from tb_orderinfo where orderId="+id;
//        List<OrderInfoModel> list = this.queryBySql(sql);
//        if(list.size()>0){
//            return list.get(0);
//        }
//        return null;
//    }
//
//    @Override
//    public List<OrderInfoModel> queryByUserId(String Userid) {
//        String sql ="select * from tb_orderinfo where orderuserinfoid="+Userid;
//        List<OrderInfoModel> list = this.queryBySql(sql);
//        return list;
//    }
}

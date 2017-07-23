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
import app.nosleep.com.model.SeatInfoModel;
import cz.msebera.android.httpclient.Header;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午2:38
 * author:zzh
 * override:
 */

public class SeatInfoApiImpl implements ISeatInfoApi{
    Context mContext = null;
    HttpUtil mUtil = null;
    String BASEURL="";
    //需要传入调用者Context 初始化HTTP对象
    public SeatInfoApiImpl(Context pContext){
        this.mContext=pContext;
        this.mUtil=HttpUtil.getHttpClient("Seatinfo");
        this.BASEURL=mContext.getString(R.string.BASEURL);
    }
    @Override
    public void add(SeatInfoModel seat, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.seatinfo_add);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("seatname",seat.getSeatName());
        _params.put("min",seat.getSeatMin());
        _params.put("max",seat.getSeatMax());
        _params.put("seatstate",seat.getSeatState());
        _params.put("seatrtrtid",seat.getSeatrtrtid());
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
    public void update(SeatInfoModel seat, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void update(int statu, String id, final ApiCallBackCroe<Void> callback) {
        String _url = BASEURL+mContext.getString(R.string.seatinfo_update);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("statu",statu);
        _params.put("id",id);
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
    public void queryBySql(String sql, ApiCallBackCroe<Void> callback) {

    }

    @Override
    public void queryByAll(final ApiCallBackCroe<SeatInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.seatinfo_querybyall);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("select","");
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<SeatInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<SeatInfoModel>>(){}.getType();
                Response<SeatInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryByRtId(String rtid, final ApiCallBackCroe<SeatInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.seatinfo_querybyrtid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("rtid",rtid);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<SeatInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<SeatInfoModel>>(){}.getType();
                Response<SeatInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    @Override
    public void queryById(String id, final ApiCallBackCroe<SeatInfoModel> callback) {
        String _url = BASEURL+mContext.getString(R.string.seatinfo_querybyid);//获取APIURL
        RequestParams _params = new RequestParams();
        _params.put("id",id);
        mUtil.post(_url, _params, new MyAsyncHttpResonseHandler() {
            @Override
            public void onSuccessCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调成功#----得到返回信息");
                Type type = new TypeToken<Response<SeatInfoModel>>(){}.getType();
                callback.onSuccess(this.getGsonToObject(body,type));
            }

            @Override
            public void onFailureCallBack(int statusCode, Header[] headers, String body) {
                Log.v("database","#API层#-#方法add()#-#添加新用户：回调失败#----得到返回信息失败");
                Type type = new TypeToken<Response<SeatInfoModel>>(){}.getType();
                Response<SeatInfoModel> res =this.getGsonToObject(body,type);
                callback.onFailure(res.getEvent(),res.getMsg());
            }
        });
    }

    //    private Context mContext;
//    private BaseSQLiteOpenHelper mBSOH;
//
//    public SeatInfoApiImpl(Context pContext){
//        this.mContext=pContext;
//        this.mBSOH=new BaseSQLiteOpenHelper(mContext);
//    }
//    @Override
//    public void add(SeatInfoModel seat) {
//        String sql ="insert into tb_seatinfo(seatName,seatmin,seatmax,seatstate,seatrtrtid) values('"
//                +seat.getSeatName()+"',"
//                +seat.getSeatMin()+","
//                +seat.getSeatMax()+","
//                +seat.getSeatState()+","
//                +seat.getSeatrtrtid()+")"
//                ;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void delete(String id) {
//        String sql ="delete tb_seatinfo where seatId="+id;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void update(SeatInfoModel seat) {
//        String sql ="update tb_seatinfo set "+
//                "seatName="+seat.getSeatName()+
//                ",seatmin="+seat.getSeatMin()+
//                ",seatmax="+seat.getSeatMax()+
//                ",seatstate="+seat.getSeatState()+
//                ",seatrtrtid="+seat.getSeatrtrtid()+
//                " where seatId="+seat.getSeatId();
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public void update(int statu, String id) {
//        String sql ="update tb_seatinfo set "+
//                "seatstate="+statu+
//                " where seatId="+id;
//        Log.v("API",sql);
//        mBSOH.execBySql(sql);
//    }
//
//    @Override
//    public List<SeatInfoModel> queryBySql(String sql) {
//        Log.v("API",""+sql);
//        Cursor c=mBSOH.getBySql(sql);
//        List<SeatInfoModel> list = new ArrayList<>();
//        while (c.moveToNext()){
//            SeatInfoModel _seat = new SeatInfoModel();
//            _seat.setSeatId(c.getInt(c.getColumnIndex("seatId")));
//            _seat.setSeatName(c.getString(c.getColumnIndex("seatName")));
//            _seat.setSeatMin(c.getInt(c.getColumnIndex("seatmin")));
//            _seat.setSeatMax(c.getInt(c.getColumnIndex("seatmax")));
//            _seat.setSeatState(c.getInt(c.getColumnIndex("seatstate")));
//            _seat.setSeatrtrtid(c.getInt(c.getColumnIndex("seatrtrtid")));
//            list.add(_seat);
//        }
//        return list;
//    }
//
//    @Override
//    public List<SeatInfoModel> queryByAll() {
//        String sql ="select * from tb_seatinfo";
//        return  this.queryBySql(sql);
//    }
//
//    @Override
//    public List<SeatInfoModel> queryByRtId(String rtid) {
//        String sql ="select * from tb_seatinfo where seatrtrtid="+rtid;
//        List<SeatInfoModel> list = this.queryBySql(sql);
//        return list;
//    }
//
//    @Override
//    public SeatInfoModel queryById(String id) {
//        String sql ="select * from tb_seatinfo where seatId="+id;
//        List<SeatInfoModel> list = this.queryBySql(sql);
//        if(list.size()>0){
//            return list.get(0);
//        }
//        return null;
//    }
}

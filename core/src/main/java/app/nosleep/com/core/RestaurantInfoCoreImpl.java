package app.nosleep.com.core;

import android.content.Context;

import java.util.List;

import app.nosleep.com.api.IRestaurantInfoApi;
import app.nosleep.com.api.RestaurantInfoImpl;
import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.RestaurantInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:12
 * author:zzh
 * override:
 */

public class RestaurantInfoCoreImpl implements IRestaurantInfoCore {
    private Context mContext;
    private IRestaurantInfoApi mApi;
    public RestaurantInfoCoreImpl(Context pContext){
        this.mContext=pContext;
        mApi=new RestaurantInfoImpl(mContext);
    }
    @Override
    public void add(String rtname, String rtmarks, String rtphone, String address, final ActionCallBackListener<String> listener) {
        RestaurantInfoModel rt = new RestaurantInfoModel();
        rt.setRtrtName(rtname);
        rt.setRtrtaddress(address);
        rt.setRtrtPhone(rtphone);
        rt.setRtrtRemarks(rtmarks);
        mApi.add(rt, new ApiCallBackCroe<Void>() {
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
    public void delete(String rtid, final ActionCallBackListener<String> listener) {
        mApi.delete(rtid, new ApiCallBackCroe<Void>() {
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
    public void update(String id, String rtname, String rtmarks, String rtphone, String address, ActionCallBackListener<String> listener) {

    }

    @Override
    public void queryBySql(String sql) {
    }

    @Override
    public void queryByAll(final ActionCallBackListener<List<RestaurantInfoModel>> listener) {
        mApi.queryByAll(new ApiCallBackCroe<RestaurantInfoModel>() {
            @Override
            public void onSuccess(Response<RestaurantInfoModel> Data) {
                if(Data.getEvent()==110){
                    listener.onFailure("error","网络繁忙，请稍后再试！");
                }else {
                    listener.onSuccess(Data.getObjlist());
                }

            }

            @Override
            public void onFailure(int errorEvent, String message) {
                listener.onFailure(errorEvent+"",message);
            }
        });
    }

    @Override
    public void queryByName(String name, ActionCallBackListener<List<RestaurantInfoModel>> listener) {
    }

    @Override
    public void queryById(String id, final ActionCallBackListener<RestaurantInfoModel> listener) {
        mApi.queryById(id, new ApiCallBackCroe<RestaurantInfoModel>() {
            @Override
            public void onSuccess(Response<RestaurantInfoModel> Data) {
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


    //    private Context mContext;
//    private IRestaurantInfoApi mApi;
//
//    public RestaurantInfoCoreImpl(Context pContext){
//        this.mContext=pContext;
//        mApi=new RestaurantInfoImpl(mContext);
//    }
//
//    @Override
//    public void add(String rtname, String rtmarks, String rtphone, String address) {
//        try{
//            RestaurantInfoModel rt = new RestaurantInfoModel();
//            rt.setRtrtName(rtname);
//            rt.setRtrtaddress(address);
//            rt.setRtrtPhone(rtphone);
//            rt.setRtrtRemarks(rtmarks);
//            mApi.add(rt);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(String rtid) {
//        try{
//            mApi.delete(rtid);
//        }catch (Exception ex){
//
//        }
//    }
//
//    @Override
//    public void update(String id, String rtname, String rtmarks, String rtphone, String address) {
//        try{
//            RestaurantInfoModel rt = new RestaurantInfoModel();
//            rt.setRtrtName(rtname);
//            rt.setRtrtaddress(address);
//            rt.setRtrtPhone(rtphone);
//            rt.setRtrtRemarks(rtmarks);
//            mApi.update(rt);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<RestaurantInfoModel> queryBySql(String sql) {
//        try{
//            return mApi.queryBySql(sql);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<RestaurantInfoModel> queryByAll() {
//        try{
//            return mApi.queryByAll();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<RestaurantInfoModel> queryByName(String name) {
//        try{
//            return mApi.queryByName(name);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public RestaurantInfoModel queryById(String id) {
//        try{
//            return mApi.queryById(id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
}

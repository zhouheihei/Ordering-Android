package app.nosleep.com.core;

import android.content.Context;

import java.util.List;

import app.nosleep.com.api.IOrderInfoApi;
import app.nosleep.com.api.IUserInfoApi;
import app.nosleep.com.api.OrderInfoApiImpl;
import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.api.mysql.UserInfoApiImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.Response;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:52
 * author:zzh
 * override:
 */

public class OrderInfoCoreImpl implements IOrderInfoCore {
    private Context mContext;
    private IOrderInfoApi mApi;
    public OrderInfoCoreImpl(Context pContext){
        this.mContext=pContext;
        mApi=new OrderInfoApiImpl(mContext);
    }
    @Override
    public void add(int userid, String datatime, int seatid, int rtid, String statu,String enddatetime, final ActionCallBackListener<String> listener) {
        OrderInfoModel order = new OrderInfoModel();
        order.setOrderUserInfoId(userid);
        order.setOrderDateTime(datatime);
        order.setOrderStatu(statu);
        order.setSeatId(seatid);
        order.setRtrtId(rtid);
        order.setFoodorderidstr("");
        order.setEnddatetime(enddatetime);
        mApi.add(order, new ApiCallBackCroe<Void>() {
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
    public void delete(String id, ActionCallBackListener<String> listener) {

    }

    @Override
    public void update(int orderId, int userid, String datatime, int seatid, int rtid, String statu, final ActionCallBackListener<String> listener) {
        OrderInfoModel order = new OrderInfoModel();
        order.setOrderId(orderId);
        order.setOrderUserInfoId(userid);
        order.setOrderDateTime(datatime);
        order.setOrderStatu(statu);
        order.setSeatId(seatid);
        order.setRtrtId(rtid);
        mApi.update(order, new ApiCallBackCroe<Void>() {
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
    public void updateByFoodStr(String orderid, String foodlist, final ActionCallBackListener<String> listener) {
            mApi.updateByFoodId(orderid, foodlist, new ApiCallBackCroe<Void>() {
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
    public void queryBySql(String sql) {

    }

    @Override
    public void queryByAll(final ActionCallBackListener<List<OrderInfoModel>> listener) {
            mApi.queryByAll(new ApiCallBackCroe<OrderInfoModel>() {
                @Override
                public void onSuccess(Response<OrderInfoModel> Data) {
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
    public void queryById(String id, final ActionCallBackListener<OrderInfoModel> listener) {
        mApi.queryById(id, new ApiCallBackCroe<OrderInfoModel>() {
            @Override
            public void onSuccess(Response<OrderInfoModel> Data) {
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

    @Override
    public void queryByUserId(String Userid, final ActionCallBackListener<List<OrderInfoModel>> listener) {
        mApi.queryByUserId(Userid, new ApiCallBackCroe<OrderInfoModel>() {
            @Override
            public void onSuccess(Response<OrderInfoModel> Data) {
                if(Data.getEvent()==100){
                    listener.onFailure("error","网路繁忙,稍后重试!");
                }else{
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
    public void queryByIsCreate(String starttime, String endtime,String seatid, final ActionCallBackListener<List<OrderInfoModel>> listener) {
        mApi.queryByIsCreate(starttime, endtime,seatid, new ApiCallBackCroe<OrderInfoModel>() {
            @Override
            public void onSuccess(Response<OrderInfoModel> Data) {
                if(Data.getEvent()==110){
                    listener.onFailure("网络错误","网络错误");
                }else{
                    listener.onSuccess(Data.getObjlist());
                }

            }

            @Override
            public void onFailure(int errorEvent, String message) {
                listener.onFailure(errorEvent+"",message);
            }
        });
    }
    //    private Context mContext;
//    private IOrderInfoApi mApi;
//    public OrderInfoCoreImpl(Context pContext){
//        this.mContext=pContext;
//        this.mApi=new OrderInfoApiImpl(mContext);
//    }
//
//    @Override
//    public void add(int userid, String datatime, int seatid, int rtid, String statu) {
//        try{
//            OrderInfoModel order = new OrderInfoModel();
//            order.setOrderUserInfoId(userid);
//            order.setOrderDateTime(datatime);
//            order.setOrderStatu(statu);
//            order.setSeatId(seatid);
//            order.setRtrtId(rtid);
//            order.setFoodorderidstr("");
//            mApi.add(order);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(String id) {
//        try{
//            mApi.delete(id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(int orderId, int userid, String datatime, int seatid, int rtid, String statu) {
//        try{
//            OrderInfoModel order = new OrderInfoModel();
//            order.setOrderId(orderId);
//            order.setOrderUserInfoId(userid);
//            order.setOrderDateTime(datatime);
//            order.setOrderStatu(statu);
//            order.setSeatId(seatid);
//            order.setRtrtId(rtid);
//            mApi.update(order);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void updateByFoodStr(String orderid, String foodlist) {
//        try{
//            mApi.updateByFoodId(orderid,foodlist);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<OrderInfoModel> queryBySql(String sql) {
//        try{
//            return mApi.queryBySql(sql);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<OrderInfoModel> queryByAll() {
//        try{
//            return mApi.queryByAll();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//
//    }
//
//    @Override
//    public OrderInfoModel queryById(String id) {
//        try{
//            return mApi.queryById(id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<OrderInfoModel> queryByUserId(String Userid) {
//        try{
//            return mApi.queryByUserId(Userid);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
}

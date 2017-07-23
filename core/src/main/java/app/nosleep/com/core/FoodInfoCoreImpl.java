package app.nosleep.com.core;

import android.content.Context;

import java.util.List;

import app.nosleep.com.api.FoodInfoApiImpl;
import app.nosleep.com.api.IFoodInfoApi;
import app.nosleep.com.api.IUserInfoApi;
import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.api.mysql.UserInfoApiImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.Response;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:33
 * author:zzh
 * override:
 */

public class FoodInfoCoreImpl implements IFoodInfoCore {
    private Context mContext;
    private IFoodInfoApi mApi;
    public FoodInfoCoreImpl(Context pContext){
        this.mContext=pContext;
        mApi=new FoodInfoApiImpl(mContext);
    }
    @Override
    public void add(String foodname, int foodprice, String foodpictrue, int foodtrtrid, String foodunit, final ActionCallBackListener<String> listener) {
        FoodInfoModel food = new FoodInfoModel();
        food.setFoodName(foodname);
        food.setFoodPrice(foodprice);
        food.setFoodPictrue(foodpictrue);
        food.setFoodRtrtId(foodtrtrid);
        food.setFoodunit(foodunit);
        mApi.add(food, new ApiCallBackCroe<Void>() {
            @Override
            public void onSuccess(Response<Void> Data) {
                if(Data.getEvent()==100){
                    listener.onFailure("error","网络繁忙，稍后重试！");
                }else{
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
    public void update(int id, String foodname, int foodprice, String foodpictrue, int foodtrtrid, String foodunit, ActionCallBackListener<String> listener) {

    }

    @Override
    public void queryBySql(String sql) {

    }

    @Override
    public void queryByAll(final ActionCallBackListener<List<FoodInfoModel>> listener) {
        mApi.queryByAll(new ApiCallBackCroe<FoodInfoModel>() {
            @Override
            public void onSuccess(Response<FoodInfoModel> Data) {
                if(Data.getEvent()==100){
                    listener.onFailure("error","网络繁忙，稍后重试！");
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
    public void queryByrtId(String rtid, final ActionCallBackListener<List<FoodInfoModel>> listener) {
        mApi.queryByrtId(rtid, new ApiCallBackCroe<FoodInfoModel>() {
            @Override
            public void onSuccess(Response<FoodInfoModel> Data) {
                if(Data.getEvent()==100){
                    listener.onFailure("error","网络繁忙，稍后重试！");
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
    public void queryById(String id, final ActionCallBackListener<FoodInfoModel> listener) {
        mApi.queryById(id, new ApiCallBackCroe<FoodInfoModel>() {
            @Override
            public void onSuccess(Response<FoodInfoModel> Data) {
                if(Data.getEvent()==100){
                    listener.onFailure("error","网络繁忙，稍后重试！");
                }else{
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
    public void queryByIdStr(String idstr, final ActionCallBackListener<List<FoodInfoModel>> listener) {
        mApi.queryByIdStr(idstr, new ApiCallBackCroe<FoodInfoModel>() {
            @Override
            public void onSuccess(Response<FoodInfoModel> Data) {
                if(Data.getEvent()==100){
                    listener.onFailure("error","网络繁忙，稍后重试！");
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

    //
//    private Context mContext;
//    private IFoodInfoApi mApi;
//
//    public FoodInfoCoreImpl(Context pContext){
//        this.mContext=pContext;
//        this.mApi=new FoodInfoApiImpl(mContext);
//    }
//
//    @Override
//    public void add(String foodname, int foodprice, String foodpictrue, int foodtrtrid, String foodunit) {
//        try{
//            FoodInfoModel food = new FoodInfoModel();
//            food.setFoodName(foodname);
//            food.setFoodPrice(foodprice);
//            food.setFoodPictrue(foodpictrue);
//            food.setFoodRtrtId(foodtrtrid);
//            food.setFoodunit(foodunit);
//            mApi.add(food);
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
//    public void update(int id, String foodname, int foodprice, String foodpictrue, int foodtrtrid, String foodunit) {
//        try{
//            FoodInfoModel food = new FoodInfoModel();
//            food.setFoodId(id);
//            food.setFoodName(foodname);
//            food.setFoodPrice(foodprice);
//            food.setFoodPictrue(foodpictrue);
//            food.setFoodRtrtId(foodtrtrid);
//            food.setFoodunit(foodunit);
//            mApi.update(food);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<FoodInfoModel> queryBySql(String sql) {
//        try{
//            return mApi.queryBySql(sql);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<FoodInfoModel> queryByAll() {
//        try{
//            return mApi.queryByAll();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<FoodInfoModel> queryByrtId(String rtid) {
//        try{
//            return mApi.queryByrtId(rtid);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public FoodInfoModel queryById(String id) {
//        try{
//            return  mApi.queryById(id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
}

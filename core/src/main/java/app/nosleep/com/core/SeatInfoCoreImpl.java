package app.nosleep.com.core;

import android.content.Context;

import java.util.List;

import app.nosleep.com.api.ISeatInfoApi;
import app.nosleep.com.api.IUserInfoApi;
import app.nosleep.com.api.SeatInfoApiImpl;
import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.api.mysql.UserInfoApiImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.SeatInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:23
 * author:zzh
 * override:
 */

public class SeatInfoCoreImpl implements ISeatInfoCore {

    private Context mContext;
    private ISeatInfoApi mApi;
    public SeatInfoCoreImpl(Context pContext){
        this.mContext=pContext;
        mApi=new SeatInfoApiImpl(mContext);
    }

    @Override
    public void add(String seatname, int min, int max, int seatstate, int seatrtrtid, final ActionCallBackListener<String> listener) {
        SeatInfoModel seat=new SeatInfoModel();
        seat.setSeatrtrtid(seatrtrtid);
        seat.setSeatState(seatstate);
        seat.setSeatMax(max);
        seat.setSeatMin(min);
        seat.setSeatName(seatname);
        mApi.add(seat, new ApiCallBackCroe<Void>() {
            @Override
            public void onSuccess(Response<Void> Data) {
                listener.onSuccess(Data.getMsg());
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
    public void update(int id, String seatname, int min, int max, int seatstate, int seatrtrtid, ActionCallBackListener<String> listener) {

    }

    @Override
    public void update(int statu, String id, final ActionCallBackListener<String> listener) {
        mApi.update(statu, id, new ApiCallBackCroe<Void>() {
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
    public void queryByAll(final ActionCallBackListener<List<SeatInfoModel>> listener) {
        mApi.queryByAll(new ApiCallBackCroe<SeatInfoModel>() {
            @Override
            public void onSuccess(Response<SeatInfoModel> Data) {
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
    public void queryByRtId(String rtid, final ActionCallBackListener<List<SeatInfoModel>> listener) {
        mApi.queryByRtId(rtid, new ApiCallBackCroe<SeatInfoModel>() {
            @Override
            public void onSuccess(Response<SeatInfoModel> Data) {
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
    public void queryById(String id, final ActionCallBackListener<SeatInfoModel> listener) {
        mApi.queryById(id, new ApiCallBackCroe<SeatInfoModel>() {
            @Override
            public void onSuccess(Response<SeatInfoModel> Data) {
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
//    private ISeatInfoApi mApi;
//
//    public SeatInfoCoreImpl(Context pContext){
//        this.mContext=pContext;
//        this.mApi=new SeatInfoApiImpl(mContext);
//    }
//
//    @Override
//    public void add(String seatname, int min, int max, int seatstate, int seatrtrtid) {
//        try{
//            SeatInfoModel seat=new SeatInfoModel();
//            seat.setSeatrtrtid(seatrtrtid);
//            seat.setSeatState(seatstate);
//            seat.setSeatMax(max);
//            seat.setSeatMin(min);
//            seat.setSeatName(seatname);
//            mApi.add(seat);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(String id) {
//        try {
//            mApi.delete(id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(int id, String seatname, int min, int max, int seatstate, int seatrtrtid) {
//        try{
//            SeatInfoModel seat=new SeatInfoModel();
//            seat.setSeatId(id);
//            seat.setSeatrtrtid(seatrtrtid);
//            seat.setSeatState(seatstate);
//            seat.setSeatMax(max);
//            seat.setSeatMin(min);
//            seat.setSeatName(seatname);
//            mApi.update(seat);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(int statu, String id) {
//        try {
//            mApi.update(statu,id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<SeatInfoModel> queryBySql(String sql) {
//        try {
//            return mApi.queryBySql(sql);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<SeatInfoModel> queryByAll() {
//        try {
//            return mApi.queryByAll();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<SeatInfoModel> queryByRtId(String rtid) {
//        try {
//            return mApi.queryByRtId(rtid);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public SeatInfoModel queryById(String id) {
//        try {
//            return mApi.queryById(id);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return null;
//    }
}

package app.nosleep.com.core;

import android.content.Context;

import java.util.List;

import app.nosleep.com.api.FoodOrderInfoApiImpl;
import app.nosleep.com.api.IFoodOrderInfoApi;
import app.nosleep.com.model.FoodOrderInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:46
 * author:zzh
 * override:
 */

public class FoodOrderCoreImpl implements IFoodOrderCore {

    private Context mContext;
    private IFoodOrderInfoApi mApi;

    public FoodOrderCoreImpl(Context pContext){
        this.mContext=pContext;
        this.mApi=new FoodOrderInfoApiImpl(mContext);
    }
    @Override
    public void add(String foodid, String orderid) {
        try{
            mApi.add(foodid,orderid);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try{
            mApi.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String id, String foodid, String orderid) {
        try{
            mApi.update(id,foodid,orderid);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<FoodOrderInfoModel> queryBySql(String sql) {
        try{
            return mApi.queryBySql(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodOrderInfoModel> queryByAll() {
        try{
            return mApi.queryByAll();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public FoodOrderInfoModel queryById(String id) {
        try{
            return mApi.queryById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FoodOrderInfoModel> queryByOrderId(String orderid) {
        try{
            return mApi.queryByOrderId(orderid);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}

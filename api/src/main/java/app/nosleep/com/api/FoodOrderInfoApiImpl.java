package app.nosleep.com.api;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.model.FoodOrderInfoModel;
import app.nosleep.com.model.SeatInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午3:28
 * author:zzh
 * override:
 */

public class FoodOrderInfoApiImpl implements IFoodOrderInfoApi {
    private Context mContext;
    private BaseSQLiteOpenHelper mBSOH;

    public FoodOrderInfoApiImpl(Context pContext){
        this.mContext=pContext;
        this.mBSOH=new BaseSQLiteOpenHelper(mContext);
    }
    @Override
    public void add(String foodid,String orderid) {
        String sql ="insert into tb_foodorderinfo(foodid,foodorder) values("
                +foodid+","
                +orderid+")"
                ;
        Log.v("API",sql);
        mBSOH.execBySql(sql);
    }

    @Override
    public void delete(String id) {
        String sql ="delete tb_foodorderinfo where foodorderId="+id;
        Log.v("API",sql);
        mBSOH.execBySql(sql);
    }

    @Override
    public void update(String id, String foodid, String orderid) {
        String sql ="update tb_foodorderinfo set "+
                ",foodid="+foodid+
                ",foodorder="+orderid+
                " where foodorderId="+id;
        Log.v("API",sql);
        mBSOH.execBySql(sql);
    }

    @Override
    public List<FoodOrderInfoModel> queryBySql(String sql) {
        Log.v("API",""+sql);
        Cursor c=mBSOH.getBySql(sql);
        List<FoodOrderInfoModel> list = new ArrayList<>();
        while (c.moveToNext()){
            FoodOrderInfoModel _foodorder = new FoodOrderInfoModel();
            _foodorder.setFoodOrderInfoId(c.getInt(c.getColumnIndex("foodorderId")));
            _foodorder.setFoodId(c.getInt(c.getColumnIndex("foodid")));
            _foodorder.setOrderId(c.getInt(c.getColumnIndex("foodorder")));
            list.add(_foodorder);
        }
        return list;
    }

    @Override
    public List<FoodOrderInfoModel> queryByAll() {
        String sql ="select * from tb_foodorderinfo";
        return  this.queryBySql(sql);
    }

    @Override
    public FoodOrderInfoModel queryById(String id) {
        String sql ="select * from tb_foodorderinfo where foodorderId="+id;
        List<FoodOrderInfoModel> list = this.queryBySql(sql);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<FoodOrderInfoModel> queryByOrderId(String orderid) {
        String sql ="select * from tb_foodorderinfo where foodorder="+orderid;
        List<FoodOrderInfoModel> list = this.queryBySql(sql);
        return list;
    }
}

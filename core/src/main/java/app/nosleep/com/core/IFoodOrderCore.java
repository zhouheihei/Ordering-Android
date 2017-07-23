package app.nosleep.com.core;

import java.util.List;

import app.nosleep.com.model.FoodOrderInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:46
 * author:zzh
 * override:
 */

public interface IFoodOrderCore {
    void add(String foodid,String orderid);
    void delete(String id);
    void update(String id,String foodid,String orderid);
    List<FoodOrderInfoModel> queryBySql(String sql);
    List<FoodOrderInfoModel> queryByAll();
    FoodOrderInfoModel queryById(String id);
    List<FoodOrderInfoModel> queryByOrderId(String orderid);
}

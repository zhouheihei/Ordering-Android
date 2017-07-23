package app.nosleep.com.api;

import android.widget.ListView;

import java.util.List;

import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.FoodOrderInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午3:22
 * author:zzh
 * override:
 */

public interface IFoodOrderInfoApi {
    void add(String foodid,String orderid);
    void delete(String id);
    void update(String id,String foodid,String orderid);
    List<FoodOrderInfoModel> queryBySql(String sql);
    List<FoodOrderInfoModel> queryByAll();
    FoodOrderInfoModel queryById(String id);
    List<FoodOrderInfoModel> queryByOrderId(String orderid);
}

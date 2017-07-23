package app.nosleep.com.core;

import java.util.List;

import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.FoodInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:30
 * author:zzh
 * override:
 */

public interface IFoodInfoCore {

    /**
     * 添加一条信息
     * @param foodname      菜品名称
     * @param foodprice     菜品价格
     * @param foodpictrue   菜品图片
     * @param foodtrtrid    餐厅ID
     * @param foodunit      菜品单位
     */
    void add(String foodname,int foodprice ,String foodpictrue,int foodtrtrid,String foodunit,ActionCallBackListener<String> listener);

    void delete(String id,ActionCallBackListener<String> listener);

    void update(int id ,String foodname,int foodprice ,String foodpictrue,int foodtrtrid,String foodunit,ActionCallBackListener<String> listener);

    void queryBySql(String sql);

    void queryByAll(ActionCallBackListener<List<FoodInfoModel>> listener);

    void queryByrtId(String rtid,ActionCallBackListener<List<FoodInfoModel>> listener);

    void queryById(String id,ActionCallBackListener<FoodInfoModel> listener);
    void queryByIdStr(String idstr,ActionCallBackListener<List<FoodInfoModel>> listener);
}

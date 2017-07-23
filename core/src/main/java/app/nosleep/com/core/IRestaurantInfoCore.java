package app.nosleep.com.core;

import java.util.List;

import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.RestaurantInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:09
 * author:zzh
 * override:
 */

public interface IRestaurantInfoCore {
    /**
     * 添加一条餐厅信息
     *
     */
    void add(String rtname,String rtmarks,String rtphone,String address,ActionCallBackListener<String> listener);

    /**
     * 删除餐厅信息
     *
     */
    void delete(String rtid,ActionCallBackListener<String> listener);

    /**
     * 更新餐厅信息
     *
     */
    void update(String id,String rtname,String rtmarks,String rtphone,String address,ActionCallBackListener<String> listener);

    /**
     * 根据SQL查询餐厅信息
     * @param sql
     * @return 餐厅信息集合
     */
    void queryBySql(String sql);

    /**
     * 查询所有餐厅信息
     * @return  餐厅信息集合
     */
    void queryByAll(ActionCallBackListener<List<RestaurantInfoModel>> listener);

    /**
     * 根据餐厅名称模糊查询
     * @param name  餐厅名称
     * @return  集合
     */
    void queryByName(String name,ActionCallBackListener<List<RestaurantInfoModel>> listener);

    /**
     * 根据餐厅ID查询
     * @param id 餐厅ID
     * @return 餐厅信息对象
     */
    void queryById(String id,ActionCallBackListener<RestaurantInfoModel> listener);
}

package app.nosleep.com.api;

import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午11:43
 * author:zzh
 * override:餐厅接口,添加餐厅,删除餐厅,查询餐厅
 *
 */

public interface IRestaurantInfoApi {
    /**
     * 添加一条餐厅信息
     * @param rtinfo 餐厅对象
     */
    void add(RestaurantInfoModel rtinfo,ApiCallBackCroe<Void> callback);

    /**
     * 删除餐厅信息
     * @param rtid   餐厅ID
     */
    void delete(String rtid,ApiCallBackCroe<Void> callback);

    /**
     * 更新餐厅信息
     * @param rtinfo 餐厅对象
     */
    void update(RestaurantInfoModel rtinfo,ApiCallBackCroe<Void> callback);

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
    void queryByAll(ApiCallBackCroe<RestaurantInfoModel> callback);

    /**
     * 根据餐厅名称模糊查询
     * @param name  餐厅名称
     * @return  集合
     */
    void queryByName(String name,ApiCallBackCroe<RestaurantInfoModel> callback);

    /**
     * 根据餐厅ID查询
     * @param id 餐厅ID
     * @return 餐厅信息对象
     */
    void queryById(String id,ApiCallBackCroe<RestaurantInfoModel> callback);
}


package app.nosleep.com.api;

import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午2:49
 * author:zzh
 * override:
 */

public interface IFoodInfoApi {
    /**
     * 添加一条信息
     * @param food
     */
    void add(FoodInfoModel food,ApiCallBackCroe<Void> callback);

    void delete(String id,ApiCallBackCroe<Void> callback);

    void update(FoodInfoModel food,ApiCallBackCroe<Void> callback);

    void queryBySql(String sql);

    void queryByAll(ApiCallBackCroe<FoodInfoModel> callback);

    void queryByrtId(String rtid,ApiCallBackCroe<FoodInfoModel> callback);

    void queryById(String id,ApiCallBackCroe<FoodInfoModel> callback);
    void queryByIdStr(String idstr,ApiCallBackCroe<FoodInfoModel> callback);
}

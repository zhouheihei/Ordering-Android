package app.nosleep.com.api;

import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午3:42
 * author:zzh
 * override:
 */

public interface IOrderInfoApi {
    void add(OrderInfoModel order,ApiCallBackCroe<Void> callback);
    void delete(String id,ApiCallBackCroe<Void> callback);
    void update(OrderInfoModel order,ApiCallBackCroe<Void> callback);
    void updateByFoodId(String orderid,String idlist,ApiCallBackCroe<Void> callback);
    void queryBySql(String sql,ApiCallBackCroe<OrderInfoModel> callback);
    void queryByAll(ApiCallBackCroe<OrderInfoModel> callback);
    void queryById(String id,ApiCallBackCroe<OrderInfoModel> callback);
    void queryByUserId(String Userid,ApiCallBackCroe<OrderInfoModel> callback);
    void queryByIsCreate(String starttime,String endtime,String seatid,ApiCallBackCroe<OrderInfoModel> callback);

}

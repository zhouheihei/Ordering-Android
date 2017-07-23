package app.nosleep.com.core;

import java.util.List;

import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.OrderInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:51
 * author:zzh
 * override:
 */

public interface IOrderInfoCore {
    void add(int userid,String datatime,int seatid,int rtid,String statu,String enddatetime,ActionCallBackListener<String> listener);
    void delete(String id,ActionCallBackListener<String> listener);
    void update(int orderId,int userid,String datatime,int seatid,int rtid,String statu,ActionCallBackListener<String> listener);
    void updateByFoodStr(String orderid,String foodlist,ActionCallBackListener<String> listener);
    void queryBySql(String sql);
    void queryByAll(ActionCallBackListener<List<OrderInfoModel>> listener);
    void queryById(String id,ActionCallBackListener<OrderInfoModel> listener);
    void queryByUserId(String Userid,ActionCallBackListener<List<OrderInfoModel>> listener);
    void queryByIsCreate(String starttime,String endtime,String seatid,ActionCallBackListener<List<OrderInfoModel>> listener);
}

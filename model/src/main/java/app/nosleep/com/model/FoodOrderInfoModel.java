package app.nosleep.com.model;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午9:59
 * author:zzh
 * override:点餐信息
 */

public class FoodOrderInfoModel {
    private int foodOrderInfoId;    //点餐信息ID
    private int foodId;   //菜品对象
    private int orderId;            //订单ID

    public int getFoodOrderInfoId() {
        return foodOrderInfoId;
    }

    public void setFoodOrderInfoId(int foodOrderInfoId) {
        this.foodOrderInfoId = foodOrderInfoId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}

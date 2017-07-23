package com.ogogc.app.bean;

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

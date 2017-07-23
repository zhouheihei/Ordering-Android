package app.nosleep.com.model;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8上午10:01
 * author:zzh
 * override:订单实体类
 */

public class OrderInfoModel {
    private int orderId;                        //订单ID
    private int orderUserInfoId;      //用户实体
    private String orderDateTime;               //就餐日期时间
    private int seatId;               //座位实体
    private int rtrtId;                 //餐厅实体
    private String foodorderidstr;
    private String enddatetime;

    public String getEnddatetime() {
        return enddatetime;
    }

    public void setEnddatetime(String enddatetime) {
        this.enddatetime = enddatetime;
    }

    public String getFoodorderidstr() {
        return foodorderidstr;
    }

    public void setFoodorderidstr(String foodorderidstr) {
        this.foodorderidstr = foodorderidstr;
    }

    public int getOrderUserInfoId() {
        return orderUserInfoId;
    }

    public void setOrderUserInfoId(int orderUserInfoId) {
        this.orderUserInfoId = orderUserInfoId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRtrtId() {
        return rtrtId;
    }

    public void setRtrtId(int rtrtId) {
        this.rtrtId = rtrtId;
    }

    private String orderStatu;                  //订单状态

    public String getOrderStatu() {
        return orderStatu;
    }

    public void setOrderStatu(String orderStatu) {
        this.orderStatu = orderStatu;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

}

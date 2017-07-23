package com.ogogc.app.bean;

public class RestaurantInfoModel {
	private int rtrtId;             //餐厅ID
    private String rtrtName;        //餐厅名称
    private String rtrtRemarks;     //餐厅简介
    private String rtrtPhone;       //餐厅电话
    private String rtrtaddress;     //餐厅地址

    public int getRtrtId() {
        return rtrtId;
    }

    public void setRtrtId(int rtrtId) {
        this.rtrtId = rtrtId;
    }

    public String getRtrtName() {
        return rtrtName;
    }

    public void setRtrtName(String rtrtName) {
        this.rtrtName = rtrtName;
    }

    public String getRtrtRemarks() {
        return rtrtRemarks;
    }

    public void setRtrtRemarks(String rtrtRemarks) {
        this.rtrtRemarks = rtrtRemarks;
    }

    public String getRtrtPhone() {
        return rtrtPhone;
    }

    public void setRtrtPhone(String rtrtPhone) {
        this.rtrtPhone = rtrtPhone;
    }

    public String getRtrtaddress() {
        return rtrtaddress;
    }

    public void setRtrtaddress(String rtrtaddress) {
        this.rtrtaddress = rtrtaddress;
    }
}

package com.ogogc.app.bean;

public class SeatInfoModel {
	private int seatId;         //位置ID
    private String seatName;    //位置名称
    private int seatMin;        //最少可坐人数
    private int seatMax;        //最多可坐人数
    private int seatState;      //座位状态
    private int seatrtrtid;     //餐厅ID

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public int getSeatMin() {
        return seatMin;
    }

    public void setSeatMin(int seatMin) {
        this.seatMin = seatMin;
    }

    public int getSeatMax() {
        return seatMax;
    }

    public void setSeatMax(int seatMax) {
        this.seatMax = seatMax;
    }

    public int getSeatState() {
        return seatState;
    }

    public void setSeatState(int seatState) {
        this.seatState = seatState;
    }

    public int getSeatrtrtid() {
        return seatrtrtid;
    }

    public void setSeatrtrtid(int seatrtrtid) {
        this.seatrtrtid = seatrtrtid;
    }
}

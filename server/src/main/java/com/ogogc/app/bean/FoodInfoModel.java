package com.ogogc.app.bean;

public class FoodInfoModel {
	 private int foodId;         //菜品ID
	    private String foodName;    //菜品名称
	    private int foodPrice;      //菜品价格
	    private String foodPictrue; //菜品图片地址
	    private int foodRtrtId;     //餐厅ID
	    private String foodunit;    //菜品单位

	    public int getFoodId() {
	        return foodId;
	    }

	    public void setFoodId(int foodId) {
	        this.foodId = foodId;
	    }

	    public String getFoodName() {
	        return foodName;
	    }

	    public void setFoodName(String foodName) {
	        this.foodName = foodName;
	    }

	    public int getFoodPrice() {
	        return foodPrice;
	    }

	    public void setFoodPrice(int foodPrice) {
	        this.foodPrice = foodPrice;
	    }

	    public String getFoodPictrue() {
	        return foodPictrue;
	    }

	    public void setFoodPictrue(String foodPictrue) {
	        this.foodPictrue = foodPictrue;
	    }

	    public int getFoodRtrtId() {
	        return foodRtrtId;
	    }

	    public void setFoodRtrtId(int foodRtrtId) {
	        this.foodRtrtId = foodRtrtId;
	    }

	    public String getFoodunit() {
	        return foodunit;
	    }

	    public void setFoodunit(String foodunit) {
	        this.foodunit = foodunit;
	    }
	
}

package com.ogogc.app.server;

import java.util.List;

import com.ogogc.app.bean.FoodInfoModel;
import com.ogogc.app.bean.FoodOrderInfoModel;
import com.ogogc.app.bean.Response;
import com.ogogc.app.dao.FoodInfoDao;

public class FoodInfoserver {
	
	FoodInfoDao dao =new FoodInfoDao();
	
	public Response<Void> add(String foodname, int foodprice, String foodpictrue, int foodtrtrid, String foodunit) {
		Response<Void> rs = new Response<Void>();
		try{
			FoodInfoModel food = new FoodInfoModel();
            food.setFoodName(foodname);
            food.setFoodPrice(foodprice);
            food.setFoodPictrue(foodpictrue);
            food.setFoodRtrtId(foodtrtrid);
            food.setFoodunit(foodunit);
			if (dao.add(food)) {
					rs.setEvent(200);
					rs.setMsg("操作成功");
			} else {
					rs.setMsg(Strings.USERINFO_DAOERROR);
			}
        }catch (Exception ex){
        	System.out.println("Server层异常捕获:" + ex.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
        }
		return rs;
	}
	
	public Response<Void> delete(String id) {
		Response<Void> rs = new Response<Void>();
		try{
			if (dao.delete(id)) {
					rs.setEvent(200);
					rs.setMsg("操作成功");
			} else {
					rs.setMsg(Strings.USERINFO_DAOERROR);
			}
        }catch (Exception ex){
        	System.out.println("Server层异常捕获:" + ex.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
        }
		return rs;
	}
	
	public Response<Void> update(int id, String foodname, int foodprice, String foodpictrue, int foodtrtrid, String foodunit) {
		Response<Void> rs = new Response<Void>();
		try{
			FoodInfoModel food = new FoodInfoModel();
            food.setFoodId(id);
            food.setFoodName(foodname);
            food.setFoodPrice(foodprice);
            food.setFoodPictrue(foodpictrue);
            food.setFoodRtrtId(foodtrtrid);
            food.setFoodunit(foodunit);
			if (dao.update(food)) {
					rs.setEvent(200);
					rs.setMsg("操作成功");
			} else {
					rs.setMsg(Strings.USERINFO_DAOERROR);
			}
        }catch (Exception ex){
        	System.out.println("Server层异常捕获:" + ex.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
        }
		return rs;
	}
	
	public Response<FoodInfoModel> queryByAll() {
		Response<FoodInfoModel> rs = new Response<FoodInfoModel>();
		try {
			List<FoodInfoModel> list = null;
			list = dao.queryByAll();
			rs.setEvent(200);
			rs.setObjlist(list);
			rs.setPageSize(0);
			rs.setCurrentPage(0);
		} catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}
	
	public Response<FoodInfoModel> queryByrtId(String rtid){
		Response<FoodInfoModel> rs = new Response<FoodInfoModel>();
		try {
			List<FoodInfoModel> list = null;
			list = dao.queryByrtId(rtid);
			rs.setEvent(200);
			rs.setObjlist(list);
			rs.setPageSize(0);
			rs.setCurrentPage(0);
		} catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}
	
	public Response<FoodInfoModel> queryByIdstr(String idstr) {
		Response<FoodInfoModel> rs = new Response<FoodInfoModel>();
		try {
			List<FoodInfoModel> model = null;
			model = dao.queryByIdstr(idstr);
			rs.setEvent(200);
			rs.setObjlist(model);
			rs.setObj(null);
			rs.setPageSize(0);
			rs.setCurrentPage(0);
		} catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}
	
	public Response<FoodInfoModel> queryById(String id) {
		Response<FoodInfoModel> rs = new Response<FoodInfoModel>();
		try {
			FoodInfoModel model = null;
			model = dao.queryById(id);
			rs.setEvent(200);
			rs.setObjlist(null);
			rs.setObj(model);
			rs.setPageSize(0);
			rs.setCurrentPage(0);
		} catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}
}

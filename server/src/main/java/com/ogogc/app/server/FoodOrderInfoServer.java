package com.ogogc.app.server;

import java.util.List;

import com.ogogc.app.bean.FoodOrderInfoModel;
import com.ogogc.app.bean.OrderInfoModel;
import com.ogogc.app.bean.Response;
import com.ogogc.app.dao.FoodOrderInfoDao;

public class FoodOrderInfoServer {
	
	FoodOrderInfoDao dao =new FoodOrderInfoDao();
	
	public Response<Void> add(String foodid, String orderid) {
		Response<Void> rs = new Response<Void>();
		try{
				if (dao.add(foodid,orderid)) {
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
	
	public Response<Void> update(String id, String foodid, String orderid) {
		Response<Void> rs = new Response<Void>();
		try{
				if (dao.update(id,foodid,orderid)) {
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
	
	public Response<FoodOrderInfoModel> queryByAll() {
		Response<FoodOrderInfoModel> rs = new Response<FoodOrderInfoModel>();
		try {
			List<FoodOrderInfoModel> list = null;
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
	
	public Response<FoodOrderInfoModel> queryById(String id) {
		Response<FoodOrderInfoModel> rs = new Response<FoodOrderInfoModel>();
		try {
			FoodOrderInfoModel model = null;
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
	
	public Response<FoodOrderInfoModel> queryByOrderId(String orderid) {
		Response<FoodOrderInfoModel> rs = new Response<FoodOrderInfoModel>();
		try {
			List<FoodOrderInfoModel> list = null;
			list = dao.queryByOrderId(orderid);
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
}

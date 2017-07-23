package com.ogogc.app.server;

import java.util.List;

import com.ogogc.app.bean.OrderInfoModel;
import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.dao.OrderInfoDao;

public class OrderInfoServer {
	
	OrderInfoDao dao = new OrderInfoDao();
	
	public Response<Void> add(int userid, String datatime, int seatid, int rtid, String statu,String enddatetime) {
		Response<Void> rs = new Response<Void>();
		try{
				OrderInfoModel order = new OrderInfoModel();
	            order.setOrderUserInfoId(userid);
	            order.setOrderDateTime(datatime);
	            order.setOrderStatu(statu);
	            order.setSeatId(seatid);
	            order.setRtrtId(rtid);
	            order.setEnddatetime(enddatetime);
	            order.setFoodorderidstr("");
				if (dao.add(order)) {
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
	
	public Response<Void> update(int orderId, int userid, String datatime, int seatid, int rtid, String statu) {
		Response<Void> rs = new Response<Void>();
		try{
			OrderInfoModel order = new OrderInfoModel();
            order.setOrderId(orderId);
            order.setOrderUserInfoId(userid);
            order.setOrderDateTime(datatime);
            order.setOrderStatu(statu);
            order.setSeatId(seatid);
            order.setRtrtId(rtid);
				if (dao.update(order)) {
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
	
	public Response<Void> updateByFoodStr(String orderid, String foodlist) {
		Response<Void> rs = new Response<Void>();
		try{
				if (dao.updateByFoodId(orderid,foodlist)) {
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
	
	 public Response<OrderInfoModel> queryByAll() {
		 Response<OrderInfoModel> rs = new Response<OrderInfoModel>();
			try {
				List<OrderInfoModel> list = null;
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
	 
	 public Response<OrderInfoModel> queryById(String id) {
		 Response<OrderInfoModel> rs = new Response<OrderInfoModel>();
			try {
				OrderInfoModel model = null;
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
	 
	 public Response<OrderInfoModel> queryByUserId(String Userid){
		 Response<OrderInfoModel> rs = new Response<OrderInfoModel>();
			try {
				List<OrderInfoModel> list = null;
				list = dao.queryByUserId(Userid);
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
	 public Response<OrderInfoModel> queryByIsCreate(String starttime,String endtime,String seatid){
		 Response<OrderInfoModel> rs = new Response<OrderInfoModel>();
			try {
				List<OrderInfoModel> list = null;
				list = dao.queryByIsCreate(starttime, endtime,seatid);
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

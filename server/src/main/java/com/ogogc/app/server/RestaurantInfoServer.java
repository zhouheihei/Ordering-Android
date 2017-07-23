package com.ogogc.app.server;

import java.util.List;

import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.dao.RestaurantInfoDao;

public class RestaurantInfoServer {
	RestaurantInfoDao dao  =new RestaurantInfoDao();
	
	public Response<Void> add(String rtname, String rtmarks, String rtphone, String address) {
		Response<Void> rs = new Response<Void>();
		try{
			  RestaurantInfoModel rt = new RestaurantInfoModel();
	            rt.setRtrtName(rtname);
	            rt.setRtrtaddress(address);
	            rt.setRtrtPhone(rtphone);
	            rt.setRtrtRemarks(rtmarks);
				if (dao.add(rt)) {
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
	
	public Response<Void> delete(String rtid) {
		Response<Void> rs = new Response<Void>();
		try{
			  	if (dao.delete(rtid)) {
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
	
	public Response<Void> update(String id, String rtname, String rtmarks, String rtphone, String address) {
		Response<Void> rs = new Response<Void>();
		try{
			RestaurantInfoModel rt = new RestaurantInfoModel();
            rt.setRtrtName(rtname);
            rt.setRtrtaddress(address);
            rt.setRtrtPhone(rtphone);
            rt.setRtrtRemarks(rtmarks);
			  	if (dao.update(rt)) {
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
	
	 
	 public Response<RestaurantInfoModel> queryByAll() {	
		 Response<RestaurantInfoModel> rs = new Response<RestaurantInfoModel>();
			try {
				List<RestaurantInfoModel> list = null;
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
	 
	 public Response<RestaurantInfoModel> queryByName(String name) {
		 Response<RestaurantInfoModel> rs = new Response<RestaurantInfoModel>();
			try {
				List<RestaurantInfoModel> list = null;
				list = dao.queryByName(name);
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
	 
	 public Response<RestaurantInfoModel> queryById(String id) {
		 Response<RestaurantInfoModel> rs = new Response<RestaurantInfoModel>();
			try {
				RestaurantInfoModel model = null;
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

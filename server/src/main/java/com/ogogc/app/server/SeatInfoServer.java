package com.ogogc.app.server;

import java.util.List;

import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.dao.SeatInfoDao;

public class SeatInfoServer {
	
	private SeatInfoDao dao =new SeatInfoDao();
	
	public Response<Void> add(String seatname, int min, int max, int seatstate, int seatrtrtid){
		Response<Void> rs = new Response<Void>();
		try{
			  SeatInfoModel seat=new SeatInfoModel();
	            seat.setSeatrtrtid(seatrtrtid);
	            seat.setSeatState(seatstate);
	            seat.setSeatMax(max);
	            seat.setSeatMin(min);
	            seat.setSeatName(seatname);
				if (dao.add(seat)) {
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
		try {
            dao.delete(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
		return rs;
	}
	
	public Response<Void> update(int id, String seatname, int min, int max, int seatstate, int seatrtrtid) {
		Response<Void> rs = new Response<Void>();
		try{
		      SeatInfoModel seat=new SeatInfoModel();
	            seat.setSeatId(id);
	            seat.setSeatrtrtid(seatrtrtid);
	            seat.setSeatState(seatstate);
	            seat.setSeatMax(max);
	            seat.setSeatMin(min);
	            seat.setSeatName(seatname);
			 if(dao.update(seat)){
				 rs.setMsg("true");
			 }else{
				 rs.setMsg("false");
			 }
			 rs.setEvent(200);
		}catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}
	
	public Response<Void> update(int statu, String id) {
		Response<Void> rs = new Response<Void>();
		try {
			if(dao.update(statu,id)){
				 rs.setMsg("true");
			 }else{
				 rs.setMsg("false");
			 }
			 rs.setEvent(200);
        }catch (Exception ex){
        	
        	rs.setEvent(110);
            ex.printStackTrace();
        }
		return rs;
	}
	
	public Response<SeatInfoModel> queryByAll() {
		Response<SeatInfoModel> rs = new Response<SeatInfoModel>();
		try {
			List<SeatInfoModel> list = null;
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
	
	public Response<SeatInfoModel> queryByRtId(String rtid) {
		Response<SeatInfoModel> rs = new Response<SeatInfoModel>();
		try {
			List<SeatInfoModel> list = null;
			list = dao.queryByRtId(rtid);
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
	
	public Response<SeatInfoModel> queryById(String id) {
		Response<SeatInfoModel> rs = new Response<SeatInfoModel>();
		try {
			SeatInfoModel model = null;
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

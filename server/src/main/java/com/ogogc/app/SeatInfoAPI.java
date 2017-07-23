package com.ogogc.app;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.SeatInfoServer;
import com.ogogc.app.server.UserInfoServer;


@RestController
public class SeatInfoAPI {
	
	private SeatInfoServer server = new SeatInfoServer();
	
	@RequestMapping(value = "/app/v1/seatinfo/add", method = RequestMethod.POST)
	public Response<Void> add(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.add(_para.get("seatname"), Integer.parseInt(_para.get("min")), Integer.parseInt(_para.get("max")), Integer.parseInt(_para.get("seatstate")) , Integer.parseInt(_para.get("seatrtrtid")));
	}
	
	@RequestMapping(value = "/app/v1/seatinfo/delete", method = RequestMethod.POST)
	public Response<Void> delete(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.delete(_para.get("id"));
	}
	@RequestMapping(value = "/app/v1/seatinfo/update", method = RequestMethod.POST)
	public Response<Void> update(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.update(Integer.parseInt(_para.get("statu")),_para.get("id"));
	}
	
	@RequestMapping(value = "/app/v1/seatinfo/queryByAll", method = RequestMethod.POST)
	public Response<SeatInfoModel> queryByAll(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByAll();
	}
	
	@RequestMapping(value = "/app/v1/seatinfo/querybyrtid", method = RequestMethod.POST)
	public Response<SeatInfoModel> queryByRtId(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByRtId(_para.get("rtid"));
	}
	
	@RequestMapping(value = "/app/v1/seatinfo/querybyid", method = RequestMethod.POST)
	public Response<SeatInfoModel> queryById(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryById(_para.get("id"));
	}
	
}

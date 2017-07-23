package com.ogogc.app;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.RestaurantInfoServer;
import com.ogogc.app.server.SeatInfoServer;
import com.ogogc.app.server.UserInfoServer;


@RestController
public class RestaurantInfoAPI {
	
	private RestaurantInfoServer server = new RestaurantInfoServer();
	
	@RequestMapping(value = "/app/v1/rtinfo/add", method = RequestMethod.POST)
	public Response<Void> add(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.add(_para.get("rtname") , _para.get("rtmarks"), _para.get("rtphone"), _para.get("address"));
	}
	
	@RequestMapping(value = "/app/v1/rtinfo/delete", method = RequestMethod.POST)
	public Response<Void> delete(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.delete(_para.get("rtid"));
	}
	@RequestMapping(value = "/app/v1/rtinfo/update", method = RequestMethod.POST)
	public Response<Void> update(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.update(_para.get("id") , _para.get("rtname") , _para.get("rtmarks") , _para.get("rtphone") , _para.get("address") );
	}
	
	@RequestMapping(value = "/app/v1/rtinfo/querybyall", method = RequestMethod.POST)
	public Response<RestaurantInfoModel> queryByAll(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByAll();
	}
	
	@RequestMapping(value = "/app/v1/rtinfo/querybyname", method = RequestMethod.POST)
	public Response<RestaurantInfoModel> queryByRtId(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByName(_para.get("name"));
	}
	
	@RequestMapping(value = "/app/v1/rtinfo/querybyid", method = RequestMethod.POST)
	public Response<RestaurantInfoModel> queryById(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryById(_para.get("id"));
	}
	
}

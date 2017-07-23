package com.ogogc.app;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ogogc.app.bean.FoodOrderInfoModel;
import com.ogogc.app.bean.OrderInfoModel;
import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.FoodOrderInfoServer;
import com.ogogc.app.server.OrderInfoServer;
import com.ogogc.app.server.RestaurantInfoServer;
import com.ogogc.app.server.SeatInfoServer;
import com.ogogc.app.server.UserInfoServer;


@RestController
public class FoodOrderInfoAPI {
	
	private FoodOrderInfoServer server = new FoodOrderInfoServer();
	
	@RequestMapping(value = "/app/v1/foodorderinfo/add", method = RequestMethod.POST)
	public Response<Void> add(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.add(_para.get("foodid"), _para.get("orderid"));
	}
	
	@RequestMapping(value = "/app/v1/foodorderinfo/delete", method = RequestMethod.POST)
	public Response<Void> delete(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.delete(_para.get("id"));
	}
	@RequestMapping(value = "/app/v1/foodorderinfo/update", method = RequestMethod.POST)
	public Response<Void> update(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.update(_para.get("id"),_para.get("foodid")  , _para.get("orderid") );
	}
	
	@RequestMapping(value = "/app/v1/foodorderinfo/queryByAll", method = RequestMethod.POST)
	public Response<FoodOrderInfoModel> queryByAll(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByAll();
	}
	
	@RequestMapping(value = "/app/v1/foodorderinfo/queryById", method = RequestMethod.POST)
	public Response<FoodOrderInfoModel> queryById(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryById(_para.get("id"));
	}
	
	@RequestMapping(value = "/app/v1/foodorderinfo/queryByOrderId", method = RequestMethod.POST)
	public Response<FoodOrderInfoModel> queryByOrderId(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByOrderId(_para.get("orderid"));
	}
	

}

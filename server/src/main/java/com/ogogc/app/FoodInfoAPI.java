package com.ogogc.app;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ogogc.app.bean.FoodInfoModel;
import com.ogogc.app.bean.FoodOrderInfoModel;
import com.ogogc.app.bean.OrderInfoModel;
import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.FoodInfoserver;
import com.ogogc.app.server.FoodOrderInfoServer;
import com.ogogc.app.server.OrderInfoServer;
import com.ogogc.app.server.RestaurantInfoServer;
import com.ogogc.app.server.SeatInfoServer;
import com.ogogc.app.server.UserInfoServer;


@RestController
public class FoodInfoAPI {
	
	private FoodInfoserver server = new FoodInfoserver();
	
	@RequestMapping(value = "/app/v1/foodinfo/add", method = RequestMethod.POST)
	public Response<Void> add(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.add(_para.get("foodname"),Integer.parseInt(_para.get("foodprice")), _para.get("foodpictrue") ,Integer.parseInt(_para.get("foodtrtrid")) ,_para.get("foodunit"));
	}
	
	@RequestMapping(value = "/app/v1/foodinfo/delete", method = RequestMethod.POST)
	public Response<Void> delete(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.delete(_para.get("id"));
	}
	@RequestMapping(value = "/app/v1/foodinfo/update", method = RequestMethod.POST)
	public Response<Void> update(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.update(Integer.parseInt(_para.get("id")),_para.get("foodname"),Integer.parseInt(_para.get("foodprice")) ,_para.get("foodpictrue"),Integer.parseInt(_para.get("foodtrtrid")) ,_para.get("foodunit"));
	}
	
	@RequestMapping(value = "/app/v1/foodinfo/queryByAll", method = RequestMethod.POST)
	public Response<FoodInfoModel> queryByAll(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByAll();
	}
	
	@RequestMapping(value = "/app/v1/foodinfo/queryByrtId", method = RequestMethod.POST)
	public Response<FoodInfoModel> queryByrtId(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByrtId(_para.get("rtid"));
	}
	
	@RequestMapping(value = "/app/v1/foodinfo/queryById", method = RequestMethod.POST)
	public Response<FoodInfoModel> queryById(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryById(_para.get("id"));
	}
	
	@RequestMapping(value = "/app/v1/foodinfo/queryByIdstr", method = RequestMethod.POST)
	public Response<FoodInfoModel> queryByIdstr(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		String idstr="0";
		if(null!=_para.get("idstr")){
			idstr=_para.get("idstr");
		}
		return server.queryByIdstr(idstr);
	}

}

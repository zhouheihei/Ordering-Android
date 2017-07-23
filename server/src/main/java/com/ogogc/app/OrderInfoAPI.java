package com.ogogc.app;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ogogc.app.bean.OrderInfoModel;
import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.OrderInfoServer;
import com.ogogc.app.server.RestaurantInfoServer;
import com.ogogc.app.server.SeatInfoServer;
import com.ogogc.app.server.UserInfoServer;


@RestController
public class OrderInfoAPI {
	
	private OrderInfoServer server = new OrderInfoServer();
	
	@RequestMapping(value = "/app/v1/orderinfo/add", method = RequestMethod.POST)
	public Response<Void> add(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.add(Integer.parseInt(_para.get("userid")), _para.get("datatime"),Integer.parseInt(_para.get("seatid")) , Integer.parseInt(_para.get("rtid")) ,_para.get("statu"),_para.get("enddatet"));
	}
	
	@RequestMapping(value = "/app/v1/orderinfo/delete", method = RequestMethod.POST)
	public Response<Void> delete(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.delete(_para.get("id"));
	}
	@RequestMapping(value = "/app/v1/orderinfo/update", method = RequestMethod.POST)
	public Response<Void> update(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.update(Integer.parseInt(_para.get("orderId")),Integer.parseInt(_para.get("userid")) ,_para.get("datatime") , Integer.parseInt(_para.get("seatid")) ,Integer.parseInt(_para.get("rtid")) ,_para.get("statu") );
	}	
	
	
	@RequestMapping(value = "/app/v1/orderinfo/updatebyfoodstr", method = RequestMethod.POST)
	public Response<Void> updatabyfoodstr(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		String foodlist ="0";
		if(null!=_para.get("foodlist")){
			foodlist=_para.get("foodlist");
		}
		return server.updateByFoodStr(_para.get("orderid") , foodlist );
	}
	
	@RequestMapping(value = "/app/v1/orderinfo/querybyall", method = RequestMethod.POST)
	public Response<OrderInfoModel> queryByAll(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByAll();
	}
	
	@RequestMapping(value = "/app/v1/orderinfo/queryById", method = RequestMethod.POST)
	public Response<OrderInfoModel> queryById(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryById(_para.get("id"));
	}
	
	@RequestMapping(value = "/app/v1/orderinfo/queryByUserId", method = RequestMethod.POST)
	public Response<OrderInfoModel> queryByUserId(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByUserId(_para.get("Userid"));
	}
	
	@RequestMapping(value = "/app/v1/orderinfo/querybuiscreate", method = RequestMethod.POST)
	public Response<OrderInfoModel> queryByIsCreate(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByIsCreate(_para.get("starttime"),_para.get("endtime"),_para.get("seatid"));
	}
}

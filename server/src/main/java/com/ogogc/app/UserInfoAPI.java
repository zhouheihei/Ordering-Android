package com.ogogc.app;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.UserInfoServer;

/**
 * 用户信息
 * 接收客户端发送消息
 * @author nosleep
 *	2016年09月21日11:46:03
 */
@RestController
public class UserInfoAPI {
	private UserInfoServer server = new UserInfoServer();
	
	@RequestMapping(value = "/app/v1/users/add", method = RequestMethod.POST)
	public Response<Void> add(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.add(_para.get("phone"), _para.get("pwd"), _para.get("number"));
	}
	
	@RequestMapping(value = "/app/v1/users/userlogin", method = RequestMethod.POST)
	public Response<UserInfoModel> userlogin(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.userLogin(_para.get("phone"), _para.get("pwd"));
	}
	@RequestMapping(value = "/app/v1/users/querybyall", method = RequestMethod.POST)
	public Response<UserInfoModel> queryByAll(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return server.queryByAll();
	}
	
	
	
	@RequestMapping(value = "/app/v1/users/querybytest", method = RequestMethod.POST)
	public String querytest(@RequestBody String para){
		System.out.println("请求参数："+para);
		Map<String , String > _para = StringUtil.StringToMap(para);
		return "nihao";
	}
	@RequestMapping(value = "/app/v1/users/test", method = RequestMethod.GET)
	public String test(){
		return "nihao";
	}
//	@RequestMapping(value = "/app/v1/users/updatabypic", method = RequestMethod.POST)
//	@ResponseBody
//	public Response<Void> updatabypic(
//			@RequestPart("file") MultipartFile file
//			,@RequestPart("newvalue") String newvalue
//			,@RequestPart("key") String key
//			,@RequestPart("userid") String userid
//			){
//		System.out.println("请求参数："+newvalue+key);
//		if(null!=file)
//			try {
//				FileUtils.SaveFileFromInputStream(file.getInputStream(),SetConstant.BASEPATH_UPLOAD,"img/"+newvalue+StringUtil.subName(file.getOriginalFilename()));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		Map<String , String > _para = new HashMap<String,String>();
//		_para.put(key, newvalue+StringUtil.subName(file.getOriginalFilename()));
//		return server.update(_para,userid);
//	}
//	
//	@RequestMapping(value = "/app/v1/users/updata", method = RequestMethod.POST)
//	public Response<Void> updata(@RequestBody String para
//			){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		Map<String , String > newpara=new HashMap<String,String>();
//		newpara.put(_para.get("key"), _para.get("newvalue"));
//		return server.update(newpara,_para.get("userid"));
//	}
//	
//	@RequestMapping(value = "/app/v1/users/querybyall", method = RequestMethod.POST)
//	public Response<UserInfoBean> queryByAll(@RequestBody String para){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		return server.queryByAll(_para.get("page"), _para.get("pagesize"));
//	}
//	
//	@RequestMapping(value = "/app/v1/users/querybyuserid", method = RequestMethod.POST)
//	public Response<UserInfoBean> queryByUserId(@RequestBody String para){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		return server.queryById(_para.get("uid"));
//	}
//	
//	@RequestMapping(value = "/app/v1/users/sendnumber", method = RequestMethod.POST)
//	public Response<Void> senPhone(@RequestBody String para){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		return server.sendPhone(_para.get("phone"));
//	}
//	
//	@RequestMapping(value = "/app/v1/users/loginuser", method = RequestMethod.POST)
//	public Response<Void> loginuser(@RequestBody String para){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		return server.queryByLogin(_para.get("uname"), _para.get("upwd"));
//	}
//	
//	@RequestMapping(value = "/app/v1/users/querybyusername", method = RequestMethod.POST)
//	public Response<Void> queryByUserName(@RequestBody String para){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		return server.queryByUserName(_para.get("uname"));
//	}
//	
//	@RequestMapping(value = "/app/v1/users/isphonenumber", method = RequestMethod.POST)
//	public Response<Void> isphonenumber(@RequestBody String para){
//		System.out.println("请求参数："+para);
//		Map<String , String > _para = StringUtil.StringToMap(para);
//		String phone =_para.get("phone");
//		String number = _para.get("number");
//		Response<Void> rs = new Response<Void>();
//		if(number.equals("1234")){
//			rs.setEvent(200);
//			rs.setMsg("true");
//		}else{
//			rs.setEvent(110);
//			rs.setMsg("false");
//		}
//		return rs;
//	}
	
}

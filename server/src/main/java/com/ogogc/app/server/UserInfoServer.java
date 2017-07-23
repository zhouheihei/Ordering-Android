package com.ogogc.app.server;

import java.util.List;
import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.dao.UserInfoDao;

/**
 * 用户信息逻辑
 * 
 * @author nosleep 对接收到的参数，装调用Dao进行持久化操作，并且对处理所有异常处理
 */
public class UserInfoServer {

	private UserInfoDao dao = new UserInfoDao();

	/**
	 * 添加用户 先进行手机验证码匹配，后进行持久化
	 * 
	 * @param phone
	 *            　 注册手机号码
	 * @param pwd
	 *            注册登陆密码
	 * @param number
	 *            手机验证码
	 * @return　true成功
	 */
	public Response<Void> add(String phone, String pwd, String number) {
		Response<Void> rs = new Response<Void>();
		rs.setEvent(200);
		System.out.println("验证码参数：" + number);
		try {
			if (phone.isEmpty() && pwd.isEmpty() && number.isEmpty()) {
				rs.setEvent(110);
				rs.setMsg(Strings.USERINFO_ERROR);
			} else {
				
				if (dao.add(phone, pwd)) {
					rs.setEvent(200);
					rs.setMsg(phone);
				} else {
					rs.setMsg(Strings.USERINFO_DAOERROR);
				}
			}
		} catch (Exception e) {
			System.out.println("Server层异常捕获:" + e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}

	/**
	 * 查询所有用户
	 * 
	 * @param page
	 *            当前页数
	 * @param pagesize
	 *            每页条数
	 * @return 封装返回消息对象
	 */
	public Response<UserInfoModel> queryByAll() {
		Response<UserInfoModel> rs = new Response<UserInfoModel>();
		try {
			List<UserInfoModel> list = null;
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
	/**
	 * 登录验证
	 * @param username
	 * @param userpwd
	 * @return
	 */
	public Response<UserInfoModel> userLogin(String username,String userpwd){
		Response<UserInfoModel> rs = new Response<UserInfoModel>();
		try{
			UserInfoModel obj=dao.userLogin(username,userpwd);
			 rs.setObj(obj);
			 rs.setEvent(200);
		}catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(Strings.USERINFO_EXERROR);
		}
		return rs;
	}
	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public Response<UserInfoModel> queryById(String id) {
		Response<UserInfoModel> rs = new Response<UserInfoModel>();
		try {
			int uid = Integer.parseInt(id);
			UserInfoModel user = dao.queryByUserId(id);
			rs.setEvent(200);
			rs.setObj(user);
		} catch (Exception e) {
			System.out.println(e.toString());
			rs.setEvent(110);
			rs.setMsg(e.toString());
		}
		return rs;
	}

}

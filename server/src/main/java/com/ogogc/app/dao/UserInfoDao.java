package com.ogogc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ogogc.app.DatabaseUtil;
import com.ogogc.app.bean.UserInfoBean;
import com.ogogc.app.bean.UserInfoModel;

/**
 * 用户数据层操作
 * 
 * @author nosleep 与客户端ＡＰＰ　ＡＰＩ接口一致
 */
public class UserInfoDao {

	private JdbcTemplate jdbcTemplate = DatabaseUtil.getjdbc();

	// 查询所有用户
	public List<UserInfoModel> queryByAll() {
        String sql ="select * from tb_userinfo";
        return  this.queryBySql(sql);
    }
	
	// 根据用户ＩＤ查询用户信息
	 public UserInfoModel queryByUserId(String id) {
	        String sql ="select * from tb_userinfo where userinfoid="+id;
	        List<UserInfoModel> list= this.queryBySql(sql);
	        if(list.size()>0){
	            return list.get(0);
	        }
	        return  null;
	    }
	 /**
	  * 根据用户名密码查询
	  * @param name
	  * @param pwd
	  * @return
	  */
	 public UserInfoModel queryByNameAndPwd(String name, String pwd) {
	        String sql = "select * from tb_userinfo where userinfoname='"+
	                name+"' and userinfopwd='"+pwd+"'";
	        List<UserInfoModel> list =this.queryBySql(sql);
	        if(null!=list&&list.size()>0){
	            return list.get(0);
	        }
	        return null;
	    }
	 
	/**
	 * 用户登录验证
	 * @param phonenumber  手机号码
	 * @return  用户ID  如果没有返回0  ，否则返回ID
	 */
	 public UserInfoModel userLogin(String name, String pwd) {
	        return this.queryByNameAndPwd(name,pwd);
	    }

	/**
	 * 添加用户
	 * 
	 * @param phone
	 *            　注册时填写手机号
	 * @param pwd
	 *            　 ＭＤ５加密密码
	 * @return　true　添加成功　false　失败
	 */
    public boolean add(String username,String userpwd){
    	boolean msg = false;
        String sql ="insert into tb_userinfo(userinfoname,userinfopwd) values('"
                +username+"','"
                +userpwd+"')";
        System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	/**
	 * 更新用户信息
	 * 
	 * @param para
	 *            　更新参数
	 * @param id
	 *            　　　用户ｕＩＤ
	 * @return　true　添加成功　false　失败
	 */
	public boolean update(UserInfoModel user) {
		boolean msg = false;
        String sql ="update tb_userinfo set "+
                "userinfoname="+user.getUserinfoName()+
                ",userinfopwd="+user.getUserinfoPwd()+
                " where userinfoid="+user.getUserinfoId();
        System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	// 根据ＳＱＬ查询用户信息
	private List<UserInfoModel> queryBySql(String sql) {
		System.out.println(sql);
		List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		list = (List<UserInfoModel>) jdbcTemplate.query(sql,
				new RowMapper<UserInfoModel>() {
					public UserInfoModel mapRow(ResultSet rs, int i)
							throws SQLException {
						UserInfoModel user = new UserInfoModel();
						user.setUserinfoId(rs.getInt("userinfoId"));
						user.setUserinfoName(rs.getString("userinfoName"));
						user.setUserinfoPwd(rs.getString("userinfoPwd"));
						return user;
					}
				});
		return list;
	}
}

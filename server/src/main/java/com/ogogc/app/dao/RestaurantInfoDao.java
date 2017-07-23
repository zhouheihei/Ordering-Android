package com.ogogc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ogogc.app.DatabaseUtil;
import com.ogogc.app.bean.RestaurantInfoModel;
import com.ogogc.app.bean.UserInfoModel;

public class RestaurantInfoDao {

	private JdbcTemplate jdbcTemplate = DatabaseUtil.getjdbc();

	/**
	 * 添加一条餐厅信息
	 * 
	 * @param rtinfo
	 *            餐厅对象
	 */
	public boolean add(RestaurantInfoModel rtinfo) {
		boolean msg = false;
		String sql = "insert into tb_restaurantinfo(rtrtName,rtrtremarks,rtrtphone,rtrtaddress) values('"
				+ rtinfo.getRtrtName()
				+ "','"
				+ rtinfo.getRtrtRemarks()
				+ "','"
				+ rtinfo.getRtrtPhone()
				+ "','"
				+ rtinfo.getRtrtaddress() + "')";
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
	 * 删除餐厅信息
	 * 
	 * @param rtid
	 *            餐厅ID
	 */
	public boolean delete(String rtid) {
		boolean msg = false;
		String sql = "delete tb_restaurantinfo where userinfoid=" + rtid;
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
	 * 更新餐厅信息
	 * 
	 * @param rtinfo
	 *            餐厅对象
	 */
	public boolean update(RestaurantInfoModel rtinfo) {
		boolean msg = false;
		String sql = "update tb_restaurantinfo set " + "rtrtName="
				+ rtinfo.getRtrtName() + ",rtrtremarks="
				+ rtinfo.getRtrtRemarks() + ",rtrtphone="
				+ rtinfo.getRtrtPhone() + ",rtrtaddress="
				+ rtinfo.getRtrtaddress() + " where rtrtId="
				+ rtinfo.getRtrtId();
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
	 * 根据SQL查询餐厅信息
	 * 
	 * @param sql
	 * @return 餐厅信息集合
	 */
	public List<RestaurantInfoModel> queryBySql(String sql) {
		System.out.println(sql);
		List<RestaurantInfoModel> list = new ArrayList<RestaurantInfoModel>();
		list = (List<RestaurantInfoModel>) jdbcTemplate.query(sql,
				new RowMapper<RestaurantInfoModel>() {
					public RestaurantInfoModel mapRow(ResultSet rs, int i)
							throws SQLException {
						RestaurantInfoModel _rt = new RestaurantInfoModel();
						_rt.setRtrtId(rs.getInt("rtrtId"));
						_rt.setRtrtName(rs.getString("rtrtName"));
						_rt.setRtrtRemarks(rs.getString("rtrtremarks"));
						_rt.setRtrtPhone(rs.getString("rtrtphone"));
						_rt.setRtrtaddress(rs.getString("rtrtaddress"));
						return _rt;
					}
				});
		return list;
	}

	/**
	 * 查询所有餐厅信息
	 * 
	 * @return 餐厅信息集合
	 */
	public List<RestaurantInfoModel> queryByAll() {
		String sql ="select * from tb_restaurantinfo";
        return  this.queryBySql(sql);
	}

	/**
	 * 根据餐厅名称模糊查询
	 * 
	 * @param name
	 *            餐厅名称
	 * @return 集合
	 */
	public List<RestaurantInfoModel> queryByName(String name) {
        String sql ="select * from tb_restaurantinfo where rtrtName like '%"+name+"%'";
        return  this.queryBySql(sql);
	}

	/**
	 * 根据餐厅ID查询
	 * 
	 * @param id
	 *            餐厅ID
	 * @return 餐厅信息对象
	 */
	public RestaurantInfoModel queryById(String id) {
		String sql ="select * from tb_restaurantinfo where rtrtId="+id;
        List<RestaurantInfoModel> list = this.queryBySql(sql);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
	}
}

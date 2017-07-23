package com.ogogc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ogogc.app.DatabaseUtil;
import com.ogogc.app.bean.FoodInfoModel;
import com.ogogc.app.bean.UserInfoModel;

public class FoodInfoDao {

	private JdbcTemplate jdbcTemplate = DatabaseUtil.getjdbc();

	public boolean add(FoodInfoModel food) {
		boolean msg = false;
		String sql = "insert into tb_foodinfo(foodName,foodprice,foodpictrue,foodrtrtid,foodunit) values('"
				+ food.getFoodName()
				+ "',"
				+ food.getFoodPrice()
				+ ",'"
				+ food.getFoodPictrue()
				+ "',"
				+ food.getFoodRtrtId()
				+ ",'"
				+ food.getFoodunit() + "')";
		System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
	}

	public boolean delete(String id) {
		boolean msg = false;
		String sql = "delete tb_foodinfo where foodId=" + id;
		System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
	}

	public boolean update(FoodInfoModel food) {
		boolean msg;
		String sql = "update tb_footinfo set " + "foodName="
				+ food.getFoodName() + ",foodprice=" + food.getFoodPrice()
				+ ",foodpictrue=" + food.getFoodPictrue() + ",foodrtrtid="
				+ food.getFoodRtrtId() + ",foodunit=" + food.getFoodunit()
				+ " where foodId=" + food.getFoodId();
		System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
	}

	public List<FoodInfoModel> queryBySql(String sql) {
		System.out.println(sql);
		List<FoodInfoModel> list = new ArrayList<FoodInfoModel>();
		list = (List<FoodInfoModel>) jdbcTemplate.query(sql,
				new RowMapper<FoodInfoModel>() {
					public FoodInfoModel mapRow(ResultSet rs, int i)
							throws SQLException {
						FoodInfoModel _foot = new FoodInfoModel();
						_foot.setFoodId(rs.getInt("foodId"));
						_foot.setFoodName(rs.getString("foodName"));
						_foot.setFoodPrice(rs.getInt("foodprice"));
						_foot.setFoodPictrue(rs.getString("foodpictrue"));
						_foot.setFoodRtrtId(rs.getInt("foodrtrtid"));
						_foot.setFoodunit(rs.getString("foodunit"));
						return _foot;
					}
				});
		return list;
	}

	public List<FoodInfoModel> queryByAll() {
		String sql ="select * from tb_foodinfo";
        return  this.queryBySql(sql);
	}

	public List<FoodInfoModel> queryByrtId(String rtid) {
		 String sql ="select * from tb_foodinfo where foodrtrtid="+rtid;
	        List<FoodInfoModel> list = this.queryBySql(sql);
	        return list;
	}

	public FoodInfoModel queryById(String id) {
		String sql ="select * from tb_foodinfo where foodId="+id;
        List<FoodInfoModel> list = this.queryBySql(sql);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
	}
	public List<FoodInfoModel> queryByIdstr(String idstr) {
		String sql ="select * from tb_foodinfo where foodId in ("+idstr+")";
        List<FoodInfoModel> list = this.queryBySql(sql);
        if(list.size()>0){
            return list;
        }
        return null;
	}
}

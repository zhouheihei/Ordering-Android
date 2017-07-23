package com.ogogc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ogogc.app.DatabaseUtil;
import com.ogogc.app.bean.FoodOrderInfoModel;
import com.ogogc.app.bean.UserInfoModel;

public class FoodOrderInfoDao {
	
	private JdbcTemplate jdbcTemplate = DatabaseUtil.getjdbc();
	
	public boolean add(String foodid,String orderid){
		boolean msg = false;
		 String sql ="insert into tb_foodorderinfo(foodid,foodorder) values("
	                +foodid+","
	                +orderid+")"
	                ;
        System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
	}
	
	public boolean delete(String id){
    	boolean msg = false;
    	String sql ="delete tb_foodorderinfo where foodorderId="+id;
       System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	
	public boolean update(String id,String foodid,String orderid){
    	boolean msg = false;
    	String sql ="update tb_foodorderinfo set "+
                ",foodid="+foodid+
                ",foodorder="+orderid+
                " where foodorderId="+id;
       System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	
	public List<FoodOrderInfoModel> queryBySql(String sql){
    	System.out.println(sql);
		List<FoodOrderInfoModel> list = new ArrayList<FoodOrderInfoModel>();
		list = (List<FoodOrderInfoModel>) jdbcTemplate.query(sql,
				new RowMapper<FoodOrderInfoModel>() {
					public FoodOrderInfoModel mapRow(ResultSet rs, int i)
							throws SQLException {
						 FoodOrderInfoModel _foodorder = new FoodOrderInfoModel();
				            _foodorder.setFoodOrderInfoId(rs.getInt("foodorderId"));
				            _foodorder.setFoodId(rs.getInt("foodid"));
				            _foodorder.setOrderId(rs.getInt("foodorder"));
						return _foodorder;
					}
				});
		return list;
    	}
    
	public  List<FoodOrderInfoModel> queryByAll(){
    	String sql ="select * from tb_foodorderinfo";
        return  this.queryBySql(sql);
    }
	public FoodOrderInfoModel queryById(String id){
    	String sql ="select * from tb_foodorderinfo where foodorderId="+id;
        List<FoodOrderInfoModel> list = this.queryBySql(sql);
        if(list.size()>0){
            return list.get(0);
        }
        return null;

    }
	public List<FoodOrderInfoModel> queryByOrderId(String orderid){
    	String sql ="select * from tb_foodorderinfo where foodorder="+orderid;
        List<FoodOrderInfoModel> list = this.queryBySql(sql);
        return list;
	}
}

package com.ogogc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ogogc.app.DatabaseUtil;
import com.ogogc.app.bean.OrderInfoModel;
import com.ogogc.app.bean.UserInfoModel;

public class OrderInfoDao {
	
	private JdbcTemplate jdbcTemplate = DatabaseUtil.getjdbc();
	
	public boolean add(OrderInfoModel order){
		boolean msg = false;
		String sql ="insert into tb_orderinfo(orderuserinfoid,orderdatetime,seatid,rtrtid,orderstatu,enddatetime,foodorderidstr) values("
                +order.getOrderUserInfoId()+",'"
                +order.getOrderDateTime()+"',"
                +order.getSeatId()+","
                +order.getRtrtId()+",'"
                +order.getOrderStatu()+"','"
                +order.getEnddatetime()+"','"
                +order.getFoodorderidstr()+"')"
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
		String sql ="delete tb_orderinfo where orderId="+id;
        System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	public boolean update(OrderInfoModel order){
    	boolean msg = false;
    	 String sql ="update tb_orderinfo set "+
                 "orderuserinfoid="+order.getOrderUserInfoId()+
                 ",orderdatetime='"+order.getOrderDateTime()+
                 "',seatid="+order.getSeatId()+
                 ",rtrtid="+order.getRtrtId()+
                 ",orderstatu='"+order.getOrderStatu()+
                 "' where orderId="+order.getOrderId();
        System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	public boolean updateByFoodId(String orderid,String idlist){
    	boolean msg = false;
    	 String sql ="update tb_orderinfo set "+
                 "foodorderidstr='"+idlist+
                 "' where orderId="+orderid;
       System.out.println(sql);
		int i = jdbcTemplate.update(sql);
		if (i > 0) {
			msg = true;
		} else {
			msg = false;
		}
		return msg;
    }
	
	public List<OrderInfoModel> queryBySql(String sql){
    	System.out.println(sql);
		List<OrderInfoModel> list = new ArrayList<OrderInfoModel>();
		list = (List<OrderInfoModel>) jdbcTemplate.query(sql,
				new RowMapper<OrderInfoModel>() {
					public OrderInfoModel mapRow(ResultSet rs, int i)
							throws SQLException {
						OrderInfoModel _orderinfo = new OrderInfoModel();
			            _orderinfo.setOrderId(rs.getInt("orderId"));
			            _orderinfo.setOrderUserInfoId(rs.getInt("orderuserinfoid"));
			            _orderinfo.setOrderDateTime(rs.getString("orderdatetime"));
			            _orderinfo.setSeatId(rs.getInt("seatid"));
			            _orderinfo.setRtrtId(rs.getInt("rtrtid"));
			            _orderinfo.setOrderStatu(rs.getString("orderstatu"));
			            _orderinfo.setFoodorderidstr(rs.getString("foodorderidstr"));
			            _orderinfo.setEnddatetime(rs.getString("enddatetime"));
						return _orderinfo;
					}
				});
		return list;
    }
    
	public List<OrderInfoModel> queryByAll(){
    	String sql ="select * from tb_orderinfo";
        return  this.queryBySql(sql);
    }
	public OrderInfoModel queryById(String id){
    	 String sql ="select * from tb_orderinfo where orderId="+id;
         List<OrderInfoModel> list = this.queryBySql(sql);
         if(list.size()>0){
             return list.get(0);
         }
         return null;
    }
	public List<OrderInfoModel> queryByUserId(String Userid){
    	String sql ="select * from tb_orderinfo where orderuserinfoid="+Userid;
        List<OrderInfoModel> list = this.queryBySql(sql);
        return list;
    }
	
	public List<OrderInfoModel> queryByIsCreate(String starttiem,String endtime,String seatid){
    	String sql ="select * from tb_orderinfo where ((orderdatetime<='"+starttiem+"' and '"+starttiem+"'<=enddatetime) or (orderdatetime<='"+endtime+"' and '"+endtime+"'<=enddatetime)) and orderstatu='进行' and seatid="+seatid;
    	System.out.println(sql);
        List<OrderInfoModel> list = this.queryBySql(sql);
        return list;
    }
}

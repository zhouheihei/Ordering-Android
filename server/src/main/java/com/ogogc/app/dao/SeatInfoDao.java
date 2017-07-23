package com.ogogc.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ogogc.app.DatabaseUtil;
import com.ogogc.app.bean.SeatInfoModel;
import com.ogogc.app.bean.UserInfoModel;

public class SeatInfoDao {

	private JdbcTemplate jdbcTemplate = DatabaseUtil.getjdbc();

	/**
	 * 添加一台位置信息
	 * 
	 * @param seat
	 *            位置信息实体
	 */
	public boolean add(SeatInfoModel seat) {
		boolean msg = false;
		String sql = "insert into tb_seatinfo(seatName,seatmin,seatmax,seatstate,seatrtrtid) values('"
				+ seat.getSeatName()
				+ "',"
				+ seat.getSeatMin()
				+ ","
				+ seat.getSeatMax()
				+ ","
				+ seat.getSeatState()
				+ ","
				+ seat.getSeatrtrtid() + ")";
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
	 * 删除一条信息
	 * 
	 * @param id
	 */
	public boolean delete(String id) {
		boolean msg = false;
		String sql = "delete tb_seatinfo where seatId=" + id;
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
	 * 更新信息
	 * 
	 * @param seat
	 *            座位实体
	 */
	public boolean update(SeatInfoModel seat) {
		boolean msg = false;
		String sql ="update tb_seatinfo set "+
                "seatName="+seat.getSeatName()+
                ",seatmin="+seat.getSeatMin()+
                ",seatmax="+seat.getSeatMax()+
                ",seatstate="+seat.getSeatState()+
                ",seatrtrtid="+seat.getSeatrtrtid()+
                " where seatId="+seat.getSeatId();
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
	 * 跟新位置状态
	 * 
	 * @param statu
	 *            状态 0空位, 1预约
	 * @param id
	 *            位置iD
	 */
	public boolean update(int statu, String id) {
		boolean msg = false;
		String sql ="update tb_seatinfo set "+
                "seatstate="+statu+
                " where seatId="+id;
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
	 * 根据SQL查询信息
	 * 
	 * @param sql
	 * @return
	 */
	public List<SeatInfoModel> queryBySql(String sql) {
		System.out.println(sql);
		List<SeatInfoModel> list = new ArrayList<SeatInfoModel>();
		list = (List<SeatInfoModel>) jdbcTemplate.query(sql,
				new RowMapper<SeatInfoModel>() {
					public SeatInfoModel mapRow(ResultSet rs, int i)
							throws SQLException {
						 SeatInfoModel _seat = new SeatInfoModel();
				            _seat.setSeatId(rs.getInt("seatId"));
				            _seat.setSeatName(rs.getString("seatName"));
				            _seat.setSeatMin(rs.getInt("seatmin"));
				            _seat.setSeatMax(rs.getInt("seatmax"));
				            _seat.setSeatState(rs.getInt("seatstate"));
				            _seat.setSeatrtrtid(rs.getInt("seatrtrtid"));
						return _seat;
					}
				});
		return list;
	}

	/**
	 * 查询所有信息
	 * 
	 * @return
	 */
	public List<SeatInfoModel> queryByAll() {
		 String sql ="select * from tb_seatinfo";
	        return  this.queryBySql(sql);
	}

	/**
	 * 根据餐厅ID查询信息
	 * 
	 * @param rtid
	 *            座位ID
	 * @return
	 */
	public List<SeatInfoModel> queryByRtId(String rtid) {
		String sql ="select * from tb_seatinfo where seatrtrtid="+rtid;
        List<SeatInfoModel> list = this.queryBySql(sql);
        return list;
	}

	/**
	 * 根据ID查询信息
	 * 
	 * @param id
	 *            信息ID
	 * @return
	 */
	public SeatInfoModel queryById(String id) {
		String sql ="select * from tb_seatinfo where seatId="+id;
        List<SeatInfoModel> list = this.queryBySql(sql);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
	}
}

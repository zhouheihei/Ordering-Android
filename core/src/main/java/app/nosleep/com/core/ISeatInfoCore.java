package app.nosleep.com.core;

import java.util.List;

import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.SeatInfoModel;

/**
 * Created by nosleep on 17-3-9.
 * 日期：17-3-9上午9:19
 * author:zzh
 * override:
 */

public interface ISeatInfoCore {

    /**
     * 添加一台位置信息
     * @param seatname  位置名称
     * @param min       最最小座位数
     * @param max       最大座位数
     * @param seatstate 座位状态
     * @param seatrtrtid 餐厅ID
     */
    void add(String seatname,int min,int max,int seatstate,int seatrtrtid,ActionCallBackListener<String> listener);

    /**
     * 删除一条信息
     * @param id
     */
    void delete(String id,ActionCallBackListener<String> listener);


    /**
     * 更新实体
     * @param id            iD
     * @param seatname      座位名称
     * @param min           最小数
     * @param max           最大数
     * @param seatstate     座位状态
     * @param seatrtrtid    餐厅ID
     */
    void update(int id,String seatname,int min,int max,int seatstate,int seatrtrtid,ActionCallBackListener<String> listener);

    /**
     * 跟新位置状态
     * @param statu 状态 0空位, 1预约
     * @param id    位置iD
     */
    void update(int statu,String id,ActionCallBackListener<String> listener);

    /**
     * 根据SQL查询信息
     * @param sql
     * @return
     */
    void queryBySql(String sql);

    /**
     * 查询所有信息
     * @return
     */
    void queryByAll(ActionCallBackListener<List<SeatInfoModel>> listener);

    /**
     * 根据餐厅ID查询信息
     * @param rtid 座位ID
     * @return
     */
    void queryByRtId(String rtid,ActionCallBackListener<List<SeatInfoModel>> listener);

    /**
     * 根据ID查询信息
     * @param id 信息ID
     * @return
     */
    void queryById(String id,ActionCallBackListener<SeatInfoModel> listener);
}

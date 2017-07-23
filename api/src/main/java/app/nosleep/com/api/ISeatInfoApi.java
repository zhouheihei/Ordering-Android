package app.nosleep.com.api;

import java.util.List;

import app.nosleep.com.api.mysql.ApiCallBackCroe;
import app.nosleep.com.model.SeatInfoModel;
import app.nosleep.com.model.UserInfoModel;

/**
 * Created by nosleep on 17-3-8.
 * 日期：17-3-8下午2:32
 * author:zzh
 * override:
 */

public interface ISeatInfoApi {
    /**
     * 添加一台位置信息
     * @param seat 位置信息实体
     */
    void add(SeatInfoModel seat,ApiCallBackCroe<Void> callback);

    /**
     * 删除一条信息
     * @param id
     */
    void delete(String id,ApiCallBackCroe<Void> callback);

    /**
     * 更新信息
     * @param seat 座位实体
     */
    void update(SeatInfoModel seat,ApiCallBackCroe<Void> callback);

    /**
     * 跟新位置状态
     * @param statu 状态 0空位, 1预约
     * @param id    位置iD
     */
    void update(int statu,String id,ApiCallBackCroe<Void> callback);

    /**
     * 根据SQL查询信息
     * @param sql
     * @return
     */
    void queryBySql(String sql,ApiCallBackCroe<Void> callback);

    /**
     * 查询所有信息
     * @return
     */
    void queryByAll(ApiCallBackCroe<SeatInfoModel> callback);

    /**
     * 根据餐厅ID查询信息
     * @param rtid 座位ID
     * @return
     */
    void queryByRtId(String rtid,ApiCallBackCroe<SeatInfoModel> callback);

    /**
     * 根据ID查询信息
     * @param id 信息ID
     * @return
     */
    void queryById(String id,ApiCallBackCroe<SeatInfoModel> callback);

}

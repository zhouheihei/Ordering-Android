package app.nosleep.com.ordering;

import android.app.Application;

import app.nosleep.com.model.UserInfoModel;


/**
 * Created by nosleep on 17-3-12.
 * 日期：17-3-12上午11:45
 * author:zzh
 * override:
 */

public class BaseApp extends Application {

    public UserInfoModel USERINFO;
    public int YEARS;       //年
    public int MONTH;       //月
    public int DAY;         //日
    public int HOUR;        //时
    public int MINUTE;      //分
    public int SeatId;
    public int RtId;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}

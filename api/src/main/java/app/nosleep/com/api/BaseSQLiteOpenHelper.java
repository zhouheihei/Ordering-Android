package app.nosleep.com.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nosleep on 16-12-6.
 * 日期：16-12-6下午1:20
 * author:zzh
 * override:
 */

public class BaseSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ordering.db";
    private static final int DB_VERSION = 1;

    public BaseSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("数据库","数据库初始化");
        //创建用户信息表
        db.execSQL("CREATE TABLE tb_userinfo(" +
                "userinfoId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "userinfoName TEXT," +
                "userinfoPwd TEXT)");
        //创建餐厅信息表
        db.execSQL("CREATE TABLE tb_restaurantinfo(" +
                "rtrtId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "rtrtName TEXT," +
                "rtrtremarks TEXT," +
                "rtrtphone TEXT," +
                "rtrtaddress TEXT)");
        //创建位置信息表
        db.execSQL("CREATE TABLE tb_seatinfo(" +
                "seatId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "seatName TEXT," +
                "seatmin INTEGER," +
                "seatmax INTEGER," +
                "seatrtrtid INTEGER," +
                "seatstate INTEGER)");
        //创建菜品信息表
        db.execSQL("CREATE TABLE tb_foodinfo(" +
                "foodId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "foodName TEXT," +
                "foodprice INTEGER," +
                "foodpictrue TEXT," +
                "foodunit TEXT," +
                "foodrtrtid INTEGER)");
        //创建点菜信息表
        db.execSQL("CREATE TABLE tb_foodorderinfo(" +
                "foodorderId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "foodid INTEGER," +
                "foodorder INTEGER)");
        //创建订单信息表
        db.execSQL("CREATE TABLE tb_orderinfo(" +
                "orderId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "orderuserinfoid INTEGER," +
                "orderdatetime TEXT," +
                "seatid INTEGER," +
                "orderstatu TEXT," +
                "rtrtid INTEGER," +
                "foodorderidstr TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 执行一条SQL
     * @param sql
     */
    public void execBySql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    /**
     * 查询SQL
     * @param sql
     * @return Cursor集合
     */
    public Cursor getBySql(String sql) {
        Cursor c=getWritableDatabase().rawQuery(sql, null);
        return c;
    }
}

package app.nosleep.com.ordering;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.nosleep.com.core.IOrderInfoCore;
import app.nosleep.com.core.OrderInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.OrderInfoModel;

public class SelectTimeActivity extends AppCompatActivity {
    private TimePicker mTime;
    private BaseApp mApp;
    private IOrderInfoCore core;
    private String datetime;
    private String mEnddateTime;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=getApplicationContext();
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApp= (BaseApp) getApplication();
        mTime= (TimePicker) findViewById(R.id.selecttime_time);
        mTime.setIs24HourView(true);
        Date _newdate =new Date();
        mApp.HOUR=_newdate.getHours();
        mApp.MINUTE=_newdate.getMinutes();
        mTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                String _datetime=mApp.YEARS+"-"+mApp.MONTH+"-"+mApp.DAY+" "+hour+":"+minute;
                SimpleDateFormat _sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
                Date _date ;
                Date _nowdate;
                try {
                    _date = _sdf.parse(_datetime);
                    _nowdate=new Date();
                    if(_date.getTime()<_nowdate.getTime()){
                        Snackbar.make(mTime,"请选择有效日期", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                    }else{
                        mApp.HOUR=hour;
                        mApp.MINUTE=minute;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, mApp.YEARS+"-"+mApp.MONTH+"-"+mApp.DAY+"-"+" "+mApp.HOUR+":"+mApp.MINUTE, Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                datetime=mApp.YEARS+"-"+mApp.MONTH+"-"+mApp.DAY+" "+mApp.HOUR+":"+mApp.MINUTE;
                core = new OrderInfoCoreImpl(getApplicationContext());
                SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm" );
                String starttime="";
                String endtime="";
                Date date = null;
                try {
                    date = sdf.parse(datetime);
                    starttime=sdf.format(date);
                    datetime=starttime;
                    Calendar ca=Calendar.getInstance();
                    ca.setTime(date);
                    ca.add(Calendar.HOUR_OF_DAY, 3);
                    endtime=sdf.format(ca.getTime());
                    mEnddateTime=endtime;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Log.v("datatime","开始时间"+starttime+"结束时间"+endtime+"添加时间"+datetime);
                core.queryByIsCreate(starttime, endtime,mApp.SeatId+"", new ActionCallBackListener<List<OrderInfoModel>>() {
                    @Override
                    public void onSuccess(List<OrderInfoModel> Data) {
                        if(null==Data||Data.size()<=0){
                            core.add(mApp.USERINFO.getUserinfoId(), datetime, mApp.SeatId, mApp.RtId, "进行",mEnddateTime, new ActionCallBackListener<String>() {
                                @Override
                                public void onSuccess(String Data) {
                                    core.queryByUserId(mApp.USERINFO.getUserinfoId() + "", new ActionCallBackListener<List<OrderInfoModel>>() {
                                        @Override
                                        public void onSuccess(List<OrderInfoModel> Data) {
                                            if(null!=Data){
                                                String addorderid="1";
                                                if(Data.size()>0){
                                                    addorderid=Data.get(Data.size()-1).getOrderId()+"";
                                                }
                                                Intent intent = new Intent(SelectTimeActivity.this,OrderActivity.class);
                                                intent.putExtra("orderid",addorderid);
                                                SelectTimeActivity.this.startActivity(intent);
                                                SelectTimeActivity.this.finish();
                                            }

                                        }

                                        @Override
                                        public void onFailure(String errorEvent, String message) {

                                        }
                                    });

                                }

                                @Override
                                public void onFailure(String errorEvent, String message) {

                                }
                            });
                        }else{
                            OrderInfoModel _order = Data.get(0);
                            if(null!=_order){
                                Snackbar.make(mTime, _order.getOrderDateTime()+"至"+_order.getEnddatetime() +"已被预约", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }

                        }
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        Snackbar.make(mTime, "网络繁忙,请稍后重试", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });



            }
        });
        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectTimeActivity.this.finish();
            }
        });
    }

}

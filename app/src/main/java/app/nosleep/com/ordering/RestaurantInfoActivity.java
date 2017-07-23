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
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import app.nosleep.com.core.IRestaurantInfoCore;
import app.nosleep.com.core.ISeatInfoCore;
import app.nosleep.com.core.RestaurantInfoCoreImpl;
import app.nosleep.com.core.SeatInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.SeatInfoModel;
import app.nosleep.com.ordering.adapter.RestaurantAdapter;

public class RestaurantInfoActivity extends AppCompatActivity {
    private ISeatInfoCore mCore;
    private IRestaurantInfoCore mRtCore;
    private String mRtId;
    private RestaurantInfoModel mRt;
    private BaseApp mApp;
    private List<SeatInfoModel> mSeatList;
    private RestaurantAdapter mAdapter;
    private Context mContext;

    //控件
    private TextView mTxt_Title;
    private TextView mTxt_slogin;
    private TextView mTxt_phone;
    private TextView mTxt_address;
    private GridView mRtGridView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=getApplicationContext();
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        init();
        setView();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        this.mSeatList =new ArrayList<>();
        mContext=getApplicationContext();
        mCore.queryByRtId(mRtId, new ActionCallBackListener<List<SeatInfoModel>>() {
            @Override
            public void onSuccess(List<SeatInfoModel> Data) {
                mAdapter =new RestaurantAdapter(mContext, mSeatList, new RestaurantAdapter.MyOnClickItems() {
                    @Override
                    public void OnClick(View v) {
                        RestaurantAdapter.ViewHolder holder = (RestaurantAdapter.ViewHolder) v.getTag();
                        Log.v("app",holder.text_name.getTag()+""+holder.text_statu.getTag());
                        if(holder.text_statu.getTag().equals("0")){
                            Intent intent = new Intent(RestaurantInfoActivity.this,SelectDateTimeActivity.class);
                            intent.putExtra("rtid", mRtId);
                            intent.putExtra("seatid", holder.text_name.getTag()+"");
                            mApp.SeatId=Integer.parseInt(holder.text_name.getTag()+"");
                            RestaurantInfoActivity.this.startActivity(intent);
                            RestaurantInfoActivity.this.finish();
                        }else{
                            showLoginBar("该座位已被预定","确定",1);
                        }

                    }

                    @Override
                    public void OnLongClick(View v) {

                    }
                });
                mRtGridView.setAdapter(mAdapter);
                mAdapter.addItems(Data);
            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });

    }

    private void init(){
        //控件
        this.mTxt_Title= (TextView) findViewById(R.id.rt_head_title);
        this.mTxt_slogin= (TextView) findViewById(R.id.rt_head_slogen);
        this.mTxt_address= (TextView) findViewById(R.id.rt_head_address);
        this.mTxt_phone= (TextView) findViewById(R.id.rt_head_phone);
        this.mRtGridView= (GridView) findViewById(R.id.rt_grid_seat);
        //初始化变量
        this.mCore=new SeatInfoCoreImpl(this);
        this.mRtCore=new RestaurantInfoCoreImpl(this);
        this.mRtId= (String) getIntent().getExtras().get("id");
        mRtCore.queryById(mRtId, new ActionCallBackListener<RestaurantInfoModel>() {
            @Override
            public void onSuccess(RestaurantInfoModel Data) {
                mRt=Data;
                mTxt_Title.setText(mRt.getRtrtName());
                mTxt_slogin.setText(mRt.getRtrtRemarks());
                mTxt_phone.setText(mRt.getRtrtPhone());
                mTxt_address.setText(mRt.getRtrtaddress());
            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });
        this.mApp= (BaseApp) getApplication();
        Log.v("app","餐厅ID:"+mRtId);
    }

    private void setView(){

        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantInfoActivity.this.finish();
            }
        });
    }
    /**
     * 弹出对话框，
     * @param title    提示语
     * @param btntext   按钮语句
     * @param type      类型，0=登陆，1=退出
     */
    private void showLoginBar(String title, final String btntext, final int type){
        Snackbar.make(mRtGridView, title, Snackbar.LENGTH_LONG)
                .setAction(btntext, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(type==0){
                        }else if(type==1){
                        }
                    }
                }).show();
    }
}

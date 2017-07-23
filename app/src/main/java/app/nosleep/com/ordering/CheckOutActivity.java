package app.nosleep.com.ordering;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.core.FoodInfoCoreImpl;
import app.nosleep.com.core.IFoodInfoCore;
import app.nosleep.com.core.IOrderInfoCore;
import app.nosleep.com.core.IRestaurantInfoCore;
import app.nosleep.com.core.ISeatInfoCore;
import app.nosleep.com.core.OrderInfoCoreImpl;
import app.nosleep.com.core.RestaurantInfoCoreImpl;
import app.nosleep.com.core.SeatInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.SeatInfoModel;
import app.nosleep.com.ordering.adapter.OrderFoodAdapter;

public class CheckOutActivity extends AppCompatActivity {

    private Context mContext;
    private BaseApp mApp;
    private IOrderInfoCore mCore;
    private ISeatInfoCore mSeatCore;
    private IFoodInfoCore mFoodCore;
    private IRestaurantInfoCore mRtCore;
    private TextView mTxt_RtName;
    private TextView mTxt_Pepor;
    private TextView mTxt_DateTime;
    private ListView mLv_List;
    private TextView mTxt_Price;
    private TextView mTxt_Number;
    private RestaurantInfoModel mRt;
    private SeatInfoModel mSeat;
    private List<FoodInfoModel> mFoodList;
    private OrderInfoModel mOrder;
    private String mOrderId;
    private OrderFoodAdapter mAdapter;
    private int mPrice;
    private int mNumber;
    private Toolbar toolbar;
    private boolean isCheckout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        init();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        isCheckout=false;
        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isCheckout){
                    mCore.update(mOrder.getOrderId(), mOrder.getOrderUserInfoId(), mOrder.getOrderDateTime(), mOrder.getSeatId(), mOrder.getRtrtId(), "完成", new ActionCallBackListener<String>() {
                        @Override
                        public void onSuccess(String Data) {
                            mSeatCore.update(0, mSeat.getSeatId() + "", new ActionCallBackListener<String>() {
                                @Override
                                public void onSuccess(String Data) {
                                    Snackbar.make(mLv_List, "结账成功！", Snackbar.LENGTH_LONG)
                                            .setAction("提示", null).show();
                                    isCheckout=true;
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
                    Snackbar.make(view, "已结账,欢迎下次光临！", Snackbar.LENGTH_LONG)
                            .setAction("提示", null).show();
                }

            }
        });

        setView();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    private void init() {
        this.mContext = getApplicationContext();
        this.mApp = (BaseApp) getApplication();
        this.mCore = new OrderInfoCoreImpl(mContext);
        this.mSeatCore = new SeatInfoCoreImpl(mContext);
        this.mFoodCore = new FoodInfoCoreImpl(mContext);
        this.mRtCore = new RestaurantInfoCoreImpl(mContext);
        this.mFoodList = new ArrayList<>();
        this.mOrderId = getIntent().getStringExtra("orderid");
        this.mLv_List = (ListView) findViewById(R.id.checkout_list);
        this.mTxt_RtName = (TextView) findViewById(R.id.checkout_rtname);
        this.mTxt_Number = (TextView) findViewById(R.id.checkout_number);
        this.mTxt_DateTime = (TextView) findViewById(R.id.checkout_datetime);
        this.mTxt_Pepor = (TextView) findViewById(R.id.checkout_pepor);
        this.mTxt_Price = (TextView) findViewById(R.id.checkout_price);
        this.mCore.queryById(mOrderId, new ActionCallBackListener<OrderInfoModel>() {
            @Override
            public void onSuccess(OrderInfoModel Data) {
                mOrder =Data;
                mTxt_DateTime.setText(mOrder.getOrderDateTime());
                mSeatCore.queryById(mOrder.getSeatId() + "", new ActionCallBackListener<SeatInfoModel>() {
                    @Override
                    public void onSuccess(SeatInfoModel Data) {
                        mSeat =Data;
                        mTxt_Pepor.setText(mSeat.getSeatMin() + "-" + mSeat.getSeatMax() + "人");
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {

                    }
                });
                mRtCore.queryById(mOrder.getRtrtId() + "", new ActionCallBackListener<RestaurantInfoModel>() {
                    @Override
                    public void onSuccess(RestaurantInfoModel Data) {
                        mRt=Data;
                        mTxt_RtName.setText(mRt.getRtrtName());
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {

                    }
                });
                mFoodCore.queryByIdStr(mOrder.getFoodorderidstr(), new ActionCallBackListener<List<FoodInfoModel>>() {
                    @Override
                    public void onSuccess(List<FoodInfoModel> Data) {
                        if(null==Data){
                            Data=new ArrayList<FoodInfoModel>();
                        }
                        for(int i=0;i<Data.size();i++){
                            FoodInfoModel _food=Data.get(i);
                            mPrice += _food.getFoodPrice();
                        }
                        mFoodList=Data;
                        mNumber = mFoodList.size();
                        mTxt_Price.setText("总金额:" + mPrice);
                        mTxt_Number.setText("数量:" + mNumber);
                        mAdapter = new OrderFoodAdapter(mContext, mFoodList, new OrderFoodAdapter.MyOnClickItems() {
                            @Override
                            public void OnClick(View v) {

                            }

                            @Override
                            public void OnLongClick(View v) {

                            }
                        });
                        mLv_List.setAdapter(mAdapter);
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

    }

    private void setView() {


        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckOutActivity.this.finish();
            }
        });
    }


}

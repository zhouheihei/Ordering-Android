package app.nosleep.com.ordering;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.core.FoodInfoCoreImpl;
import app.nosleep.com.core.FoodOrderCoreImpl;
import app.nosleep.com.core.IFoodInfoCore;
import app.nosleep.com.core.IFoodOrderCore;
import app.nosleep.com.core.IOrderInfoCore;
import app.nosleep.com.core.IRestaurantInfoCore;
import app.nosleep.com.core.ISeatInfoCore;
import app.nosleep.com.core.IUserInfoCore;
import app.nosleep.com.core.OrderInfoCoreImpl;
import app.nosleep.com.core.RestaurantInfoCoreImpl;
import app.nosleep.com.core.SeatInfoCoreImpl;
import app.nosleep.com.core.UserInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.FoodOrderInfoModel;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.SeatInfoModel;
import app.nosleep.com.model.UserInfoModel;
import app.nosleep.com.ordering.adapter.OrderFoodAdapter;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private List<FoodInfoModel> mList;
    private OrderFoodAdapter mApapter;
    private IFoodOrderCore mCore;
    private IOrderInfoCore mOrderCore;
    private IRestaurantInfoCore mRtCore;
    private IUserInfoCore mUserCore;
    private ISeatInfoCore mSeatCore;
    private IFoodInfoCore mFoodCore;
    private String mOrderId;

    private OrderInfoModel mOrder;
    private SeatInfoModel mSeat;
    private UserInfoModel mUser;
    private RestaurantInfoModel mRt;

    private TextView mHead_Title;
    private TextView mHead_Slogin;
    private TextView mHead_Phone;
    private TextView mHead_Address;
    private TextView mSeat_Name;
    private TextView mSeat_number;
    private TextView mOrder_DateTime;
    private ListView mFoodList;
    private TextView mList_Tip;
    private Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        init();
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.v("orderActivity","OnCreate");
        setView();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderCore.queryById(mOrderId, new ActionCallBackListener<OrderInfoModel>() {
                    @Override
                    public void onSuccess(OrderInfoModel Data) {
                        mOrder=Data;
                        if(mOrder.getOrderStatu().equals("进行")){
                            Intent intent = new Intent(OrderActivity.this,SelectFoodActivity.class);
                            intent.putExtra("orderid", mOrderId);
                            OrderActivity.this.startActivityForResult(intent,110);
                        }else{
                            showLoginBar("该订单已结账！","确定",1);
                        }
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        showLoginBar("网络异常！","确定",1);
                    }
                });

            }
        });

    }


    private void init(){
        this.mContext=getApplicationContext();
        this.mCore=new FoodOrderCoreImpl(mContext);
        this.mOrderCore=new OrderInfoCoreImpl(mContext);
        this.mSeatCore=new SeatInfoCoreImpl(mContext);
        this.mRtCore=new RestaurantInfoCoreImpl(mContext);
        this.mFoodCore=new FoodInfoCoreImpl(mContext);
        this.mUserCore=new UserInfoCoreImpl(mContext);
        this.mOrderId=getIntent().getStringExtra("orderid");
        this.mList=new ArrayList<>();
        this.mApapter=new OrderFoodAdapter(mContext, mList, new OrderFoodAdapter.MyOnClickItems() {
            @Override
            public void OnClick(View v) {

            }

            @Override
            public void OnLongClick(View v) {

            }
        });
        mOrderCore.queryById(mOrderId, new ActionCallBackListener<OrderInfoModel>() {
            @Override
            public void onSuccess(OrderInfoModel Data) {
                mOrder=Data;
                mOrder_DateTime.setText(mOrder.getOrderDateTime());
                mFoodCore.queryByIdStr(mOrder.getFoodorderidstr(), new ActionCallBackListener<List<FoodInfoModel>>() {
                    @Override
                    public void onSuccess(List<FoodInfoModel> Data) {
                        if(null==Data){
                            Data=new ArrayList<FoodInfoModel>();
                        }
                        mApapter.addItems(Data);
                        if(mList.size()>0){
                            mList_Tip.setVisibility(View.INVISIBLE);
                            mFoodList.setVisibility(View.VISIBLE);
                        }else{
                            mList_Tip.setVisibility(View.VISIBLE);
                            mFoodList.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        showLoginBar(message,"确定",1);
                    }
                });
                mSeatCore.queryById(mOrder.getSeatId() + "", new ActionCallBackListener<SeatInfoModel>() {
                    @Override
                    public void onSuccess(SeatInfoModel Data) {
                        mSeat=Data;
                        mSeat_Name.setText(mSeat.getSeatName());
                        mSeat_number.setText(mSeat.getSeatMin()+"-"+mSeat.getSeatMax()+"人");
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {

                    }
                });
                mUserCore.queryById(mOrder.getOrderUserInfoId() + "", new ActionCallBackListener<UserInfoModel>() {
                    @Override
                    public void onSuccess(UserInfoModel Data) {
                        mUser=Data;
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {

                    }
                });
                mRtCore.queryById(mOrder.getRtrtId() + "", new ActionCallBackListener<RestaurantInfoModel>() {
                    @Override
                    public void onSuccess(RestaurantInfoModel Data) {
                        if(null!=Data){
                            mRt=Data;
                            mHead_Title.setText(mRt.getRtrtName());
                            mHead_Slogin.setText(mRt.getRtrtRemarks());
                            mHead_Phone.setText(mRt.getRtrtPhone());
                            mHead_Address.setText(mRt.getRtrtaddress());
                        }
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        showLoginBar(message,"确定",1);
                    }
                });
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                showLoginBar(message,"确定",1);
            }
        });

        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderActivity.this.finish();
            }
        });
        //View
        this.mHead_Title= (TextView) findViewById(R.id.order_head_rt_title);
        this.mHead_Slogin= (TextView) findViewById(R.id.order_head_rt_slogen);
        this.mHead_Phone= (TextView) findViewById(R.id.order_head_rt_phone);
        this.mHead_Address= (TextView) findViewById(R.id.order_head_rt_address);
        this.mSeat_Name= (TextView) findViewById(R.id.order_seat_name);
        this.mSeat_number= (TextView) findViewById(R.id.order_seat_number);
        this.mOrder_DateTime= (TextView) findViewById(R.id.order_datetime);
        this.mList_Tip= (TextView) findViewById(R.id.order_tip);
        this.mFoodList= (ListView) findViewById(R.id.order_food_list);

    }

//    private void getFoodDate(String foodlistsstr){
//        List<FoodInfoModel> _list =new ArrayList<>();
//        if(!foodlistsstr.isEmpty()){
//            String[] idlist = foodlistsstr.split(",");
//            for(int i = 0 ;i<idlist.length;i++){
//                Log.v("list",idlist[i]);
//                if(!idlist[i].isEmpty()&&idlist[i]!=""){
//                    Log.v("list","id:"+idlist[i]);
//                    FoodInfoModel _food = mFoodCore.queryById(idlist[i]);
//                    _list.add(_food);
//                }
//            }
//        }
//    }
    private void setView(){
        this.mList_Tip.setOnClickListener(this);
        this.mFoodList.setAdapter(mApapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("start",mOrderId);
        mOrderCore.queryById(mOrderId, new ActionCallBackListener<OrderInfoModel>() {
            @Override
            public void onSuccess(OrderInfoModel Data) {
                mOrder=Data;
                Log.v("order",mOrder.getFoodorderidstr());
                mFoodCore.queryByIdStr(mOrder.getFoodorderidstr(), new ActionCallBackListener<List<FoodInfoModel>>() {
                    @Override
                    public void onSuccess(List<FoodInfoModel> Data) {
                        mList=Data;
                        if(mList==null){
                            mList=new ArrayList<FoodInfoModel>();
                        }
                        mApapter.update(mList);
                        if(mList.size()>0){
                            mList_Tip.setVisibility(View.INVISIBLE);
                            mFoodList.setVisibility(View.VISIBLE);
                        }else{
                            mList_Tip.setVisibility(View.VISIBLE);
                            mFoodList.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        showLoginBar(message,"确定",1);
                    }
                });
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                showLoginBar(message,"确定",1);
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(null!=mOrder){
            if(view.getId()==R.id.order_tip&&mOrder.getOrderStatu().equals("进行")){
                Intent intent = new Intent(OrderActivity.this,SelectFoodActivity.class);
                intent.putExtra("orderid", mOrderId);
                OrderActivity.this.startActivityForResult(intent,110);
            }else{
                showLoginBar("该订单已结账！","确定",1);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        if(mOrder.getOrderStatu().equals("进行")){
            getMenuInflater().inflate(R.menu.menu_main, menu);

//        }
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.toolar_checkout) {
            mOrderCore.queryById(mOrderId, new ActionCallBackListener<OrderInfoModel>() {
                @Override
                public void onSuccess(OrderInfoModel Data) {
                    mOrder=Data;
                    if(mOrder.getOrderStatu().equals("进行")) {
                        Intent intent = new Intent(OrderActivity.this, CheckOutActivity.class);
                        intent.putExtra("orderid", mOrderId);
                        OrderActivity.this.startActivity(intent);
                    }else{
                        showLoginBar("该订单已结账.","确定",1);
                    }
                }

                @Override
                public void onFailure(String errorEvent, String message) {
                    showLoginBar("网络异常.","确定",1);
                }
            });

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 弹出对话框，
     * @param title    提示语
     * @param btntext   按钮语句
     * @param type      类型，0=登陆，1=退出
     */
    private void showLoginBar(String title, final String btntext, final int type){
        Snackbar.make(mFoodList, title, Snackbar.LENGTH_LONG)
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

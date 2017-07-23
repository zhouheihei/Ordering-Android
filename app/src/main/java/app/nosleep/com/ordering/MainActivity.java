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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

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
import app.nosleep.com.core.UserInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.UserInfoModel;
import app.nosleep.com.ordering.adapter.MainAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView mMainListView;
    private IRestaurantInfoCore mCore;
    private IOrderInfoCore mOrderCore;
    private BaseApp mApp;
    private BaseUtils mBU;
    private List<RestaurantInfoModel> mList;
    private MainAdapter mApdater;
    private String mOrderid;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=getApplicationContext();
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                UserInfoCoreImpl userservice = new UserInfoCoreImpl(getApplicationContext());
            }
        });
        init();
        mApdater = new MainAdapter(this, mList, new MainAdapter.MyOnClickItems() {
            @Override
            public void OnClick(View v) {
                if (null != v && null != v.getTag()) {
                    CheckOrder();
//                    MainActivity.this.mOrderid = mBU.isOrderRun(mApp.USERINFO.getUserinfoId()+"",MainActivity.this)+"";
//                    if (!mOrderid.equals("-1")) {
//                        showLoginBar("您有一个正在进行的订单.","进入",0);
//                        return;
//                    }
                    MainAdapter.ViewHolder datas = (MainAdapter.ViewHolder) v.getTag();
                    String _noteid = datas.text_title.getTag() + "";
                    Intent intent = new Intent(MainActivity.this, RestaurantInfoActivity.class);
                    Log.v("Item Click", "Item Click" + _noteid);
                    intent.putExtra("id", _noteid);
                    mApp.RtId = Integer.parseInt(_noteid);
                    MainActivity.this.startActivity(intent);
                }
            }

            @Override
            public void OnLongClick(View v) {
                Log.v("Main", "OnLongClick");
            }
        });
        mMainListView.setAdapter(mApdater);
//        this.mOrderid = mBU.isOrderRun(mApp.USERINFO.getUserinfoId()+"",this)+"";
//        if (!mOrderid.equals("-1")) {
//            showLoginBar("您有一个正在进行的订单.","进入",0);
//        }
        CheckOrder();
    }

    private void CheckOrder() {
         mOrderCore.queryByUserId(mApp.USERINFO.getUserinfoId() + "", new ActionCallBackListener<List<OrderInfoModel>>() {
            @Override
            public void onSuccess(List<OrderInfoModel> Data) {
                if(null!=Data){
                    for (int i = 0; i < Data.size(); i++) {
                        if (Data.get(i).getOrderStatu().equals("进行")) {
                            mOrderid=Data.get(i).getOrderId()+"";
                            showLoginBar("您有一个正在进行的订单.","进入",0);
                        }
                    }
                }

            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });

    }

    private void init() {
        mApp = (BaseApp) getApplication();
        mCore = new RestaurantInfoCoreImpl(this);
        mOrderCore = new OrderInfoCoreImpl(this);
        mMainListView = (ListView) findViewById(R.id.main_list);
        mBU=new BaseUtils();
        mList=new ArrayList<>();
        mCore.queryByAll(new ActionCallBackListener<List<RestaurantInfoModel>>() {
            @Override
            public void onSuccess(List<RestaurantInfoModel> Data) {
                if(null!=Data){
                    mApdater.addItems(Data);
                }
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                Snackbar.make(mMainListView, "网络错误", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.toolar_checkout) {
//            mFoodCore.add("酱香烤鱼",35,"",1,"条");
//            mFoodCore.add("麻辣烤鱼",40,"",1,"条");
//            mFoodCore.add("番茄烤鱼",38,"",1,"条");
//            mFoodCore.add("香辣烤鱼",25,"",1,"条");
//            mFoodCore.add("酸菜烤鱼",30,"",1,"条");
//            mFoodCore.add("粉条",8,"",1,"份");
//            mFoodCore.add("香菇",9,"",1,"份");
//            mFoodCore.add("小锅鸭头",45,"",2,"锅");
//            mFoodCore.add("中锅鸭头",55,"",2,"锅");
//            mFoodCore.add("大锅鸭头",65,"",2,"锅");
//            mFoodCore.add("全家福",85,"",2,"份");
//            mFoodCore.add("脆皮长",15,"",2,"份");

            return true;
        }else if(id==R.id.toolar_my){
            IRestaurantInfoCore mCore = new RestaurantInfoCoreImpl(this);
            ISeatInfoCore mSeatCore=new SeatInfoCoreImpl(this);
            IFoodInfoCore mFoodCore=new FoodInfoCoreImpl(this);
            Intent intent = new Intent(MainActivity.this, MyActivity.class);
            MainActivity.this.startActivity(intent);
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
        Snackbar.make(mMainListView, title, Snackbar.LENGTH_LONG)
                .setAction(btntext, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(type==0){
                            Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                            intent.putExtra("orderid", mOrderid + "");
                            MainActivity.this.startActivity(intent);
                        }else if(type==1){
                        }
                    }
                }).show();
    }
}

package app.nosleep.com.ordering;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.core.FoodInfoCoreImpl;
import app.nosleep.com.core.FoodOrderCoreImpl;
import app.nosleep.com.core.IFoodInfoCore;
import app.nosleep.com.core.IFoodOrderCore;
import app.nosleep.com.core.IOrderInfoCore;
import app.nosleep.com.core.OrderInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.FoodOrderInfoModel;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.ordering.adapter.SelectFoodAdapter;

public class SelectFoodActivity extends AppCompatActivity {

    private Context mContext;
    private IFoodInfoCore mCore;
    //private IFoodOrderCore mFoodOrderCore;
    private IOrderInfoCore mOrderCore;
    private List<FoodInfoModel> mList;
    private ListView mListView;
    private String mRtId;
    private String mOrderId;
    private SelectFoodAdapter mAdapter;
    private OrderInfoModel mOrder;
    private Toolbar toolbar;
    private List<String> mCheckidlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=getApplicationContext();
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCore=new FoodInfoCoreImpl(mContext);
        //mFoodOrderCore=new FoodOrderCoreImpl(mContext);
        mOrderCore=new OrderInfoCoreImpl(mContext);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        init();
        setView();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> _list=mAdapter.getCheckId();
                String idstr = "";
                for(int i=0;i<_list.size();i++){
                    if(!_list.get(i).equals("null")){
                        idstr=idstr+_list.get(i);
                        if(!_list.get(i).equals("")){
                            if(i==_list.size()-1){
                            }else{
                                idstr=idstr+",";
                            }
                        }
                    }
                }
                Log.v("update",idstr);
                mOrderCore.updateByFoodStr(mOrderId, idstr, new ActionCallBackListener<String>() {
                    @Override
                    public void onSuccess(String Data) {
                        setResult(110);
                        SelectFoodActivity.this.finish();
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {

                    }
                });
            }
        });
    }

    private void init(){
        this.mOrderId=getIntent().getStringExtra("orderid");
        mCheckidlist=new ArrayList<>();
        mOrderCore.queryById(mOrderId, new ActionCallBackListener<OrderInfoModel>() {
            @Override
            public void onSuccess(OrderInfoModel Data) {
                mOrder=Data;
                mRtId=mOrder.getRtrtId()+"";
                String[] _liststr = mOrder.getFoodorderidstr().split(",");
                for(int j = 0 ;j<_liststr.length;j++){
                    mCheckidlist.add(_liststr[j]);
                }
                mCore.queryByrtId(mRtId, new ActionCallBackListener<List<FoodInfoModel>>() {
                    @Override
                    public void onSuccess(List<FoodInfoModel> Data) {
                        mList=Data;
                        mAdapter=new SelectFoodAdapter(mContext, mList,mCheckidlist, new SelectFoodAdapter.MyOnClickItems() {
                            @Override
                            public void OnClick(View v) {
                                SelectFoodAdapter.ViewHolder holder = (SelectFoodAdapter.ViewHolder) v.getTag();
                                String id = (String) holder.txt_name.getTag();
                                Log.v("id",""+id);
                                mAdapter.check(id);
                            }

                            @Override
                            public void OnLongClick(View v) {

                            }
                        });
                        //mAdapter.addItems(mList);
                        mListView.setAdapter(mAdapter);
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
        this.mListView= (ListView) findViewById(R.id.select_food_list);
        //List<FoodOrderInfoModel> _foodorder=mFoodOrderCore.queryByOrderId(mOrderId);



    }
    private void setView(){
        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectFoodActivity.this.finish();
            }
        });
    }


}

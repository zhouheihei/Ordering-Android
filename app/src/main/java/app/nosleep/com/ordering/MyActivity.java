package app.nosleep.com.ordering;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.nosleep.com.core.IOrderInfoCore;
import app.nosleep.com.core.OrderInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.ordering.adapter.MainAdapter;
import app.nosleep.com.ordering.adapter.MyAdapter;

public class MyActivity extends AppCompatActivity {
    private TextView mText_OrderNumber;
    private List<OrderInfoModel> list;
    private ListView mList;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mContext=getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        mText_OrderNumber= (TextView) findViewById(R.id.my_ordernumber);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.INVISIBLE);
        list= new ArrayList<>();
        IOrderInfoCore core= new OrderInfoCoreImpl(this);
        BaseApp mApp = (BaseApp) getApplication();
        mList = (ListView) findViewById(R.id.my_list_order);
        core.queryByUserId(mApp.USERINFO.getUserinfoId() + "", new ActionCallBackListener<List<OrderInfoModel>>() {
            @Override
            public void onSuccess(List<OrderInfoModel> Data) {
                if(null!=Data){
                    list=Data;
                    mText_OrderNumber.setText("订单数:"+list.size());
                    MyAdapter adapter = new MyAdapter(mContext, list, new MainAdapter.MyOnClickItems() {
                        @Override
                        public void OnClick(View v) {
                            MyAdapter.ViewHolder datas = (MyAdapter.ViewHolder) v.getTag();
                            String _id = (String) datas.txt_statu.getTag();
                            Intent intent = new Intent(MyActivity.this,OrderActivity.class);
                            intent.putExtra("orderid",_id);
                            MyActivity.this.startActivity(intent);
                        }

                        @Override
                        public void OnLongClick(View v) {

                        }
                    });
                    mList.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });

        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyActivity.this.finish();
            }
        });
    }

}

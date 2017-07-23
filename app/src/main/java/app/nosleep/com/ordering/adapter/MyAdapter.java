package app.nosleep.com.ordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
import app.nosleep.com.core.IRestaurantInfoCore;
import app.nosleep.com.core.ISeatInfoCore;
import app.nosleep.com.core.RestaurantInfoCoreImpl;
import app.nosleep.com.core.SeatInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.OrderInfoModel;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.SeatInfoModel;
import app.nosleep.com.ordering.R;

/**
 * Created by nosleep on 17-3-17.
 * 日期：17-3-17上午9:33
 * author:zzh
 * override:
 */

public class MyAdapter extends BaseAdapter implements View.OnClickListener {
    private Context mContext;
    private List<OrderInfoModel> mList;
    private ISeatInfoCore mSeatCore;
    private IRestaurantInfoCore mRtCore;
    private MainAdapter.MyOnClickItems onClickItems;

    public MyAdapter(Context pContext,List<OrderInfoModel> pList,MainAdapter.MyOnClickItems pOnClickItems){
        this.mContext = pContext;
        this.mList = pList;
        this.onClickItems = pOnClickItems;
        this.mRtCore=new RestaurantInfoCoreImpl(mContext);
        this.mSeatCore=new SeatInfoCoreImpl(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view || view.getTag() == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.my_list_layout, null);
            MyAdapter.ViewHolder holder = new MyAdapter.ViewHolder();
            holder.txt_rtname= (TextView) view.findViewById(R.id.my_list_rtname);
            holder.txt_orderid= (TextView) view.findViewById(R.id.my_list_orderid);
            holder.txt_pepornumber= (TextView) view.findViewById(R.id.my_list_pepor);
            holder.txt_datetime= (TextView) view.findViewById(R.id.my_list_datetime);
            holder.txt_statu= (TextView) view.findViewById(R.id.my_list_statu);
            view.setOnClickListener(this);
            view.setTag(holder);
        }
        OrderInfoModel _order = mList.get(i);
        final MyAdapter.ViewHolder holder = (MyAdapter.ViewHolder) view.getTag();
        mSeatCore.queryById(_order.getSeatId() + "", new ActionCallBackListener<SeatInfoModel>() {
            @Override
            public void onSuccess(SeatInfoModel Data) {
                if(null!=Data){
                    SeatInfoModel _seat =Data;
                    holder.txt_pepornumber.setTag("人数:"+_seat.getSeatMin()+"-"+_seat.getSeatMax()+"人");
                    holder.txt_pepornumber.setText("人数:"+_seat.getSeatMin()+"-"+_seat.getSeatMax()+"人");
                }
            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });
        mRtCore.queryById(_order.getRtrtId() + "", new ActionCallBackListener<RestaurantInfoModel>() {
            @Override
            public void onSuccess(RestaurantInfoModel Data) {
                if(null!=Data){
                    RestaurantInfoModel _rt=Data;
                    holder.txt_rtname.setText(_rt.getRtrtName());
                }
            }

            @Override
            public void onFailure(String errorEvent, String message) {

            }
        });
        holder.txt_datetime.setText(_order.getOrderDateTime());
        holder.txt_orderid.setText("订单号:"+_order.getOrderId()+1000);
        holder.txt_statu.setText(_order.getOrderStatu());
        holder.txt_statu.setTag(_order.getOrderId()+"");
        return view;
    }

    @Override
    public void onClick(View view) {
        onClickItems.OnClick(view);
    }

    public class ViewHolder {
        public TextView txt_rtname;
        public TextView txt_orderid;
        public TextView txt_pepornumber;
        public TextView txt_datetime;
        public TextView txt_statu;
    }

    public interface MyOnClickItems {
        void OnClick(View v);

        void OnLongClick(View v);
    }
}

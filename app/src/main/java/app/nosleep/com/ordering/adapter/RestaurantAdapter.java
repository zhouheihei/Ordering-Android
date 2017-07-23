package app.nosleep.com.ordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.model.SeatInfoModel;
import app.nosleep.com.ordering.R;

/**
 * Created by nosleep on 17-3-10.
 * 日期：17-3-10上午10:18
 * author:zzh
 * override:
 */

public class RestaurantAdapter extends BaseAdapter implements View.OnClickListener, View.OnLongClickListener {

    private Context mContext;
    private List<SeatInfoModel> mList;
    private MyOnClickItems onClickItems;

    public RestaurantAdapter(Context pContext, List<SeatInfoModel> pList, MyOnClickItems pOnClickItems) {
        this.mContext = pContext;
        this.mList = pList;
        this.onClickItems = pOnClickItems;
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
    public void addItems(List<SeatInfoModel> pList){
        this.mList.addAll(pList);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view || view.getTag() == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.rt_gride_layout, null);
            ViewHolder holder = new ViewHolder();
            holder.rl = (RelativeLayout) view.findViewById(R.id.rt_list_gv);
            holder.text_name = (TextView) view.findViewById(R.id.rt_list_name);
            holder.text_number = (TextView) view.findViewById(R.id.rt_list_number);
            holder.text_statu= (TextView) view.findViewById(R.id.rt_list_is);
            holder.rl.setOnClickListener(this);
            holder.rl.setOnLongClickListener(this);
            view.setTag(holder);
        }
        SeatInfoModel seat = mList.get(i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.text_name.setText(seat.getSeatName());
        holder.text_number.setText(seat.getSeatMin()+"-"+seat.getSeatMax()+"人");
        holder.text_name.setTag(seat.getSeatId());
        holder.text_statu.setTag(seat.getSeatState()+"");
        if(seat.getSeatState()==1){
            holder.text_statu.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
        }else{
            holder.text_statu.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        onClickItems.OnClick(view);
    }

    @Override
    public boolean onLongClick(View view) {
        onClickItems.OnLongClick(view);
        return false;
    }

    public class ViewHolder {
        public RelativeLayout rl;
        public TextView text_name;
        public TextView text_number;
        public TextView text_statu;
    }

    public interface MyOnClickItems {
        void OnClick(View v);

        void OnLongClick(View v);
    }
}

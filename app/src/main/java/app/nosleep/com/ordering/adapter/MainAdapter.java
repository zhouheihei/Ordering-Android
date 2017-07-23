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
import app.nosleep.com.ordering.R;

/**
 * Created by nosleep on 17-3-10.
 * 日期：17-3-10上午10:18
 * author:zzh
 * override:
 */

public class MainAdapter extends BaseAdapter implements View.OnClickListener, View.OnLongClickListener {

    private Context mContext;
    private List<RestaurantInfoModel> mList;
    private MyOnClickItems onClickItems;

    public MainAdapter(Context pContext, List<RestaurantInfoModel> pList, MyOnClickItems pOnClickItems) {
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

    public void addItems(List<RestaurantInfoModel> pList){
        this.mList.addAll(pList);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view || view.getTag() == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.main_list_layout, null);
            ViewHolder holder = new ViewHolder();
            holder.rl = (RelativeLayout) view.findViewById(R.id.main_list_rl);
            holder.text_title = (TextView) view.findViewById(R.id.main_list_title);
            holder.text_slogin = (TextView) view.findViewById(R.id.main_list_slogen);
            holder.rl.setOnClickListener(this);
            holder.rl.setOnLongClickListener(this);
            view.setTag(holder);
        }
        RestaurantInfoModel rtrt = mList.get(i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.text_slogin.setText(rtrt.getRtrtRemarks());
        holder.text_title.setText(rtrt.getRtrtName());
        holder.text_title.setTag(rtrt.getRtrtId());
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
        public TextView text_title;
        public TextView text_slogin;
    }

    public interface MyOnClickItems {
        void OnClick(View v);

        void OnLongClick(View v);
    }
}

package app.nosleep.com.ordering.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.nosleep.com.core.FoodInfoCoreImpl;
import app.nosleep.com.core.IFoodInfoCore;
import app.nosleep.com.model.FoodInfoModel;
import app.nosleep.com.model.FoodOrderInfoModel;
import app.nosleep.com.model.RestaurantInfoModel;
import app.nosleep.com.ordering.R;

/**
 * Created by nosleep on 17-3-14.
 * 日期：17-3-14上午11:23
 * author:zzh
 * override:
 */

public class OrderFoodAdapter extends BaseAdapter implements View.OnClickListener, View.OnLongClickListener {
    private List<FoodInfoModel> mList;
    private Context mContext;
    private OrderFoodAdapter.MyOnClickItems onClickItems;

    public OrderFoodAdapter(Context pContext, List<FoodInfoModel> pList,OrderFoodAdapter.MyOnClickItems pOnClickItems) {
        this.mContext = pContext;
        this.mList = pList;
        this.onClickItems=pOnClickItems;
    }

    public void update(List<FoodInfoModel> pList){
        mList=pList;
        notifyDataSetChanged();
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
    public void addItems(List<FoodInfoModel> pList){
        this.mList.addAll(pList);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view || view.getTag() == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.order_food_list_layout, null);
            ViewHolder holder = new ViewHolder();
            holder.txt_name = (TextView) view.findViewById(R.id.order_food_list_name);
            holder.txt_price = (TextView) view.findViewById(R.id.order_food_list_price);
            holder.txt_name.setOnClickListener(this);
            holder.txt_name.setOnLongClickListener(this);
            holder.txt_price.setOnClickListener(this);
            holder.txt_price.setOnLongClickListener(this);
            view.setTag(holder);
        }
        FoodInfoModel food = mList.get(i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.txt_name.setText(food.getFoodName());
        holder.txt_price.setText(food.getFoodPrice()+"元/"+food.getFoodunit());

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
        public TextView txt_name;
        public TextView txt_price;
    }

    public interface MyOnClickItems {
        void OnClick(View v);

        void OnLongClick(View v);
    }

}

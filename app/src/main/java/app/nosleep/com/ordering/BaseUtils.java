package app.nosleep.com.ordering;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import app.nosleep.com.core.IOrderInfoCore;
import app.nosleep.com.core.OrderInfoCoreImpl;
import app.nosleep.com.model.OrderInfoModel;

/**
 * Created by nosleep on 17-3-19.
 * 日期：17-3-19上午8:55
 * author:zzh
 * override:
 */

public class BaseUtils {

    private IOrderInfoCore mCore;

    /**
     * 正则合法性
     * @param str   用户输入文本
     * @param param 正则选项，0用户名 1密码 2手机号
     * @return
     */
    public boolean isMatch(String str,int param){
        boolean i = false;
        switch (param){
            case 0:
                i= str.matches("^[a-zA-Z]\\w{5,17}$");
                break;
            case 1:
                i= str.matches("^\\w{5,17}$");
                break;
            case 2:
                i= str.matches("^1[3|4|5|7|8]\\d{9}$");
                break;
        }
        return i;
    }

    public int isOrderRun(String id, Context pContext){
//        if(null==mCore){
//            mCore=new OrderInfoCoreImpl(pContext);
//        }
//        List<OrderInfoModel> _list= mCore.queryByUserId(id,null);
//        if(_list.size()>0){
//            OrderInfoModel _order =_list.get(_list.size()-1);
//            Log.v("orderrun","最后一个订单！"+_order.getOrderId());
//            if(_order.getOrderStatu().equals("进行")){
//                return _order.getOrderId();
//            }
//        }
        return -1;
    }

    public String getShareP(String key,Context pcontext){
        SharedPreferences sp = pcontext.getSharedPreferences("isdatabase",0);
        String token = sp.getString(key,"");
        return token;
    }

    public void setShareP(String key,String value,Context pcontext){
        SharedPreferences sp = pcontext.getSharedPreferences("isdatabase",0);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key,value);
        editor.commit();
    }
}

package app.nosleep.com.ordering;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.Random;

import app.nosleep.com.core.FoodInfoCoreImpl;
import app.nosleep.com.core.IFoodInfoCore;
import app.nosleep.com.core.IRestaurantInfoCore;
import app.nosleep.com.core.ISeatInfoCore;
import app.nosleep.com.core.RestaurantInfoCoreImpl;
import app.nosleep.com.core.SeatInfoCoreImpl;

/**
 * Created by nosleep on 17-3-19.
 * 日期：17-3-19上午9:38
 * author:zzh
 * override:
 */

public class SplashActivity extends Activity {
    private Context mContext = null;
    private BaseUtils mBU = null;
    private BaseApp app = null;
    private Intent mIntent=null;
    private long startTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_new);
        init();
        setview();
        setlistenner();

        if(true){
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if(firstRun()){
                        initdatabase();
                        mBU.setShareP("firstrun","false",mContext);
                    }
                    mIntent.setClass(mContext,LoginActivity.class);
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(mIntent);
                    SplashActivity.this.finish();
                }
            }, 3000);

        }
    }
    private void init() {
        this.mContext = getApplicationContext();
        this.mBU = new BaseUtils();
        this.app=(BaseApp) getApplication();
        this.mIntent=new Intent();
    }
    private void setview() {

    }

    private void setlistenner() {
    }
    /**
     * 检查是否第一次运行
     * @return ture第一次，false不是
     */
    private boolean firstRun(){
        String isRun=mBU.getShareP("firstrun",this);
        Log.v("",isRun);
        if(isRun.equals("ture")||isRun.equals("")){
            return true;
        }
        return false;
    }
    private void initdatabase(){
        IRestaurantInfoCore _rtcore=new RestaurantInfoCoreImpl(this);
        ISeatInfoCore mSeatCore=new SeatInfoCoreImpl(this);
        IFoodInfoCore mFoodCore=new FoodInfoCoreImpl(this);
//        _rtcore.add("九日兴大酒店", "可免费使用包间，提供免费停车位。", "0375-2551888", "卫东区新华路立交桥向北200米路东");
//        _rtcore.add("姜子牙干锅城", "一品余香，干锅鸭头涮锅...", "0375-8592999", "湛河区新华路南头锦绣花园北100米路东");
//        _rtcore.add("粤海美食广场", "全新推出卤味系列", "0394-8275115", "川汇区七一路与八一路交叉口东行100米路南");
//        _rtcore.add("潇湘人家", "湘水，湘情，湘味", "0394-8697777", "川汇区交通路西段现代城斜对面");
//        _rtcore.add("粤海如意坊", "舌尖上的如意坊，幸福滋味", "0394-8598566", "川汇区莲花路东段");
//        _rtcore.add("家香美·小馆子", "栖身都市，食客云集", "0394-8560066", "川汇区中州大道与莲花路交叉口西北角");
//        _rtcore.add("肯德基（顺达店）", "KFC", "400-882-3823", " 周口市七一路与五一路交汇处西北角");
//        mFoodCore.add("清蒸尨俐鱼",58,"",1,"份");
//        mFoodCore.add("粉皮焖鸡",48,"",1,"份");
//        mFoodCore.add("麻辣香锅",48,"",1,"份");
//        mFoodCore.add("孜然鹅翅根",32,"",1,"份");
//        mFoodCore.add("酥肉炖粉条",32,"",1,"份");
//        mFoodCore.add("东坡水豆花",18,"",1,"份");
//        mFoodCore.add("香菇菜心",18,"",1,"份");
//        mFoodCore.add("肉沫酱茄子",16,"",1,"份");
//        mFoodCore.add("干妈牛腱",38,"",1,"条");
//        mFoodCore.add("香酥银鱼",29,"",1,"条");
//        mFoodCore.add("鲜椒口水鸡",28,"",1,"条");
//        mFoodCore.add("鸡丝粉皮",18,"",1,"条");
//        mFoodCore.add("醋泡双脆",16,"",1,"份");
//        mFoodCore.add("大刀黄瓜",12,"",1,"份");
//        mFoodCore.add("素锅贴",16,"",1,"份");
//        mFoodCore.add("地锅馍沾酱",12,"",1,"份");
//        mFoodCore.add("米酒汤圆",16,"",1,"份");
//        mFoodCore.add("干锅鱿鱼虾（大）",98,"",1,"份");
//        mFoodCore.add("菌类大拼",22,"",1,"份");
//        mFoodCore.add("蔬菜大拼",18,"",1,"份");
//        mFoodCore.add("华英鸭血",12,"",1,"份");
//        mFoodCore.add("鱼豆腐",15,"",1,"份");
//        mFoodCore.add("绿豆面",6,"",1,"份");
//        mFoodCore.add("餐位费",1,"",1,"份");
//        mFoodCore.add("美食油浸鱼",108,"",1,"份");
//        mFoodCore.add("茶树菇炖柴鸡",78,"",1,"份");
//        mFoodCore.add("精品毛血旺",49,"",1,"份");
//        mFoodCore.add("桂花广肚",48,"",1,"份");
//
//        mFoodCore.add("干锅鱿鱼虾（大）",98,"",2,"份");
//        mFoodCore.add("菌类大拼",22,"",2,"份");
//        mFoodCore.add("蔬菜大拼",18,"",2,"份");
//        mFoodCore.add("华英鸭血",12,"",2,"份");
//        mFoodCore.add("鱼豆腐",15,"",2,"份");
//        mFoodCore.add("绿豆面",6,"",2,"份");
//        mFoodCore.add("餐位费",1,"",2,"份");
//        mFoodCore.add("麻辣香锅",48,"",2,"份");
//        mFoodCore.add("孜然鹅翅根",32,"",2,"份");
//        mFoodCore.add("酥肉炖粉条",32,"",2,"份");
//        mFoodCore.add("东坡水豆花",18,"",2,"份");
//        mFoodCore.add("香菇菜心",18,"",2,"份");
//        mFoodCore.add("肉沫酱茄子",16,"",2,"份");
//        mFoodCore.add("干妈牛腱",38,"",2,"条");
//
//        mFoodCore.add("美食油浸鱼",108,"",3,"份");
//        mFoodCore.add("茶树菇炖柴鸡",78,"",3,"份");
//        mFoodCore.add("精品毛血旺",49,"",3,"份");
//        mFoodCore.add("桂花广肚",48,"",3,"份");
//        mFoodCore.add("喜饼特色小炒肉",46,"",3,"份");
//        mFoodCore.add("紫薯豌豆派",38,"",3,"份");
//        mFoodCore.add("美食四宝炖豆腐",48,"",3,"份");
//        mFoodCore.add("白灼广东菜心",26,"",3,"份");
//        mFoodCore.add("香辣鸭翅",36,"",3,"份");
//        mFoodCore.add("川香口水鸡",36,"",3,"份");
//        mFoodCore.add("蝴蝶鱼片",38,"",3,"份");
//        mFoodCore.add("五香牛蹄筋",38,"",3,"份");
//        mFoodCore.add("三色蒸菜",16,"",3,"份");
//        mFoodCore.add("干煸龙豆角",18,"",3,"份");
//        mFoodCore.add("炝拌莲菜",18,"",3,"份");
//        mFoodCore.add("香菜木耳",16,"",3,"份");
//        mFoodCore.add("滋补珍菌汤",58,"",3,"份");
//        mFoodCore.add("黄桥烧饼",16,"",3,"份");
//        mFoodCore.add("米饭",2,"",3,"份");
//        mFoodCore.add("山寨鱼头王",58,"",3,"份");
//        mFoodCore.add("招牌扣肉",48,"",3,"份");
//        mFoodCore.add("柴鸡蛋焖肉",38,"",3,"份");
//        mFoodCore.add("蟹黄粉丝煲",38,"",3,"份");
//        mFoodCore.add("玉米炒汤圆",22,"",3,"份");
//        mFoodCore.add("蒜茸时蔬",16,"",3,"份");
//
//        mFoodCore.add("招牌棒棒虾",48,"",4,"份");
//        mFoodCore.add("牛鞭煨土鸡",98,"",4,"份");
//        mFoodCore.add("山寨鱼头王",58,"",4,"份");
//        mFoodCore.add("招牌扣肉",48,"",4,"份");
//        mFoodCore.add("柴鸡蛋焖肉",38,"",4,"份");
//        mFoodCore.add("蟹黄粉丝煲",38,"",4,"份");
//        mFoodCore.add("玉米炒汤圆",22,"",4,"份");
//        mFoodCore.add("蒜茸时蔬",16,"",4,"份");
//        mFoodCore.add("秘制酱牛腱",58,"",4,"份");
//        mFoodCore.add("葱椒鸡",36,"",4,"份");
//        mFoodCore.add("红油耳丝",38,"",4,"份");
//        mFoodCore.add("香酥小黄鱼",26,"",4,"份");
//        mFoodCore.add("荷兰双拼",18,"",4,"份");
//        mFoodCore.add("蓝莓山药",26,"",4,"份");
//        mFoodCore.add("香菜拌木耳",18,"",4,"份");
//        mFoodCore.add("养颜秋葵",19,"",4,"份");
//        mFoodCore.add("杠子馍",18,"",4,"份");
//        mFoodCore.add("食神炒饭",18,"",4,"份");
//        mFoodCore.add("西湖牛肉羹",22,"",4,"份");
//        mFoodCore.add("水果拼盘",22,"",4,"份");
//        mFoodCore.add("美式肥牛",58,"",4,"份");
//        mFoodCore.add("内蒙古羔羊肉",52,"",4,"份");
//        mFoodCore.add("七彩水晶包",28,"",4,"份");
//        mFoodCore.add("亲亲脆皮肠",28,"",4,"份");
//        mFoodCore.add("西湖莲藕",18,"",4,"份");
//        mFoodCore.add("鲜平菇",18,"",4,"份");
//        mFoodCore.add("广东生菜",15,"",4,"份");
//        mFoodCore.add("水晶粉丝",15,"",4,"份");
//
//        mFoodCore.add("冰岛肥蚝",36,"",5,"份");
//        mFoodCore.add("夏威夷扇贝",18,"",5,"份");
//        mFoodCore.add("南湾野生鱼",58,"",5,"份");
//        mFoodCore.add("精品雪花肥牛",98,"",5,"份");
//        mFoodCore.add("安格斯牛肉",78,"",5,"份");
//        mFoodCore.add("精品肥牛",58,"",5,"份");
//        mFoodCore.add("美式肥牛",58,"",5,"份");
//        mFoodCore.add("内蒙古羔羊肉",52,"",5,"份");
//        mFoodCore.add("七彩水晶包",28,"",5,"份");
//        mFoodCore.add("亲亲脆皮肠",28,"",5,"份");
//        mFoodCore.add("西湖莲藕",18,"",5,"份");
//        mFoodCore.add("鲜平菇",18,"",5,"份");
//        mFoodCore.add("广东生菜",15,"",5,"份");
//        mFoodCore.add("水晶粉丝",15,"",5,"份");
//        mFoodCore.add("精选茼蒿",18,"",5,"份");
//        mFoodCore.add("金针菇",15,"",5,"份");
//        mFoodCore.add("小白菜",12,"",5,"份");
//        mFoodCore.add("自制千张",12,"",5,"份");
//        mFoodCore.add("红薯粉条",12,"",5,"份");
//        mFoodCore.add("土豆片",10,"",5,"份");
//        mFoodCore.add("杂粮拼盘",38,"",5,"份");
//        mFoodCore.add("回味油条",15,"",5,"份");
//        mFoodCore.add("蔬菜面条",12,"",5,"份");
//        mFoodCore.add("天然菌汤锅底",12,"",5,"份");
//        mFoodCore.add("潭府金汤锅",12,"",5,"份");
//        mFoodCore.add("天然菌汤锅底",12,"",5,"份");
//        mFoodCore.add("天府香辣锅",12,"",5,"份");
//        mFoodCore.add("养生清汤锅",12,"",5,"份");
//        mFoodCore.add("煎扒鱼",38,"",6,"份");
//        mFoodCore.add("毛血旺",38,"",6,"份");
//        mFoodCore.add("干锅花菜",28,"",6,"份");
//        mFoodCore.add("酥口甜心",18,"",6,"份");
//        mFoodCore.add("咸水鸭",32,"",6,"份");
//        mFoodCore.add("土芹拌黄豆",16,"",6,"份");
//        mFoodCore.add("凤凰玉米羹",16,"",6,"份");
//        mFoodCore.add("馒头",1,"",6,"个");
//        mFoodCore.add("伴鸡伴虾堡土豆泥餐",41,"",7,"份");
//        mFoodCore.add("香辣鸡腿堡土豆泥餐",39,"",7,"份");
//        mFoodCore.add("新奥良腿堡土豆泥餐",40,"",7,"份");
//        mFoodCore.add("劲脆鸡腿堡土豆泥餐",39,"",7,"份");
//        mFoodCore.add("香辣鸡腿堡",17,"",7,"份");
//        mFoodCore.add("新奥尔良烤鸡腿堡",18,"",7,"份");
//        mFoodCore.add("劲脆鸡腿堡",17,"",7,"份");
//        mFoodCore.add("老北京卷土豆泥餐",38,"",7,"份");
//        mFoodCore.add("老北京鸡肉卷",15,"",7,"份");
//        mFoodCore.add("吮指原味鸡套餐Bnew",43,"",7,"份");
//        mFoodCore.add("1根骨肉相连加",8,"",7,"份");
//        mFoodCore.add("2根骨肉相连加",13,"",7,"份");
//        mFoodCore.add("二块香辣鸡翅",10,"",7,"份");
//        mFoodCore.add("二块新奥尔良烤翅",11,"",7,"份");
//        mFoodCore.add("黄金鸡块5块装",10,"",7,"份");
//        mFoodCore.add("劲爆鸡米花(小)",11,"",7,"份");
//        mFoodCore.add("吮指原味鸡套餐A",13,"",7,"份");
//        mFoodCore.add("一块吮指原味鸡",35,"",7,"份");
//        mFoodCore.add("醇香土豆泥",11,"",7,"份");
//        mFoodCore.add("玉米沙拉",6,"",7,"份");
//        mFoodCore.add("香甜粟米棒",8,"",7,"份");
//        mFoodCore.add("芙蓉荟蔬汤",8,"",7,"份");
//        mFoodCore.add("快乐儿童餐A",8,"",7,"份");
//        mFoodCore.add("快乐儿童餐B",29,"",7,"份");
//        mFoodCore.add("葡式蛋挞(经典)1只装",30,"",7,"份");
//        mFoodCore.add("圣代(巧克力)",7,"",7,"份");
//        mFoodCore.add("红豆派",8,"",7,"份");
//        mFoodCore.add("圣代(草莓)",8,"",7,"份");
//        mFoodCore.add("伴柠伴桔鲜果茶",13,"",7,"份");
//        mFoodCore.add("热牛奶(甜)12oz",10,"",7,"份");
//        mFoodCore.add("九珍果汁饮料",16,"",7,"份");
//        mFoodCore.add("热牛奶(甜)12oz",11,"",7,"份");
//        mFoodCore.add("雀巢果维C加橙味",8,"",7,"份");
        //座位
//        mSeatCore.add("北京厅",10,15,0,1);
//        mSeatCore.add("上海厅",5,10,1,1);
//        mSeatCore.add("广州厅",1,4,0,1);
//        mSeatCore.add("深圳厅",2,6,1,1);
//        mSeatCore.add("成都厅",15,20,0,1);
//        mSeatCore.add("杭州厅",1,4,0,1);
//        mSeatCore.add("南京厅",4,8,1,1);
//        mSeatCore.add("天津厅",10,15,1,1);
//        mSeatCore.add("武汉厅",10,15,1,1);
//        mSeatCore.add("重庆厅",10,15,0,1);
//        mSeatCore.add("梅花",1,4,1,2);
//        mSeatCore.add("牡丹",1,4,0,2);
//        mSeatCore.add("菊花",2,6,0,2);
//        mSeatCore.add("兰花",2,6,1,2);
//        mSeatCore.add("月季",5,10,0,2);
//        mSeatCore.add("杜鹃",5,10,1,2);
//        mSeatCore.add("茶花",10,15,0,2);
//        mSeatCore.add("荷花",10,15,0,2);
//        mSeatCore.add("桂花",15,20,1,2);
//        mSeatCore.add("水仙",10,20,0,2);
        for(int i =0 ;i<20;i++){
            Random dom = new Random();
            int _ss =dom.nextInt(50)+1;
            Log.v("random",_ss+"");
            if(_ss%2==0){
//                mSeatCore.add((i+1)+"号座位",1,4,0,3);
//                mSeatCore.add((i+1)+"号座位",1,4,1,4);
//                mSeatCore.add((i+1)+"号座位",2,4,0,5);
//                mSeatCore.add((i+1)+"号座位",5,10,1,6);
//                mSeatCore.add((i+1)+"号座位",1,4,0,7);
            }else{
//                mSeatCore.add((i+1)+"号座位",5,10,1,3);
//                mSeatCore.add((i+1)+"号座位",10,15,0,4);
//                mSeatCore.add((i+1)+"号座位",1,4,1,5);
//                mSeatCore.add((i+1)+"号座位",1,4,0,6);
//                mSeatCore.add((i+1)+"号座位",2,6,1,7);
            }
        }
    }

}

package app.nosleep.com.ordering;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.nosleep.com.api.mysql.NetUtil;
import app.nosleep.com.api.mysql.Util.HttpUtil;
import app.nosleep.com.api.mysql.Util.MyAsyncHttpResonseHandler;
import app.nosleep.com.core.IUserInfoCore;
import app.nosleep.com.core.UserInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;
import app.nosleep.com.model.Response;
import app.nosleep.com.model.UserInfoModel;
import cz.msebera.android.httpclient.Header;

/**
 * Created by nosleep on 17-3-19.
 * 日期：17-3-19上午9:01
 * author:zzh
 * override:
 */

public class LoginActivity extends Activity implements View.OnClickListener {
    private Context mContext=null;
    private BaseApp app =null;
    private BaseUtils mBU = null;
    private IUserInfoCore mUserCore;

    //窗体控件
    private EditText mUserNmae=null;
    private EditText mUserPwd=null;
    private TextView mReg=null;
    private TextView mReset=null;
    private Button mBtnLogin=null;
    private TextView mLookLook=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        setView();
        setOnListenner();
    }
    private void init(){
        this.mContext=getApplicationContext();
        this.app= (BaseApp) getApplication();
        this.mUserCore=new UserInfoCoreImpl(this);
        this.mBtnLogin= (Button) findViewById(R.id.login_ok);
        this.mReg= (TextView) findViewById(R.id.login_reg);
        this.mReset= (TextView) findViewById(R.id.login_resetpwd);
        this.mUserNmae= (EditText) findViewById(R.id.login_username);
        this.mUserPwd= (EditText) findViewById(R.id.login_userpwd);
        this.mLookLook= (TextView) findViewById(R.id.login_looklook);
        this.mBU=new BaseUtils();
        this.mReset.setVisibility(View.GONE);
    }
    private void setView(){
    }
    private void setOnListenner(){
        this.mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Login","找回密码！");
            }
        });
        this.mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Login","注册");
                Intent intent = new Intent(mContext, RegeditActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        this.mLookLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                LoginActivity.this.finish();
            }
        });

        this.mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Login","登陆");
                boolean is =false;
                is=mBU.isMatch(mUserNmae.getText().toString(),2);
                if(!is){
                    mBtnLogin.setText("手机号码格式不正确！");
                    return;
                }
                is=mBU.isMatch(mUserPwd.getText().toString(),1);
                if(!is){
                    mBtnLogin.setText("密码格式为6-18位,非中文！");
                    return;
                }
                mBtnLogin.setText("正在登陆...");
                mUserCore.queryByLogin(mUserNmae.getText().toString(), mUserPwd.getText().toString(), new ActionCallBackListener<UserInfoModel>() {
                    @Override
                    public void onSuccess(UserInfoModel Data) {
                        if(null!=Data){
                            app.USERINFO=Data;
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            LoginActivity.this.startActivity(intent);
                            LoginActivity.this.finish();
                            startActivity(intent);
                        }else{
                            mBtnLogin.setText("密码或用户名不正确！");
                        }
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        mBtnLogin.setText("网络繁忙,稍后重试！");
                    }
                });
//                try {
//                    NetUtil.doPostAsyn("http://192.168.1.106:8080/app/v1/users/userlogin", "phone="+mUserNmae.getText().toString()+"&&pwd="+mUserPwd.getText().toString()+"&&number=123", new NetUtil.CallBack() {
//                        @Override
//                        public void onRequestComplete(String result) {
//                            Gson gson =new GsonBuilder().create();
//                            Response<Void> rs = gson.fromJson(result,Response.class);
//                            if(rs.getMsg().equals("true")){
//                                UserInfoModel _user = mUserCore.queryByNameAndPwd(mUserNmae.getText().toString(),mUserPwd.getText().toString());
//                                if(null!=_user){
//                                    app.USERINFO=_user;
//                                }
//                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                                LoginActivity.this.startActivity(intent);
//                                LoginActivity.this.finish();
//                            }else{
//                                mBtnLogin.setText("密码或用户名不正确！");
//                            }
//                            Log.v("http",rs.getMsg());
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if(mUserCore.queryByLogin(mUserNmae.getText().toString(),mUserPwd.getText().toString())){
//                    UserInfoModel _user = mUserCore.queryByNameAndPwd(mUserNmae.getText().toString(),mUserPwd.getText().toString());
//                    if(null!=_user){
//                        app.USERINFO=_user;
//                    }
//                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                    LoginActivity.this.startActivity(intent);
//                    LoginActivity.this.finish();
//                }else{
//                    mBtnLogin.setText("密码或用户名不正确！");
//                    return;
//                }
            }
        });
        mUserNmae.setOnClickListener(this);
        mUserPwd.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(!mBtnLogin.getText().toString().equals("登    陆")){
            mBtnLogin.setText("登    陆");
        }
    }
}

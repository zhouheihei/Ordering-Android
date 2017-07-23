package app.nosleep.com.ordering;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.nosleep.com.core.IUserInfoCore;
import app.nosleep.com.core.UserInfoCoreImpl;
import app.nosleep.com.core.mysql.ActionCallBackListener;

/**
 * Created by nosleep on 17-3-19.
 * 日期：17-3-19上午8:49
 * author:zzh
 * override:
 */

public class RegeditActivity extends Activity implements View.OnClickListener{
    private Context mContext=null;
    private BaseApp app=null;
    private BaseUtils mBU=null;
    private IUserInfoCore mCore;

    private EditText mEdUserName=null;
    private EditText mEdUserPwd=null;
    private EditText mEdNumber=null;
    private TextView mTxtGetNumber=null;
    private Button mRegBtn=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regedit);
        init();
        setView();
        setOnListenner();
    }

    private void init(){
        this.mContext=getApplicationContext();
        this.app= (BaseApp) getApplication();
        this.mCore=new UserInfoCoreImpl(this);
        this.mEdUserName= (EditText) findViewById(R.id.reg_username);
        this.mEdUserPwd= (EditText) findViewById(R.id.reg_userpwd);
        this.mEdNumber= (EditText) findViewById(R.id.reg_number);
        this.mTxtGetNumber= (TextView) findViewById(R.id.reg_getnumber);
        this.mRegBtn= (Button) findViewById(R.id.reg_regbut);
        this.mBU=new BaseUtils();
    }
    private void setView(){}
    private void setOnListenner(){
        this.mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                if (btn.getText().toString().equals("注册成功！点击登陆！")) {
                    RegeditActivity.this.finish();
                    return;
                }
                boolean is ;
                is=mBU.isMatch(mEdUserName.getText().toString(),2);
                if(!is){
                    mRegBtn.setText("手机号码格式不正确！");
                    return;
                }
                is=mBU.isMatch(mEdUserPwd.getText().toString(),1);
                if(!is){
                    mRegBtn.setText("密码格式为6-18位,非中文！");
                    return;
                }
//                if(mEdNumber.getText().toString().equals("")){
//                    mRegBtn.setText("验证不能为空！");
//                    return;
//                }
                mCore.add(mEdUserName.getText().toString(), mEdUserPwd.getText().toString(), new ActionCallBackListener<String>() {
                    @Override
                    public void onSuccess(String Data) {
                        mRegBtn.setText("注册成功！点击登陆！");
                    }

                    @Override
                    public void onFailure(String errorEvent, String message) {
                        mRegBtn.setText("网络异常...");
                    }
                });

            }
        });
        this.mEdNumber.setOnClickListener(this);
        this.mEdUserPwd.setOnClickListener(this);
        this.mEdUserName.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!this.mRegBtn.getText().toString().equals("注   册")) {
            this.mRegBtn.setText("注   册");
        }
    }
}

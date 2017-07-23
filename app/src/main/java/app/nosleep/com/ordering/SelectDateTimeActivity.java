package app.nosleep.com.ordering;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelectDateTimeActivity extends AppCompatActivity {

    private DatePicker datep;
    private BaseApp mApp;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mContext=getApplicationContext();
        toolbar.setTitleTextColor(mContext.getResources().getColor(R.color.titlecolor));
        setSupportActionBar(toolbar);
        //设置返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datep = (DatePicker) findViewById(R.id.select_datetime);
        mApp = (BaseApp) getApplication();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Log.v("date", "datechanged");
        datep.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Log.v("date", "datechanged");
                if (isDateAfter(datePicker)) {
                    Calendar mCalendar = Calendar.getInstance();
                    datePicker.init(mCalendar.get(Calendar.YEAR),
                            mCalendar.get(Calendar.MONTH),
                            mCalendar.get(Calendar.DAY_OF_MONTH), this);
                }
            }

            private boolean isDateAfter(DatePicker tempView) {
                Calendar mCalendar = Calendar.getInstance();
                Calendar tempCalendar = Calendar.getInstance();
                tempCalendar.set(tempView.getYear(), tempView.getMonth(),
                        tempView.getDayOfMonth(), 0, 0, 0);
                if (tempCalendar.before(mCalendar))
                    return true;
                else
                    return false;
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.v("select",datep.getYear()+"-"+datep.getMonth()+"-"+datep.getDayOfMonth());
                mApp.YEARS = datep.getYear();
                mApp.MONTH = datep.getMonth()+1;
                mApp.DAY = datep.getDayOfMonth();
                Log.v("select", mApp.YEARS + "-" + mApp.MONTH + "-" + mApp.DAY);
                Intent intent = new Intent(SelectDateTimeActivity.this, SelectTimeActivity.class);
                SelectDateTimeActivity.this.startActivity(intent);
                SelectDateTimeActivity.this.finish();
            }
        });
        //绑定返回主界面事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectDateTimeActivity.this.finish();
            }
        });
    }

}

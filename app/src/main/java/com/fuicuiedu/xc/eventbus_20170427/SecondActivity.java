package com.fuicuiedu.xc.eventbus_20170427;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.second_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发事件
                EventBus.getDefault().post(new MessageEvent("面对疾风吧！"));
            }
        });
    }
}

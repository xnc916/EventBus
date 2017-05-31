package com.fuicuiedu.xc.eventbus_20170427;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


//EventBus的使用
//1.首先要有一个消息的类
//2.在需要发消息的页面,执行EventBus发消息的方法(post)
//3.在需要接受消息的页面，执行注册EventBus的方法（register）
//4.处理消息，在接受页面处理消息（通过注解的方法）、
//5.用完之后，执行反注册EventBus的方法（unRegister）

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        button = (Button) findViewById(R.id.main_btn);
        textView = (TextView) findViewById(R.id.main_tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 跳转到第二页
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){
        String msg = "onEvent收到了消息：" + event.getMessage();

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        textView.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册EventBus
        EventBus.getDefault().unregister(this);
    }
}

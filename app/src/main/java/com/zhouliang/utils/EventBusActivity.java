package com.zhouliang.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zhouliang.util.ToastUtils;
import com.zhouliang.utils.base.UtilsActivity;
import com.zhouliang.utils.message.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouliang on 2017/8/8.
 */

public class EventBusActivity extends UtilsActivity {
    @Bind(R.id.eventbus_bt)
    Button eventbusBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.eventbus_bt)
    public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("我是界面EventBusActivity发布的消息"));
    }
}

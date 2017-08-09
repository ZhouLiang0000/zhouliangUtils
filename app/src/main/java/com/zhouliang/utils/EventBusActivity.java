package com.zhouliang.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.Button;

import com.zhouliang.util.LogUtils;
import com.zhouliang.utils.base.UtilsActivity;
import com.zhouliang.utils.domain.MessageEvent;
import com.zhouliang.utils.domain.User;

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
    private static String TAG = EventBusActivity.class.getSimpleName();
    @Bind(R.id.eventbus_bt)
    Button eventbusBt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @OnClick(R.id.eventbus_bt)
    public void onViewClicked() {
//        EventBus.getDefault().post(new MessageEvent("我是界面EventBusActivity发布的消息"));
        EventBus.getDefault().postSticky(new MessageEvent("我是粘性事件发布的消息"));
    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessagePostingEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessagePostingEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageMainEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessageMainEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageBackgroundEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessageBackgroundEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageAsyncEvent(MessageEvent event) {
        LogUtils.i(TAG,"onMessageAsyncEvent ---- " + event.message+"==========="+Thread.currentThread());
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getUserMessage(User user){
        eventbusBt.setText(user.getUserName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            setResult(200);
            EventBusActivity.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

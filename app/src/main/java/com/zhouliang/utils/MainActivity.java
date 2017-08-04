package com.zhouliang.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.zhouliang.util.LogUtils;
import com.zhouliang.util.NetUtils;
import com.zhouliang.util.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.main_bt)
    Button mainBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_bt)
    public void onViewClicked() {
        if (NetUtils.isConnected(MainActivity.this)) {
            LogUtils.i(TAG, "点击了测试按钮");
            ToastUtils.getIntance().showToast(MainActivity.this, "wo shi toast", true);
        } else {
            ToastUtils.getIntance().showToast(MainActivity.this, "未连接网络", false);
        }
    }
}

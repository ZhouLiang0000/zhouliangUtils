package com.zhouliang.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhouliang.utils.base.UtilsActivity;

/**
 * Created by zhouliang on 2017/8/10.
 */

public class DaoActivity extends UtilsActivity {
    public static void skipToDaoActivity(Context context) {
        Intent intent = new Intent(context, DaoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao);
    }
}

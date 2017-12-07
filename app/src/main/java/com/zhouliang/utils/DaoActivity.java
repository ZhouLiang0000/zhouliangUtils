package com.zhouliang.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zhouliang.utils.base.UtilsActivity;
import com.zhouliang.utils.base.UtilsApplication;
import com.zhouliang.utils.dao.UserDao;
import com.zhouliang.utils.domain.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhouliang on 2017/8/10.
 */

public class DaoActivity extends UtilsActivity {
    @BindView(R.id.name_et)
    EditText nameEt;
    @BindView(R.id.gender_et)
    EditText genderEt;
    @BindView(R.id.age_et)
    EditText ageEt;
    @BindView(R.id.add_bt)
    Button addBt;
    @BindView(R.id.delete_bt)
    Button deleteBt;
    @BindView(R.id.update_bt)
    Button updateBt;
    @BindView(R.id.query_bt)
    Button queryBt;
    @BindView(R.id.query_all_bt)
    Button queryAllBt;
    @BindView(R.id.dao_recyclerview)
    RecyclerView daoRecyclerview;
    private UtilsApplication mUtilsApplication;
    private UserDao mUserDao;
    private List<User> mUserList;
    private User mUser;
    private String userName, userAge, userGender;

    public static void skipToDaoActivity(Context context) {
        Intent intent = new Intent(context, DaoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao);
        ButterKnife.bind(this);
        initData();
        initRecyclerView();
    }

    private void initData() {
        mUtilsApplication = UtilsApplication.getUtilsApplication();
        mUserDao = mUtilsApplication.getDaoSession().getUserDao();
    }

    private void initRecyclerView() {

    }

    @OnClick({R.id.add_bt, R.id.delete_bt, R.id.update_bt, R.id.query_bt, R.id.query_all_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_bt:
                cleanUserMessage();
                insertData();
                break;
            case R.id.delete_bt:
                cleanUserMessage();
                deleteData(1);
                break;
            case R.id.update_bt:
                cleanUserMessage();
                updateData();
                break;
            case R.id.query_bt:
                cleanUserMessage();
                queryData(1);
                break;
            case R.id.query_all_bt:
                cleanUserMessage();
                queryAllData();
                break;
        }
    }

    private void getUserMessage() {
        userName = nameEt.getText().toString().trim();
        userAge = ageEt.getText().toString().trim();
        userGender = genderEt.getText().toString().trim();
    }

    private void cleanUserMessage() {
        nameEt.setText("");
        ageEt.setText("");
        genderEt.setText("");
    }

    private void insertData() {
        getUserMessage();
        User insertData = new User(null, userName, userGender, userAge);
        mUserDao.insert(insertData);
    }

    private void deleteData(long id) {
        mUserDao.deleteByKey(id);
    }

    private void updateData() {

    }

    private User queryData(long id) {
        return mUserDao.load(id);
    }

    private List<User> queryAllData() {
        return mUserDao.loadAll();
    }

}

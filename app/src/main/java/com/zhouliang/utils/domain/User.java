package com.zhouliang.utils.domain;

/**
 * Created by zhouliang on 2017/8/9.
 */

public class User {
    private String userName;
    private String userGender;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                '}';
    }
}

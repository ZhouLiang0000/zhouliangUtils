package com.zhouliang.utils.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by zhouliang on 2017/8/9.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String userName;
    private String userGender;

    @Generated(hash = 1374613186)
    public User(Long id, String userName, String userGender) {
        this.id = id;
        this.userName = userName;
        this.userGender = userGender;
    }

    @Generated(hash = 586692638)
    public User() {
    }

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

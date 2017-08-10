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
    private String userAge;
    public String getUserAge() {
        return this.userAge;
    }
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }
    public String getUserGender() {
        return this.userGender;
    }
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 334107271)
    public User(Long id, String userName, String userGender, String userAge) {
        this.id = id;
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}

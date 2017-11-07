package com.example.qhshe.oops_1;

/**
 * Created by qhshe on 2017-08-05.
 */

public class User {

    String userSno;
    String userName;
    String userGold;

    public String getUserSno() {
        return userSno;
    }

    public void setUserSno(String userSno) {
        this.userSno = userSno;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGold() {
        return userGold;
    }

    public void setUserGold(String userGold) {
        this.userGold = userGold;
    }

    public User(String userSno, String userName, String userGold) {
        this.userSno = userSno;
        this.userName = userName;
        this.userGold = userGold;
    }
}

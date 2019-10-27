package com.sdl.entity;

public class SUserInfo {
    int userId;
    String userType;
    String userName;
    String userSex;
    String userTel;
    String userQQ;
    SUserInfo(){}

    public SUserInfo(int userId, String userType, String userName, String userSex, String userTel, String userQQ) {
        this.userId = userId;
        this.userType = userType;
        this.userName = userName;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userQQ = userQQ;
    }

    @Override
    public String toString() {
        return "SUserInfo{" +
                "userId=" + userId +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userQQ='" + userQQ + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }
}

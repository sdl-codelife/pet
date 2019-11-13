package com.sdl.entity;

public class UserInfo {
    Integer infoId;
    String userSex;
    String userTel;
    String userQQ;
    String userNote;
    int userId;
    String userName;//暂存

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserInfo() {
    }

    public UserInfo(Integer infoId, String userSex, String userTel, String userQQ, String userNote, int userId) {
        this.infoId = infoId;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userQQ = userQQ;
        this.userNote = userNote;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "infoId=" + infoId +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userNote='" + userNote + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
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

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

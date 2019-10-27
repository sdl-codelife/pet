package com.sdl.entity;

public class UserInfo {
    Integer infoId;
    String userSex;
    String userTel;
    String userQQ;
    String userNote;

    public UserInfo(){

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

    public UserInfo(Integer infoId, String userSex, String userTel, String userQQ, String userNote) {
        this.infoId = infoId;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userQQ = userQQ;
        this.userNote = userNote;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "infoId=" + infoId +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userQQ='" + userQQ + '\'' +
                ", userNote='" + userNote + '\'' +
                '}';
    }
}

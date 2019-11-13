package com.sdl.entity;

public class Description {
    int dId;
    String date;
    String petName;
    String description;
    String result;
    int resoved;
    int petId;
    int userId;

    public Description() {
    }

    public Description(int dId, String date, String petName, String description, String result, int resoved, int petId) {
        this.dId = dId;
        this.date = date;
        this.petName = petName;
        this.description = description;
        this.result = result;
        this.resoved = resoved;
        this.petId = petId;
    }
    public Description(int dId, String date, String petName, String description, String result, int resoved, int petId, int userId) {
        this.dId = dId;
        this.date = date;
        this.petName = petName;
        this.description = description;
        this.result = result;
        this.resoved = resoved;
        this.petId = petId;
        this.userId = userId;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getResoved() {
        return resoved;
    }

    public void setResoved(int resoved) {
        this.resoved = resoved;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Description{" +
                "dId=" + dId +
                ", date='" + date + '\'' +
                ", petName='" + petName + '\'' +
                ", description='" + description + '\'' +
                ", result='" + result + '\'' +
                ", resoved=" + resoved +
                ", petId=" + petId +
                ", userId=" + userId +
                '}';
    }
}

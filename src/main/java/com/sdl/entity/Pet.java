package com.sdl.entity;

public class Pet {
    int petId;
    String petName;
    String petBreed;
    String petSex;
    String petAge;
    String petWeight;
    int userId;

    public Pet() {
    }

    public Pet(int petId, String petName, String petBreed, String petSex, String petAge, String petWeight, int userId) {
        this.petId = petId;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petSex = petSex;
        this.petAge = petAge;
        this.petWeight = petWeight;
        this.userId = userId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(String petWeight) {
        this.petWeight = petWeight;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", petBreed='" + petBreed + '\'' +
                ", petSex='" + petSex + '\'' +
                ", petAge='" + petAge + '\'' +
                ", petWeight='" + petWeight + '\'' +
                ", userId=" + userId +
                '}';
    }
}

package com.sdl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.Pet;

public class UserAction extends ActionSupport {
    Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}

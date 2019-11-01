package com.sdl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.Pet;
import com.sdl.entity.User;
import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport {
    Pet pet;
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String toaddPet() {
        System.out.println(user.getUserId());
        return "success";
    }

    public String addPet() {
        UserService userService = new UserServiceImpl();
        System.out.println(pet);
        userService.addPet(pet);
        return "success";
    }
}

package com.sdl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.Pet;
import com.sdl.entity.User;
import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;
import com.sdl.util.PageUtil;

import java.util.List;

public class UserAction extends ActionSupport {
    Pet pet;
    User user;

    List<Pet> petList;
    PageUtil pageUtil;

    public PageUtil getPageUtil() {
        return pageUtil;
    }

    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }
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

    public String petList() {
        UserService userService = new UserServiceImpl();
        petList = pageUtil.setList(userService.petList(pet.getUserId()), pageUtil.getPageNo());
        return "success";
    }

    public String delPet() {
        UserService userService = new UserServiceImpl();
        System.out.println(pet.getPetId() + "SFSDFSDFSFSDFFSFSFSDFSFSFSD");
        userService.delPet(pet.getPetId());
        return "success";
    }
}

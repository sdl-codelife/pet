package com.sdl.action;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.entity.User;
import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;
import com.sdl.util.PageUtil;
import com.sdl.util.RadomNum;
import com.sdl.util.SelectPet;


import java.util.List;

public class UserAction extends ActionSupport {
    Pet pet;
    User user;
    List<Pet> petList;
    List<SelectPet> selectPet;
    PageUtil pageUtil;
    Description description;
    JsonElement SelectPetlist;
    List<Description> descriptionList;

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public List<SelectPet> getSelectPet() {
        return selectPet;
    }

    public void setSelectPet(List<SelectPet> selectPet) {
        this.selectPet = selectPet;
    }

    public JsonElement getSelectPetlist() {
        return SelectPetlist;
    }

    public void setSelectPetlist(JsonElement selectPetlist) {
        SelectPetlist = selectPetlist;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

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
        userService.delPet(pet.getPetId());
        return "success";
    }

    public String toupdatePet() {
        System.out.println(pet);
        return "success";
    }

    public String updatePet() {
        UserService userService = new UserServiceImpl();
        userService.updatePet(pet);
        return "success";
    }
    public String todescriptForm() {
        UserService userService = new UserServiceImpl();
        System.out.println(pet.getPetId());
        System.out.println(pet.getPetName());
        selectPet = userService.Selectlist(pet.getUserId());
        Gson gson = new Gson();
        SelectPetlist = gson.toJsonTree(selectPet);
        System.out.println(SelectPetlist);
        return "success";
    }

    public String descriptForm() {
        UserService userService = new UserServiceImpl();
        pet = userService.selectPet(description.getPetId());
        description.setPetName(pet.getPetName());
        description.setUserId(pet.getUserId());
        //0代表未治疗
        description.setResoved(0);
        //写入数据库。。。。。。
        System.out.println(description);
        userService.creatDescription(description);
        return "success";
    }

    public String todescripted() {
        UserService userService = new UserServiceImpl();
        System.out.println(description.getUserId());
        //获取userid 输出挂号对象
        descriptionList = userService.getDescription(description.getUserId());
        System.out.println(descriptionList);
        return "success";
    }
}

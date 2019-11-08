package com.sdl.action;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.entity.User;
import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;
import com.sdl.util.PageUtil;
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

    //跳转到新增宠物
    public String toaddPet() {
        System.out.println(user.getUserId());
        return "success";
    }

    //新增宠物
    public String addPet() {
        UserService userService = new UserServiceImpl();
        System.out.println(pet);
        int flag = userService.addPet(pet);
        if (flag != 0) {
            ActionContext.getContext().put("message", "添加成功");
            return "success";
        } else {
            ActionContext.getContext().put("message", "添加失败");
            return "fail";
        }
    }

    //宠物列表
    public String petList() {
        UserService userService = new UserServiceImpl();
        petList = pageUtil.setList(userService.petList(pet.getUserId()), pageUtil.getPageNo());
        return "success";
    }

    //根据宠物Id删除宠物
    public String delPet() {
        UserService userService = new UserServiceImpl();
        int flag = userService.delPet(pet.getPetId());
        System.out.println(pet.getPetId());
        if (flag == 1) {
            ActionContext.getContext().put("message", "删除成功");
            return "success";
        } else {
            ActionContext.getContext().put("message", "删除失败");
            return "fail";
        }
    }

    public String toupdatePet() {
        System.out.println(pet);
        return "success";
    }

    //更新宠物
    public String updatePet() {
        UserService userService = new UserServiceImpl();
        int flag = userService.updatePet(pet);
        if (flag == 1) {
            ActionContext.getContext().put("message", "更新成功");
            return "success";
        } else {
            ActionContext.getContext().put("message", "更新失败");
            return "fail";
        }
    }
    public String todescriptForm() {
        UserService userService = new UserServiceImpl();
        selectPet = userService.Selectlist(pet.getUserId());
        Gson gson = new Gson();
        SelectPetlist = gson.toJsonTree(selectPet);
        System.out.println(SelectPetlist);
        return "success";
    }

    //挂号
    public String descriptForm() {
        UserService userService = new UserServiceImpl();
        pet = userService.selectPet(description.getPetId());
        description.setPetName(pet.getPetName());
        description.setUserId(pet.getUserId());
        //0代表未治疗
        description.setResoved(0);
        //写入数据库。。。。。。
        System.out.println(description);
        int flag = userService.creatDescription(description);
        if (flag == 1) {
            ActionContext.getContext().put("message", "挂号成功");
            return "success";
        } else {
            ActionContext.getContext().put("message", "挂号失败");
            return "fail";
        }
    }

    public String todescripted() {
        UserService userService = new UserServiceImpl();
        System.out.println(description.getUserId());
        //获取userid 输出挂号对象
        descriptionList = pageUtil.setList(userService.getDescription(description.getUserId()), pageUtil.getPageNo());
        System.out.println(descriptionList);
        return "success";
    }

    public String totreatdForm() {
        UserService userService = new UserServiceImpl();
        System.out.println(description.getUserId());
        selectPet = userService.Selectlist(description.getUserId());
        Gson gson = new Gson();
        SelectPetlist = gson.toJsonTree(selectPet);
        return "success";
    }

    public String treatdForm() {
        UserService userService = new UserServiceImpl();
        System.out.println(pet.getPetId());
        selectPet = userService.Selectlist(description.getUserId());
        Gson gson = new Gson();
        SelectPetlist = gson.toJsonTree(selectPet);
        description = userService.getaDescription(pet.getPetId());
        return "success";
    }

    public String deldescriptForm() {
        //根据id删除挂号单
        UserService userService = new UserServiceImpl();
        int flag = userService.deldescriptForm(description.getdId());
        if (flag == 1) {
            ActionContext.getContext().put("message", "删除成功");
            return "success";
        } else {
            ActionContext.getContext().put("message", "删除失败");
            return "fail";
        }
    }
}

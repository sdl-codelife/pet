package com.sdl.action;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.Description;
import com.sdl.service.DoctorService;
import com.sdl.service.impl.DoctorServiceImpl;
import com.sdl.util.PageUtil;
import com.sdl.util.SelectPet;

import java.util.ArrayList;
import java.util.List;

public class DoctorAction extends ActionSupport {
    Description description;
    List<Description> descriptionList;
    PageUtil pageUtil;
    JsonElement jsonElement;

    public JsonElement getJsonElement() {
        return jsonElement;
    }

    public void setJsonElement(JsonElement jsonElement) {
        this.jsonElement = jsonElement;
    }

    public PageUtil getPageUtil() {
        return pageUtil;
    }

    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getDescriptions() {
        DoctorService doctorService = new DoctorServiceImpl();
        descriptionList = pageUtil.setList(doctorService.getDescription(description.getResoved()), pageUtil.getPageNo());
        return "success";
    }

    public String totreated() {
        List<SelectPet> selectPets = new ArrayList<>();
        List<Description> list = new DoctorServiceImpl().getDescription(0);
        for (int i = 0; i < list.size(); i++) {
            String petName = list.get(i).getPetName();
            int dId = list.get(i).getdId();
            SelectPet selectPet = new SelectPet(petName, dId);
            selectPets.add(selectPet);
        }
        Gson gson = new Gson();
        jsonElement = gson.toJsonTree(selectPets);
        System.out.println(selectPets);
        return "success";
    }

    public String seeDescription() {
        System.out.println(description.getdId() + "上岛咖啡东风风神东风破");
        List<Description> list = new DoctorServiceImpl().getDescription(0);
        for (int i = 0; i < list.size(); i++) {
            int dId = list.get(i).getdId();
            if (dId == description.getdId()) {
                description = list.get(i);
            }
            System.out.println(description + "上岛咖啡东风风神东风破");
        }
        return "success";
    }

    public String treated() {
        DoctorService doctorService = new DoctorServiceImpl();
        doctorService.updateDescript(description);
        return "success";
    }
}

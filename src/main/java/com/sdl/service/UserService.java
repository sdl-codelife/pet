package com.sdl.service;

import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.util.SelectPet;

import java.util.List;

public interface UserService {
    public int addPet(Pet pet);

    public List<Pet> petList(int userId);

    public int delPet(int petId);

    public int updatePet(Pet pet);

    public List<SelectPet> Selectlist(int userId);

    public Pet selectPet(int petId);

    public int creatDescription(Description description);

    public List<Description> getDescription(int userId);

    public Description getaDescription(int petId);

    public int deldescriptForm(int dId);
}

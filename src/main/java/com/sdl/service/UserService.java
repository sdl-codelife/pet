package com.sdl.service;

import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.util.SelectPet;

import java.util.List;

public interface UserService {
    public boolean addPet(Pet pet);

    public List<Pet> petList(int userId);

    public boolean delPet(int petId);

    public boolean updatePet(Pet pet);

    public List<SelectPet> Selectlist(int userId);

    public Pet selectPet(int petId);

    public boolean creatDescription(Description description);

    public List<Description> getDescription(int userId);
}

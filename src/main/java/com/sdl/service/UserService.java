package com.sdl.service;

import com.sdl.entity.Pet;

import java.util.List;

public interface UserService {
    public boolean addPet(Pet pet);

    public List<Pet> petList(int userId);

    public boolean delPet(int petId);
}

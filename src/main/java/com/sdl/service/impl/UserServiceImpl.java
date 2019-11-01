package com.sdl.service.impl;

import com.sdl.dao.UserDao;
import com.sdl.dao.impl.UserDaoImpl;
import com.sdl.entity.Pet;
import com.sdl.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean addPet(Pet pet) {
        return userDao.addPet(pet);
    }

    @Override
    public List<Pet> petList(int userId) {
        return userDao.petList(userId);
    }

    @Override
    public boolean delPet(int petId) {
        return userDao.delPet(petId);
    }
}

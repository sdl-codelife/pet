package com.sdl.service.impl;

import com.sdl.dao.UserDao;
import com.sdl.dao.impl.UserDaoImpl;
import com.sdl.entity.Description;
import com.sdl.entity.Pet;
import com.sdl.service.UserService;
import com.sdl.util.SelectPet;
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

    @Override
    public boolean updatePet(Pet pet) {
        return userDao.updatePet(pet);
    }

    @Override
    public List<SelectPet> Selectlist(int userId) {
        return userDao.Selectlist(userId);
    }

    @Override
    public Pet selectPet(int petId) {
        return userDao.selectPet(petId);
    }

    @Override
    public boolean creatDescription(Description description) {
        return userDao.creatDescription(description);
    }

    @Override
    public List<Description> getDescription(int userId) {
        return userDao.getDescription(userId);
    }
}

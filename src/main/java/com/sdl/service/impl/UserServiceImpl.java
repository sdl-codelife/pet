package com.sdl.service.impl;

import com.sdl.dao.UserDao;
import com.sdl.dao.impl.UserDaoImpl;
import com.sdl.entity.Pet;
import com.sdl.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean addPet(Pet pet) {
        return userDao.addPet(pet);
    }
}

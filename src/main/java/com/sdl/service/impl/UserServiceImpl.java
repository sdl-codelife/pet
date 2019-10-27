package com.sdl.service.impl;

import com.sdl.dao.UserDao;
import com.sdl.dao.impl.UserDaoImpl;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import com.sdl.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User findUser(String userName, String userPassword) {
        return userDao.findUser(userName, userPassword);
    }

    @Override
    public UserInfo findUserInfo(int userId) {
        return userDao.findUserInfo(userId);
    }

    @Override
    public boolean updateUserInfo(String userSex, String userTel, String userQQ, String userNote, int userId) {
        return userDao.updateUserInfo(userSex, userTel, userQQ, userNote, userId);
    }

    @Override
    public boolean updateUserPassword(int userId, String userName, String userPassword) {
        return userDao.updateUserPassword(userId,userName,userPassword);
    }

    @Override
    public List<SUserInfo> findAllUserInfo(String userType) {
        return userDao.findAllUserInfo(userType);
    }

    @Override
    public boolean delUser(int userId) {
        return userDao.delUser(userId);
    }
}

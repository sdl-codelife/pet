package com.sdl.service.impl;

import com.sdl.dao.AdminDao;
import com.sdl.dao.impl.AdminDaoImpl;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import com.sdl.service.AdminService;


import java.util.List;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    @Override

    public User findUser(String userName, String userPassword) {
        return adminDao.findUser(userName, userPassword);
    }

    @Override
    public UserInfo findUserInfo(int userId) {
        return adminDao.findUserInfo(userId);
    }

    @Override
    public boolean updateUserInfo(String userSex, String userTel, String userQQ, String userNote, int userId) {
        return adminDao.updateUserInfo(userSex, userTel, userQQ, userNote, userId);
    }

    @Override
    public boolean updateUserPassword(int userId, String userName, String userPassword) {
        return adminDao.updateUserPassword(userId, userName, userPassword);
    }

    @Override
    public List<SUserInfo> findAllUserInfo(String userType) {
        return adminDao.findAllUserInfo(userType);
    }

    @Override
    public boolean delUser(int userId) {
        return adminDao.delUser(userId);
    }

    @Override
    public boolean addUser(User user) {
        return adminDao.addUser(user);
    }

    @Override
    public boolean addUserInfo(int userId, UserInfo userInfo) {
        return adminDao.addUserInfo(userId, userInfo);
    }
}

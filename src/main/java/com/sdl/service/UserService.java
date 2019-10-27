package com.sdl.service;

import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;

import java.util.List;

public interface UserService {
    public User findUser(String userName,String userPassword);
    public UserInfo findUserInfo(int userId);
    public boolean updateUserInfo(String userSex,String userTel,String userQQ,String userNote,int userId);
    public boolean updateUserPassword(int userId,String userName,String userPassword);
    public List<SUserInfo> findAllUserInfo(String userType);
    public boolean delUser(int userId);
}

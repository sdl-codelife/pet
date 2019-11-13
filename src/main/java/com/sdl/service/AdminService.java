package com.sdl.service;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import java.util.List;

public interface AdminService {
    public User findUser(String userName,String userPassword);

    UserInfo findUserInfo(int userId);

    public int updateUserInfo(UserInfo userInfo);

    public int updateUserPassword(User user);

    public List<SUserInfo> findAllUserInfo(String userType);

    public boolean delUser(int userId);

    public boolean addUser(User user);

    public boolean addUserInfo(int userId, UserInfo userInfo);
}

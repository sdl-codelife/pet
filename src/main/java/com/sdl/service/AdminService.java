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

    public int delUser(int userId);

    public int addUser(User user);

    public int addUserInfo(int userId, UserInfo userInfo);
}

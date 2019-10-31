package com.sdl.dao;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import java.util.List;

public interface AdminDao {
    /**
     * 查找用户
     * @param userName
     * @param userPassWord
     * @return
     */
    public User findUser(String userName,String userPassWord);

    /**
     * 根据ID查找用户信息
     * @param userId
     * @return
     */
    public UserInfo findUserInfo(int userId);

    /**
     * 根据userId修改用户信息
     * @param userSex
     * @param userTel
     * @param userQQ
     * @param userNote
     * @param userId
     * @return
     */
    public boolean updateUserInfo(String userSex,String userTel,String userQQ,String userNote,int userId);

    /**
     * 更改密码
     * @param userId
     * @param userPassword
     * @return
     */
    public boolean updateUserPassword(int userId,String userName,String userPassword);

    /**
     * 查找某类型的所有用户信息
     * @param userType
     * @return
     */
    public List<SUserInfo> findAllUserInfo(String userType);

    /**
     * 根据Id删除用户
     * @param userId
     * @return
     */
    public boolean delUser(int userId);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 根据用户id添加用户信息
     *
     * @param userInfo
     * @return
     */
    public boolean addUserInfo(int userId, UserInfo userInfo);
}

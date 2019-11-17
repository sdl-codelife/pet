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
     * 根据userInfo.userId修改用户信息
     * @param userInfo
     * @return
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 更改密码
     * @param user
     * @return
     */
    public int updateUserPassword(User user);

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
    public int delUser(int userId);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 根据用户id添加用户信息
     *
     * @param userInfo
     * @return
     */
    public int addUserInfo(int userId, UserInfo userInfo);
}

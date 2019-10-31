package com.sdl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;
import com.sdl.util.PageUtil;

import java.util.List;

public class AdminAction extends ActionSupport {
    User user;
    UserInfo userInfo;
    int userId;
    String userName;
    List<SUserInfo> infoList;
    PageUtil pageUtil;

    public PageUtil getPageUtil() {
        return pageUtil;
    }

    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    public List<SUserInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<SUserInfo> infoList) {
        this.infoList = infoList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    //    登录
    public String login() {
        UserService userService = new UserServiceImpl();
        user = userService.findUser(user.getUserName(), user.getUserPassword());
        System.out.println(user);
        if (user != null) {
            return user.getUserType();
        } else {
            return "fail";
        }
    }

    //    根据Id查看用户信息
    public String userinfo() {
        UserService userService = new UserServiceImpl();
        System.out.println(userId);
        System.out.println(userName);
        userInfo = userService.findUserInfo(userId);
        System.out.println(userInfo);
        return "success";
    }

    //    更新用户信息
    public String updateUserInfo() {
        UserService userService = new UserServiceImpl();
        boolean a = userService.updateUserInfo(userInfo.getUserSex(), userInfo.getUserTel(), userInfo.getUserQQ(), userInfo.getUserNote(), userId);
        System.out.println(userId);
        System.out.println(userInfo);
        userInfo = userService.findUserInfo(userId);
        return "success";
    }

    //    更改用户密码
    public String updateUserPassword() {
        UserService userService = new UserServiceImpl();
        boolean a = userService.updateUserPassword(userId, user.getUserName(), user.getUserPassword());
        System.out.println(userId);
        System.out.println(user.getUserName());
        userInfo = userService.findUserInfo(userId);
        return "success";
    }

    //    查看某类型的全部用户
    public String userlist() {
        UserService userService = new UserServiceImpl();
        infoList = pageUtil.setList(userService.findAllUserInfo(user.getUserType()), pageUtil.getPageNo());
        System.out.println(pageUtil.getPageNo());
        System.out.println(infoList);
        System.out.println(infoList.size());
        return "success";
    }

    //    根据id删除用户
    public String delUser() {
        UserService userService = new UserServiceImpl();
        userService.delUser(user.getUserId());
        infoList = pageUtil.setList(userService.findAllUserInfo(user.getUserType()), pageUtil.getPageNo());
        return "success";
    }

    //    添加用户
    public String addUser() {
        UserService userService = new UserServiceImpl();
        System.out.println(user);
        System.out.println(userInfo);
        userService.addUser(user);
        userService.addUserInfo(user.getUserId(), userInfo);
        System.out.println(user.getUserType() + "啦啦啦啦啦啦啦啦");
        return "success";

    }

    //    添加用户类型
    public String toaddUser() {
        System.out.println(user.getUserType());
        return "success";

    }

    //    退出
    public String logout() {
        System.out.println(user);
        user = null;
        return "success";
    }
}

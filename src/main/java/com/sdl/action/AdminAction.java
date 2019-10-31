package com.sdl.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import com.sdl.service.AdminService;
import com.sdl.service.impl.AdminServiceImpl;
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
        AdminService adminService = new AdminServiceImpl();
        user = adminService.findUser(user.getUserName(), user.getUserPassword());
        System.out.println(user);
        if (user != null) {
            return user.getUserType();
        } else {
            return "fail";
        }
    }

    //    根据Id查看用户信息
    public String userinfo() {
        AdminService adminService = new AdminServiceImpl();
        System.out.println(userId);
        System.out.println(userName);
        userInfo = adminService.findUserInfo(userId);
        System.out.println(userInfo);
        return "success";
    }

    //    更新用户信息
    public String updateUserInfo() {
        AdminService adminService = new AdminServiceImpl();
        boolean a = adminService.updateUserInfo(userInfo.getUserSex(), userInfo.getUserTel(), userInfo.getUserQQ(), userInfo.getUserNote(), userId);
        System.out.println(userId);
        System.out.println(userInfo);
        userInfo = adminService.findUserInfo(userId);
        return "success";
    }

    //    更改用户密码
    public String updateUserPassword() {
        AdminService adminService = new AdminServiceImpl();
        boolean a = adminService.updateUserPassword(userId, user.getUserName(), user.getUserPassword());
        System.out.println(userId);
        System.out.println(user.getUserName());
        userInfo = adminService.findUserInfo(userId);
        return "success";
    }

    //    查看某类型的全部用户
    public String userlist() {
        AdminService adminService = new AdminServiceImpl();
        infoList = pageUtil.setList(adminService.findAllUserInfo(user.getUserType()), pageUtil.getPageNo());
        System.out.println(pageUtil.getPageNo());
        System.out.println(infoList);
        System.out.println(infoList.size());
        return "success";
    }

    //    根据id删除用户
    public String delUser() {
        AdminService adminService = new AdminServiceImpl();
        adminService.delUser(user.getUserId());
        infoList = pageUtil.setList(adminService.findAllUserInfo(user.getUserType()), pageUtil.getPageNo());
        return "success";
    }

    //    添加用户
    public String addUser() {
        AdminService adminService = new AdminServiceImpl();
        System.out.println(user);
        System.out.println(userInfo);
        adminService.addUser(user);
        adminService.addUserInfo(user.getUserId(), userInfo);
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

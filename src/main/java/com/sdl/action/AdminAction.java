package com.sdl.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.entity.UserInfo;
import com.sdl.service.AdminService;
import com.sdl.service.impl.AdminServiceImpl;
import com.sdl.util.PageUtil;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminAction extends ActionSupport {
    ActionContext actionContext = ActionContext.getContext();
    HttpServletResponse response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);
    HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
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
        System.out.println();
        String name = userInfo.getUserName();
        userInfo = adminService.findUserInfo(userInfo.getUserId());
        userInfo.setUserName(name);//用户名写入
        return "success";
    }

    //    更新用户信息
    public String updateUserInfo() {
        AdminService adminService = new AdminServiceImpl();
        System.out.println(userInfo.getUserId() + "ssssssssss");
        String name = userInfo.getUserName();
        userInfo.setUserId(userInfo.getUserId());
        int flag = adminService.updateUserInfo(userInfo);
        userInfo.setUserName(name);//用户名写入
        //userInfo = adminService.findUserInfo(userId);
        System.out.println(userInfo);
        if (flag == 1) {
            ActionContext.getContext().put("message", "更新成功");
            return "success";
        } else {
            ActionContext.getContext().put("message", "更新失败");
            return "fail";
        }
    }

    //    //    更改用户密码
    public String updateUserPassword() {
        AdminService adminService = new AdminServiceImpl();
        System.out.println(user);
        int flag = adminService.updateUserPassword(user);
        System.out.println(flag);
        // userInfo = adminService.findUserInfo(userId);
        if (flag == 1) {
            response.setContentType("text/html;charset=utf-8");
            ActionContext.getContext().put("message", "更改成功，请重新登录！");

            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String result = "<script type=\"text/javascript\">alert('更改成功，请重新登录！');top.location='login.jsp';</script>";
            out.println(result);
            out.flush();
            out.close();
            return "success";
        } else {
            ActionContext.getContext().put("message", "更新失败");
            return "fail";
        }
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

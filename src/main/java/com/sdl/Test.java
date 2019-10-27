package com.sdl;

import com.sdl.entity.SUserInfo;
import com.sdl.entity.User;
import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;

import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    void testlogin(){
        UserService userService = new UserServiceImpl();
        boolean S= userService.delUser(1003);
        System.out.println(S);
    }
}

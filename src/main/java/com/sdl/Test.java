package com.sdl;

import com.sdl.service.UserService;
import com.sdl.service.impl.UserServiceImpl;
import com.sdl.util.RadomNum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    @org.junit.jupiter.api.Test
    void testlogin(){
        System.out.println(new UserServiceImpl().getDescription(3233));

    }
}

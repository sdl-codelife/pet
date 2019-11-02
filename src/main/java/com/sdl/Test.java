package com.sdl;

import com.sdl.util.RadomNum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    @org.junit.jupiter.api.Test
    void testlogin(){
        System.out.println(new RadomNum().generateRadomnum());
        System.out.println(new RadomNum().generateTime());
    }
}

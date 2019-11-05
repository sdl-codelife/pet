package com.sdl.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RadomNum {


    public int generateRadomnum() {
        String time = new SimpleDateFormat("yyyyMMddHH").format(new Date().getTime());
        int num = Integer.valueOf(time);
        return num;
    }

    public String generateTime() {
        String time = new SimpleDateFormat("yyyy年MM月ddHH:mm:ss").format(new Date().getTime());
        return time;
    }
}

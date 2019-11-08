package com.sdl.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RadomNum {


    public int generateRadomnum() {
        int num = (int) (Math.random() * 1000000);
        return num;
    }

    public String generateTime() {
        String time = new SimpleDateFormat("yyyy年MM月dd日-HH:mm:ss").format(new Date().getTime());
        return time;
    }
}

package com.sdl.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class RadomNum {


    public int generateRadomnum() {
        int num = Integer.parseInt((new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime())).trim());
        ;


        return num;
    }

    public String generateTime() {
        String time = new SimpleDateFormat("yyyy年MM月ddHH:mm:ss").format(new Date().getTime());
        ;
        return time;
    }
}

package com.a15w.gameheadlines.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Utils {

    public static String chooseTime(int second){

        long l = System.currentTimeMillis();
        long m = l / 1000;

        int time = (int) (m - second);
        int min = time / 60 ;
        if(min > 59){
          int hour  =  min / 60;
            if(hour > 23){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
                String format = simpleDateFormat.format(new Date(l));
                return format;
            }else{
                return hour + "小时前";
            }
        }else if(min>3){
            return min + "分钟前";
        }else{
            return "刚刚";
        }
    }
}

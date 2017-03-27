package com.a15w.gameheadlines.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/9/6.
 */
public class DoLog {
    private static final String TAG = "android1000";

    public static void doLog(String str){
        Log.d(TAG, "doLog: " + str);
    }
}

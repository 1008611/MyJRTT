package com.wildwolf.myjrtt.utils;

import android.content.Context;

/**
 * Created by ${wild00wolf} on 2016/11/7.
 */
public class AppContextUtil {
    private static Context sContext;

    public AppContextUtil() {
    }

    public static void init(Context context) {
        sContext = context;
    }

    public static Context getInstance() {
        if (sContext == null) {
            throw new NullPointerException("this context is null");

        }
        return sContext;
    }
}

package com.wildwolf.myjrtt.base;

import android.app.Application;
import android.content.Context;

import com.wildwolf.myjrtt.utils.AppContextUtil;


/**
 * Created by ${wild00wolf} on 2016/11/7.
 */
public class App extends Application {

    private static Context mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;
        AppContextUtil.init(this);

    }

    public static Context getContext() {
        return mApplicationContext;
    }
}

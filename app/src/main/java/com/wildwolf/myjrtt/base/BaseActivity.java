package com.wildwolf.myjrtt.base;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by ${wild00wolf} on 2016/11/11.
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        ButterKnife.bind(this);
        afterCreat(savedInstanceState);
    }

    protected abstract void afterCreat(Bundle savedInstanceState);

    protected abstract int getLayoutId();
}

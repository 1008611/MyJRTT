package com.wildwolf.myjrtt.main.widget;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wildwolf.myjrtt.R;
import com.wildwolf.myjrtt.about.AboutFragment;
import com.wildwolf.myjrtt.adapter.BaseFragmentAdapter;
import com.wildwolf.myjrtt.base.BaseActivity;
import com.wildwolf.myjrtt.image.widget.ImageFragment;
import com.wildwolf.myjrtt.news.widget.NewsFragment;
import com.wildwolf.myjrtt.view.MainBottomTab;
import com.wildwolf.myjrtt.weather.widget.WeatherFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Author : Harry
 * Github  : https://github.com/HarryXR
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.vp)
    ViewPager mViewPager;
    @Bind(R.id.bottom)
    FrameLayout mBottom;

    private MainBottomTab mBottomTab;
    private BaseFragmentAdapter mAdapter;

    @Override
    protected void afterCreat(Bundle savedInstanceState) {
        mAdapter = new BaseFragmentAdapter(getFragmentManager());
        mAdapter.setFragments(new NewsFragment(), new ImageFragment(), new WeatherFragment(), new AboutFragment());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);

        initBottomView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    private void initBottomView() {
        mBottomTab = (MainBottomTab) View.inflate(this, R.layout.main_bottom_tab, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottom.addView(mBottomTab, params);
        mBottomTab.setViewPager(mViewPager);
    }


}

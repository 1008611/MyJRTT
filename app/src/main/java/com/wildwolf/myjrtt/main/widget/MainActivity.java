package com.wildwolf.myjrtt.main.widget;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.wildwolf.myjrtt.R;
import com.wildwolf.myjrtt.about.AboutFragment;
import com.wildwolf.myjrtt.adapter.BaseFragmentAdapter;
import com.wildwolf.myjrtt.image.widget.ImageFragment;
import com.wildwolf.myjrtt.main.view.MainView;
import com.wildwolf.myjrtt.news.widget.NewsFragment;
import com.wildwolf.myjrtt.view.MainBottomTab;
import com.wildwolf.myjrtt.weather.widget.WeatherFragment;


/**
 * Author : Harry
 * Github  : https://github.com/HarryXR
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private FrameLayout mBottom;
    private MainBottomTab mBottomTab;
    private BaseFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp);
        mBottom = (FrameLayout) findViewById(R.id.bottom);
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();

        initBottomView();
        mAdapter = new BaseFragmentAdapter(getFragmentManager());
        mAdapter.setFragments(new NewsFragment(), new ImageFragment(), new WeatherFragment(),new AboutFragment());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void initBottomView() {
        mBottomTab = (MainBottomTab) View.inflate(this, R.layout.main_bottom_tab, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottom.addView(mBottomTab, params);
        mBottomTab.setViewPager(mViewPager);
    }


}

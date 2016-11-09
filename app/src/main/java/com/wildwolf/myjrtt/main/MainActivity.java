package com.wildwolf.myjrtt.main;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wildwolf.myjrtt.R;
import com.wildwolf.myjrtt.about.AboutFragment;
import com.wildwolf.myjrtt.adapter.BaseFragmentAdapter;
import com.wildwolf.myjrtt.image.widget.ImageFragment;
import com.wildwolf.myjrtt.news.widget.NewsFragment;
import com.wildwolf.myjrtt.view.MainBottomTab;
import com.wildwolf.myjrtt.weather.widget.WeatherFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(R.id.bottom)
    FrameLayout bottom;

    private MainBottomTab mainBottomTab;
    private BaseFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initBottomView();
        adapter = new BaseFragmentAdapter(getFragmentManager());
        adapter.setFragments(new NewsFragment(), new ImageFragment(), new WeatherFragment(), new AboutFragment());
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(4);
    }

    private void initBottomView() {
        mainBottomTab = (MainBottomTab) View.inflate(this, R.layout.main_bottom_tab, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        bottom.addView(mainBottomTab, params);
        mainBottomTab.setViewPager(vp);

    }


}

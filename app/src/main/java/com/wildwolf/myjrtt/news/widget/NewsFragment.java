package com.wildwolf.myjrtt.news.widget;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildwolf.myjrtt.R;
import com.wildwolf.myjrtt.adapter.AfFragmentPagerAdapter;
import com.wildwolf.myjrtt.news.NewsListFragment;
import com.wildwolf.myjrtt.view.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/9.
 */
public class NewsFragment extends Fragment {

    public static final int NEWS_TYPE_TOP = 0;
    public static final int NEWS_TYPE_NBA = 1;
    public static final int NEWS_TYPE_CARS = 2;
    public static final int NEWS_TYPE_JOKES = 3;

    private PagerSlidingTabStrip mTablayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);

        mTablayout = (PagerSlidingTabStrip) view.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(7);
        setupViewPager(mViewPager);
        mTablayout.setViewPager(mViewPager);
        return view;
    }

    private void setupViewPager(ViewPager mViewPager) {
        FragmentManager fragmentManager;
        if (Build.VERSION.SDK_INT >= 17) {
            fragmentManager = getChildFragmentManager();
        } else {
            fragmentManager = getFragmentManager();
        }

        MyPageAdapter adapter = new MyPageAdapter(fragmentManager);
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_TOP), getString(R.string.top));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_NBA), getString(R.string.nba));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_CARS), getString(R.string.cars));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_JOKES), getString(R.string.jokes));


        mViewPager.setAdapter(adapter);
    }

    public static class MyPageAdapter extends AfFragmentPagerAdapter {

        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            mFragmentTitles.add(title);
        }
    }

    protected CharSequence getTitle() {
        return getClass().getSimpleName();
    }
}

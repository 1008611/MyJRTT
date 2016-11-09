package com.wildwolf.myjrtt.adapter;

import android.app.Fragment;
import android.app.FragmentManager;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/9.
 */
public class BaseFragmentAdapter extends AfFragmentPagerAdapter {

    private List<Fragment> fragments;

    public BaseFragmentAdapter(FragmentManager fm) {
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
        return getItem(position).getClass().getSimpleName();
    }

    public void setFragments(Fragment... fragments) {
        this.fragments = new ArrayList<>();
        if (fragments != null) {
            for (Fragment f : fragments) {
                this.fragments.add(f);
            }
        }

    }


}

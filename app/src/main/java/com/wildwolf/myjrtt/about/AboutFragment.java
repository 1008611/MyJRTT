package com.wildwolf.myjrtt.about;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wildwolf.myjrtt.R;

/**
 * Created by ${wild00wolf} on 2016/11/9.
 */
public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,null);
        return view;
    }
    protected CharSequence getTitle(){
        return getClass().getSimpleName();
    }
}

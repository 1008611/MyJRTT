package com.wildwolf.myjrtt.weather.widget;

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
public class WeatherFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,null);
        return view;
    }
}

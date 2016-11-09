package com.wildwolf.myjrtt.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import android.widget.RadioGroup;

import com.wildwolf.myjrtt.R;

/**
 * Created by ${wild00wolf} on 2016/11/9.
 */
public class MainBottomTab  extends RadioGroup implements RadioGroup.OnCheckedChangeListener {

    private ViewPager viewPager;

    public MainBottomTab(Context context) {
        super(context);
    }

    public MainBottomTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    private Paint p = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(getContext().getResources().getColor(R.color.divider));
        setWillNotDraw(false);
        setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup  group, int checkId) {
        if (this.viewPager != null){
            for (int i=0;i<viewPager.getChildCount();i++){
                if (group.getChildAt(i).getId() ==checkId){
                    this.viewPager.setCurrentItem(i,false);
                }
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        if (this.viewPager !=null){
            this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    check(getChildAt(position).getId());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        }
    }
}

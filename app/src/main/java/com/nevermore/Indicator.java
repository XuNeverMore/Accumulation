package com.nevermore;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class Indicator extends LinearLayout {

    private ViewPager mVp;
    private int count;
    private ArrayList<ImageView> list;
    private int mPadding;
    private int mRes;
    private int mSelectRes;
    private int currentPosition;


    public Indicator(Context context) {
        super(context);
    }

    public Indicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public Indicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setUpWithViewPager(ViewPager viewPager){
        mVp = viewPager;
        if(mVp==null||mVp.getAdapter()==null){
            return;
        }


        count = mVp.getAdapter().getCount();
        list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LayoutParams(-2,-2));
            imageView.setPadding(mPadding,mPadding,mPadding,mPadding);
            list.add(imageView);
        }


        drawPoint();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                list.get(currentPosition).setAlpha(1-positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                drawPoint();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void drawPoint() {
        this.removeAllViews();

        for (int i = 0; i < count; i++) {
            ImageView imageView = list.get(i);

            if(i==currentPosition){
                imageView.setImageResource(mSelectRes);
            }else {

            imageView.setImageResource(mRes);
            }
            this.addView(imageView);
        }

    }

    public void setPadding(int padding){
        mPadding = padding;
    }

    public void setNormalImg(int res){
        mRes = res;

    }

    public void setSelectImg(int res){
        mSelectRes = res;

    }


}

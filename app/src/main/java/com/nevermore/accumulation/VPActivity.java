package com.nevermore.accumulation;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nevermore.Indicator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VPActivity extends AppCompatActivity {

    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.activity_vp)
    LinearLayout activityVp;
    @Bind(R.id.indicator)
    Indicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        ButterKnife.bind(this);
        int[] ints = {R.mipmap.pg_00, R.mipmap.pg_01, R.mipmap.pg_02, R.mipmap.pg_04, R.mipmap.pg_05, R.mipmap.pg_06, R.mipmap.pg_07};
        ArrayList<ImageView> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));


            imageView.setImageResource(ints[i]);
            list.add(imageView);
        }


        viewPager.setAdapter(new QuickPagerAdapter<ImageView>(list));

        indicator.setPadding(10);
        indicator.setNormalImg(R.drawable.oval_white);
        indicator.setSelectImg(R.drawable.oval_red);
        indicator.setUpWithViewPager(viewPager);

    }

    class QuickPagerAdapter<T> extends PagerAdapter {
        private ArrayList<T> mList;

        public QuickPagerAdapter(ArrayList<T> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList == null ? 0 : mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView((View) mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


    @OnClick(R.id.view_pager)
    public void onClick() {
    }
}

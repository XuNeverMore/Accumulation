package com.nevermore.accumulation;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewFliActivity extends AppCompatActivity {

    @Bind(R.id.view_flipper)
    ViewFlipper viewFlipper;
    @Bind(R.id.view_flipper_1)
    ViewFlipper viewFlipper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fli);
        ButterKnife.bind(this);
        ViewPager viewPager;





        int[] ints = {R.mipmap.pg_00, R.mipmap.pg_01, R.mipmap.pg_02, R.mipmap.pg_04, R.mipmap.pg_05, R.mipmap.pg_06, R.mipmap.pg_07};
        ArrayList<ImageView>  list= new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            ImageView imageView = new ImageView(this);

            imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

            imageView.setImageResource(ints[i]);
            list.add(imageView);
        }

        for (int i = 0; i < list.size(); i++) {
            viewFlipper.addView(list.get(i));
        }
        for (int i = 0; i < ints.length; i++) {
            ImageView imageView = new ImageView(this);

            imageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));

            imageView.setImageResource(ints[i]);
            viewFlipper1.addView(imageView);
        }
        viewFlipper1.startFlipping();
        viewFlipper.startFlipping();

        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flipping = viewFlipper.isFlipping();
                if(flipping){
                    viewFlipper.stopFlipping();
                }else{
                    viewFlipper.startFlipping();
                }
            }
        });
        viewFlipper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flipping = viewFlipper1.isFlipping();
                if(flipping){
                    viewFlipper1.stopFlipping();
                }else{
                    viewFlipper1.startFlipping();
                }
            }
        });



    }
}

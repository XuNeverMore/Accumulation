package com.nevermore.accumulation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AlphaBarActivity extends AppCompatActivity {

    @Bind(R.id.tv_titla)
    TextView tvTitla;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.activity_alpha_bar)
    LinearLayout activityAlphaBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_bar);
        ButterKnife.bind(this);

    }
}

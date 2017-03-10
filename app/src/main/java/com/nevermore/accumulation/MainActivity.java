package com.nevermore.accumulation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.btn_scr)
    Button btnScr;
    @Bind(R.id.btn_round)
    Button btnRound;
    private Button btnVF;
    private Button btnVP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        findViews();
    }

    private void findViews() {
        btnVF = (Button) findViewById(R.id.btn_vf);
        btnVF.setOnClickListener(this);

        btnVP = (Button) findViewById(R.id.btn_vp);
        btnVP.setOnClickListener(this);
        btnScr.setOnClickListener(this);

        btnRound.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_vf:
                startActivity(new Intent(this, ViewFliActivity.class));
                break;
            case R.id.btn_vp:
                startActivity(new Intent(this, VPActivity.class));
                break;
            case R.id.btn_scr:
                startActivity(new Intent(this, AlphaBarActivity.class));
                break;
            case R.id.btn_round:
                startActivity(new Intent(this,RoundCornerActivity.class));
                break;
        }


    }
}

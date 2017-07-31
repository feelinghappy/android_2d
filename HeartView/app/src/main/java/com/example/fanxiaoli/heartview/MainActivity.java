package com.example.fanxiaoli.heartview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.heartlib.HeartView;
import java.util.Random;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HeartView mHeartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeartView = (HeartView) findViewById(R.id.heart_view);
        ImageView bgImage = (ImageView) findViewById(R.id.iv_bg);
        mHeartView.setOnClickListener(this);
        bgImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mHeartView.addHeart(new Random().nextInt(6));
    }
}

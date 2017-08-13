package com.example.fanxiaoli.cv.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.example.fanxiaoli.cv.R;

public class ShowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TextView textView = (TextView) findViewById(R.id.text01);
    }

    class MyClickableSpan extends ClickableSpan {

        private String content;

        public MyClickableSpan(String content) {
            this.content = content;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(ShowActivity.this, OtherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("content", content);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        }
    }
}

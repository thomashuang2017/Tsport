package com.example.gaga.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class Baseball_news_2 extends AppCompatActivity {

    TextView tv;
    TextView tv2;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_news_2);
        tv=(TextView)findViewById(R.id.tv_content);
        tv2=(TextView)findViewById(R.id.tv_content_date);
        iv=(ImageView)findViewById(R.id.news2_image);
        Bundle bundle = this.getIntent().getExtras();
        int pic=bundle.getInt("image");
        String cat = bundle.getString("content");
        String dat = bundle.getString("date");
        iv.setImageResource(pic);
        tv.setText(cat);
        tv2.setText(dat);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(Baseball_news_2.this, Baseball_news.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

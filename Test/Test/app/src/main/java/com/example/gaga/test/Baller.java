package com.example.gaga.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;


public class Baller extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;

    TextView tv7;
    TextView tv8;
    TextView tv9;
    TextView tv10;
    TextView tv11;
    TextView tv12;

    ImageView iv_back;
    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baller);
        tv1=(TextView)findViewById(R.id.tv_num);
        tv2=(TextView)findViewById(R.id.tv_name);
        tv3=(TextView)findViewById(R.id.tv_pos);
        tv4=(TextView)findViewById(R.id.tv_uh);
        tv5=(TextView)findViewById(R.id.tv_hw);
        tv6=(TextView)findViewById(R.id.tv_bir);
        tv7=(TextView)findViewById(R.id.tv_get_num);
        tv8=(TextView)findViewById(R.id.tv_get_name);
        tv9=(TextView)findViewById(R.id.tv_get_pos);
        tv10=(TextView)findViewById(R.id.tv_get_uh);
        tv11=(TextView)findViewById(R.id.tv_get_hw);
        tv12=(TextView)findViewById(R.id.tv_get_bir);

        iv_back=(ImageView)findViewById(R.id.img_back);
        iv=(ImageView)findViewById(R.id.baller_image);
        tv1.setText("背號");
        tv2.setText("姓名");
        tv3.setText("位置");
        tv4.setText("慣用手");
        tv5.setText("身高體重");
        tv6.setText("生日");

        Bundle bundle = this.getIntent().getExtras();
        String b1 = bundle.getString("num");
        String b2 = bundle.getString("name");
        String b3 = bundle.getString("position");
        String b4 = bundle.getString("UH");
        String b5 = bundle.getString("HW");
        String b6 = bundle.getString("birth");
        tv7.setText(b1);
        tv8.setText(b2);
        tv9.setText(b3);
        tv10.setText(b4);
        tv11.setText(b5);
        tv12.setText(b6);
        int pic_back=bundle.getInt("picback");
        iv_back.setImageResource(pic_back);
        int pic=bundle.getInt("pic");
        iv.setImageResource(pic);


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(Baller.this, Baseball_Team.class);
            team_parser tp = new team_parser();
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

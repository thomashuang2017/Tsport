package com.example.gaga.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Baseball_Team extends AppCompatActivity {

    private ImageButton bt_sc;
    private ImageButton bt_news;
    private ImageButton bt_team;
    private ImageButton bt_profile;
    private ImageButton bt_record;
    private ImageButton bt_bar;
    private ImageButton bt_chat;
    private ImageButton ib1;
    private ImageButton ib2;
    private ImageButton ib3;
    private ImageButton ib4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        bt_sc=(ImageButton)findViewById(R.id.button_schedule);
        bt_news=(ImageButton)findViewById(R.id.button_news);
        bt_team=(ImageButton)findViewById(R.id.button_team);
        bt_profile=(ImageButton)findViewById(R.id.button_profile);
        bt_record=(ImageButton)findViewById(R.id.button_record);
        bt_bar=(ImageButton)findViewById(R.id.button_bar);
        bt_chat=(ImageButton)findViewById(R.id.button_chat);
        ib1=(ImageButton) findViewById(R.id.ibt_ele);
        ib2=(ImageButton) findViewById(R.id.ibt_lion);
        ib3=(ImageButton) findViewById(R.id.ibt_lami);
        ib4=(ImageButton) findViewById(R.id.ibt_war);


        bt_chat.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_Login.class);
                startActivity(intent);
                finish();
            }
        });

        ib1.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_elephant.class);
                startActivity(intent);
                finish();
            }
        });

        ib2.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_lion.class);
                startActivity(intent);
                finish();
            }
        });

        ib3.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_lamigo.class);
                startActivity(intent);
                finish();
            }
        });

        ib4.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_warrior.class);
                startActivity(intent);
                finish();
            }
        });

        bt_sc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball.class);
                startActivity(intent);
                finish();
            }
        });

        bt_news.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_news.class);
                startActivity(intent);
                finish();
            }
        });

        bt_team.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_Team.class);
                startActivity(intent);
                finish();
            }
        });

        bt_bar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bt_profile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_Profile.class);
                startActivity(intent);
                finish();
            }
        });

        bt_record.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Team.this,Baseball_Record.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(Baseball_Team.this, Baseball.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

package com.example.gaga.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Baseball_Profile extends AppCompatActivity {

    private ImageButton bt_sc;
    private ImageButton bt_news;
    private ImageButton bt_team;
    private ImageButton bt_profile;
    private ImageButton bt_bar;
    private ImageButton bt_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bt_sc=(ImageButton)findViewById(R.id.button_schedule);
        bt_news=(ImageButton)findViewById(R.id.button_news);
        bt_team=(ImageButton)findViewById(R.id.button_team);
        bt_profile=(ImageButton)findViewById(R.id.button_profile);
        bt_bar=(ImageButton)findViewById(R.id.button_bar);
        bt_chat=(ImageButton)findViewById(R.id.button_chat);

        bt_chat.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Profile.this,Baseball_Login.class);
                startActivity(intent);
                finish();
            }
        });

        bt_sc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Profile.this,Baseball.class);
                startActivity(intent);
                finish();
            }
        });

        bt_news.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Profile.this,Baseball_news.class);
                startActivity(intent);
                finish();
            }
        });

        bt_team.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Profile.this,Baseball_Team.class);
                startActivity(intent);
                finish();
            }
        });

        bt_bar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Profile.this,MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bt_profile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_Profile.this,Baseball_Profile.class);
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
            myIntent = new Intent(Baseball_Profile.this, Baseball.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

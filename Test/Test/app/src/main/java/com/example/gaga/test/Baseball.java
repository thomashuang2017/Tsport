package com.example.gaga.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baseball extends AppCompatActivity {

    private ImageButton bt_sc;
    private ImageButton bt_news;
    private ImageButton bt_team;
    private ImageButton bt_profile;
    private ImageButton bt_bar;
    private ImageButton bt_live;
    private ImageButton bt_chat;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);
        bt_sc=(ImageButton)findViewById(R.id.button_schedule);
        bt_news=(ImageButton)findViewById(R.id.button_news);
        bt_team=(ImageButton)findViewById(R.id.button_team);
        bt_profile=(ImageButton)findViewById(R.id.button_profile);
        bt_bar=(ImageButton)findViewById(R.id.button_bar);
        bt_live=(ImageButton)findViewById(R.id.imageButton_live);
        bt_chat=(ImageButton)findViewById(R.id.button_chat);

        bt_chat.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,Baseball_Login.class);
                startActivity(intent);
                finish();
            }
        });

        bt_live.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,Firebase_live.class);
                startActivity(intent);
                finish();
            }
        });

        bt_sc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,Baseball.class);
                startActivity(intent);
                finish();
            }
        });

        bt_news.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,Baseball_news.class);
                startActivity(intent);
                finish();
            }
        });

        bt_team.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,Baseball_Team.class);
                startActivity(intent);
                finish();
            }
        });

        bt_bar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bt_profile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball.this,Baseball_Profile.class);
                startActivity(intent);
                finish();
            }
        });

        lv=(ListView)findViewById(R.id.listview_main);
        String url= "http://163.13.201.116/schedule.php";
        final main_Downloader d = new main_Downloader(this,url,lv);
        d.execute();
        registerForContextMenu(lv);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 攔截返回鍵
        new AlertDialog.Builder(Baseball.this)
                .setMessage("確定要離開T-Sport嗎?")
                .setPositiveButton("確定",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                finish();
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // TODO Auto-generated method stub

                            }
                        }).show();
    }
        return true;
    }

}

package com.example.gaga.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private String[] list= {"中華職棒","電競","SBL"};
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listview_logo);
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int position, long p4) {
                // ItemClick/ItemSelect Code
                switch (position){
                    case 0:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Baseball.class);//第一個class是當前的頁面，第二個是要跳去的頁面
                    startActivity(intent);
                    finish();
                    break;

                    case 1:
                        Intent i2 = new Intent();
                        i2.setClass(MainActivity.this, Esport.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent();
                        i3.setClass(MainActivity.this, basketball.class);
                        startActivity(i3);
                        break;
                }
            }
        });

    }
}

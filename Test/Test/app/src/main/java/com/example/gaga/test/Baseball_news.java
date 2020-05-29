package com.example.gaga.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Baseball_news extends AppCompatActivity {

    public int location;
    public static String TAG = "myfavorite";
    private Gson gson = new Gson();
    private List<String> favor_l = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    private ImageButton bt_sc;
    private ImageButton bt_news;
    private ImageButton bt_team;
    private ImageButton bt_profile;
    private ImageButton bt_bar;
    private ListView lv3;
    private ImageButton bt_chat;

    public static boolean j_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_news);
        bt_sc=(ImageButton)findViewById(R.id.button_schedule);
        bt_news=(ImageButton)findViewById(R.id.button_news);
        bt_team=(ImageButton)findViewById(R.id.button_team);
        bt_profile=(ImageButton)findViewById(R.id.button_profile);
        bt_bar=(ImageButton)findViewById(R.id.button_bar);
        bt_chat=(ImageButton)findViewById(R.id.button_chat);
        /*
                if(first==true & second=true ) clear
        */
        bt_chat.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_news.this,Baseball_Login.class);
                startActivity(intent);
                finish();
            }
        });

        bt_sc.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_news.this,Baseball.class);
                startActivity(intent);
                finish();
            }
        });

        bt_news.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_news.this,Baseball_news.class);
                startActivity(intent);
                finish();
            }
        });

        bt_team.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_news.this,Baseball_Team.class);
                startActivity(intent);
                finish();
            }
        });

        bt_bar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_news.this,MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bt_profile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_news.this,Baseball_Profile.class);
                startActivity(intent);
                finish();
            }
        });
        lv3=(ListView)findViewById(R.id.listview_news1);
        String url= "http://163.13.201.116/cpbl_new.php";
        final news1_Downloader d = new news1_Downloader(this,url,lv3);
        d.execute();
        registerForContextMenu(lv3);

        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                news1_parser ns = new news1_parser();
                //Intent picIntent = new Intent(Baseball_news.this, Baseball_news_2.class);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("image",ns.parse_pic(position));
                Intent intent = new Intent();
                //Intent intent1 = new Intent();
                intent.setClass(Baseball_news.this,Baseball_news_2.class);
                String s = ns.parsego(position);
                String d = ns.parsegodate(position);
                Bundle bundle = new Bundle();
                Bundle bundle1 = new Bundle();
                bundle.putString("content",s);
                bundle1.putString("date",d);
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                intent.putExtras(bundle2);
                startActivity(intent);
                finish();

                //Snackbar.make(view,players.get(position),Snackbar.LENGTH_SHORT).show();
            }
        });


        lv3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            //public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                location = position;
                showDialog();
                return true;
            }
        });

    }

//watch=false;

    private  void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Baseball_news.this);
        final String[] items = new String[]{"收藏","取消"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(which==0){
                    j_empty=true;
                    news1_parser np=new news1_parser();
                    favor_l.add(np.parse_favorit(location));
                    String data_title = gson.toJson(favor_l);
                    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Baseball_news.this);
                    sharedPreferences.edit().putString(TAG,data_title).commit();
                }
                else ;
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent myIntent = new Intent();
            myIntent = new Intent(Baseball_news.this, Baseball.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

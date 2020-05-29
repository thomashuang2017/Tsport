package com.example.gaga.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Baseball_warrior extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;
    ListView lv;
    Button bt1;
    Button bt2;


    int picture[]={R.drawable.fubon_1,R.drawable.fubon_2,R.drawable.fubon_8,R.drawable.fubon_9,R.drawable.fubon_11,
            R.drawable.fubon_15,R.drawable.fubon_17,R.drawable.fubon_18,R.drawable.fubon_20,R.drawable.fubon_22,
            R.drawable.fubon_32,R.drawable.fubon_33,R.drawable.fubon_37,R.drawable.fubon_39,R.drawable.fubon_40,
            R.drawable.fubon_44,R.drawable.fubon_51,R.drawable.fubon_51,R.drawable.fubon_52,R.drawable.fubon_54,
            R.drawable.fubon_58,R.drawable.fubon_64,R.drawable.fubon_66,R.drawable.fubon_77,R.drawable.fubon_93,
            R.drawable.fubon_96,R.drawable.fubon_98};


    int picture_back[] = {R.drawable.fubon00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_warrior);
        tv1=(TextView)findViewById(R.id.tv_num);
        tv2=(TextView)findViewById(R.id.tv_name);
        tv3=(TextView)findViewById(R.id.tv_pos);
        tv4=(TextView)findViewById(R.id.tv_uh);
        tv5=(TextView)findViewById(R.id.tv_hw);
        tv6=(TextView)findViewById(R.id.tv_bir);
        lv=(ListView)findViewById(R.id.listv_team);
        bt1=(Button)findViewById(R.id.bt_off);
        bt2=(Button)findViewById(R.id.bt_def);
        tv1.setText("NUM");
        tv2.setText("NAME");
        tv3.setText("POS");
        tv4.setText("UH");
        tv5.setText("HW");
        tv6.setText("BIRTH");
        String url= "http://163.13.201.116/fuban.php";
        lv=(ListView)findViewById(R.id.listv_team);
        final team_Downloader d = new team_Downloader(this,url,lv);
        d.execute();
        registerForContextMenu(lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                team_parser tp = new team_parser();
                Intent intent = new Intent();
                intent.setClass(Baseball_warrior.this,Baller.class);
                Bundle bundle = new Bundle();
                ArrayList<String> catcher = new ArrayList<String>();
                catcher = tp.Ballerparse(position);
                bundle.putInt("picback",picture_back[0]);
                bundle.putInt("pic",picture[position]);
                bundle.putString("num",catcher.get(0));
                bundle.putString("name",catcher.get(1));
                bundle.putString("position",catcher.get(2));
                bundle.putString("UH",catcher.get(3));
                bundle.putString("HW",catcher.get(4));
                bundle.putString("birth",catcher.get(5));
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });

        bt1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_warrior.this,fuban_offense.class);
                startActivity(intent);
                finish();
            }
        });

        bt2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Baseball_warrior.this,fuban_defense.class);
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
            myIntent = new Intent(Baseball_warrior.this, Baseball_Team.class);
            startActivity(myIntent);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

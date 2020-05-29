package com.example.gaga.test;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaga on 2017/8/17.
 */

public class news1_parser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    ListView lv;
    static String data;
    ListView lvgoto;
    static String con="";

    static int picture[]={R.drawable.news_1_resized,R.drawable.news_2_resized,R.drawable.news_3_resized,R.drawable.news_4_resized,R.drawable.news_5_resized
            ,R.drawable.news_6_resized,R.drawable.news_7_resized,R.drawable.news_8_resized,R.drawable.news_9_resized,R.drawable.news_10_resized
            ,R.drawable.news_11_resized,R.drawable.news_12_resized,R.drawable.news_13_resized,R.drawable.news_14_resized,R.drawable.news_15_resized
            ,R.drawable.news_16_resized,R.drawable.news_17_resized,R.drawable.news_18_resized,R.drawable.news_19_resized,R.drawable.news_20_resized
            };

    static List<String> favor_list = new ArrayList<>();

    //ArrayList<String> players=new ArrayList<>();
    List<Map<String,Object>> mData = new ArrayList<Map<String, Object>>();
    //List<Map<String,Object>> gData = new ArrayList<Map<String, Object>>();
    ArrayList<String> gData = new ArrayList<String>();

    ProgressDialog pd;

    public news1_parser() {

    }
    public static int parse_pic(int pos){
        return picture[pos];
    }

    public static String parse_favorit(int pos){
        return favor_list.get(pos);
    }

    public news1_parser(Context c, String data, ListView lv) {
        this.c = c;
        this.data = data;
        this.lv = lv;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("record_Parser");
        pd.setMessage("Parsing ....Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parse();
    }
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);

        if(integer == 1)
        {
            //ADAPTER
            SimpleAdapter adapter = new SimpleAdapter(c,
                    mData,
                    R.layout.layout_for_news1,
                    //new String[]{"title"},
                    new String[]{"title","picture"},
                    new int[]{R.id.tv_news1,R.id.news_imageview});
                    //new int[]{R.id.tv_news1});
            //ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,players);

            //ADAPT TO LISTVIEW
            lv.setAdapter(adapter);
            //LISTENET
        }else
        {
            Toast.makeText(c,"Unable to Parse",Toast.LENGTH_SHORT).show();
        }

        pd.dismiss();
    }

   public static String parsego(int pos){
       try
       {
           JSONArray ja=new JSONArray(data);
           JSONObject jo = null;
           //gData.clear();
           jo=ja.getJSONObject(pos);
           //Map<String,Object> item = new HashMap<String,Object>();
           String content=jo.getString("content");
           con=content;
       } catch (JSONException e) {
           e.printStackTrace();
       }
       return  con;
   }

    public static String parsegodate(int pos){
        try
        {
            JSONArray ja=new JSONArray(data);
            JSONObject jo = null;
            //gData.clear();
            jo=ja.getJSONObject(pos);
            //Map<String,Object> item = new HashMap<String,Object>();
            String date=jo.getString("date");
            con=date;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  con;
    }

    //PARSE RECEIVED DATA
    private int parse()
    {
        try
        {
            //ADD THAT DATA TO JSON ARRAY FIRST
            JSONArray ja=new JSONArray(data);

            //CREATE JO OBJ TO HOLD A SINGLE ITEM
            JSONObject jo=null;

            mData.clear();

            //LOOP THRU ARRAY
            //for(int i=0;i<ja.length();i++)
            for(int i=0;i<20;i++) //20 is news
            {
                jo=ja.getJSONObject(i);
                Map<String,Object> item = new HashMap<String,Object>();
                //RETRIOEVE NAME

                favor_list.add(jo.getString("title"));
                String title=jo.getString("title");
                item.put("picture",picture[i]);
                item.put("title",title);
                //ADD IT TO OUR ARRAYLIST
                mData.add(item);
                //mData.add(item);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}

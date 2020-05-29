package com.example.gaga.test;
import android.app.ProgressDialog;
import android.content.Context;
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

public class team_parser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    ListView lv;
    static String data;

    static ArrayList<String> Ateam_parser=new ArrayList<String>();
    //ArrayList<String> players=new ArrayList<>();
    public static List<Map<String,Object>> mData = new ArrayList<Map<String, Object>>();

    ProgressDialog pd;

    public team_parser(){

    }


    public team_parser(Context c, String data, ListView lv) {
        this.c = c;
        this.data = data;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("main_Parser");
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
                    R.layout.layout_for_team,
                    new String[]{"number","name","position","UH","HW","birth"},
                    new int[]{R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6});
            //ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,players);

            //ADAPT TO LISTVIEW
            lv.setAdapter(adapter);
        }else
        {
            Toast.makeText(c,"Unable to Parse",Toast.LENGTH_SHORT).show();
        }

        pd.dismiss();
    }

    public static ArrayList<String> Ballerparse(int pos){
        try
        {
            JSONArray ja=new JSONArray(data);
            JSONObject jo = null;

            //gData.clear();
            Ateam_parser.clear();
            jo=ja.getJSONObject(pos);
            //Map<String,Object> item = new HashMap<String,Object>();
            String num = jo.getString("number");
            String name=jo.getString("name");
            String positon=jo.getString("position");
            String UH = jo.getString("UH");
            String HW = jo.getString("HW");
            String birth = jo.getString("birth");
            Ateam_parser.add(num);
            Ateam_parser.add(name);
            Ateam_parser.add(positon);
            Ateam_parser.add(UH);
            Ateam_parser.add(HW);
            Ateam_parser.add(birth);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  Ateam_parser;

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
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                Map<String,Object> item = new HashMap<String,Object>();
                //RETRIOEVE NAME
                String num = jo.getString("number");
                String name=jo.getString("name");
                String pos=jo.getString("position");
                String UH = jo.getString("UH");
                String HW = jo.getString("HW");
                String birth = jo.getString("birth");
                item.put("number",num);
                item.put("name",name);
                item.put("position",pos);
                item.put("UH",UH);
                item.put("HW",HW);
                item.put("birth",birth);
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

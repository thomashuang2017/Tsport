package com.example.gaga.test;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
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

public class team_defense_parser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    ListView lv;
    String data;

    //ArrayList<String> players=new ArrayList<>();
    List<Map<String,Object>> mData = new ArrayList<Map<String, Object>>();

    ProgressDialog pd;

    public team_defense_parser(Context c, String data, ListView lv) {
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
                    R.layout.layout_for_team_off_def,
                    new String[]{"name","year","team","G","TC","PO","A"},
                    new int[]{R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7});
            //ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,players);

            //ADAPT TO LISTVIEW
            lv.setAdapter(adapter);

            //LISTENET
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mData.get(position);
                    //mData.get(position);
                    //Snackbar.make(view,players.get(position),Snackbar.LENGTH_SHORT).show();
                }
            });

        }else
        {
            Toast.makeText(c,"Unable to Parse",Toast.LENGTH_SHORT).show();
        }

        pd.dismiss();
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
                String name=jo.getString("name");
                String year=jo.getString("year");
                String team=jo.getString("team");
                String G=jo.getString("G");
                String TC=jo.getString("TC");
                String PO=jo.getString("PO");
                String A=jo.getString("A");
                item.put("name",name);
                item.put("year",year);
                item.put("team",team);
                item.put("G",G);
                item.put("TC",TC);
                item.put("PO",PO);
                item.put("A",A);
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
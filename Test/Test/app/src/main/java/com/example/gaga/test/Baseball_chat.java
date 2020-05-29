package com.example.gaga.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Baseball_chat extends AppCompatActivity {

    private EditText editText;
    private DatabaseReference chat_data_ref;
    private DatabaseReference user_name_ref;
    private ListView listView;
    private FirebaseAuth mAuth;
    private String name="";
    HashMap<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball_chat);
        mAuth= FirebaseAuth.getInstance();
        editText=(EditText)findViewById(R.id.edittext);
        chat_data_ref= FirebaseDatabase.getInstance().getReference().child("chat_data");
        try {
            user_name_ref=FirebaseDatabase.getInstance().getReference().child("chat_users").child(mAuth.getCurrentUser().getUid()).child("name");
            Log.d("Main:onCreate","here");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        listView=(ListView)findViewById(R.id.listview);
        map=new HashMap<>();
        try {
            user_name_ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {
                        name=dataSnapshot.getValue().toString();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    Log.d("Main:add","here");
                }
                @Override
                public void onCancelled(DatabaseError error) {

                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FirebaseListAdapter<Message> adapter=new FirebaseListAdapter<Message>(
                this,Message.class, R.layout.individual_row,chat_data_ref
        ) {
            @Override
            protected void populateView(View v, Message model, int position) {
                TextView msg=(TextView)v.findViewById(R.id.textView1);
                TextView user=(TextView)v.findViewById(R.id.textView2);
                user.setText(model.getUser_name()+" : ");
                msg.setText(model.getMessage());
            }
        };
        listView.setAdapter(adapter);
    }
    public void send(View view) {
        chat_data_ref.push().setValue(new Message(editText.getText().toString(),name));//storing actual msg with name of the user
        editText.setText("");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.logout)
        {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,Baseball_Login.class));
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Baseball_news.class));
    }
}

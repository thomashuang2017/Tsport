package com.example.gaga.test;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Baseball_Register extends AppCompatActivity {

    private EditText email, name, password;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    private DatabaseReference userIdRef;
    ProgressDialog registerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball__register);
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("chat_users");
        mAuth = FirebaseAuth.getInstance();
        registerDialog = new ProgressDialog(this);
        registerDialog.setMessage("Registering..");
    }
    private static boolean isEmailValid(String Email) {
        return !TextUtils.isEmpty(Email) && android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches();
    }
    private static boolean isPasswordValid(String Password){
        return (Password.length() >= 6);
    }

    public void submit(final View view) {
        registerDialog.show();

        String Email = email.getText().toString().trim();
        String Password =password.getText().toString().trim();
        if(email.getText().toString().equals("") || password.getText().toString().equals("") || name.getText().toString().equals("") || !isEmailValid(Email) || !isPasswordValid(Password) ){
            Toast.makeText(getApplicationContext(), "信箱密碼格式錯誤", Toast.LENGTH_SHORT).show();
            registerDialog.dismiss();
        }else
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    try{
                        if (task.isSuccessful()) {
                            registerDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
                            userIdRef = databaseReference.child(mAuth.getCurrentUser().getUid());
                            userIdRef.child("name").setValue(name.getText().toString());
                            finish();
                        }else{
                            Toast.makeText(getApplicationContext(), "註冊失敗", Toast.LENGTH_SHORT).show();
                            registerDialog.dismiss();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
    }

}

package com.example.gaga.test;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class Baseball_Login extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private String a="a",b="a";
    private EditText email,password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog loginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball__login);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();
        loginDialog =new ProgressDialog(this);
        loginDialog.setMessage("Login..");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Baseball_Login.this, Baseball_chat.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
                }
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private static boolean isEmailValid(String Email) {
        return !TextUtils.isEmpty(Email) && android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches();
    }

    private static boolean isPasswordValid(String Password){
        return (Password.length() >= 6);
    }

    public void login(final View view) {
        String Email = email.getText().toString().trim();
        String Password =password.getText().toString().trim();
        loginDialog.show();
        if (email.getText().toString().equals("") || password.getText().toString().equals("") || !isEmailValid(Email) || !isPasswordValid(Password)){
            Toast.makeText(getApplicationContext(), "帳號密碼格式錯誤", Toast.LENGTH_SHORT).show();
            loginDialog.dismiss();
        }else {
            a = email.getText().toString();
            b = password.getText().toString();
            mAuth.signInWithEmailAndPassword(a, b).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        loginDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "登入失敗", Toast.LENGTH_SHORT).show();
                    } else {
                        loginDialog.dismiss();
                        startActivity(new Intent(view.getContext(), Baseball_chat.class));
                    }

                }
            });
        }
    }
    public void register(View view) {
        startActivity(new Intent(Baseball_Login.this,Baseball_Register.class));
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Baseball_news.class));
    }
}

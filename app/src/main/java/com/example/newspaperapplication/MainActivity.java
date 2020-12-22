package com.example.newspaperapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText login_userName,login_password;
    Button register,login;
    String given_usrName,given_password;
    final String PREF_USERNAME="username";
    final String PREF_PASSWORD="password";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String FileName="MyPrefs";
    int mode=0;
    SaveSharedPreference saveSharedPreference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_userName=(EditText)findViewById(R.id.login_username);
        login_password=(EditText)findViewById(R.id.login_password);
        login=(Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            loginCheck();

            }
        });

        register=(Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });






    }
    @Override
    protected void onStart() {
        super.onStart();
        //if user is logged in
       checkSession();
    }


    //Login check
  public void loginCheck(){
      sharedPreferences=getSharedPreferences(FileName,mode);
        given_password=sharedPreferences.getString(PREF_USERNAME,"");
        given_usrName=sharedPreferences.getString(PREF_PASSWORD,"");

        if(login_userName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Type usrName",Toast.LENGTH_SHORT).show();
        }
        else  if(login_password.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Type your password",Toast.LENGTH_SHORT).show();
        }
        else if(!(login_userName.getText().toString().equals(given_usrName))){
            Toast.makeText(getApplicationContext(),"Please register",Toast.LENGTH_SHORT).show();
        }
        else if(!(login_password.getText().toString().equals(given_password))){
            Toast.makeText(getApplicationContext(),"Incorrect password",Toast.LENGTH_SHORT).show();
        }

        else{
            User user=new User(12,login_userName.getText().toString(),login_password.getText().toString());

         SessionManagement sessionManagement=new SessionManagement(MainActivity.this);
         sessionManagement.SaveSession(user);

         moveToMainActivity();
        }


  }
    private void moveToMainActivity(){
        Intent intent=new Intent(MainActivity.this,Homepage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void checkSession(){
        SessionManagement sessionManagement=new SessionManagement(MainActivity.this);
        int USER_ID=sessionManagement.getSession();

        if(USER_ID!=-1){
            moveToMainActivity();
        }
        else {

        }
    }


}

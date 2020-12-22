package com.example.newspaperapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class Register extends AppCompatActivity {
    TextView login_now;
    EditText reg_Name,reg_username,reg_password,reg_email,reg_password_repeat;
    Button reg_signUp;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String FileName="MyPrefs";
    int mode=0;
    final String PREF_USERNAME="username";
    final String PREF_PASSWORD="password";
    final String PREF_EMAIL="email";



   // SaveSharedPreference saveSharedPreference=new SaveSharedPreference();
    Intent intent1,intent2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        login_now=(TextView)findViewById(R.id.login_now);
        reg_Name=(EditText)findViewById(R.id.reg_Name);
        reg_username=(EditText)findViewById(R.id.reg_userName);
        reg_password=(EditText)findViewById(R.id.reg_password);
        reg_email=(EditText)findViewById(R.id.reg_emails);
       reg_password_repeat=(EditText)findViewById(R.id.reg_passwordRepeat);
        reg_signUp=(Button)findViewById(R.id.reg_signUp);


        login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrationCheck();

            }
        });

        reg_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             registrationCheck();

            }
        });
    }
    //Check all blanks are filled
    public void registrationCheck(){
        if(reg_Name.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Fill in your name",Toast.LENGTH_SHORT).show();
        }
        else if(reg_username.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Fill in your username",Toast.LENGTH_SHORT).show();
        }
        else if(reg_email.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Fill in your email",Toast.LENGTH_SHORT).show();
        }
        else if(reg_password.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Fill in your password",Toast.LENGTH_SHORT).show();
        }
        else if(reg_password_repeat.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Retype your password",Toast.LENGTH_SHORT).show();
        }
        else if(!(reg_password.getText().toString().equals(reg_password_repeat.getText().toString()))){
            Toast.makeText(getApplicationContext(),"Check your password",Toast.LENGTH_SHORT).show();
        }
        else{
            sharedPreferences=getSharedPreferences(FileName,mode);
           editor=sharedPreferences.edit();
           editor.putString(PREF_USERNAME,reg_username.getText().toString());
           editor.putString(PREF_PASSWORD,reg_password.getText().toString());
           editor.putString(PREF_EMAIL,reg_email.getText().toString());
           editor.apply();

            intent1=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent1);
        }
    }
}

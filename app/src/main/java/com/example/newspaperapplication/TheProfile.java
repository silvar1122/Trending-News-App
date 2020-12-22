package com.example.newspaperapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TheProfile extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ProfileModal> profileModals;
    ProfileAdapter profileAdapter;
    TextView username,email;
    Button logout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String FileName="MyPrefs";
    int mode=0;
    final String PREF_USERNAME="username";
    final String PREF_PASSWORD="password";
    final String PREF_EMAIL="email";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_profile);
        sharedPreferences=getSharedPreferences(FileName,mode);

        username=(TextView)findViewById(R.id.username);
        email=(TextView)findViewById(R.id.email);

        username.setText(sharedPreferences.getString(PREF_USERNAME,"username"));
        email.setText(sharedPreferences.getString(PREF_EMAIL,"....@gmail.com"));

        logout=(Button)findViewById(R.id.login);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //Will remove session and open login screen
                SessionManagement sessionManagement=new SessionManagement(TheProfile.this);
                sessionManagement.removeSession();
                moveToLoginScreen();

            }
        });

        recyclerView=findViewById(R.id.recyclerView);
        PopulateData();
        init();
    }

    public void init(){
        profileAdapter=new ProfileAdapter(profileModals,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(profileAdapter);

    }
    public void PopulateData(){
        profileModals=new ArrayList<>();
        profileModals.add(new ProfileModal(R.drawable.ic_lock,"Privacy Policy","App Terms and Policies"));
        profileModals.add(new ProfileModal(R.drawable.ic_rate,"Rate Us","Give your rate and feedback"));
        profileModals.add(new ProfileModal(R.drawable.ic_moreapps,"More Apps","More apps from developer"));
        profileModals.add(new ProfileModal(R.drawable.ic_about,"About","App info, Build version, Copyright"));
    }
    public void moveToLoginScreen(){
        Intent intent=new Intent(TheProfile.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

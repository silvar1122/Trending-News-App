package com.example.newspaperapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveSharedPreference {
     final String PREF_USERNAME="username";
     final String PREF_PASSWORD="password";
     String Data ="b";
     String FileName="MyPrefs";
    int mode=0;
     Context context;
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;



    public SaveSharedPreference(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences(FileName,mode);
        editor=sharedPreferences.edit();
       // editor.apply();
    }



   /* public  void SaveUserName(Context context,String username){

        editor.putString(PREF_USERNAME,username);
        editor.apply();
    }
    public void SavePassword(Context context,String password){

        editor.putString(PREF_PASSWORD,password);
        editor.apply();
    }
    public  String getUserName(Context context){
        return sharedPreferences.getString(PREF_USERNAME,"");
    }
    public  String getPassword(Context context){
        return sharedPreferences.getString(PREF_PASSWORD,"");
    }*/

    //for second time user
   /* public void secondTime(){
        editor.putBoolean(Data,true);
        editor.apply();
    }

    //for first time
    public void firstTime(){
        if(!this.login()){
            Intent intent=new Intent(context,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }

    private boolean login() {
        return sharedPreferences.getBoolean(Data,false);
    }*/

}

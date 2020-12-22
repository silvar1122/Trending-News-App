package com.example.newspaperapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_FILE="MyPrefs";
    int mode=0;
    final String PREF_USERNAME="username";
    final String PREF_PASSWORD="password";
    final  String  PREF_KEY="id";

    public SessionManagement(Context context){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_FILE,mode);
        editor=sharedPreferences.edit();
    }

    public void SaveSession(User user){
        //save session of user
        int id=user.getId();
        editor.putInt(PREF_KEY,id).apply();

    }
    public int getSession(){
        return sharedPreferences.getInt(PREF_KEY,-1);
    }
    public void removeSession(){
        editor.putInt(PREF_KEY,-1).apply();
    }
}

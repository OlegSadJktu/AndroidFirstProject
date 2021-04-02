package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.function.Predicate;

public class DataService {

    public static String getRemebmeredMessage(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("MESSAGE", "null");

    }

    public static void rememberMessage(Context context, String message){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("MESSAGE", message);
        editor.apply();

    }

}

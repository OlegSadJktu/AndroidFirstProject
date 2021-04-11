package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkCategoryActivity extends AppCompatActivity {

    public static final String TAG = "DrinkCategoryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                Drink.drinks);

        ListView listView = (ListView) findViewById(R.id.forListAdapter);
        listView.setAdapter(listAdapter);


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINK_ID, (int) id);
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemClickListener);


    }

    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.edit_sending_text);

        String sendingText = editText.getText().toString();
        Log.d(TAG, sendingText);

        Pattern pattern = Pattern.compile("олег/s*ир[ау]", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(sendingText);

        while (matcher.find()) {

            Log.d(TAG, sendingText.substring(matcher.start(), matcher.end()));
            Log.d(TAG, matcher.start() + " " + matcher.end());
        }


//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, "ОЛЕГ Я ЛЮБЛЮ ТЕБЯ!!!1!!!1!!1!!");
//        startActivity(intent);

    }

}

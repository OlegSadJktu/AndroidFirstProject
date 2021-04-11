package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.IBinder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);
                Intent intent;
                if (position == 0) {
                    intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    intent = new Intent(TopLevelActivity.this, CryptographyActivity.class);
                    startActivity(intent);
                }


            }
        };
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);

        TextView textView = findViewById(R.id.data_string);

        String savedMessage = DataService.getRemebmeredMessage(this);
        if (!savedMessage.equals("null")) {
            textView.setText(savedMessage);
        }


    }

    public void saveMessage(View view){
        EditText entry = findViewById(R.id.data_entry);
        DataService.rememberMessage( this, entry.getText().toString());


    }

}

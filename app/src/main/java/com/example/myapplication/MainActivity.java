package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication.BeerExpert;
import com.example.myapplication.MessageActivity;
import com.example.myapplication.R;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private boolean running;
    private boolean wasRunning;
    private int seconds = 0;

    private BeerExpert beerExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        "".isEmpty();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            running = savedInstanceState.getBoolean("running");
            seconds = savedInstanceState.getInt("seconds");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
//        runTimer();
    }

    public void someMethod(View view){
        Intent intent = new Intent(this, MessageActivity.class);
        //"message", editText.getText()
        intent.putExtra(MessageActivity.EXTRA_MESSAGE, "sadasd");
        startActivity(intent);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);

    }



//    public void switchChange(View view){
//        Switch mySwitch = findViewById(R.id.mySwitch);
//        ImageView imageView = findViewById(R.id.myImage);
//        boolean switchValue = mySwitch.isChecked();
//        if (switchValue) {
//            System.out.println("switch on");
//            imageView.setImageResource(R.drawable.screenshot);
//        }
//        else {
//            System.out.println("switch off");
//            imageView.setImageResource(R.drawable.duck);
//
//
//        }
//    }


    private void runTimer () {
        final TextView textView = findViewById(R.id.time);
        textView.setText("asda");
        running = true;
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String text = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, secs);
                textView.setText(text);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 3);
            }
        });
    }

    @Override
    protected void onPause() {
        System.out.println("Activity paused");
        super.onPause();
        wasRunning = running;
        running = false;

    }

    @Override
    protected void onRestart() {
        System.out.println("Activity restarting");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        System.out.println("Activity resume");

        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    protected void onStart() {
        System.out.println("Activity starting");
        super.onStart();
    }

    @Override
    protected void onStop() {
        System.out.println("Activity stopping");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("Activity destroyed");
        super.onDestroy();
    }

    public void startTimer(View view){
        running = true;

    }

    public void stopTimer(View view){
        running = false;

    }

    public void resetTimer(View view){
        running = false;
        seconds = 0;
    }
}

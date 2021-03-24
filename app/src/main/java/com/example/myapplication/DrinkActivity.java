package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK_ID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkId = (Integer) getIntent().getExtras().get(EXTRA_DRINK_ID);

        Drink drink = Drink.drinks[drinkId];

        ImageView image = findViewById(R.id.coffeeImage);
        TextView name = findViewById(R.id.name);
        TextView description = findViewById(R.id.description);

        image.setImageResource(drink.getImageResourceId());
        name.setText(drink.getName());
        description.setText(drink.getDescription());


    }
}

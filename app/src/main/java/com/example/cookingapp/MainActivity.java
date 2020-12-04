package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ingredientButton = (Button) findViewById(R.id.ingredient_button);

        ingredientButton.setOnClickListener(new View.onClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.setContentView(R.layout.activity_ingredients__screen);
            }

        });

    }

}
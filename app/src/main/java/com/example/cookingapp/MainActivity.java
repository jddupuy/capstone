//Mainscreen Activity
//Hosts two Buttons, Ingredients and Recipes
//Juan Dupuy

package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureIngredientButton();
    }

    private void configureIngredientButton(){
        Button nextButton = (Button) findViewById(R.id.ingredient_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, Ingredients_Screen.class));
            }

        });
    }

}
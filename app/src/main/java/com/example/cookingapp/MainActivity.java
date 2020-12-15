//Mainscreen Activity
//Hosts two Buttons, Ingredients and Recipes
//Juan Dupuy

package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Node> Ingredients_List = new ArrayList<Node>();
    int launchIngredientScreen = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureIngredientButton();
        configureRecipeButton();
    }

    private void configureIngredientButton(){
        Button nextButton = (Button) findViewById(R.id.ingredient_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, Ingredients_Screen.class);
                i.putExtra("Ingredients_List", Ingredients_List);
                //setResult(RESULT_OK,i);
                startActivityForResult(i,1);
                //startActivityForResult(i, launchIngredientScreen);
                //Ingredients_List = i.getExtras("Ingredients_List")
                System.out.println("WE ARE NOW BACK");
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        System.out.println("Do we reach here without errors?");
        if(requestCode == launchIngredientScreen){
            if(resultCode == Activity.RESULT_OK){
                Ingredients_List = (ArrayList<Node>) data.getSerializableExtra("Updated_List");
                for(Node node:Ingredients_List){
                    System.out.println(node.ingredient + " : " + node.available);
                }
            }
        }

        System.out.println("This is from the main java file");

    }

    private void configureRecipeButton(){
        Button nextButton = (Button) findViewById(R.id.recipe_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Intent i = new Intent(MainActivity.this, Recipe_Screen.class);
                i.putExtra("Ingredients_List", Ingredients_List);
                startActivity(i);
            }

        });
    }

}
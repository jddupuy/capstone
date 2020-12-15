package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe_Screen extends AppCompatActivity {

    ArrayList<Node> ingredients = new ArrayList<Node>();
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    LinearLayout layout;
    LayoutInflater layoutInflater;
    ArrayList<Integer> possibleRecipes = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe__screen);


        Intent intent = getIntent();
        ingredients = (ArrayList<Node>) getIntent().getSerializableExtra("Ingredients_List");

        makeRecipes();
        checkRecipes();

        //setting up screen
        layout = (LinearLayout) findViewById(R.id.recipeLayout);
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);



        //possibleRecipes.add(R.string.Brownies);
        //possibleRecipes.add(R.string.ItalianMeatlballPasta);
        //adding recipe
        for(Integer recipe:possibleRecipes){
            View myView = layoutInflater.inflate(R.layout.rlayout,null,false); //android:text="@string/Brownies"
            layout.addView(myView);
            TextView textView = (TextView) myView.findViewById(R.id.textView);
            textView.setText(recipe);
        }


        //setting text


        //looping
        /*
        View myView2 = layoutInflater.inflate(R.layout.rlayout,null,false); //android:text="@string/Brownies"
        layout.addView(myView2);

        //setting text
        TextView textView2 = (TextView) findViewById(R.id.textView);
        textView2.setText(R.string.Brownies);*/

        //test

        configureBackButton();
    }

    private void createCardView(){

    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.backButtonRecipe);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    private void makeRecipes(){
        //File file = new File("assets/Recipes.txt");
        try{
            Scanner scan = new Scanner(getAssets().open("Recipes.txt"));

            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] full = line.split(",");
                String recipeName = full[0];
                ArrayList<String> ingredients = new ArrayList<String>();
                for(String a:full){
                    ingredients.add(a);
                }
                ingredients.remove(0);
                recipes.add(new Recipe(recipeName,ingredients));
                recipes.get(recipes.size()-1).toString();
                //System.out.println("next line");
            }

        }catch(IOException e){
            System.out.println("FILE FAILED LOADING");
        }

    }

    private void checkRecipes(){
        for(Recipe recipe:recipes){
            for(Node node:recipe.neededIngredients){
                for(Node ing:ingredients){
                    if(node.ingredient.equals(ing.ingredient)){
                        node.available = ing.available;
                    }
                }
            }

        }

        //prints possible recipes
        for(Recipe recipe:recipes){
            boolean possible = true;
            for(Node node:recipe.neededIngredients){
                if(node.available == false){
                    possible = false;
                }
            }

            if(possible){
                System.out.println(recipe.recipeName + " IS POSSIBLE!!");

                //add possible recipe to possible recipe array

                for(Field field : R.string.class.getDeclaredFields()){
                    if(Modifier.isStatic(field.getModifiers()) && !Modifier.isPrivate(field.getModifiers()) && field.getType().equals(int.class)){
                        try{
                            if(field.getName().equals(recipe.recipeName)) {
                                possibleRecipes.add(field.getInt(null));
                            }
                        }catch(IllegalArgumentException e){
                            System.out.println("FAILED AT THIS POINT HERE");
                        }catch(IllegalAccessException e){
                        System.out.println("FAILED AT THIS POINT HERE2");
                        }
                    }
                }
                //end of crazieness

            }else{
                System.out.println(recipe.recipeName + "NOT POSSIBLE");
            }
        }
    }

    private void addRecipe(){

    }
}

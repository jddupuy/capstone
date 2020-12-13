//Ingredients Screen
//Allows users to enter ingredients that they have
//Juan Dupuy

package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.*;

public class Ingredients_Screen extends AppCompatActivity {
    ArrayList<Node> Ingredients_List = new ArrayList<Node>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Ingredients_List = (ArrayList<Node>) getIntent().getSerializableExtra("Ingredients_List");

        //Resetting checkboxes values

        setContentView(R.layout.activity_ingredients__screen);
        configureBackButton(Ingredients_List);

    }

    private void configureBackButton(ArrayList<Node> Ingredients_List){
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View view){
                //we first need to save all the ingredients before leaving this page.
                Intent returnIntent = new Intent();
                TableLayout table = (TableLayout)findViewById(R.id.table);
                //loops through all rows in table
                for(int i = 0; i < table.getChildCount(); i++){
                    TableRow row = (TableRow) table.getChildAt(i);
                    //loops through all elements in row
                    for(int k = 0; k < row.getChildCount(); k++){
                        View current = row.getChildAt(k);
                        //if element is checkbox, pulls out value and name, assigns to array
                        if(current instanceof CheckBox){
                            CheckBox x = (CheckBox) current;
                            //System.out.println("The current box is: " + x.getText() + " and the value is: " + x.isChecked());
                            String name = (String) x.getText();
                            Ingredients_List.add(new Node(name,x.isChecked()));
                        }
                    }
                }
                System.out.println("Success");
                returnIntent.putExtra("Updated_List", Ingredients_List);
                setResult(Activity.RESULT_OK, returnIntent);
                /*for(Node node:Ingredients_List){
                    System.out.println(node.ingredient + " : " + node.available);
                }*/
                //this finish call will end the intent, and go back to the main screen
                finish();
           }
        });
    }

    private void checkBox(){
        //current.setChecked(true);
    }
}

/*
    ArrayList Nodes

    class Node
    String value;
    boolean available;

    Milk - available = true; string = "Milk";
    String = "Flour" , available = false;


    Recipe
    ArrayList String = "Milk", "Eggs", "Flour".

    cake.canDO();
    returns = false , cannot make.


 */
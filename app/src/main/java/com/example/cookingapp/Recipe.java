package com.example.cookingapp;

import java.util.ArrayList;

public class Recipe {

    String recipeName;
    ArrayList<Node> neededIngredients = new ArrayList<Node>();
    boolean available;

    Recipe(String name, ArrayList<String> x){

        recipeName = name;

        //takes all needed ingredients from array and assigns them to false in a node array.
        for(int i = 0; i<x.size(); i++){
            neededIngredients.add(new Node(x.get(i), false));
        }

        //checks to see if recipe has all necessary ingredients
        available = true;
        for(Node node:neededIngredients){
            if(node.available == false) {
                available = false;
                break;
            }
        }

    }

    public String toString(){

        System.out.println("Recipe is : " + recipeName);
        System.out.println("Ingredients are: ");
        for(Node node:neededIngredients){
            System.out.println(node.ingredient);
        }

        return("");
    }


    /*
    Cake
    Node1: EGG, FALSE
    Node2: MILK, FALSE
    Node3: FLOUR, FALSE
     */

    //RECIPE.JAVA
    /*
    compare Ingredient List Array with Recipe Array
    return all TRUE RECIPES
     */

}

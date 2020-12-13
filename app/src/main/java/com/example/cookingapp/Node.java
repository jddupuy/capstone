package com.example.cookingapp;

import java.io.Serializable;
import java.util.*;

public class Node implements Serializable {

     String ingredient;
     boolean available;

    public Node(String ing, boolean val){
        ingredient = ing;
        available = val;
    }



}

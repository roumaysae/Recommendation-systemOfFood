package com.example.javafx_foodrecommandation.dao;

import java.util.ArrayList;

public class Categorie {
    private String Nom;
    private String id;
    private ArrayList<Meal> Meals;

    public Categorie(String nom, String id, ArrayList<Meal> Meals) {
        this.Nom = nom;
        this.id = id;
        this.Meals = Meals;
    }

    public String getNom() {
        return Nom;
    }
    public String getId() {
        return id;
    }
    public ArrayList<Meal> getMeals() {return Meals;}
}



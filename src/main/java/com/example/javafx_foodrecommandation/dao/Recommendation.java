package com.example.javafx_foodrecommandation.dao;

import java.util.ArrayList;

public class Recommendation {
    private String Title;
    private String Ingredients;
    private String Instructions;
    private String TimeOfPreparation;
    private ArrayList<Preferences> Preferences;

    public Recommendation(String title, String ingredients, String instructions, String timeOfPreparation, ArrayList<com.example.javafx_foodrecommandation.dao.Preferences> preferences) {
        Title = title;
        Ingredients = ingredients;
        Instructions = instructions;
        TimeOfPreparation = timeOfPreparation;
        Preferences = preferences;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public String getTimeOfPreparation() {
        return TimeOfPreparation;
    }

    public void setTimeOfPreparation(String timeOfPreparation) {
        TimeOfPreparation = timeOfPreparation;
    }

    public ArrayList<com.example.javafx_foodrecommandation.dao.Preferences> getPreferences() {
        return Preferences;
    }

    public void setPreferences(ArrayList<com.example.javafx_foodrecommandation.dao.Preferences> preferences) {
        Preferences = preferences;
    }
}
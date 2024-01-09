package com.example.javafx_foodrecommandation.dao;

public class Recommendation {
    private String Title ;
    private String Ingredients ;
    private String Instructions ;
    private String TimeOfPreparation ;

    public Recommendation(String title, String ingredients, String instructions, String timeOfPreparation) {
        Title = title;
        Ingredients = ingredients;
        Instructions = instructions;
        TimeOfPreparation = timeOfPreparation;
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
}

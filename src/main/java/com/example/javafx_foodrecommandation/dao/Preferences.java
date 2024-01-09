package com.example.javafx_foodrecommandation.dao;

public class Preferences {
    private CuisinePreferences CuisinePreferences ;
    private FlavorsAndIngredients FlavorsAndIngredients ;
    private DietaryPreferences DietaryPreferences ;
    private MealType MealType ;
    private TimeOfPreparation TimeOfPreparation;
    private IngredientAvailability IngredientAvailability ;
    private MealTiming MealTiming ;
    private Allergies Allergies;

    public Preferences(com.example.javafx_foodrecommandation.dao.CuisinePreferences cuisinePreferences, com.example.javafx_foodrecommandation.dao.FlavorsAndIngredients flavorsAndIngredients, com.example.javafx_foodrecommandation.dao.DietaryPreferences dietaryPreferences, com.example.javafx_foodrecommandation.dao.MealType mealType, TimeOfPreparation timeOfPreparation, com.example.javafx_foodrecommandation.dao.IngredientAvailability ingredientAvailability, com.example.javafx_foodrecommandation.dao.MealTiming mealTiming, com.example.javafx_foodrecommandation.dao.Allergies allergies) {
        CuisinePreferences = cuisinePreferences;
        FlavorsAndIngredients = flavorsAndIngredients;
        DietaryPreferences = dietaryPreferences;
        MealType = mealType;
        TimeOfPreparation = timeOfPreparation;
        IngredientAvailability = ingredientAvailability;
        MealTiming = mealTiming;
        Allergies = allergies;
    }

    public com.example.javafx_foodrecommandation.dao.CuisinePreferences getCuisinePreferences() {
        return CuisinePreferences;
    }

    public void setCuisinePreferences(com.example.javafx_foodrecommandation.dao.CuisinePreferences cuisinePreferences) {
        CuisinePreferences = cuisinePreferences;
    }

    public com.example.javafx_foodrecommandation.dao.FlavorsAndIngredients getFlavorsAndIngredients() {
        return FlavorsAndIngredients;
    }

    public void setFlavorsAndIngredients(com.example.javafx_foodrecommandation.dao.FlavorsAndIngredients flavorsAndIngredients) {
        FlavorsAndIngredients = flavorsAndIngredients;
    }

    public com.example.javafx_foodrecommandation.dao.DietaryPreferences getDietaryPreferences() {
        return DietaryPreferences;
    }

    public void setDietaryPreferences(com.example.javafx_foodrecommandation.dao.DietaryPreferences dietaryPreferences) {
        DietaryPreferences = dietaryPreferences;
    }

    public com.example.javafx_foodrecommandation.dao.MealType getMealType() {
        return MealType;
    }

    public void setMealType(com.example.javafx_foodrecommandation.dao.MealType mealType) {
        MealType = mealType;
    }

    public com.example.javafx_foodrecommandation.dao.TimeOfPreparation getTimeOfPreparation() {
        return TimeOfPreparation;
    }

    public void setTimeOfPreparation(com.example.javafx_foodrecommandation.dao.TimeOfPreparation timeOfPreparation) {
        TimeOfPreparation = timeOfPreparation;
    }

    public com.example.javafx_foodrecommandation.dao.IngredientAvailability getIngredientAvailability() {
        return IngredientAvailability;
    }

    public void setIngredientAvailability(com.example.javafx_foodrecommandation.dao.IngredientAvailability ingredientAvailability) {
        IngredientAvailability = ingredientAvailability;
    }

    public com.example.javafx_foodrecommandation.dao.MealTiming getMealTiming() {
        return MealTiming;
    }

    public void setMealTiming(com.example.javafx_foodrecommandation.dao.MealTiming mealTiming) {
        MealTiming = mealTiming;
    }

    public com.example.javafx_foodrecommandation.dao.Allergies getAllergies() {
        return Allergies;
    }

    public void setAllergies(com.example.javafx_foodrecommandation.dao.Allergies allergies) {
        Allergies = allergies;
    }
}



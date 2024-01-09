package com.example.javafx_foodrecommandation.dao;

public class Preferences {
    private CuisinePreferences CuisinePreferences ;
    private FlavorsAndIngredients FlavorsAndIngredients ;
    private DietaryPreferences DietaryPreferences ;
    private MealType MealType ;
    private  TimeForPreparation TimeForPreparation ;
    private IngredientAvailability IngredientAvailability ;
    private MealTiming MealTiming ;

    public Preferences(com.example.javafx_foodrecommandation.dao.CuisinePreferences cuisinePreferences, com.example.javafx_foodrecommandation.dao.FlavorsAndIngredients flavorsAndIngredients, com.example.javafx_foodrecommandation.dao.DietaryPreferences dietaryPreferences, com.example.javafx_foodrecommandation.dao.MealType mealType, com.example.javafx_foodrecommandation.dao.TimeForPreparation timeForPreparation, com.example.javafx_foodrecommandation.dao.IngredientAvailability ingredientAvailability, com.example.javafx_foodrecommandation.dao.MealTiming mealTiming) {
        CuisinePreferences = cuisinePreferences;
        FlavorsAndIngredients = flavorsAndIngredients;
        DietaryPreferences = dietaryPreferences;
        MealType = mealType;
        TimeForPreparation = timeForPreparation;
        IngredientAvailability = ingredientAvailability;
        MealTiming = mealTiming;
    }

    public com.example.javafx_foodrecommandation.dao.CuisinePreferences getCuisinePreferences() {
        return CuisinePreferences;
    }

    public com.example.javafx_foodrecommandation.dao.FlavorsAndIngredients getFlavorsAndIngredients() {
        return FlavorsAndIngredients;
    }

    public com.example.javafx_foodrecommandation.dao.DietaryPreferences getDietaryPreferences() {
        return DietaryPreferences;
    }

    public com.example.javafx_foodrecommandation.dao.MealType getMealType() {
        return MealType;
    }

    public com.example.javafx_foodrecommandation.dao.TimeForPreparation getTimeForPreparation() {
        return TimeForPreparation;
    }

    public com.example.javafx_foodrecommandation.dao.IngredientAvailability getIngredientAvailability() {
        return IngredientAvailability;
    }

    public com.example.javafx_foodrecommandation.dao.MealTiming getMealTiming() {
        return MealTiming;
    }

    public void setCuisinePreferences(com.example.javafx_foodrecommandation.dao.CuisinePreferences cuisinePreferences) {
        CuisinePreferences = cuisinePreferences;
    }

    public void setFlavorsAndIngredients(com.example.javafx_foodrecommandation.dao.FlavorsAndIngredients flavorsAndIngredients) {
        FlavorsAndIngredients = flavorsAndIngredients;
    }

    public void setDietaryPreferences(com.example.javafx_foodrecommandation.dao.DietaryPreferences dietaryPreferences) {
        DietaryPreferences = dietaryPreferences;
    }

    public void setMealType(com.example.javafx_foodrecommandation.dao.MealType mealType) {
        MealType = mealType;
    }

    public void setTimeForPreparation(com.example.javafx_foodrecommandation.dao.TimeForPreparation timeForPreparation) {
        TimeForPreparation = timeForPreparation;
    }

    public void setIngredientAvailability(com.example.javafx_foodrecommandation.dao.IngredientAvailability ingredientAvailability) {
        IngredientAvailability = ingredientAvailability;
    }

    public void setMealTiming(com.example.javafx_foodrecommandation.dao.MealTiming mealTiming) {
        MealTiming = mealTiming;
    }


}



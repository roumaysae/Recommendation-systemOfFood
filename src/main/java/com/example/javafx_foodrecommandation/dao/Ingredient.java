package com.example.javafx_foodrecommandation.dao;

public class Ingredient {
    private String title;
    private double measure;
    private String imageMeal;

    public Ingredient(String title, double measure, String imageMeal) {
        this.title = title;
        this.measure = measure;
        this.imageMeal = imageMeal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMeasure() {
        return measure;
    }

    public void setMeasure(double measure) {
        this.measure = measure;
    }

    public String getImageMeal() {
        return imageMeal;
    }

    public void setImageMeal(String imageMeal) {
        this.imageMeal = imageMeal;
    }
}

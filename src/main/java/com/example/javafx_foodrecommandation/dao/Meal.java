package com.example.javafx_foodrecommandation.dao;

public class Meal {
        private String title;
        private String instructions;
        private String country;
        private String imageMeal;

    public Meal() {
    }

    public Meal(String title, String instructions, String country, String imageMeal) {
        this.title = title;
        this.instructions = instructions;
        this.country = country;
        this.imageMeal = imageMeal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageMeal() {
        return imageMeal;
    }

    public void setImageMeal(String imageMeal) {
        this.imageMeal = imageMeal;
    }
}

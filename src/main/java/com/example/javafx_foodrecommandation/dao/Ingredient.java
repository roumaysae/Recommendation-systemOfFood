package com.example.javafx_foodrecommandation.dao;

public class Ingredient {
    private String name ;
    private String mesure ;

    public String setName(String ingredient1Name) {
        return name;
    }

    public String setMeasure(String ingredient1Mesure) {
        return mesure;
    }

    public char[] getName() {
        return name.toCharArray();
    }

    public char[] getMeasure() {
        return mesure.toCharArray();
    }
}

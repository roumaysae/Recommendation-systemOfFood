package com.example.javafx_foodrecommandation.dao;

public class Categorie {
    private String Nom;
    private String description;
    private String imageCategorie;

    public Categorie(String nom, String description, String imageCategorie) {
        Nom = nom;
        this.description = description;
        this.imageCategorie = imageCategorie;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageCategorie() {
        return imageCategorie;
    }

    public void setImageCategorie(String imageCategorie) {
        this.imageCategorie = imageCategorie;
    }
}

package com.example.javafx_foodrecommandation.dao;

public class Categorie {
    private String Nom;
    private String id;

    public Categorie(String nom, String description, String imageCategorie) {
        this.Nom = nom;
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getId() {
        return id;
    }
}



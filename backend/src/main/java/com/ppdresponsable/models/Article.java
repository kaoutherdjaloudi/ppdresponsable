package com.ppdresponsable.models;

public class Article {
    private String nom;
    private double prix;
    private String image;

    public Article() {}

    public Article(String nom, double prix, String image) {
        this.nom = nom;
        this.prix = prix;
        this.image = image;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}

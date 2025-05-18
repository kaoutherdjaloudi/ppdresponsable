package com.ppdresponsable.models;

public class FactureDetails {

    private int id;
    private String designation;
    private int quantite;
    private double prixUnitaire;

    // ✅ Constructeur nécessaire pour corriger l'erreur
    public FactureDetails(int id, String designation, int quantite, double prixUnitaire) {
        this.id = id;
        this.designation = designation;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    // ✅ Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}

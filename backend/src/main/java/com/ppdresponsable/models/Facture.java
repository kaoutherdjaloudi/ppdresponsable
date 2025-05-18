package com.ppdresponsable.models;

import java.util.Date;
import java.util.List;

public class Facture {
    private String numeroFacture;
    private Date date;
    private String adresseLivraison;
    private double prixTotal;
    private String statut;
    private int idClient;
    private List<Article> articles;

    public Facture() {}

    public Facture(String numeroFacture, Date date, String adresseLivraison,
                   double prixTotal, String statut, int idClient, List<Article> articles) {
        this.numeroFacture = numeroFacture;
        this.date = date;
        this.adresseLivraison = adresseLivraison;
        this.prixTotal = prixTotal;
        this.statut = statut;
        this.idClient = idClient;
        this.articles = articles;
    }

    public String getNumeroFacture() { return numeroFacture; }
    public void setNumeroFacture(String numeroFacture) { this.numeroFacture = numeroFacture; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }

    public double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public int getIdClient() { return idClient; }
    public void setIdClient(int idClient) { this.idClient = idClient; }

    public List<Article> getArticles() { return articles; }
    public void setArticles(List<Article> articles) { this.articles = articles; }
}

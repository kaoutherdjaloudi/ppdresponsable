package com.ppdresponsable.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ppdresponsable.models.FactureDetails;

public class FactureService {

    private static final String URL = "jdbc:mysql://localhost:3306/ppdtech";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public List<FactureDetails> getFacturesDetails() {
        List<FactureDetails> list = new ArrayList<>();
        String query = "SELECT f.numeroFacture, p.reference, lf.quantite, lf.prixUnitaire " +
                       "FROM Facture f " +
                       "JOIN LigneFacture lf ON f.numeroFacture = lf.id_facture " +
                       "JOIN Produit p ON lf.id_produit = p.id_produit";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FactureDetails detail = new FactureDetails(
                    rs.getInt("numeroFacture"),
                    rs.getString("reference"),
                    rs.getInt("quantite"),
                    rs.getDouble("prixUnitaire")
                );
                list.add(detail);
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage()); // Meilleur message d'erreur
        }

        return list;
    }
}
package com.recette.dao;

import com.recette.model.Recette;
import com.recette.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO pour gérer les opérations sur les recettes
 */
public class RecetteDAO {
    
    /**
     * Rechercher les recettes contenant un ingrédient donné
     * @param nomIngredient Le nom de l'ingrédient recherché
     * @return Liste des recettes contenant cet ingrédient
     */
    public List<Recette> chercherRecettesParIngredient(String nomIngredient) {
        List<Recette> recettes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        // Requête SQL avec jointure
        String sql = "SELECT DISTINCT r.id_recette, r.nom_recette, r.description " +
                     "FROM recette r " +
                     "INNER JOIN recette_ingredient ri ON r.id_recette = ri.id_recette " +
                     "INNER JOIN ingredient i ON ri.id_ingredient = i.id_ingredient " +
                     "WHERE i.nom_ingredient LIKE ?";
        
        try {
            // Obtenir la connexion
            connection = DatabaseConnection.getConnection();
            
            if (connection != null) {
                // Préparer la requête
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + nomIngredient + "%");
                
                // Exécuter la requête
                resultSet = statement.executeQuery();
                
                // Parcourir les résultats
                while (resultSet.next()) {
                    Recette recette = new Recette();
                    recette.setIdRecette(resultSet.getInt("id_recette"));
                    recette.setNomRecette(resultSet.getString("nom_recette"));
                    recette.setDescription(resultSet.getString("description"));
                    
                    recettes.add(recette);
                }
                
                System.out.println("Nombre de recettes trouvées : " + recettes.size());
            }
            
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) DatabaseConnection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return recettes;
    }
    
    /**
     * Obtenir toutes les recettes (pour test)
     * @return Liste de toutes les recettes
     */
    public List<Recette> getAllRecettes() {
        List<Recette> recettes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT id_recette, nom_recette, description FROM recette";
        
        try {
            connection = DatabaseConnection.getConnection();
            
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                
                while (resultSet.next()) {
                    Recette recette = new Recette();
                    recette.setIdRecette(resultSet.getInt("id_recette"));
                    recette.setNomRecette(resultSet.getString("nom_recette"));
                    recette.setDescription(resultSet.getString("description"));
                    
                    recettes.add(recette);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) DatabaseConnection.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return recettes;
    }
}
package com.recette.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilitaire pour la connexion à la base de données
 */
public class DatabaseConnection {
    
    // Paramètres de connexion configurables via variables d'environnement
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = envOrDefault("DB_USER", "root");
    private static final String PASSWORD = envOrDefault("DB_PASSWORD", "Sankou7frr?");
    private static final String URL = resolveJdbcUrl();
    
    /**
     * Obtenir une connexion à la base de données
     * @return Connection ou null si erreur
     */
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            // Charger le driver MySQL
            Class.forName(DRIVER);
            
            // Établir la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Connexion à la base de données réussie sur " + URL);
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL introuvable : " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
        }
        
        return connection;
    }
    
    /**
     * Fermer une connexion
     * @param connection La connexion à fermer
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture : " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static String resolveJdbcUrl() {
        String envUrl = System.getenv("DB_URL");
        if (envUrl != null && !envUrl.isBlank()) {
            return envUrl;
        }

        String host = envOrDefault("DB_HOST", "localhost");
        String port = envOrDefault("DB_PORT", "3306");
        String database = envOrDefault("DB_NAME", "recette");
        String params = envOrDefault("DB_JDBC_PARAMS", "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        return String.format("jdbc:mysql://%s:%s/%s?%s", host, port, database, params);
    }

    private static String envOrDefault(String key, String fallback) {
        String value = System.getenv(key);
        return (value == null || value.isBlank()) ? fallback : value;
    }
}

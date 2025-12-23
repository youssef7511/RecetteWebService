package com.recette.ws;

import com.recette.dao.RecetteDAO;
import com.recette.model.Recette;
import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 * Web Service pour rechercher des recettes par ingrédient
 */
@WebService(serviceName = "RecetteWebService")
public class RecetteWebService {
    
    // Instance du DAO
    private RecetteDAO recetteDAO;
    
    // Constructeur
    public RecetteWebService() {
        this.recetteDAO = new RecetteDAO();
    }
    
    /**
     * Opération Web Service : Chercher des recettes par ingrédient
     * @param ingredient Le nom de l'ingrédient recherché
     * @return Liste des recettes contenant cet ingrédient
     */
    @WebMethod(operationName = "chercherRecettesParIngredient")
    public List<Recette> chercherRecettesParIngredient(
            @WebParam(name = "ingredient") String ingredient) {
        
        System.out.println("Recherche de recettes pour l'ingrédient : " + ingredient);
        
        // Vérifier que l'ingrédient n'est pas vide
        if (ingredient == null || ingredient.trim().isEmpty()) {
            System.out.println("Ingrédient vide ou null");
            return new ArrayList<>();
        }
        
        // Appeler le DAO pour rechercher
        List<Recette> recettes = recetteDAO.chercherRecettesParIngredient(ingredient);
        
        System.out.println("Nombre de recettes trouvées : " + recettes.size());
        
        return recettes;
    }
    
    /**
     * Opération de test : Obtenir toutes les recettes
     * @return Liste de toutes les recettes
     */
    @WebMethod(operationName = "getAllRecettes")
    public List<Recette> getAllRecettes() {
        System.out.println("Récupération de toutes les recettes");
        return recetteDAO.getAllRecettes();
    }
    
    /**
     * Opération de test : Simple Hello World
     * @param name Nom de la personne
     * @return Message de salutation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String name) {
        return "Bonjour " + name + " ! Web Service fonctionnel.";
    }
}
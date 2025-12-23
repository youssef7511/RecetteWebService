package com.recette.client.cli;

import com.recette.client.stub.Recette;
import com.recette.client.stub.RecetteWebService;
import com.recette.client.stub.RecetteWebService_Service;
import javax.xml.ws.BindingProvider;
import java.util.List;

/**
 * Simple CLI runner that calls the Recette Web Service and prints results.
 */
public class RecetteClientCli {

    public static void main(String[] args) {
        String ingredient = (args != null && args.length > 0) ? args[0] : "tomate";
        try {
            // Ensure Metro uses a resolvable XML catalog implementation
            // Metro may attempt to load JDK-internal CatalogManager (com.sun.org.apache.xml.internal.resolver.CatalogManager).
            // Force it to use the xml-resolver implementation we've added as a dependency.
            System.setProperty("xml.catalog.className", "org.apache.xml.resolver.tools.CatalogResolver");

            RecetteWebService_Service svc = new RecetteWebService_Service();
            RecetteWebService port = svc.getRecetteWebServicePort();

            String override = System.getProperty("recette.ws.url");
            if (override == null || override.isBlank()) {
                override = System.getenv("RECETTE_WS_URL");
            }
            if (override != null && !override.isBlank()) {
                ((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, override);
                System.out.println("Using override endpoint: " + override);
            }

            System.out.println("Searching recipes for ingredient: " + ingredient);
            List<Recette> listes = port.chercherRecettesParIngredient(ingredient);
            if (listes == null || listes.isEmpty()) {
                System.out.println("No recipes found for '" + ingredient + "'.");
                return;
            }
            System.out.println("Found " + listes.size() + " recipe(s):");
            for (Recette r : listes) {
                System.out.println("- " + (r.getNomRecette() == null ? "(no name)" : r.getNomRecette()));
                System.out.println("  Description: " + (r.getDescription() == null ? "(none)" : r.getDescription()));
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Error calling service: " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(2);
        }
    }
}

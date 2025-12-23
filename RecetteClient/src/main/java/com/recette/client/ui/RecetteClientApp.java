package com.recette.client.ui;

import com.recette.client.stub.Recette;
import com.recette.client.stub.RecetteWebService;
import com.recette.client.stub.RecetteWebService_Service;
import javax.xml.ws.BindingProvider;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 * Simple Swing client that consumes the Recette SOAP Web Service.
 */
public class RecetteClientApp extends JFrame {

    private final JTextField ingredientField = new JTextField(20);
    private final JButton searchButton = new JButton("Chercher");
    private final JButton allButton = new JButton("Toutes les recettes");
    private final JTextArea resultArea = new JTextArea();
    private final JLabel statusLabel = new JLabel("Prêt");

    private final RecetteWebService port;

    public RecetteClientApp() {
        super("Recette Client");
        this.port = createPort();
        buildUi();
        bindActions();
    }

    private void buildUi() {
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Ingrédient:"));
        northPanel.add(ingredientField);
        northPanel.add(searchButton);
        northPanel.add(allButton);

        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Résultats"));

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(statusLabel, BorderLayout.CENTER);
        southPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        setLayout(new BorderLayout(10, 10));
        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
    }

    private void bindActions() {
        searchButton.addActionListener(this::handleSearch);
        allButton.addActionListener(evt -> runQuery("Chargement de toutes les recettes", port::getAllRecettes));
    }

    private void handleSearch(ActionEvent event) {
        final String ingredient = ingredientField.getText().trim();
        if (ingredient.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Merci de saisir un ingrédient.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        runQuery("Recherche en cours...", () -> port.chercherRecettesParIngredient(ingredient));
    }

    private void runQuery(String statusMessage, ServiceCall call) {
        searchButton.setEnabled(false);
        allButton.setEnabled(false);
        statusLabel.setText(statusMessage);

        new SwingWorker<List<Recette>, Void>() {
            @Override
            protected List<Recette> doInBackground() throws Exception {
                return call.execute();
            }

            @Override
            protected void done() {
                try {
                    List<Recette> recettes = get();
                    resultArea.setText(formatRecettes(recettes));
                    statusLabel.setText(String.format("%d recette(s) trouvée(s)", recettes.size()));
                } catch (Exception ex) {
                    resultArea.setText("Erreur lors de l'appel du service : " + ex.getMessage());
                    statusLabel.setText("Erreur");
                } finally {
                    searchButton.setEnabled(true);
                    allButton.setEnabled(true);
                }
            }
        }.execute();
    }

    private String formatRecettes(List<Recette> recettes) {
        if (recettes == null || recettes.isEmpty()) {
            return "Aucune recette trouvée.";
        }
        StringBuilder builder = new StringBuilder();
        for (Recette recette : recettes) {
            builder.append("- ")
                   .append(defaultString(recette.getNomRecette(), "Recette sans nom"))
                   .append('\n');
            builder.append("  Description: ")
                   .append(defaultString(recette.getDescription(), "(aucune)"))
                   .append("\n\n");
        }
        return builder.toString();
    }

    private RecetteWebService createPort() {
        RecetteWebService_Service service = new RecetteWebService_Service();
        RecetteWebService proxy = service.getRecetteWebServicePort();

        String override = System.getProperty("recette.ws.url");
        if (override == null || override.isBlank()) {
            override = System.getenv("RECETTE_WS_URL");
        }

        if (override != null && !override.isBlank()) {
            ((BindingProvider) proxy).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, override);
        }
        return proxy;
    }

    private static String defaultString(String value, String fallback) {
        return (value == null || value.isBlank()) ? fallback : value;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new RecetteClientApp().setVisible(true));
    }

    @FunctionalInterface
    private interface ServiceCall {
        List<Recette> execute() throws Exception;
    }
}

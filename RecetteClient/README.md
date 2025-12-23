# RecetteClient

Client lourd (Swing) permettant de consommer le service SOAP `RecetteWebService`.

## Prérequis

1. Docker Desktop actif et projet serveur démarré :
   ```powershell
   cd ..\RecetteWebService
   docker compose up -d
   ```
2. Maven (via l'image officielle) : aucune installation locale n'est requise, le script ci-dessous utilise l'image `maven:3.9.9-eclipse-temurin-17`.

## Génération des stubs et compilation

```powershell
cd RecetteClient
# Télécharge/rafraîchit la WSDL si nécessaire (serveur doit être démarré)
Invoke-WebRequest -Uri http://localhost:8080/RecetteWebService/RecetteWebService?wsdl -OutFile src/main/resources/wsdl/RecetteWebService.wsdl
Invoke-WebRequest -Uri http://localhost:8080/RecetteWebService/RecetteWebService?xsd=1 -OutFile src/main/resources/wsdl/RecetteWebService.xsd

# Construire et générer les stubs via Maven dans un conteneur
docker run --rm -v ${PWD}:/workspace -w /workspace maven:3.9.9-eclipse-temurin-17 mvn clean package
```

Le JAR résultant se trouve dans `target/recette-client-1.0.0.jar`. Les sources générées par `wsimport` sont sous `target/generated-sources/wsimport`.

## Lancement de l'interface graphique

```powershell
# Toujours depuis le dossier RecetteClient
setx RECETTE_WS_URL "http://localhost:8080/RecetteWebService/RecetteWebService"   # optionnel
java -jar target/recette-client-1.0.0.jar
```

Par défaut, le client appelle l'URL `http://localhost:8080/RecetteWebService/RecetteWebService`. Pour cibler un autre environnement, définissez la variable d'environnement `RECETTE_WS_URL` ou passez l'option JVM `-Drecette.ws.url=...`.

## Fonctionnement

- Champ texte pour l'ingrédient + bouton **Chercher** déclenchant l'opération `chercherRecettesParIngredient`.
- Bouton **Toutes les recettes** appelant `getAllRecettes`.
- Les résultats sont affichés dans la zone centrale; une barre d'état indique le nombre de recettes ou les erreurs retournées.

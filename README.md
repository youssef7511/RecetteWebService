# RecetteWebService

This repository contains two parts:

- `RecetteWebService` — the SOAP service (WAR) built with Maven and packaged to run on GlassFish (Docker).
- `RecetteClient` — a standalone Java Swing client (and a small CLI) that consumes the SOAP service.

Quick start (development)

1. Start the server (Docker):

```powershell
Set-Location 'C:\Users\youss\eclipse-workspace\RecetteWebService'
docker compose up -d --build
```

2. Build the client (locally or using Dockerized Maven):

```powershell
Set-Location 'C:\Users\youss\eclipse-workspace\RecetteWebService\RecetteClient'
# Option A: native Maven
mvn clean package
# Option B: Dockerized Maven (when mvn not installed locally)
docker run --rm -v "${PWD}:/workspace" -w /workspace maven:3.9.9-eclipse-temurin-17 mvn -DskipTests package
```

3. Run client UI:

```powershell
java -jar target\recette-client-1.0.0.jar
```

Or use the CLI runner (example: search for "tomate"):

```powershell
java -jar target\recette-client-1.0.0-uber.jar tomate
```

CI

A GitHub Actions workflow is provided at `.github/workflows/maven-package.yml`. It builds the project with JDK 17 and uploads the generated JAR(s) as workflow artifacts.

Notes

- The repo previously included generated and build artifacts; they have been removed from git history and excluded by `.gitignore`. If you want a fully cleaned history (rewrite), tell me and I can produce steps (force-push required).
- If your service runs on a different URL, set the environment variable `RECETTE_WS_URL` or JVM property `-Drecette.ws.url` to override the client endpoint.

# syntax=docker/dockerfile:1
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml ./
RUN mvn -q -B dependency:go-offline
COPY src ./src
RUN mvn -q -B clean package

FROM ghcr.io/eclipse-ee4j/glassfish:latest
ENV GLASSFISH_HOME=/opt/glassfish7/glassfish
ENV DEPLOY_DIR="$GLASSFISH_HOME/domains/domain1/autodeploy"
COPY --from=build /workspace/target/RecetteWebService.war ${DEPLOY_DIR}/RecetteWebService.war
EXPOSE 8080 4848
CMD ["/bin/sh","-c","$GLASSFISH_HOME/bin/asadmin start-domain --verbose domain1"]

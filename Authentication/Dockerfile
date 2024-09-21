# Stage 1: Build the application using Maven
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le pom.xml et télécharger les dépendances du projet
COPY pom.xml .

# Télécharger les dépendances du projet dans le dépôt Maven local
RUN mvn dependency:go-offline

# Copier le code source du projet dans le conteneur
COPY src ./src

# Construire l'application Spring Boot (crée un fichier JAR)
RUN mvn clean package -DskipTests

# Stage 2: Créer une image légère avec JDK pour exécuter l'application
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR de l'étape de build dans le nouveau conteneur
COPY --from=build /app/target/Authentication-0.0.1-SNAPSHOT.jar ./app.jar

# Exposer le port que votre application Spring Boot va utiliser
EXPOSE 8081

# Définir la commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

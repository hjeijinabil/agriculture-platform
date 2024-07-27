# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Argument pour le chemin du fichier JAR
ARG JAR_FILE=target/eureka-server-0.0.1-SNAPSHOT.jar

# Copier le fichier JAR dans le conteneur
COPY ${JAR_FILE} eureka-server.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8761

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]

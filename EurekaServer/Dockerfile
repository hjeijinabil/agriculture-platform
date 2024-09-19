# Stage 1: Build the application using Maven
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download the project dependencies
COPY pom.xml .

# Download project dependencies into the local Maven repository
RUN mvn dependency:go-offline

# Copy the project source code into the container
COPY src ./src

# Build the Spring Boot application (this will create a JAR file)
RUN mvn clean package -DskipTests

# Stage 2: Create a lightweight image with JDK to run the application
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into the new container
COPY --from=build /app/target/eureka-server.jar ./app.jar

# Expose the port that your Eureka Server will run on
EXPOSE 8761

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

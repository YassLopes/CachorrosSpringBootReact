# Use an official Java runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven files first
COPY pom.xml .
COPY src ./src

# Install Maven
RUN apk add --no-cache maven

# Build the application
RUN mvn clean package -DskipTests

# Expose the application port
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "target/meu-projeto-springboot-1.0-SNAPSHOT.jar"]
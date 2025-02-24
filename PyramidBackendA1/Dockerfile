# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy application JAR to container
COPY target/PyramidBackendA1.jar PyramidBackendA1.jar

# Expose application port
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "PyramidBackendA1"]

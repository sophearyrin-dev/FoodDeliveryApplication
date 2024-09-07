#FROM openjdk:17.0.1-slim
#WORKDIR /opt
#COPY target/*.jar /opt/app.jar
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

# Set the working directory in the container
WORKDIR /opt

# Copy the JAR file from the target directory and rename it
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /opt/my-app.jar

# Expose the port the app runs on (e.g., 8080)
EXPOSE 8080

# Set an environment variable for the secret, fallback if not provided
ENV JWT_SECRET_KEY=default-secret-key

# Run the application with the custom JAR name
ENTRYPOINT ["java", "-jar", "/opt/my-app.jar"]


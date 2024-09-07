# Set the working directory in the container
WORKDIR /opt

# Copy the JAR file from the target directory and rename it
COPY target/security-service-0.0.1-SNAPSHOT.jar /opt/my-app.jar

# Expose the port the app runs on (e.g., 8080)
EXPOSE 9898

# Run the application with the custom JAR name
ENTRYPOINT ["java", "-jar", "/opt/my-app.jar"]

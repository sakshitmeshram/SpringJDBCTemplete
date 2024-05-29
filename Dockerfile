# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable WAR file into the container
COPY target/SpringJDBCTemplete-0.0.1-SNAPSHOT.war app.war

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the WAR file
ENTRYPOINT ["java", "-jar", "app.war"]

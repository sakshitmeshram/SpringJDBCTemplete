# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the wait-for-it script
COPY wait-for-it.sh /app/wait-for-it.sh

# Make the wait-for-it script executable
RUN chmod +x /app/wait-for-it.sh

# Copy the executable WAR file into the container
COPY target/SpringJDBCTemplete-0.0.1-SNAPSHOT.war app.war

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the WAR file, waiting for MySQL to be ready
ENTRYPOINT ["/app/wait-for-it.sh", "mysql:3306", "--timeout=30", "--", "java", "-jar", "app.war"]

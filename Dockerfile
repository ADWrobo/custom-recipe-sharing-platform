# Use Maven base image to build the project
FROM maven:3.9.6-sapmachine-21 as build

# Copy your project files into the image
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Set the working directory
WORKDIR /usr/src/app

# Build your application with Maven
RUN mvn clean package -DskipTests

# Use OpenJDK for running the application
FROM openjdk:21

# Copy the built artifact from the build stage
COPY --from=build /usr/src/app/target/custom-recipe-sharing-platform-0.0.1-SNAPSHOT.jar /usr/app/custom-recipe-sharing-platform.jar

# Set the working directory for the application
WORKDIR /usr/app

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "custom-recipe-sharing-platform.jar"]

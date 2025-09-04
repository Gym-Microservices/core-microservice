# Gym Core Dockerfile
# Note: This is a gym module, not a standalone service
# It should not be deployed independently but included as dependency in other microservices

FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy parent POM
COPY parent/pom.xml /app/parent/pom.xml
RUN cd /app/parent && mvn install -N

# Copy core module POM and source
COPY core-microservice/pom.xml .
COPY core-microservice/src ./src

# Build and install the gym
RUN mvn clean install -DskipTests

# This gym doesn't need a runtime stage as it's included in other services
# The JAR is now available in the local Maven repository for other builds

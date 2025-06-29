#!/bin/bash

echo "Building Rentro Microservices..."

# Build API Gateway
echo "Building API Gateway..."
cd api-gateway
mvn clean package -DskipTests
cd ..

# Build User Service
echo "Building User Service..."
cd user-service
mvn clean package -DskipTests
cd ..

# Build Property Service
echo "Building Property Service..."
cd property-service
mvn clean package -DskipTests
cd ..

# Build Booking Service
echo "Building Booking Service..."
cd booking-service
mvn clean package -DskipTests
cd ..

# Build Society Service
echo "Building Society Service..."
cd society-service
mvn clean package -DskipTests
cd ..

# Build Notification Service
echo "Building Notification Service..."
cd notification-service
mvn clean package -DskipTests
cd ..

echo "All services built successfully!"
echo "Run 'docker-compose up --build' to start all services"

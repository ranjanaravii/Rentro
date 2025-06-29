# Rentro
A backend platform to simplify home renting by connecting tenants directly with flat owners in societies — no brokers, no hidden charges.

## Architecture Overview

Rentro is built using a microservices architecture with the following services:

### Services

1. **API Gateway** (Port: 8080)
   - Central entry point for all client requests
   - Routes requests to appropriate microservices
   - Handles authentication and authorization
   - CORS configuration

2. **User Service** (Port: 8081)
   - User registration and authentication
   - Profile management
   - JWT token generation and validation
   - User types: TENANT, OWNER, ADMIN

3. **Property Service** (Port: 8082)
   - Property listing management
   - Property search and filtering
   - Property verification
   - Image and amenity management

4. **Society Service** (Port: 8085)
   - Society registration and management
   - Society verification
   - Location-based services
   - Society amenities and details

5. **Booking Service** (Port: 8083)
   - Rental booking requests
   - Booking status management
   - Lease agreement handling
   - Payment tracking

6. **Notification Service** (Port: 8084)
   - Email notifications
   - SMS notifications
   - Push notifications
   - Notification templates

### Database & Infrastructure

- **PostgreSQL**: Primary database for all services
- **Redis**: Caching and session management
- **Docker**: Containerization for all services
- **Docker Compose**: Local development environment

## Key Features

### For Tenants
- Browse properties in societies without broker involvement
- Direct communication with property owners
- Advanced search and filtering
- Booking requests and status tracking
- Profile and preference management

### For Property Owners
- List properties in their societies
- Manage property details and images
- Review and respond to booking requests
- Direct tenant communication
- Property verification status

### For Societies
- Society registration and verification
- Manage society details and amenities
- Location-based property discovery
- Society-wide property listings

## Technology Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **Database**: PostgreSQL 15
- **Cache**: Redis 7
- **Security**: Spring Security, JWT
- **API Gateway**: Spring Cloud Gateway
- **Containerization**: Docker & Docker Compose
- **Build Tool**: Maven

## Getting Started

### Prerequisites
- Java 21
- Docker & Docker Compose
- Maven

### Running the Application

1. Clone the repository
```bash
git clone <repository-url>
cd Rentro
```

2. Start the infrastructure services
```bash
docker-compose up postgres redis -d
```

3. Build and run all services
```bash
docker-compose up --build
```

4. Access the API Gateway at `http://localhost:8080`

### API Endpoints

#### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `POST /api/auth/verify-email` - Email verification

#### Properties
- `GET /api/properties` - List properties
- `POST /api/properties` - Create property
- `GET /api/properties/{id}` - Get property details
- `PUT /api/properties/{id}` - Update property

#### Societies
- `GET /api/societies` - List societies
- `POST /api/societies` - Register society
- `GET /api/societies/{id}` - Get society details

#### Bookings
- `POST /api/bookings` - Create booking request
- `GET /api/bookings/tenant/{tenantId}` - Get tenant bookings
- `GET /api/bookings/owner/{ownerId}` - Get owner bookings
- `PUT /api/bookings/{id}/status` - Update booking status

## Development

Each service is independently deployable and follows these patterns:
- RESTful API design
- JPA for database operations
- DTO pattern for data transfer
- Service layer for business logic
- Repository pattern for data access
- Comprehensive validation
- Audit trails with created/updated timestamps

## Database Schema

The platform uses separate schemas for each service with proper relationships:
- Users (authentication and profiles)
- Properties (listings and details)
- Societies (housing society information)
- Bookings (rental requests and agreements)
- Notifications (communication logs)

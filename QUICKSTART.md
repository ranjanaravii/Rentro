# Rentro - Quick Start Guide

## Project Structure

```
Rentro/
├── api-gateway/          # API Gateway Service (Port: 8080)
├── user-service/         # User Management Service (Port: 8081)
├── property-service/     # Property Management Service (Port: 8082)
├── booking-service/      # Booking Management Service (Port: 8083)
├── notification-service/ # Notification Service (Port: 8084)
├── society-service/      # Society Management Service (Port: 8085)
├── docker-compose.yml    # Docker Compose configuration
├── build.sh             # Build script for all services
└── README.md            # Project documentation
```

## Quick Setup

### 1. Prerequisites
- Java 21
- Maven 3.6+
- Docker & Docker Compose

### 2. Build All Services
```bash
./build.sh
```

### 3. Start Infrastructure
```bash
docker-compose up postgres redis -d
```

### 4. Start All Services
```bash
docker-compose up --build
```

### 5. Test the API
```bash
# Register a new user
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "+1234567890",
    "password": "password123",
    "userType": "TENANT",
    "city": "Mumbai",
    "state": "Maharashtra"
  }'

# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john.doe@example.com",
    "password": "password123"
  }'
```

## Service Endpoints

### API Gateway (Port: 8080)
- All requests go through the API Gateway
- Routes to appropriate microservices

### User Service (Port: 8081)
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `POST /api/auth/verify-email` - Email verification

### Property Service (Port: 8082)
- `GET /api/properties` - List properties
- `POST /api/properties` - Create property
- `GET /api/properties/{id}` - Get property details

### Society Service (Port: 8085)
- `GET /api/societies` - List societies
- `POST /api/societies` - Register society
- `GET /api/societies/{id}` - Get society details

### Booking Service (Port: 8083)
- `POST /api/bookings` - Create booking request
- `GET /api/bookings/tenant/{tenantId}` - Get tenant bookings
- `GET /api/bookings/owner/{ownerId}` - Get owner bookings

## Development

### Running Individual Services
Each service can be run independently:

```bash
cd user-service
mvn spring-boot:run
```

### Database Access
- PostgreSQL: `localhost:5432`
- Database: `rentro_db`
- Username: `rentro_user`
- Password: `rentro_pass`

### Redis Cache
- Redis: `localhost:6379`

## Next Steps

1. Complete the implementation of remaining services
2. Add JWT authentication and authorization
3. Implement property search and filtering
4. Add notification system
5. Create comprehensive test suites
6. Add API documentation with Swagger
7. Implement file upload for property images
8. Add payment integration

# 🛒 E-Commerce Microservices Project

A **production-ready, scalable E-Commerce backend system** built using **Microservices Architecture** with Spring Boot and Spring Cloud. This project demonstrates industry best practices for building distributed systems with independent services, service discovery, API gateway routing, and inter-service communication.

The project is especially useful for **Java Backend / Spring Boot Developers** who want hands-on experience with real-world microservices patterns and enterprise-grade system design.

---

## 📌 Project Overview

This E-Commerce Microservices platform decouples business logic into independent, scalable microservices. Each service is responsible for a specific domain and communicates with others through REST APIs and event-driven messaging. The architecture ensures flexibility, scalability, and maintainability while following the Single Responsibility Principle.

### Why Microservices?

- **Scalability** – Scale individual services independently
- **Flexibility** – Different technologies for different services
- **Resilience** – Failure in one service doesn't crash the entire system
- **Maintainability** – Smaller codebases are easier to maintain
- **Deployment** – Services can be deployed independently
- **Team Autonomy** – Different teams can work on different services

---

## 🧩 Microservices Architecture

Each core business functionality is implemented as an **independent microservice**:

| Service | Port | Purpose | Key Features |
|---------|------|---------|--------------|
| **Eureka Server** | 8761 | Service Discovery & Registration | Service registry, health monitoring |
| **API Gateway** | 8080 | Request Routing & Load Balancing | Single entry point, request filtering |
| **Auth Service** | 8081 | Authentication & Authorization | JWT token generation, user validation |
| **User Service** | 8082 | User Management | Registration, profile, preferences |
| **Product Service** | 8083 | Product Catalog | Product CRUD, inventory, categories |
| **Order Service** | 8084 | Order Management | Order creation, tracking, history |
| **Payment Service** | 8085 | Payment Processing | Payment gateway integration, transactions |
| **Billing Service** | 8086 | Billing & Invoicing | Invoice generation, payment records |
| **Notification Service** | 8087 | Communications | Email, SMS, push notifications |

---

## 🛠️ Tech Stack

### Backend

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 17+ | Programming language |
| **Spring Boot** | 3.2.5+ | Application framework |
| **Spring Cloud** | 2023.0.1+ | Microservices infrastructure |
| **Spring Security** | Latest | Authentication & authorization |
| **Spring Data JPA** | Latest | Database abstraction |
| **Hibernate** | Latest | ORM framework |

### Service Discovery & Routing

| Component | Purpose |
|-----------|---------|
| **Eureka** | Service registration & discovery |
| **API Gateway** | Request routing, load balancing |
| **OpenFeign** | Inter-service REST communication |
| **Config Server** | Centralized configuration management |

### Database & Caching

| Technology | Purpose |
|-----------|---------|
| **MySQL / PostgreSQL** | Persistent data storage |
| **Redis** | In-memory caching (optional) |
| **H2** | In-memory database for testing |

### Communication & Messaging

| Technology | Purpose |
|-----------|---------|
| **REST APIs** | Synchronous service communication |
| **Kafka / RabbitMQ** | Asynchronous event-driven messaging (optional) |
| **OpenFeign** | Declarative REST client |

### DevOps & Tools

| Tool | Purpose |
|------|---------|
| **Docker** | Containerization |
| **Docker Compose** | Multi-container orchestration |
| **Maven** | Build and dependency management |
| **Postman** | API testing |
| **Git / GitHub** | Version control |

---

## 📂 Project Structure

```
ecom-Microservice_CodeBase/
│
├── eureka-server/                      # Service Discovery Server
│   ├── src/main/java
│   │   └── com/example/eureka
│   │       └── EurekaServerApplication.java
│   ├── src/main/resources
│   │   └── application.properties      # Eureka configuration
│   └── pom.xml
│
├── api-gateway/                        # API Gateway (Request Router)
│   ├── src/main/java
│   │   └── com/example/gateway
│   │       ├── GatewayApplication.java
│   │       ├── config/
│   │       │   └── GatewayConfig.java  # Route configuration
│   │       └── filter/
│   │           └── AuthFilter.java     # JWT validation filter
│   ├── src/main/resources
│   │   └── application.yml             # Gateway routes
│   └── pom.xml
│
├── config-server/                      # Centralized Configuration
│   ├── src/main/java
│   │   └── com/example/config
│   │       └── ConfigServerApplication.java
│   ├── src/main/resources
│   │   └── application.properties
│   └── pom.xml
│
├── auth-service/                       # Authentication Service
│   ├── src/main/java
│   │   └── com/example/auth
│   │       ├── AuthServiceApplication.java
│   │       ├── controller/
│   │       │   └── AuthController.java
│   │       ├── service/
│   │       │   ├── AuthService.java
│   │       │   └── JwtTokenProvider.java
│   │       ├── entity/
│   │       │   └── User.java
│   │       └── repository/
│   │           └── UserRepository.java
│   ├── src/main/resources
│   │   └── application.properties
│   └── pom.xml
│
├── user-service/                       # User Management Service
│   ├── src/main/java
│   │   └── com/example/user
│   │       ├── UserServiceApplication.java
│   │       ├── controller/
│   │       │   └── UserController.java
│   │       ├── service/
│   │       │   └── UserService.java
│   │       ├── entity/
│   │       │   └── UserProfile.java
│   │       └── repository/
│   │           └── UserRepository.java
│   └── pom.xml
│
├── product-service/                    # Product Catalog Service
│   ├── src/main/java
│   │   └── com/example/product
│   │       ├── ProductServiceApplication.java
│   │       ├── controller/
│   │       │   ├── ProductController.java
│   │       │   └── CategoryController.java
│   │       ├── service/
│   │       │   ├── ProductService.java
│   │       │   └── InventoryService.java
│   │       ├── entity/
│   │       │   ├── Product.java
│   │       │   ├── Category.java
│   │       │   └── Inventory.java
│   │       └── repository/
│   │           ├── ProductRepository.java
│   │           └── InventoryRepository.java
│   └── pom.xml
│
├── order-service/                      # Order Management Service
│   ├── src/main/java
│   │   └── com/example/order
│   │       ├── OrderServiceApplication.java
│   │       ├── controller/
│   │       │   └── OrderController.java
│   │       ├── service/
│   │       │   └── OrderService.java
│   │       ├── entity/
│   │       │   ├── Order.java
│   │       │   └── OrderItem.java
│   │       ├── repository/
│   │       │   └── OrderRepository.java
│   │       └── client/
│   │           ├── ProductServiceClient.java   # Feign client
│   │           └── PaymentServiceClient.java
│   └── pom.xml
│
├── payment-service/                    # Payment Processing Service
│   ├── src/main/java
│   │   └── com/example/payment
│   │       ├── PaymentServiceApplication.java
│   │       ├── controller/
│   │       │   └── PaymentController.java
│   │       ├── service/
│   │       │   ├── PaymentService.java
│   │       │   └── PaymentGatewayIntegration.java
│   │       ├── entity/
│   │       │   └── Payment.java
│   │       └── repository/
│   │           └── PaymentRepository.java
│   └── pom.xml
│
├── billing-service/                    # Billing & Invoicing Service
│   ├── src/main/java
│   │   └── com/example/billing
│   │       ├── BillingServiceApplication.java
│   │       ├── controller/
│   │       │   └── BillingController.java
│   │       ├── service/
│   │       │   ├── BillingService.java
│   │       │   └── InvoiceService.java
│   │       ├── entity/
│   │       │   ├── Bill.java
│   │       │   └── Invoice.java
│   │       └── repository/
│   │           ├── BillingRepository.java
│   │           └── InvoiceRepository.java
│   └── pom.xml
│
├── notification-service/               # Notification Service
│   ├── src/main/java
│   │   └── com/example/notification
│   │       ├── NotificationServiceApplication.java
│   │       ├── controller/
│   │       │   └── NotificationController.java
│   │       ├── service/
│   │       │   ├── EmailService.java
│   │       │   ├── SmsService.java
│   │       │   └── PushNotificationService.java
│   │       ├── entity/
│   │       │   └── Notification.java
│   │       └── repository/
│   │           └── NotificationRepository.java
│   └── pom.xml
│
├── docker-compose.yml                  # Multi-container orchestration
├── README.md                           # This file
└── pom.xml                            # Parent POM (optional)
```

---

## 🔐 Authentication Flow (JWT)

```
┌──────────┐
│  Client  │
└────┬─────┘
     │ 1. POST /auth/login (username, password)
     │
     ▼
┌───────────────────────┐
│   API Gateway         │  2. Route to Auth Service
└──────────┬────────────┘
           │
           ▼
┌───────────────────────┐
│   Auth Service        │  3. Validate credentials
│   Generate JWT Token  │
└──────────┬────────────┘
           │
     4. JWT Token
     │
     ▼
┌───────────────────────┐
│  Client receives JWT  │
│  (Authorization header)
└──────────┬────────────┘
           │
           │ 5. Subsequent requests with JWT
           │
           ▼
┌───────────────────────┐
│   API Gateway         │  6. Validate JWT in AuthFilter
└──────────┬────────────┘
           │
           │ 7. Route to target service
           ▼
┌───────────────────────┐
│  Target Microservice  │  8. Process request
└───────────────────────┘
```

---

## 🔄 Inter-Service Communication

### Synchronous Communication (REST + Feign)

**Order Service → Product Service**

```java
@FeignClient(name = "product-service")
public interface ProductServiceClient {
    @GetMapping("/api/products/{id}")
    Product getProduct(@PathVariable Long id);
}
```

**Order Service → Payment Service**

```java
@FeignClient(name = "payment-service")
public interface PaymentServiceClient {
    @PostMapping("/api/payments")
    PaymentResponse processPayment(@RequestBody PaymentRequest request);
}
```

### Asynchronous Communication (Event-Driven)

**Event Flow:**

```
Order Service creates order
    │
    ▼
Post event to Kafka: "OrderCreated"
    │
    ├─► Payment Service consumes: "OrderCreated"
    │   └─► Process Payment
    │       └─► Emit "PaymentProcessed" event
    │
    ├─► Notification Service consumes: "OrderCreated"
    │   └─► Send Order Confirmation Email
    │
    └─► Notification Service consumes: "PaymentProcessed"
        └─► Send Payment Confirmation Email
```

---

## 🚀 How to Run the Project

### Prerequisites

- **Java Development Kit (JDK)** 17 or higher
- **Apache Maven** 3.6 or higher
- **Docker & Docker Compose** (recommended)
- **MySQL Server** 8.0+ (if not using Docker)
- **Postman** (for API testing)

### Option 1: Using Docker Compose (Recommended)

```bash
# Clone the repository
git clone https://github.com/JavaDeveloper-Sinku/ecom-Microservice_CodeBase.git
cd ecom-Microservice_CodeBase

# Start all services using Docker Compose
docker-compose up

# Services will be available at:
# - API Gateway: http://localhost:8080
# - Eureka Dashboard: http://localhost:8761
# - Auth Service: http://localhost:8081
# - Product Service: http://localhost:8083
# - Order Service: http://localhost:8084
```

### Option 2: Local Development Setup

#### 1️⃣ Start Eureka Server (Service Discovery)

```bash
cd eureka-server
mvn spring-boot:run
```

Access Eureka Dashboard: http://localhost:8761

#### 2️⃣ Start API Gateway

```bash
cd api-gateway
mvn spring-boot:run
```

#### 3️⃣ Start Individual Microservices

In separate terminal windows:

```bash
# Auth Service
cd auth-service
mvn spring-boot:run

# User Service
cd user-service
mvn spring-boot:run

# Product Service
cd product-service
mvn spring-boot:run

# Order Service
cd order-service
mvn spring-boot:run

# Payment Service
cd payment-service
mvn spring-boot:run

# Billing Service
cd billing-service
mvn spring-boot:run

# Notification Service
cd notification-service
mvn spring-boot:run
```

#### 4️⃣ Verify All Services are Running

Visit Eureka Dashboard: http://localhost:8761

All services should be registered and showing as "UP".

---

## 📡 API Endpoints

### Authentication Endpoints

| Method | Endpoint | Description | Body |
|--------|----------|-------------|------|
| POST | `/api/auth/login` | User login | `{username, password}` |
| POST | `/api/auth/register` | User registration | `{username, email, password}` |
| POST | `/api/auth/validate-token` | Validate JWT token | `{token}` |
| POST | `/api/auth/refresh-token` | Refresh JWT token | `{token}` |

**Login Request:**
```json
{
  "username": "user123",
  "password": "password123"
}
```

**Login Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "expiresIn": 3600,
  "user": {
    "id": 1,
    "username": "user123",
    "email": "user@example.com"
  }
}
```

### Product Service Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|----------------|
| GET | `/api/products` | Get all products | No |
| GET | `/api/products/{id}` | Get product by ID | No |
| POST | `/api/products` | Create product | Yes (Admin) |
| PUT | `/api/products/{id}` | Update product | Yes (Admin) |
| DELETE | `/api/products/{id}` | Delete product | Yes (Admin) |
| GET | `/api/products/search` | Search products | No |
| GET | `/api/categories` | Get all categories | No |

### Order Service Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|----------------|
| POST | `/api/orders` | Create order | Yes |
| GET | `/api/orders` | Get user's orders | Yes |
| GET | `/api/orders/{id}` | Get order details | Yes |
| PUT | `/api/orders/{id}` | Update order | Yes |
| DELETE | `/api/orders/{id}` | Cancel order | Yes |
| GET | `/api/orders/{id}/status` | Get order status | Yes |

**Create Order Request:**
```json
{
  "userId": 1,
  "items": [
    {
      "productId": 10,
      "quantity": 2,
      "price": 99.99
    }
  ],
  "shippingAddress": "123 Main St, City, State",
  "billingAddress": "123 Main St, City, State"
}
```

### Payment Service Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|----------------|
| POST | `/api/payments` | Process payment | Yes |
| GET | `/api/payments/{id}` | Get payment details | Yes |
| GET | `/api/payments/order/{orderId}` | Get payments for order | Yes |
| POST | `/api/payments/{id}/refund` | Refund payment | Yes (Admin) |

**Process Payment Request:**
```json
{
  "orderId": 1,
  "amount": 199.98,
  "paymentMethod": "CREDIT_CARD",
  "cardDetails": {
    "cardNumber": "1234567890123456",
    "expiryDate": "12/25",
    "cvv": "123"
  }
}
```

### Notification Service Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|----------------|
| POST | `/api/notifications/email` | Send email | Yes (Internal) |
| POST | `/api/notifications/sms` | Send SMS | Yes (Internal) |
| POST | `/api/notifications/push` | Send push notification | Yes (Internal) |
| GET | `/api/notifications` | Get notifications | Yes |

---

## 🗄️ Database Schema

### Users Table

```sql
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  phone VARCHAR(20),
  address TEXT,
  role VARCHAR(20) DEFAULT 'USER',
  is_active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);
```

### Products Table

```sql
CREATE TABLE products (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  category_id BIGINT,
  price DECIMAL(10, 2) NOT NULL,
  discount_price DECIMAL(10, 2),
  sku VARCHAR(100) UNIQUE,
  stock_quantity INT,
  image_url VARCHAR(255),
  is_active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  FOREIGN KEY (category_id) REFERENCES categories(id)
);
```

### Orders Table

```sql
CREATE TABLE orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  order_date TIMESTAMP,
  total_amount DECIMAL(10, 2),
  status VARCHAR(20) DEFAULT 'PENDING',
  shipping_address TEXT,
  billing_address TEXT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);
```

### Payments Table

```sql
CREATE TABLE payments (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  payment_method VARCHAR(50),
  status VARCHAR(20) DEFAULT 'PENDING',
  transaction_id VARCHAR(100),
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  FOREIGN KEY (order_id) REFERENCES orders(id)
);
```

---

## 🧪 API Testing with Postman

### Import Postman Collection

Postman collections are available in the `postman` directory:

```bash
# Collections included:
- Auth-Service.postman_collection.json
- Product-Service.postman_collection.json
- Order-Service.postman_collection.json
- Payment-Service.postman_collection.json
```

### Manual Testing Steps

1. **Login & Get Token:**
   - POST `http://localhost:8080/api/auth/login`
   - Body: `{"username": "user123", "password": "password123"}`
   - Copy the returned `token`

2. **Use Token in Requests:**
   - Add header: `Authorization: Bearer <token>`
   - GET `http://localhost:8080/api/products`

3. **Create Order:**
   - POST `http://localhost:8080/api/orders`
   - Add token in Authorization header
   - Body: Order details

---

## 🏗️ Microservices Communication Flow

### Complete User Journey: Order Creation to Payment

```
1. User logs in
   └─► Auth Service generates JWT token

2. User browses products
   └─► API Gateway routes to Product Service

3. User creates order
   └─► API Gateway routes to Order Service
   └─► Order Service calls Product Service (Feign)
       └─► Check product availability & prices
   └─► Order Service publishes "OrderCreated" event to Kafka

4. Payment Processing
   └─► Payment Service consumes "OrderCreated" event
   └─► Processes payment (can call Payment Gateway)
   └─► Publishes "PaymentProcessed" or "PaymentFailed" event

5. Billing
   └─► Billing Service consumes "PaymentProcessed" event
   └─► Generates invoice and bill

6. Notifications
   └─► Notification Service consumes multiple events
   └─► Sends order confirmation email
   └─► Sends payment confirmation email
   └─► Sends shipping notification (when order ships)
```

---

## ⚙️ Configuration Management

### Eureka Configuration

**eureka-server/src/main/resources/application.properties:**

```properties
server.port=8761
spring.application.name=eureka-server

eureka.server.enable-self-preservation=false
eureka.server.eviction-interval-timer-in-ms=3000

logging.level.com.netflix.eureka=INFO
```

### API Gateway Configuration

**api-gateway/src/main/resources/application.yml:**

```yaml
spring:
  application:
    name: api-gateway
  cloud:
    gateway:
      routes:
        - id: auth-service
          uri: lb://auth-service
          predicates:
            - Path=/api/auth/**
          
        - id: product-service
          uri: lb://product-service
          predicates:
            - Path=/api/products/**
          
        - id: order-service
          uri: lb://order-service
          predicates:
            - Path=/api/orders/**
          
        - id: payment-service
          uri: lb://payment-service
          predicates:
            - Path=/api/payments/**

eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
```

---

## 🐛 Common Issues & Troubleshooting

| Issue | Solution |
|-------|----------|
| **Service not registering on Eureka** | Ensure Eureka Server is running on port 8761 |
| **API Gateway not routing requests** | Check gateway configuration and service URLs |
| **JWT token validation fails** | Verify JWT secret is same across all services |
| **Feign client connection timeout** | Increase timeout in service configuration |
| **Database connection error** | Check MySQL is running and credentials are correct |
| **Port already in use** | Change port in application.properties |
| **Docker image build fails** | Run `mvn clean package` before building Docker image |

---

## 📊 Monitoring & Observability

### Health Checks

```bash
# Check Eureka Server health
curl http://localhost:8761/actuator/health

# Check API Gateway health
curl http://localhost:8080/actuator/health

# Check individual service health
curl http://localhost:8081/actuator/health  # Auth Service
curl http://localhost:8083/actuator/health  # Product Service
```

### Eureka Dashboard

Visit: http://localhost:8761

Shows:
- All registered services
- Service instances and their status
- Health status of each instance

---

## 🚀 Deployment

### Docker Compose

```yaml
version: '3.8'

services:
  eureka-server:
    build: ./eureka-server
    ports:
      - "8761:8761"
    environment:
      EUREKA_CLIENT_REGISTERWITEUREKA: "false"

  api-gateway:
    build: ./api-gateway
    ports:
      - "8080:8080"
    depends_on:
      - eureka-server
    environment:
      EUREKA_CLIENT_SERVICEURL_DEFAULTZONE: http://eureka-server:8761/eureka/

  auth-service:
    build: ./auth-service
    ports:
      - "8081:8081"
    depends_on:
      - eureka-server
      - mysql-db
    environment:
      EUREKA_CLIENT_SERVICEURL_DEFAULTZONE: http://eureka-server:8761/eureka/

  mysql-db:
    image: mysql:8.0
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: ecommerce_db
```

### Kubernetes Deployment (Optional)

Each microservice can be deployed as a separate Kubernetes pod with appropriate service definitions.

---

## 📚 Learning Resources

- **Spring Boot Documentation** – https://spring.io/projects/spring-boot
- **Spring Cloud** – https://spring.io/projects/spring-cloud
- **Microservices Patterns** – https://microservices.io/
- **Netflix Eureka** – https://github.com/Netflix/eureka
- **Spring Cloud Gateway** – https://spring.io/projects/spring-cloud-gateway
- **RESTful API Design** – https://restfulapi.net/
- **JWT Authentication** – https://jwt.io/

---

## 🚀 Future Enhancements

- [ ] **Circuit Breaker** – Resilience4j for fault tolerance
- [ ] **Distributed Tracing** – Zipkin/Jaeger for request tracking
- [ ] **Rate Limiting** – Throttle API requests per client
- [ ] **Caching Layer** – Redis for frequently accessed data
- [ ] **Message Queue** – Kafka for event-driven architecture
- [ ] **Logging & Monitoring** – ELK Stack (Elasticsearch, Logstash, Kibana)
- [ ] **Admin Dashboard** – Centralized monitoring and management
- [ ] **Kubernetes Deployment** – Container orchestration
- [ ] **GraphQL API** – Alternative to REST
- [ ] **API Documentation** – Swagger/OpenAPI integration
- [ ] **Unit & Integration Tests** – Comprehensive test coverage
- [ ] **Load Testing** – JMeter for performance testing

---

## 📄 License

This project is open-source and available under the **MIT License**.

---

## 👨‍💻 Author

**Sinku Singh**  
Java Backend Developer | Spring Boot | Microservices | System Design

- 💼 GitHub: [JavaDeveloper-Sinku](https://github.com/JavaDeveloper-Sinku)
- 📧 Email: singh173@gmail.com
- 💻 Portfolio: [sinku-portfolio.vercel.app](https://sinku-portfolio.vercel.app)
- 🔗 LinkedIn: [Sinku Singh](https://www.linkedin.com/in/sinku-singh-7a22ab233/)

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## ⭐ Support

If you find this project helpful, please consider giving it a **star** ⭐ on GitHub!

---

## 📞 Contact & Support

For issues, suggestions, or questions:
- Open an **Issue** on GitHub
- Email: singh173@gmail.com
- LinkedIn: [Sinku Singh](https://www.linkedin.com/in/sinku-singh-7a22ab233/)

---

## 🔗 Related Projects

- [Employee Management System](https://github.com/JavaDeveloper-Sinku/Employee-ManagementSystem)
- [JWT Authentication System](https://github.com/JavaDeveloper-Sinku/Jwt_AuthenticationSystem)
- [GraphQL CRUD APIs](https://github.com/JavaDeveloper-Sinku/GraphQL-CRUD-APIs)
- [Finance Dashboard Backend](https://github.com/JavaDeveloper-Sinku/Finance-Data-Processing-and-Access-Control-Backend)
- [Daily Report App](https://github.com/JavaDeveloper-Sinku/DailyReportApp)

---

**Happy Coding! 🚀🛒**

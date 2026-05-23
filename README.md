# 🛒 E-Commerce Microservices Project

A **production-ready, scalable E-Commerce backend system** built using **Microservices Architecture** with Spring Boot and Spring Cloud.

---

## 📌 Project Overview

This E-Commerce Microservices platform decouples business logic into independent, scalable microservices. Each service is responsible for a specific domain and communicates with others through REST APIs and event-driven messaging.

---

## 🧩 Microservices Architecture

| Service | Port | Purpose |
|---------|------|---------|
| **Eureka Server** | 8761 | Service Discovery & Registration |
| **API Gateway** | 8080 | Request Routing & Load Balancing |
| **Auth Service** | 8081 | Authentication & Authorization |
| **User Service** | 8082 | User Management |
| **Product Service** | 8083 | Product Catalog |
| **Order Service** | 8084 | Order Management |
| **Payment Service** | 8085 | Payment Processing |
| **Billing Service** | 8086 | Billing & Invoicing |
| **Notification Service** | 8087 | Email, SMS, Push Notifications |

---

## 🛠️ Tech Stack

- **Java 17+** – Programming language
- **Spring Boot 3.2.5+** – Application framework
- **Spring Cloud 2023.0.1+** – Microservices infrastructure
- **Spring Security** – Authentication & authorization
- **Spring Data JPA** – Database abstraction
- **Hibernate** – ORM framework
- **Eureka** – Service registration & discovery
- **API Gateway** – Request routing
- **OpenFeign** – Inter-service REST communication
- **MySQL / PostgreSQL** – Persistent data storage
- **Redis** – In-memory caching (optional)
- **Kafka / RabbitMQ** – Event-driven messaging (optional)
- **Docker** – Containerization
- **Maven** – Build and dependency management

---

## 📂 Project Structure

```
ecom-Microservice_CodeBase/
├── eureka-server/              # Service Discovery
├── api-gateway/                # Request Router
├── config-server/              # Centralized Configuration
├── auth-service/               # Authentication
├── user-service/               # User Management
├── product-service/            # Product Catalog
├── order-service/              # Order Management
├── payment-service/            # Payment Processing
├── billing-service/            # Billing & Invoicing
├── notification-service/       # Notifications
├── docker-compose.yml          # Multi-container orchestration
└── README.md
```

---

## 🔐 Authentication Flow

1. User performs login
2. Auth Service generates JWT token
3. API Gateway validates token
4. Authorized requests forwarded to respective microservices

---

## 🔄 Inter-Service Communication

**Synchronous:** REST APIs using Feign Client  
**Asynchronous:** Event-driven communication using Kafka

---

## 🚀 How to Run

### Option 1: Using Docker Compose (Recommended)

```bash
git clone https://github.com/JavaDeveloper-Sinku/ecom-Microservice_CodeBase.git
cd ecom-Microservice_CodeBase
docker-compose up
```

Access:
- API Gateway: http://localhost:8080
- Eureka Dashboard: http://localhost:8761

### Option 2: Local Development

#### Start Eureka Server
```bash
cd eureka-server
mvn spring-boot:run
```

#### Start Individual Services
In separate terminal windows:
```bash
cd auth-service && mvn spring-boot:run
cd user-service && mvn spring-boot:run
cd product-service && mvn spring-boot:run
cd order-service && mvn spring-boot:run
cd payment-service && mvn spring-boot:run
cd billing-service && mvn spring-boot:run
cd notification-service && mvn spring-boot:run
```

---

## 📡 API Endpoints

### Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/login` | User login |
| POST | `/api/auth/register` | User registration |
| POST | `/api/auth/validate-token` | Validate JWT token |

### Products
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create product (Admin) |
| PUT | `/api/products/{id}` | Update product (Admin) |
| DELETE | `/api/products/{id}` | Delete product (Admin) |

### Orders
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Create order |
| GET | `/api/orders` | Get user's orders |
| GET | `/api/orders/{id}` | Get order details |
| PUT | `/api/orders/{id}` | Update order |
| DELETE | `/api/orders/{id}` | Cancel order |

### Payments
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/payments` | Process payment |
| GET | `/api/payments/{id}` | Get payment details |
| GET | `/api/payments/order/{orderId}` | Get order payments |

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
  sku VARCHAR(100) UNIQUE,
  stock_quantity INT,
  is_active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMP,
  updated_at TIMESTAMP
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

## 🧪 API Testing

### Login & Get Token
```bash
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "user123",
  "password": "password123"
}
```

### Use Token in Requests
```bash
Authorization: Bearer <token>
GET http://localhost:8080/api/products
```

---

## 📊 User Journey: Order Creation to Payment

```
1. User logs in → Auth Service generates JWT
2. User browses products → Product Service
3. User creates order → Order Service
   └─ Order Service calls Product Service (check availability)
   └─ Publishes "OrderCreated" event
4. Payment Processing → Payment Service processes payment
   └─ Publishes "PaymentProcessed" event
5. Billing → Billing Service generates invoice
6. Notifications → Sends confirmation emails
```

---

## ⚙️ Configuration

### Eureka Configuration
**eureka-server/src/main/resources/application.properties:**
```properties
server.port=8761
spring.application.name=eureka-server
eureka.server.enable-self-preservation=false
eureka.server.eviction-interval-timer-in-ms=3000
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
```

---

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| Service not registering on Eureka | Ensure Eureka Server is running on port 8761 |
| API Gateway not routing requests | Check gateway configuration |
| JWT token validation fails | Verify JWT secret is same across services |
| Database connection error | Check MySQL is running |
| Port already in use | Change port in application.properties |

---

## 📞 Contact

**Sinku Singh**  
Java Backend Developer | Spring Boot | Microservices

- GitHub: [JavaDeveloper-Sinku](https://github.com/JavaDeveloper-Sinku)
- Email: singh173@gmail.com
- LinkedIn: [Sinku Singh](https://www.linkedin.com/in/sinku-singh-7a22ab233/)

---

## ⭐ Support

If you find this project helpful, please consider giving it a **star** ⭐ on GitHub!

Happy Coding 🚀

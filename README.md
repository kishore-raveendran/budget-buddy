# 💰 Budget Buddy

A comprehensive personal finance management application built with **Spring Boot** backend and **React TypeScript** frontend. Track your expenses, visualize spending patterns, and manage your budget with beautiful interactive charts.

![Budget Buddy](https://img.shields.io/badge/Status-Active-green) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen) ![React](https://img.shields.io/badge/React-18-blue) ![TypeScript](https://img.shields.io/badge/TypeScript-5.x-blue) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)

## 🌟 Features

### 🔐 **Authentication & Security**
- JWT-based authentication system
- User registration and login
- Secure password encryption with BCrypt
- Protected API endpoints

### 📊 **Data Visualization**
- Interactive pie charts showing expense breakdown by category
- Real-time transaction visualization
- INR currency formatting throughout the application
- Responsive charts that adapt to screen size

### 💳 **Transaction Management**
- Automatic transaction categorization
- SMS/message parsing for transaction details
- Real-time transaction listing with search and filter
- Transaction count and total expense tracking

### 🎨 **Modern UI/UX**
- Clean, responsive dashboard
- Mobile-friendly design
- Loading states and error handling
- Professional styling with styled-components

## 🏗️ Architecture

```
Budget Buddy
├── Backend (Spring Boot)
│   ├── RESTful APIs
│   ├── JWT Authentication
│   ├── PostgreSQL Database
│   └── Transaction Categorization
└── Frontend (React TypeScript)
    ├── Dashboard with Charts
    ├── Authentication Flow
    ├── Real-time Data Display
    └── Responsive Design
```

## 🛠️ Tech Stack

### **Backend**
- **Spring Boot 3.x** - Main framework
- **Spring Security** - Authentication & authorization
- **Spring Data JPA** - Database abstraction
- **PostgreSQL** - Primary database
- **JWT** - Token-based authentication
- **Maven** - Dependency management

### **Frontend**
- **React 18** - UI framework
- **TypeScript** - Type safety
- **Chart.js + react-chartjs-2** - Data visualization
- **styled-components** - CSS-in-JS styling
- **Axios/Fetch** - API communication

## 🚀 Quick Start

### Prerequisites

- **Java 17+**
- **Node.js 16+**
- **PostgreSQL 13+**
- **Maven 3.8+**
- **npm or yarn**

### 🗄️ Database Setup

```sql
-- Create database
CREATE DATABASE budgetbuddy;

-- Create user (optional)
CREATE USER postgres WITH PASSWORD 'mysecretpassword';
GRANT ALL PRIVILEGES ON DATABASE budgetbuddy TO postgres;
```

### 🔧 Backend Setup

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd budget-buddy
   ```

2. **Configure database:**
   ```properties
   # src/main/resources/application-dev.properties
   spring.datasource.url=jdbc:postgresql://localhost:5433/budgetbuddy
   spring.datasource.username=postgres
   spring.datasource.password=mysecretpassword
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run -Dspring.profiles.active=dev
   ```

   The backend will start on `http://localhost:7779`

### 🎨 Frontend Setup

1. **Navigate to frontend directory:**
   ```bash
   cd ../budget-buddy-frontend
   ```

2. **Install dependencies:**
   ```bash
   npm install
   ```

3. **Configure API URL:**
   ```env
   # .env
   REACT_APP_API_URL=http://localhost:7779
   ```

4. **Start the development server:**
   ```bash
   npm start
   ```

   The frontend will start on `http://localhost:3000`

## 📡 API Endpoints

### Authentication
```http
POST /api/auth/register    # User registration
POST /api/auth/login       # User login
```

### Transactions
```http
GET  /api/transactions/all              # Get all user transactions
POST /api/transactions/save             # Save new transaction
GET  /api/transactions/count            # Get transaction count
GET  /api/transactions/report/category  # Get expenses by category
```

## 🏃‍♂️ Running the Complete Application

1. **Start PostgreSQL** (make sure it's running on port 5433)

2. **Start the Backend:**
   ```bash
   cd budget-buddy
   ./mvnw spring-boot:run -Dspring.profiles.active=dev
   ```

3. **Start the Frontend:**
   ```bash
   cd ../budget-buddy-frontend
   npm start
   ```

4. **Access the application:**
   - Frontend: `http://localhost:3000`
   - Backend API: `http://localhost:7779`
   - Health Check: `http://localhost:7779/actuator/health`

## 📊 Dashboard Features

### **Statistics Cards**
- Total number of transactions
- Total expenses in INR
- User account information

### **Interactive Charts**
- Pie chart showing expense breakdown by category
- Hover tooltips with detailed information
- Legend showing amounts and percentages
- Automatic color generation for categories

### **Transaction List**
- Recent transactions with details
- Category-wise organization
- Date formatting and sorting
- Amount display in INR currency

## 🔒 Security Features

- **JWT Token Authentication**
- **Password Encryption** with BCrypt
- **CORS Configuration** for cross-origin requests
- **Protected Routes** requiring authentication
- **Secure API endpoints** with proper authorization

## 🌐 Environment Configuration

### Development
```properties
# Backend
server.port=7779
spring.profiles.active=dev
cors.allowed-origins=http://localhost:3000

# Frontend
REACT_APP_API_URL=http://localhost:7779
```

### Production
```properties
# Backend
server.port=8080
spring.profiles.active=prod
cors.allowed-origins=https://your-domain.com

# Frontend
REACT_APP_API_URL=https://api.your-domain.com
```

## 📁 Project Structure

```
budget-buddy/
├── src/main/java/com/finance/saas/
│   ├── controller/          # REST controllers
│   ├── service/            # Business logic
│   ├── repository/         # Data access layer
│   ├── entity/             # JPA entities
│   ├── config/             # Security & JWT configuration
│   └── dto/                # Data transfer objects
├── src/main/resources/
│   ├── application.properties
│   └── application-dev.properties
└── pom.xml

budget-buddy-frontend/
├── src/
│   ├── components/         # React components
│   │   ├── charts/        # Chart components
│   │   ├── Dashboard.tsx
│   │   ├── Login.tsx
│   │   └── TransactionsList.tsx
│   ├── services/          # API services
│   ├── types/             # TypeScript interfaces
│   ├── utils/             # Utility functions
│   └── App.tsx
├── public/
└── package.json
```

## 🚧 Development

### Adding New Features

1. **Backend:** Add controllers, services, and entities
2. **Frontend:** Create components and connect to APIs
3. **Database:** Update schema using JPA migrations

### Testing

```bash
# Backend tests
./mvnw test

# Frontend tests
npm test
```

## 📦 Deployment

### Backend Deployment
```bash
./mvnw clean package
java -jar target/budget-buddy-*.jar
```

### Frontend Deployment
```bash
npm run build
# Deploy the build/ folder to your hosting service
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 🐛 Troubleshooting

### Common Issues

**CORS Errors:**
- Ensure `cors.allowed-origins` is set in `application-dev.properties`
- Check that frontend URL matches CORS configuration

**Database Connection:**
- Verify PostgreSQL is running
- Check database credentials in application properties
- Ensure database exists

**Port Conflicts:**
- Backend default: 7779
- Frontend default: 3000
- Change ports if needed in configuration files

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Kishore Kumar**

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- React and Chart.js teams for powerful tools
- Contributors and testers

---

**Happy Budgeting! 💰✨**

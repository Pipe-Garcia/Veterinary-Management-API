# 🐾 Veterinary Management API

This is a RESTful API built with **Spring Boot**, designed to manage pet owners and their pets for a veterinary system. The application follows a clean **multi-layered architecture** and applies industry-standard **best practices** like the use of **DTOs**, **JPA relationships**, and **clean endpoint design**.

---

## 📚 Features

- Create, read, update and delete (CRUD) for:
  - Pet owners
  - Pets
- One-to-Many relationship between owners and pets
- Filter pets by `species` and `breed`
- DTOs for:
  - Requests (`CreateDTO`, `UpdateDTO`)
  - Responses (`DTO`, `DetailDTO`)
- Proper separation of concerns (Controller → Service → Repository)
- Professional and scalable codebase

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL
- Maven

---

## 🧱 Architecture Overview

 - 📁 model
 - 📁 repository
 - 📁 service
 - 📁 controller
 - 📁 dto


Each layer has a specific role:
- `model`: JPA entity definitions
- `repository`: CRUD and custom queries
- `service`: Business logic and DTO conversion
- `controller`: REST endpoints
- `dto`: Secure data transfer to/from client

---

## 🔗 API Endpoints (Examples)

### 📌 Owners

| Method | Endpoint                  | Description                 |
|--------|---------------------------|-----------------------------|
| GET    | `/duenios`                | Get all owners              |
| GET    | `/duenios/{id}`           | Get owner by ID             |
| GET    | `/duenios/{id}/detalle`   | Get owner + pet details     |
| POST   | `/duenios/create`         | Create new owner (DTO)      |
| PUT    | `/duenios/update`         | Update owner (DTO)          |
| DELETE | `/duenios/{id}`           | Delete owner by ID          |

---

### 🐶 Pets

| Method | Endpoint                    | Description                    |
|--------|-----------------------------|--------------------------------|
| GET    | `/mascotas`                 | Get all pets                   |
| GET    | `/mascotas/{id}`            | Get pet by ID                  |
| POST   | `/mascotas/create`          | Create new pet (DTO)           |
| PUT    | `/mascotas/update`          | Update pet (DTO)               |
| DELETE | `/mascotas/{id}`            | Delete pet by ID               |
| POST   | `/mascotas/filtrar`         | Filter pets by species & breed |

---

## 📥 Sample JSON for Requests

### ✅ Create Owner

```json
  {
    "nombre": "Lucía",
    "apellido": "Pérez",
    "dni": 44255633,
    "nroCelular": 1123456789
  }
  ```

### ✅ Create Pet

```json
  {
    "nombre": "Toby",
    "especie": "Perro",
    "raza": "Caniche",
    "color": "Blanco",
    "duenioId": 1
  }
  ```

### ✅ Filter Pets

```json
  {
    "especie": "Perro",
    "raza": "Caniche"
  }
  ```

---


### 🧠 Learning Highlights

This project demonstrates:

   - DTO separation for request/response

   - Avoiding entity exposure in controllers

   - JPA One-to-Many & Many-to-One mapping

   - Dependency injection and service layering

   - Use of streams and collectors

   - Circular dependency management with @Lazy


---

### 🚀 How to Run

1. Clone the repo:

  ```bash
    git clone https://github.com/your-username/veterinary-api.git
```

2. Configure your MySQL database (application.properties)

3. Run the app with:

  ```bash
   mvn spring-boot:run
```

---

### 📂 Folder Structure Preview

  ```bash
  src/
  ├── main/
  │   ├── java/com/appTest/veterinaria/
  │   │   ├── controller/
  │   │   ├── service/
  │   │   ├── model/
  │   │   ├── dto/
  │   │   └── repository/
  │   └── resources/
  │       └── application.properties
  ```

---

### 🤝 Contributing

Contributions, ideas, and improvements are welcome. Fork it, star it ⭐ and make it yours!

---

### 🧑‍🎓 Author

 - Developed by [Felipe Garcia]
 - Final project for university Spring Boot backend module.
 - Connect on <a href="https://www.linkedin.com/in/felipe-garc%C3%ADa-dev/">LinkedIn

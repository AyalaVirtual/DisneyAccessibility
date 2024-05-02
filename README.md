# Disney Parks Accessibility 

The Disney Parks Accessibility App is a web application designed to provide detailed accessibility information for attractions at Disney World parks. It aims to enhance the park experience for visitors with disabilities or special needs by offering personalized accessibility guides and resources.



## Technologies Used 

- **Frontend:**
    - React (JavaScript library for building user interfaces)
    - Axios (HTTP client for making API requests)
    - React Router (Library for routing within a React application)

- **Backend:**
    - Java 17 
    - Maven 
    - Spring Boot (Backend framework for RESTful APIs)
    - Spring Data JPA (Data access layer for interacting with databases)
    - H2 Database (In-memory database for development and testing)
    - Spring Web (Module for handling web requests)
    - Postman
    - Apache Tomcat
    - IntelliJ



## Features
* Interactive maps of each Disney World park. 
* Lists of attractions with detailed information.
* Accessibility details for each attraction, including wheelchair accessibility, sensory considerations, and ride transfer options.
* User-friendly interfaces for browsing attractions and accessibility information.
* Back end APIs for retrieving park data, attraction details, and accessibility information.



## Getting Started

### Prerequisites
* Node.js and npm (for frontend development)
* Java Development Kit (JDK) 8 or higher
* IntelliJ IDEA or Eclipse IDE (recommended for Java development)
* Git (optional but recommended for version control)


### Installation
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/your-username/disney-parks-accessibility.git

2. **Frontend Setup:**
   ```bash
   cd frontend
   npm install
   ```

3. **Backend Setup:**
    - Open the project in your IDE (IntelliJ IDEA or Eclipse).
    - Build and run the Spring Boot application (`DisneyParksAccessibilityApplication`).

4. **Database Configuration (H2 Database):**
    - The project is configured to use an H2 in-memory database for development.
    - Database configurations can be found in `application.properties` under `src/main/resources` in the backend module.

5. **Start the Application:**
    - Start the frontend development server:
      ```bash
      cd frontend
      npm start
      ```
    - The frontend should now be accessible at `http://localhost:3000`.
    - The backend API endpoints will be available at `http://localhost:8080`.



## Usage
1. Open your web browser and navigate to `http://localhost:3000` to access the application.
2. Explore parks, attractions, and accessibility information using the provided interfaces.
3. Interact with the frontend components to view detailed attraction information and accessibility details.


## Entity Relationship Diagram

<img src="./images/DisneyParksAccessibilityERD.png" alt="ERD">


## HTTP Endpoints

| Request Type | URL                                                                               | Functionality                                                    | Access |
|--------------|-----------------------------------------------------------------------------------|------------------------------------------------------------------|--------|
| GET          | `/api/parks/`                                                                     | Get a list of all parks.                                         | Public |
| GET          | `/api/parks/{parkId}/`                                                            | Get details of a specific park by ID.                            | Public |
| GET          | `/api/parks/{parkId}/accessibility/{accessibilityId}/` | Get accessibility information for an attraction.                 | Public |
| GET          | `/api/parks/{parkId}/attractions/`                                                | Get a list of all attractions in a specific park.                | Public |
| GET          | `/api/parks/{parkId}/attractions/{attractionId}/`                                 | Get details of a specific attraction.                            | Public |




### Links
* User Stories - https://docs.google.com/document/d/1mLiORi0NO0TcaMykAujzYsgFoyzLBELlFtPALw_Yj3c/edit?usp=sharing 

* HTTP requests/endpoints spreadsheet - https://docs.google.com/spreadsheets/d/1xIWKhaml3FHhzpcYROyoGMMztVnEql5rJnGOybD2k2M/edit?usp=sharing 


### Authors

:woman_technologist: Erica Ayala

* [LinkedIn](https://www.linkedin.com/in/ayalavirtual)

* [GitHub](https://www.github.com/AyalaVirtual)




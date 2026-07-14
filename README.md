# GenEd Research Tool

A web application that helps students search, filter, and explore University of Illinois General Education (GenEd) courses. The application provides filtering capabilities and aggregates course information into an easy-to-use interface for planning schedules and satisfying GenEd requirements.

## Features

- Search courses by:
  - Course title
  - Course number
  - Subject
- Filter courses by General Education categories
<!-- - View detailed course information -->
- Fast search using backend filtering and database queries
- Responsive React frontend

## Tech Stack

### Frontend

- React
- TypeScript
- CSS

### Backend

- Spring Boot
- Spring Data JPA
- Hibernate

### Database

- PostgreSQL

<!-- Make a diagram of the project architecture -->

## Running the Project

### Prerequisites

- Java 21
- Node.js
- npm
- PostgreSQL

### Backend

1. Navigate to the backend directory.

2. Configure your PostgreSQL connection in:

```
src/main/resources/application.properties
```

3. Start the Spring Boot application.

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

The backend will start on:

```
http://localhost:8080
```

---

### Frontend

1. Navigate to the frontend directory.

2. Install dependencies.

```bash
npm install
```

3. Start the development server.

```bash
npm run dev
```

(or `npm start` depending on your setup)

The frontend will be available at:

```
http://localhost:5173
```

## API

The frontend communicates with the backend using REST endpoints for retrieving:

- Subjects
- Courses
- Filtered search results

Course searches support combinations of filters, including:

- Subject
- Course Number
- Course Title
- Course Level
- minimum and maximum average gpa
- GenEd Categories

## Future Improvements

- Authentication
- Class description
- Instructor information
- Semester availability
- Advanced sorting
- Favorite courses
- Schedule planner
- Pagination
- Course prerequisite visualization

## License

This project is intended for educational purposes.

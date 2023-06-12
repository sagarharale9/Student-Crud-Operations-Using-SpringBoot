# Student-Crud-Operations-Using-SpringBoot
Student  (ADD, DELETE,UPDATE,GETSTUDENT DETAILS) Crud Operations using Springboot(STS tool) project

# StudentInfo-springboot-project
springboot project with resttemplate 

# Spring Boot Student API

This is a simple Spring Boot API that manages students. The API has endpoints for creating, retrieving, updating, and deleting students.

## Getting Started

To run the application, you will need to have Java 8 or higher installed on your system. You can clone this repository and run the `main` method in the `com.training.StudentApiApplication` class.

```
git clone https://github.com/yourusername/student-api.git
cd student-api
./gradlew bootRun
```

The API will then be accessible at `http://localhost:8080/student`.

## API Endpoints

The API has the following endpoints:

| Method | Endpoint       | Description                                              |
| ------ | -------------- | -------------------------------------------------------- |
| GET    | /students      | Get a list of all students                               |
| GET    | /students/{id} | Get a specific student by ID                              |
| POST   | /students      | Create a new student                                      |
| PUT    | /students/{id} | Update an existing student by ID                          |
| DELETE | /students/{id} | Delete an existing student by ID and returns the deleted student       |

### Student Object

A student object has the following fields:

- `id` (integer) - The ID of the student
- `name` (string) - The name of the student
- `gender` (string) - The gender of the student
- `course` (string) - The course of the student
- `hobbies` (list of strings) - A list of the student's hobbies

## Contributing

If you would like to contribute to this project, please submit a pull request.

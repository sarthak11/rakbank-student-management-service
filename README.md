# rakbank-student-management-service

The purpose of this microservice is to manage student's related data on the platform.

## Description

* The main API of this microservice is /student/save API which saves student data in the H2 in memory data
* Also it supports the collection service with /student/{id} for fetching data of the saved student by student id.

## Getting Started

### Dependencies

* Springboot - 3.0.2
* JAVA - 19
* H2 - 1.4.193
* Lombok - 1.18.24

### Executing program

In the root directory of the project just do

```
mvn spring-boot:run
```
This will make the application up on port 8080

### Postman Collection

```
https://api.postman.com/collections/21016888-5f88590a-b0af-4442-9de5-bacae3df6281?access_key=PMAT-01GNP3N0ZC6P52XX1WPDN45W20
```

### Schema

* Student

|  Column                                |  Type   |  Description
| --------------------------------------|----------|----------------------------------------------
| id                                    | Long     | Primary key
| unique_id                             | Long     | Unique id / enrollment id/ student id per student
| name                                  | String   | Student name
| grade                                 | Int      | Student grade
| mobile_number                         | String   | Mobile number
| school_name                           | String   | School name
| created_date                          | Datetime | Created date

## Authors
* Sarthak Soni - sarthaksoni987@gmail.com

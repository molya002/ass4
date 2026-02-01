# Zoo Management System (Java + PostgreSQL)

## Description
This project is a console-based Java application for managing a zoo.
It demonstrates a layered architecture with clear separation of responsibilities:
database connection, repositories, services, models, and the main entry point.

The system works with Animals, Zoos, and Zookeepers using PostgreSQL.

## Project Structure

src
|-- connection
|   `-- DBConnection.java
|-- model
|   |-- Animal.java
|   |-- Zoo.java
|   `-- Zookeeper.java
|-- repository
|   |-- AnimalRepository.java
|   |-- ZooRepository.java
|   `-- ZookeeperRepository.java
|-- service
|   |-- AnimalService.java
|   `-- ZookeeperService.java
`-- Main.java


## Database

PostgreSQL is used as the database.
Connection parameters are configured in DBConnection.java.

Example SQL schema:

CREATE TABLE zoo (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100)
);

CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(50),
    age INT,
    zoo_id INT REFERENCES zoo(id)
);

CREATE TABLE zookeeper (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    experience INT,
    zoo_id INT REFERENCES zoo(id)
);

## Technologies
- Java
- PostgreSQL
- JDBC
- pgAdmin

## How to Run

1. Create a PostgreSQL database
2. Execute the SQL scripts to create tables
3. Configure database credentials in DBConnection.java
4. Run the application:

javac Main.java
java Main

## Application Logic

Repository layer:
Handles all SQL queries and database operations.

Service layer:
Contains business logic and validation.

Model layer:
Represents entities as plain Java objects.

Main class:
Application entry point and user menu.

## Example Menu

1. Add Zoo
2. Add Animal
3. Add Zookeeper
4. Show All Animals
5. Exit

## Purpose
This project is intended for educational use.
It helps practice JDBC, PostgreSQL, and layered architecture in Java.
It can be used as a university assignment or portfolio project.

## Author
Student project for learning Java and PostgreSQL integration.


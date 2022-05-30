## Project's Title:
	JDBC:DAOs

## Project Description:
	Prerequisites:

	customers, addresses, orders and products tables with example data

	Theory:

	Data Access Object (DAO) Pattern

	Builder pattern with Lombok

	Generating test data using JavaFaker

	Practical tasks:


	1.Create Addresses, Orders and Products POJO

	Description: Using Lombok, create POJO classes for addresses, orders and products tables.


	2.Create Customers, Addresses, Orders and Products classes example data 

	Description: Using Lombok, implement the Builder pattern for Customers, Addresses, Orders and Products classes. 


	3.Using JavaFaker:

	create a single object with random data

	a list of X objects with random data



	4.Create a CRUD DAO Interface

	Description:  create interface that all DAO classes will implement. The following methods should be included:

	save - saves the record to the database

	delete - deletes the record from the database

	deleteAll - deletes all records in the table

	getById - get a single record from the table by id

	getByIds - get a list of records by list of ids

	getAllRecordsCount - get the count of all records in the table

	getRandomId - returns a random record id

	getRandomIds(X) - returns a list of X random record ids


	5.Create Customer, Order, Address and Product DAO

	Description: Create a DAO for the customers, orders,
	addresses and products tables that implement the CRUD DAO interface.


	Acceptance criteria:

	As a QA Automation trainee, I want to gain knowledge of:

	how and why to use DAO pattern 

	how to implement builder pattern with Lombok 

	how to quickly create test data using JavaFaker

	how to implement database tests using JDBC, JUnit and all design patterns I have learned so far

	how to extract relational data from a database using JDBC


## Table of Contents:
	Task.txt - description of the task
	README.md file
	estafet.training.DAO
	.gitignore file
	DBscript.sql

## How to Install and Run the Project:
	SQL: Local database environment setup
	 
## How to Use the Project:
	IDE need to execute the java project

## Useful links:
	https://howtodoinjava.com/lombok/lombok-builder-annotation/
	https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/

## Add a License
	no needed



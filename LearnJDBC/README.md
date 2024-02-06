# Learn JDBC Module

This module requires a bit of extra configuration:
- Installing MySql on your machine.
- Setting up MySql database.
- Adding MySql driver to "classpath".

The driver for MySql v8.3.0 has been put into the [lib folder](./lib).

## Database setup script

The below script intialize a database called `employees_database` with an `employees` table with data.
```mysql
-- Database Script:
-- These two dashes represent a comment in SQL

create database employees_database;

use employees_database;

show databases;

create table employees (
id INT AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
department varchar(10),
salary int(10)
);

insert into employees values(100,'Michael','Sales',5500);
insert into employees values(200,'Cassandra','Technology',6000);
insert into employees values(300,'Samuel','Technology',7000);
insert into employees values(400,'John','Marketing',9500);
insert into employees values(500,'Beth','Technology',6500);
insert into employees values(600,'Peter','HR',5000);
insert into employees values(700,'Romeo','Legal',5400);

-- To drop database use Drop database employees_database
```


### Starting the MySql database

Below is a command to start the MySql database.

`mysqld --console`

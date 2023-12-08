CREATE DATABASE cardealership;

USE cardealership;

CREATE TABLE dealerships(
dealership_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
address VARCHAR(50),
phone VARCHAR(50)
);

CREATE TABLE vehicles(
VIN INT PRIMARY KEY,
price FLOAT,
make VARCHAR(50),
model VARCHAR(50),
color VARCHAR(50),
sold BOOLEAN
);

CREATE TABLE inventory(
dealership_id INT,
VIN INT
);

CREATE TABLE sales_contracts(
sale_id INT AUTO_INCREMENT PRIMARY KEY,
first VARCHAR(50),
last VARCHAR(50),
address VARCHAR(50),
VIN INT
);

CREATE TABLE lease_contracts(
lease_id INT AUTO_INCREMENT PRIMARY KEY,
amount_paid FLOAT,
amount_due FLOAT,
VIN INT
);
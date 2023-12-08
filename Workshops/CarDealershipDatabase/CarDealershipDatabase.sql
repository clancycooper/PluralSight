-- This is my main SQL Script for the Car Dealership DB Workshop
-- Check the CreateDB Script to see my creation process
-- Check the Populating Script to see the population process
-- Check any Query to see my testing process

DROP DATABASE IF EXISTS cardealership;

CREATE DATABASE cardealership;

USE cardealership;

CREATE TABLE dealerships(
dealership_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
address VARCHAR(50),
phone VARCHAR(12)
);

CREATE TABLE vehicles(
    VIN INT PRIMARY KEY,
    dealership_id INT,
    price FLOAT,
    make VARCHAR(50),
    model VARCHAR(50),
    color VARCHAR(50),
    sold BOOLEAN,
    sale_id INT
);

CREATE TABLE inventory(
    dealership_id INT,
    VIN INT
);

CREATE TABLE sales_contracts(
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN INT,
    dealership_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(50),
    sale_date DATE
);

CREATE TABLE lease_contracts(
    lease_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN INT,
    dealership_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    address VARCHAR(50),
    amount_paid FLOAT,
    amount_due FLOAT,
    start_date DATE,
    end_date DATE
);

-- Altering tables to include foreign keys
ALTER TABLE vehicles
    ADD FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    ADD FOREIGN KEY (sale_id) REFERENCES sales_contracts(sale_id);

ALTER TABLE inventory
    ADD FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    ADD FOREIGN KEY (VIN) REFERENCES vehicles(VIN);

ALTER TABLE sales_contracts
    ADD FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    ADD FOREIGN KEY (VIN) REFERENCES vehicles(VIN);

ALTER TABLE lease_contracts
    ADD FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id),
    ADD FOREIGN KEY (VIN) REFERENCES vehicles(VIN);
    
USE cardealership;

-- Populating dealerships Table
INSERT INTO dealerships (name, address, phone)
VALUES ('Clancys Coopers', '123 Main St', '123-456-7890'),
       ('Scout Used Cars', '456 Elm St', '987-654-3210');
       
-- Populating vehicles Table
INSERT INTO vehicles (VIN, dealership_id, price, make, model, color, sold)
VALUES (123, 1, 25000.00, 'Toyota', 'Pruis', 'Black', true),
       (456, 2, 30000.00, 'Mazda', 'Miata', 'White', false),
       (789, 1, 35000.00, 'Mini', 'Mini Coop', 'Red', false),
       (321, 2, 65000.00, 'Tesla', 'Model S', 'Purple', true);

-- Added a few new cars to help with the Find Dealership By Car Type Query
INSERT INTO vehicles (VIN, dealership_id, price, make, model, color, sold)
VALUES (645, 1, 55000.00, 'Mini', 'Mini Coop', 'Yellow', false),
       (987, 2, 38500.00, 'Toyota', 'Tacoma', 'Red', false);

-- Decided to add lease_id to vehicles table in addition to sales_id
ALTER TABLE vehicles ADD COLUMN lease_id INT;

-- Populating inventory Table       
INSERT INTO inventory (dealership_id, VIN)
VALUES (1, 123),
       (2, 456),
       (1, 789);

-- Forgot to insert Tesla into inventory (oops)
INSERT INTO inventory (dealership_id, VIN)
VALUES (2, 321);

-- Insert for new vehicles
INSERT INTO inventory (dealership_id, VIN)
VALUES (1, 645),
       (2, 987);

-- Populating sales_contracts Table       
INSERT INTO sales_contracts (VIN, dealership_id, first_name, last_name, address, sale_date)
VALUES (123, 1, 'Banjomin', 'Joseph', '42 Aroo Rd', '2023-12-01'),
       (321, 2, 'Contra', 'White', '69 Polar Bear Avenue', '2023-12-05');

-- Using the established relationship between vehicles and sales_contract
-- to update my VIN and sale_id values
UPDATE vehicles v
JOIN sales_contracts s ON v.VIN = s.VIN
SET v.sale_id = s.sale_id;

-- Populating lease_contracts Table
INSERT INTO lease_contracts (VIN, dealership_id, first_name, last_name, address, amount_paid, amount_due, start_date, end_date)
VALUES (456, 2, 'Dale', 'Senior', '789 Park Ln', 5000.00, 20000.00, '2023-11-10', '2024-11-10'),
       (789, 1, 'Dale', 'Junior', '101 Forest Ave', 3000.00, 32000.00, '2023-12-01', '2024-12-01');
       
-- Using the established relationship between vehicles and lease_contract
-- to update my VIN and lease_id values       
UPDATE vehicles v
JOIN lease_contracts l ON v.VIN = l.VIN
SET v.lease_id = l.lease_id;

USE cardealership;

SELECT * FROM dealerships;

SELECT * FROM inventory;

SELECT * FROM lease_contracts;

SELECT * FROM sales_contracts;

SELECT * FROM vehicles;
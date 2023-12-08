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
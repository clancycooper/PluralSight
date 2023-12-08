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
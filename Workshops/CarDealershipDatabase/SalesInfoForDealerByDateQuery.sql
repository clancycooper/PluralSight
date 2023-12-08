USE cardealership;

-- Query for Dealership Sales information between Jan 1, 2023 and Dec 1, 2023
SELECT
	s.*, d.name, v.make, v.model, v.color, v.price
FROM 
	sales_contracts s
INNER JOIN dealerships d
	ON s.dealership_id = d.dealership_id
INNER JOIN vehicles v
	ON v.sale_id = s.sale_id
WHERE 
	sale_date BETWEEN '2023-01-01' AND '2023-12-01';
    
-- Query for Dealership Sales information between Jan 1, 2022 and Jan 1, 2024
SELECT
	s.*, d.name, v.make, v.model, v.color, v.price
FROM 
	sales_contracts s
INNER JOIN dealerships d
	ON s.dealership_id = d.dealership_id
INNER JOIN vehicles v
	ON v.sale_id = s.sale_id
WHERE 
	sale_date BETWEEN '2022-01-01' AND '2024-01-01';
USE cardealership;

-- Find all of the Dealerships that sell Toyotas
SELECT
	d.name, v.make, v.model, v.color, v.price
FROM 
	dealerships d
INNER JOIN vehicles v
	ON d.dealership_id = v.dealership_id
WHERE make = 'Toyota';

-- Find all of the Dealerships that sell red cars
SELECT
	d.name, v.make, v.model, v.color, v.price
FROM 
	dealerships d
INNER JOIN vehicles v
	ON d.dealership_id = v.dealership_id
WHERE color = 'Red';
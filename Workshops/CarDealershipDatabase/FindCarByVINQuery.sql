USE cardealership;

-- Finding the Purple Tesla by VIN
SELECT
	i.*, d.name, v.price, v.make, v.model, v.color
FROM
	inventory i
INNER JOIN dealerships d
	ON i.dealership_id = d.dealership_id
INNER JOIN vehicles v
	ON i.VIN = v.VIN
WHERE
	v.VIN = 321;
    
-- Finding the Pruis by VIN
SELECT
	i.*, d.name, v.price, v.make, v.model, v.color
FROM
	inventory i
INNER JOIN dealerships d
	ON i.dealership_id = d.dealership_id
INNER JOIN vehicles v
	ON i.VIN = v.VIN
WHERE
	v.VIN = 123;